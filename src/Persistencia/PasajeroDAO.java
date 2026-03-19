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
        
            public List<Pasajero> cargarTodos() {
        List<Pasajero> lista = new ArrayList<>();
        File f = new File(ARCHIVO);
        if (!f.exists()) return lista;
        
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;
                String[] campos = linea.split(";", -1);
                if (campos.length < 3) continue;
                
                
                                String cedula = campos[0];
                String nombre = campos[1];
                String tipo   = campos[2];

                Pasajero p;
                switch (tipo) {
                    case "Estudiante":  p = new PasajeroEstudiante(cedula, nombre);  break;
                    case "AdultoMayor": p = new PasajeroAdultoMayor(cedula, nombre); break;
                    default:            p = new PasajeroRegular(cedula, nombre);     break;
                }
                lista.add(p);
            }
    
    
    
}
