/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author 2jcue
 */
import Persistencia.VehiculoDAO;
import Modelo.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoService {

    private VehiculoDAO dao;
    private List<Vehiculo> vehiculos;
    private RutaService rutaService;

    public VehiculoService(RutaService rutaService) {
        this.dao         = new VehiculoDAO();
        this.rutaService = rutaService;
        this.vehiculos   = dao.cargarTodos(rutaService.getRutasCargadas());
    }

    public String registrarVehiculo(String tipo, String placa, String codigoRuta) {
        if (placa == null || placa.trim().isEmpty())
            return "ERROR: La placa no puede estar vacia.";
        if (buscarPorPlaca(placa) != null)
            return "ERROR: Ya existe un vehiculo con la placa " + placa;

        Ruta ruta = rutaService.buscarPorCodigo(codigoRuta);
        if (ruta == null)
            return "ERROR: No existe una ruta con el codigo " + codigoRuta;

        Vehiculo v;
        switch (tipo.toLowerCase()) {
            case "buseta":   v = new Buseta(placa.toUpperCase(), ruta);   break;
            case "bus":      v = new Bus(placa.toUpperCase(), ruta);      break;
            case "microbus": v = new Microbus(placa.toUpperCase(), ruta); break;
            default: return "ERROR: Tipo de vehiculo no reconocido.";
        }

        vehiculos.add(v);
        dao.guardar(v);
        return "OK: Vehiculo " + tipo + " placa " + placa + " registrado en ruta " + codigoRuta + ".";
    }

    public Vehiculo buscarPorPlaca(String placa) {
        for (Vehiculo v : vehiculos)
            if (v.getPlaca().equalsIgnoreCase(placa)) return v;
        return null;
    }

    public List<Vehiculo> listarTodos() {
        return new ArrayList<>(vehiculos);
    }

    public void guardarCambios() {
        dao.reescribirTodos(vehiculos);
    }
}