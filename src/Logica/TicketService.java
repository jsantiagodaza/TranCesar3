package Logica;

import Persistencia.TicketDAO;
import Modelo.*;
import java.util.ArrayList;
import java.util.List;

public class TicketService {

    private TicketDAO dao;
    private List<Ticket> tickets;
    private VehiculoService vehiculoService;
    
    
    
    public TicketService(VehiculoService vehiculoService,
                     PersonaService personaService) {
    this.dao             = new TicketDAO();
    this.vehiculoService = vehiculoService;
    this.tickets = dao.cargarTodos(
            personaService.getPasajerosCargados(),
            vehiculoService.listarTodos()
    );
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}