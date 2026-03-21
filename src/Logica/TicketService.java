package Logica;


import Persistencia.TicketDAO;
import Modelo.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketService {

    private TicketDAO dao;
    private List<Ticket> tickets;
    private VehiculoService vehiculoService;
    private FestivoService festivoService;

    public TicketService(VehiculoService vehiculoService,
                         PersonaService personaService) {
        this.dao             = new TicketDAO();
        this.vehiculoService = vehiculoService;
        this.festivoService  = new FestivoService();
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
            return "ERROR: El vehiculo " + placaVehiculo + " esta lleno.";

        if (origen == null || origen.trim().isEmpty())
            return "ERROR: El origen no puede estar vacio.";

        if (destino == null || destino.trim().isEmpty())
            return "ERROR: El destino no puede estar vacio.";

        // Validar límite 3 tickets por día
        LocalDate hoy = LocalDate.now();
        int ticketsHoy = contarTicketsPasajeroEnFecha(cedulaPasajero, hoy);
        if (ticketsHoy >= 3)
            return "ERROR: El pasajero ya tiene " + ticketsHoy
                   + " ticket(s) comprados hoy. Limite diario: 3.";

        // Calcular tarifa con posible recargo festivo
        double tarifaFinal = festivoService.aplicarRecargo(vehiculo.getTarifaBase(), hoy);
        boolean esFestivo  = festivoService.esFestivo(hoy);

        Ticket t = new Ticket(pasajero, vehiculo, origen, destino, tarifaFinal);
        vehiculo.agregarPasajero();
        tickets.add(t);
        dao.guardar(t);
        vehiculoService.guardarCambios();

        String msg = String.format("OK: Ticket #%d generado. Valor: $%,.0f", t.getId(), t.getValorFinal());
        if (esFestivo) msg += "  [Tarifa festiva +20%]";
        return msg;
    }

    private int contarTicketsPasajeroEnFecha(String cedula, LocalDate fecha) {
        int count = 0;
        for (Ticket t : tickets)
            if (t.getPasajero().getCedula().equals(cedula)
                    && t.getFechaCompra().equals(fecha)) count++;
        return count;
    }

    public List<Ticket> listarTodos() {
        return new ArrayList<>(tickets);
    }

    public List<Ticket> listarPorFecha(LocalDate fecha) {
        List<Ticket> resultado = new ArrayList<>();
        for (Ticket t : tickets)
            if (t.getFechaCompra().equals(fecha)) resultado.add(t);
        return resultado;
    }

    public List<Ticket> listarPorTipoVehiculo(String tipo) {
        List<Ticket> resultado = new ArrayList<>();
        for (Ticket t : tickets)
            if (t.getVehiculo().getTipo().equalsIgnoreCase(tipo)) resultado.add(t);
        return resultado;
    }

    public List<Ticket> listarPorTipoPasajero(String tipo) {
        List<Ticket> resultado = new ArrayList<>();
        for (Ticket t : tickets)
            if (t.getPasajero().getTipo().equalsIgnoreCase(tipo)) resultado.add(t);
        return resultado;
    }
}