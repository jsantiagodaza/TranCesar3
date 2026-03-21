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
    
}
