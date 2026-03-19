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
    
    public String asignarConductorAVehiculo(String cedula, Vehiculo vehiculo) {
    Conductor c = buscarConductorPorCedula(cedula);
    if (c == null)
        return "ERROR: No se encontro conductor con cedula " + cedula;
    if (!c.tieneLicencia())
        return "ERROR: El conductor " + c.getNombre() + " no tiene licencia registrada.";
    return "OK: Conductor " + c.getNombre() + " asignado al vehiculo " + vehiculo.getPlaca() + ".";
}

    public Conductor buscarConductorPorCedula(String cedula) {
    for (Conductor c : conductores)
        if (c.getCedula().equals(cedula)) return c;
    return null;
}

    public List<Conductor> listarConductores() {
    return new ArrayList<>(conductores);
}
    
    // ── PASAJEROS ─────────────────────────────────────────────

    public String registrarPasajero(String cedula, String nombre, String tipo) {
    if (cedula == null || cedula.trim().isEmpty())
        return "ERROR: La cedula no puede estar vacia.";
    if (nombre == null || nombre.trim().isEmpty())
        return "ERROR: El nombre no puede estar vacio.";
    if (buscarPasajeroPorCedula(cedula) != null)
        return "ERROR: Ya existe un pasajero con la cedula " + cedula;

    Pasajero p;
    switch (tipo.toLowerCase()) {
        case "estudiante":
            p = new PasajeroEstudiante(cedula, nombre);  break;
        case "adultomayor":
        case "adulto mayor":
            p = new PasajeroAdultoMayor(cedula, nombre); break;
        default:
            p = new PasajeroRegular(cedula, nombre);     break;
    }

    pasajeros.add(p);
    pasajeroDAO.guardar(p);
    return "OK: Pasajero " + nombre + " (" + p.getTipo() + ") registrado correctamente.";
}

    public Pasajero buscarPasajeroPorCedula(String cedula) {
    for (Pasajero p : pasajeros)
        if (p.getCedula().equals(cedula)) return p;
    return null;
}

    public List<Pasajero> listarPasajeros() {
    return new ArrayList<>(pasajeros);
}
    
    public List<Pasajero> getPasajerosCargados() {
    return pasajeros;
}
    
 
    
}