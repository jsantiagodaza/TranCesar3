package Logica;

import Persistencia.ReservaDAO;
import Modelo.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservaService {

    private ReservaDAO dao;
    private List<Reserva> reservas;
    private VehiculoService vehiculoService;
    private FestivoService festivoService;
    
    
    
    public ReservaService(VehiculoService vehiculoService,
                      PersonaService personaService) {
    this.dao             = new ReservaDAO();
    this.vehiculoService = vehiculoService;
    this.festivoService  = new FestivoService();
    this.reservas = dao.cargarTodos(
            personaService.getPasajerosCargados(),
            vehiculoService.listarTodos()
    );
}
    
    
    
    
    
    
}