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

    } catch (IOException e) {
        System.err.println("Error al cargar reservas: " + e.getMessage());
    }

    return lista;
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}