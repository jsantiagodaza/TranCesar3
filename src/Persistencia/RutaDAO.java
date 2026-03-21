/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

/**
 *
 * @author 2jcue
 */
import Modelo.Ruta;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RutaDAO {
    
    private static final String ARCHIVO = "rutas.txt";

    public void guardar(Ruta r) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(r.toCSV());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar ruta: " + e.getMessage());
        }
    }
    
    public List<Ruta> cargarTodos() {
        List<Ruta> lista = new ArrayList<>();
        File f = new File(ARCHIVO);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;
                String[] c = linea.split(";", -1);
                if (c.length < 5) continue;
                lista.add(new Ruta(c[0], c[1], c[2],
                        Double.parseDouble(c[3]),
                        Integer.parseInt(c[4])));
            }
        } catch (IOException e) {
            System.err.println("Error al cargar rutas: " + e.getMessage());
        }
        return lista;
    }
    
}