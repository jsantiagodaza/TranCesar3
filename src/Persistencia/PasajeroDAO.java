package Persistencia;


import Presentacion.*;
import Modelo.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PasajeroDAO {

    private static final String ARCHIVO = "pasajeros.txt";
    
        public void guardar(Pasajero p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(p.toCSV());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar pasajero: " + e.getMessage());
        }
    }
    
    
    
}
