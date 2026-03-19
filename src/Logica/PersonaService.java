package Logica;

import Persistencia.ConductorDAO;
import Persistencia.PasajeroDAO;
import Modelo.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaService {

    private ConductorDAO conductorDAO;
    private PasajeroDAO  pasajeroDAO;
    private List<Conductor> conductores;
    private List<Pasajero>  pasajeros;
    
    public PersonaService() {
    this.conductorDAO = new ConductorDAO();
    this.pasajeroDAO  = new PasajeroDAO();
    this.conductores  = conductorDAO.cargarTodos();
    this.pasajeros    = pasajeroDAO.cargarTodos();
}
    
        // ── CONDUCTORES ──────────────────────────────────────────

    public String registrarConductor(String cedula, String nombre,
                                 String numLicencia, String catLicencia) {
    if (cedula == null || cedula.trim().isEmpty())
        return "ERROR: La cedula no puede estar vacia.";
    if (nombre == null || nombre.trim().isEmpty())
        return "ERROR: El nombre no puede estar vacio.";
    if (buscarConductorPorCedula(cedula) != null)
        return "ERROR: Ya existe un conductor con la cedula " + cedula;

    Conductor c = new Conductor(cedula, nombre, numLicencia, catLicencia);
    conductores.add(c);
    conductorDAO.guardar(c);
    return "OK: Conductor " + nombre + " registrado correctamente.";
}

    public Conductor buscarConductorPorCedula(String cedula) {
    for (Conductor c : conductores)
        if (c.getCedula().equals(cedula)) return c;
    return null;
}

    public List<Conductor> listarConductores() {
    return new ArrayList<>(conductores);
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}