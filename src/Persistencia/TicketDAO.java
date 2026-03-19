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
    
    
    
}
