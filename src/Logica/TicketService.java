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
    
    
    public String venderTicket(String cedulaPasajero, String placaVehiculo,
                           String origen, String destino,
                           PersonaService personaService) {
    Pasajero pasajero = personaService.buscarPasajeroPorCedula(cedulaPasajero);
    if (pasajero == null)
        return "ERROR: No se encontro pasajero con cedula " + cedulaPasajero;

    Vehiculo vehiculo = vehiculoService.buscarPorPlaca(placaVehiculo);
    if (vehiculo == null)
        return "ERROR: No se encontro vehiculo con placa " + placaVehiculo;

    if (!vehiculo.isDisponible())
        return "ERROR: El vehiculo " + placaVehiculo + " no esta disponible.";

    if (!vehiculo.tieneCupos())
        return "ERROR: El vehiculo " + placaVehiculo + " está lleno. No hay cupos disponibles.";

    if (origen == null || origen.trim().isEmpty())
        return "ERROR: El origen no puede estar vacio.";

    if (destino == null || destino.trim().isEmpty())
        return "ERROR: El destino no puede estar vacio.";
    
    
    Ticket t = new Ticket(pasajero, vehiculo, origen, destino);
    vehiculo.agregarPasajero();
    tickets.add(t);
    dao.guardar(t);
    vehiculoService.guardarCambios();

    return String.format("OK: Ticket #%d generado. Valor: $%,.0f", t.getId(), t.getValorFinal());
    
}
    public List<Ticket> listarTodos() {
    return new ArrayList<>(tickets);
    }
      
}