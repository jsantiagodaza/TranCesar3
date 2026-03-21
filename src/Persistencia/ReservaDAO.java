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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}