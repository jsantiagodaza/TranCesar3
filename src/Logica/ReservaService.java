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
    
    
            Reserva nueva = new Reserva(pasajero, vehiculo, fechaViaje);
                    vehiculo.agregarPasajero();
                    reservas.add(nueva);
            dao.guardar(nueva);
                    vehiculoService.guardarCambios();

                        return "OK: Reserva " + nueva.getCodigo() + " creada para "
                              + pasajero.getNombre() + " en vehiculo " + placaVehiculo + ".";


 }
        
        
        
        public String cancelarReserva(String codigo) {
             Reserva r = buscarPorCodigo(codigo);
            if (r == null)
              return "ERROR: No se encontro reserva con codigo " + codigo;
            if (r.getEstado() != EstadoReserva.ACTIVA)
        return "ERROR: La reserva " + codigo + " ya esta " + r.getEstado() + ".";

             r.cancelar();
            dao.reescribirTodos(reservas);
             vehiculoService.guardarCambios();
             return "OK: Reserva " + codigo + " cancelada. Cupo liberado.";
}
    
    
    public String convertirEnTicket(String codigo,
                                PersonaService personaService,
                                TicketService ticketService) {
    Reserva r = buscarPorCodigo(codigo);
    if (r == null)
        return "ERROR: No se encontro reserva con codigo " + codigo;
    if (r.getEstado() != EstadoReserva.ACTIVA)
        return "ERROR: La reserva " + codigo + " ya esta " + r.getEstado() + ".";

    r.convertir();

    String origen  = r.getVehiculo().getRuta().getCiudadOrigen();
    String destino = r.getVehiculo().getRuta().getCiudadDestino();

    String resultado = ticketService.venderTicket(
            r.getPasajero().getCedula(),
            r.getVehiculo().getPlaca(),
            origen, destino,
            personaService
    );

    dao.reescribirTodos(reservas);
    vehiculoService.guardarCambios();

    if (resultado.startsWith("OK")) {
        return "OK: Reserva " + codigo + " convertida en ticket. " + resultado;
    } else {
        return "ERROR al convertir: " + resultado;
    }
}
    
    

    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
}
        

