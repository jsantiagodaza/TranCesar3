/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

/**
 *
 * @author 2jcue
 */
import Modelo.*;
import java.io.*;
import java.time.LocalDate;
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
                String[] c = linea.split(";", -1);
                if (c.length < 4) continue;

                String cedula         = c[0];
                String nombre         = c[1];
                String tipo           = c[2];
                LocalDate fechaNac    = LocalDate.parse(c[3]);

                Pasajero p;
                switch (tipo) {
                    case "Estudiante":  p = new PasajeroEstudiante(cedula, nombre, fechaNac);  break;
                    case "AdultoMayor": p = new PasajeroAdultoMayor(cedula, nombre, fechaNac); break;
                    default:            p = new PasajeroRegular(cedula, nombre, fechaNac);     break;
                }
                lista.add(p);
            }
        } catch (IOException e) {
            System.err.println("Error al cargar pasajeros: " + e.getMessage());
        }
        return lista;
    }
}