package Persistencia;
import Presentacion.*;
import Modelo.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO {

    private static final String ARCHIVO_BUSETA   = "buseta.txt";
    private static final String ARCHIVO_BUS      = "bus.txt";
    private static final String ARCHIVO_MICROBUS = "microbus.txt";

    public void guardar(Vehiculo v) {
        String archivo = getArchivo(v);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            bw.write(v.toCSV());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar vehiculo: " + e.getMessage());
        }
    }

    public List<Vehiculo> cargarTodos() {
        List<Vehiculo> lista = new ArrayList<>();
        lista.addAll(cargarDesdeArchivo(ARCHIVO_BUSETA,   "Buseta"));
        lista.addAll(cargarDesdeArchivo(ARCHIVO_BUS,      "Bus"));
        lista.addAll(cargarDesdeArchivo(ARCHIVO_MICROBUS, "MicroBus"));
        return lista;
    }

    private List<Vehiculo> cargarDesdeArchivo(String archivo, String tipo) {
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
                String ruta        = campos[1];
                int pasajeros      = Integer.parseInt(campos[2]);
                boolean disponible = campos[3].equals("1");

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
        for (Vehiculo v : todos) {
            guardar(v);
        }
    }

    private String getArchivo(Vehiculo v) {
        switch (v.getTipo()) {
            case "Buseta":  return ARCHIVO_BUSETA;
            case "Bus":     return ARCHIVO_BUS;
            case "MicroBus": return ARCHIVO_MICROBUS;
            default:        return "vehiculos.txt";
        }
    }

    private Vehiculo crearVehiculo(String tipo, String placa, String ruta) {
        switch (tipo) {
            case "Buseta":  return new Buseta(placa, ruta);
            case "Bus":     return new Bus(placa, ruta);
            case "MicroBus": return new Microbus(placa, ruta);
            default:        return null;
        }
    }

    private void borrarContenido(String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, false))) {
            // vaciar archivo
        } catch (IOException e) {
            System.err.println("Error al limpiar " + archivo + ": " + e.getMessage());
        }
    }
}