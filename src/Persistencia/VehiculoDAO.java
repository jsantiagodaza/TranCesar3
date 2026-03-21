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
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO {

    private static final String ARCHIVO_BUSETA   = "buseta.txt";
    private static final String ARCHIVO_BUS      = "bus.txt";
    private static final String ARCHIVO_MICROBUS = "microbus.txt";

    public void guardar(Vehiculo v) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(getArchivo(v), true))) {
            bw.write(v.toCSV());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar vehículo: " + e.getMessage());
        }
    }

    public List<Vehiculo> cargarTodos(List<Ruta> rutas) {
        List<Vehiculo> lista = new ArrayList<>();
        lista.addAll(cargarDesdeArchivo(ARCHIVO_BUSETA,   "Buseta",   rutas));
        lista.addAll(cargarDesdeArchivo(ARCHIVO_BUS,      "Bus",      rutas));
        lista.addAll(cargarDesdeArchivo(ARCHIVO_MICROBUS, "MicroBus", rutas));
        return lista;
    }

    private List<Vehiculo> cargarDesdeArchivo(String archivo, String tipo, List<Ruta> rutas) {
        List<Vehiculo> lista = new ArrayList<>();
        File f = new File(archivo);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;
                String[] campos = linea.split(";");
                if (campos.length < 4) continue;

                String placa       = campos[0];
                String codigoRuta  = campos[1];
                int pasajeros      = Integer.parseInt(campos[2]);
                boolean disponible = campos[3].equals("1");

                Ruta ruta = buscarRuta(rutas, codigoRuta);
                if (ruta == null) continue;

                Vehiculo v = crearVehiculo(tipo, placa, ruta);
                if (v != null) {
                    v.setPasajerosActuales(pasajeros);
                    v.setDisponible(disponible);
                    lista.add(v);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar " + archivo + ": " + e.getMessage());
        }
        return lista;
    }

    public void reescribirTodos(List<Vehiculo> todos) {
        borrarContenido(ARCHIVO_BUSETA);
        borrarContenido(ARCHIVO_BUS);
        borrarContenido(ARCHIVO_MICROBUS);
        for (Vehiculo v : todos) guardar(v);
    }

    private Ruta buscarRuta(List<Ruta> rutas, String codigo) {
        for (Ruta r : rutas)
            if (r.getCodigo().equalsIgnoreCase(codigo)) return r;
        return null;
    }

    private String getArchivo(Vehiculo v) {
        switch (v.getTipo()) {
            case "Buseta":   return ARCHIVO_BUSETA;
            case "Bus":      return ARCHIVO_BUS;
            case "MicroBus": return ARCHIVO_MICROBUS;
            default:         return "vehiculos.txt";
        }
    }

    private Vehiculo crearVehiculo(String tipo, String placa, Ruta ruta) {
        switch (tipo) {
            case "Buseta":   return new Buseta(placa, ruta);
            case "Bus":      return new Bus(placa, ruta);
            case "MicroBus": return new Microbus(placa, ruta);
            default:         return null;
        }
    }

    private void borrarContenido(String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, false))) {
        } catch (IOException e) {
            System.err.println("Error al limpiar " + archivo + ": " + e.getMessage());
        }
    }
}