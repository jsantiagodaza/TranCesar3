/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

/**
 *
 * @author 2jcue
 */
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
    
}
