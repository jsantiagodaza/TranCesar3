package Persistencia;

import Presentacion.*;
import Modelo.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    private static final String ARCHIVO = "tickets.txt";
    
    
    public void guardar(Ticket t) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
        bw.write(t.toCSV());
        bw.newLine();
    } catch (IOException e) {
        System.err.println("Error al guardar ticket: " + e.getMessage());
    }
}
    
    public List<Ticket> cargarTodos(List<Pasajero> pasajeros, List<Vehiculo> vehiculos) {
    List<Ticket> lista = new ArrayList<>();
    File f = new File(ARCHIVO);
    if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;
                String[] campos = linea.split(";", -1);
                if (campos.length < 7) continue;

                int id                = Integer.parseInt(campos[0]);
                String cedulaPasajero = campos[1];
                String placaVehiculo  = campos[2];
                LocalDate fecha       = LocalDate.parse(campos[3]);
                String origen         = campos[4];
                String destino        = campos[5];
                double valor          = Double.parseDouble(campos[6]);

                Pasajero p = buscarPasajero(pasajeros, cedulaPasajero);
                Vehiculo v = buscarVehiculo(vehiculos, placaVehiculo);

                if (p != null && v != null) {
                    lista.add(new Ticket(id, p, v, fecha, origen, destino, valor));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar tickets: " + e.getMessage());
        }
        return lista;
    }

    
    
    
}
