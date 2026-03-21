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
    
        public String crearReserva(String cedulaPasajero, String placaVehiculo,
                           LocalDateTime fechaViaje,
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
        return "ERROR: El vehiculo " + placaVehiculo
               + " no tiene cupos disponibles (tickets + reservas activas).";
    
    LocalDate diaViaje = fechaViaje.toLocalDate();
    for (Reserva r : reservas) {
    if (r.getEstado() == EstadoReserva.ACTIVA
            && r.getPasajero().getCedula().equals(cedulaPasajero)
            && r.getVehiculo().getPlaca().equalsIgnoreCase(placaVehiculo)
            && r.getFechaViaje().toLocalDate().equals(diaViaje)) {
        return "ERROR: El pasajero ya tiene una reserva activa ("
               + r.getCodigo() + ") para ese vehiculo en esa fecha.";
    }
}
    
    
    
    
    

    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
}
        

}