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
    
    
    
}