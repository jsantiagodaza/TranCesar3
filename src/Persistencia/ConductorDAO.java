/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

/**
 *
 * @author 2jcue
 */
import Presentacion.*;
import Modelo.Conductor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConductorDAO {
    
    private static final String ARCHIVO = "conductores.txt";

    public void guardar(Conductor c) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(c.toCSV());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar conductor: " + e.getMessage());
        }
    }
    
      public List<Conductor> cargarTodos() {
          
        List<Conductor> lista = new ArrayList<>();
        File f = new File(ARCHIVO);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;
                String[] campos = linea.split(";", -1);
                if (campos.length < 4) continue;

                String cedula    = campos[0];
                String nombre    = campos[1];
                String numLic    = campos[2];
                String catLic    = campos[3];
                lista.add(new Conductor(cedula, nombre, numLic, catLic));
            }
        } catch (IOException e) {
            System.err.println("Error al cargar conductores: " + e.getMessage());
        }
        return lista;
    }
}
