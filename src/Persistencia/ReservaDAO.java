package Persistencia;

import Modelo.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    private static final String ARCHIVO = "reservas.txt";
    
    
    public void guardar(Reserva r) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
        bw.write(r.toCSV());
        bw.newLine();
    } catch (IOException e) {
        System.err.println("Error al guardar reserva: " + e.getMessage());
    }
}
    
    
    public List<Reserva> cargarTodos(List<Pasajero> pasajeros, List<Vehiculo> vehiculos) {
    List<Reserva> lista = new ArrayList<>();
    File f = new File(ARCHIVO);
    if (!f.exists()) return lista;

    try (BufferedReader br = new BufferedReader(new FileReader(f))) {
        String linea;
        while ((linea = br.readLine()) != null) {
        linea = linea.trim();
         if (linea.isEmpty()) continue;
    
            String[] c = linea.split(";", -1);
                    if (c.length < 6) continue;
                    
                String codigo = c[0];
                String cedulaPasajero = c[1];
                String placaVehiculo = c[2];
                LocalDateTime fechaCreacion = LocalDateTime.parse(c[3]);
                LocalDateTime fechaViaje = LocalDateTime.parse(c[4]);
                EstadoReserva estado = EstadoReserva.valueOf(c[5]); 
                Pasajero p = buscarPasajero(pasajeros, cedulaPasajero);
                Vehiculo v = buscarVehiculo(vehiculos, placaVehiculo);

                    if (p != null && v != null) {
                    lista.add(new Reserva(codigo, p, v, fechaCreacion, fechaViaje, estado));
                    }
            }                   
        
    } catch (IOException e) {
        System.err.println("Error al cargar reservas: " + e.getMessage());
    }

    return lista;
}
    
        public void reescribirTodos(List<Reserva> reservas) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, false))) {
        for (Reserva r : reservas) {
            bw.write(r.toCSV());
            bw.newLine();
        }
    } catch (IOException e) {
        System.err.println("Error al reescribir reservas: " + e.getMessage());
    }
}
    
    private Pasajero buscarPasajero(List<Pasajero> lista, String cedula) {
    for (Pasajero p : lista)
        if (p.getCedula().equals(cedula)) return p;
    return null;
}

    private Vehiculo buscarVehiculo(List<Vehiculo> lista, String placa) {
    for (Vehiculo v : lista)
        if (v.getPlaca().equalsIgnoreCase(placa)) return v;
    return null;
}
    
    
  
    
 
    
    
}