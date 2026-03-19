/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author 2jcue
 */
import Modelo.*;
import java.util.*;
  
    public class EstadisticaService {

    private TicketService ticketService;

    public EstadisticaService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public double calcularTotalRecaudado() {
        double total = 0;
        for (Ticket t : ticketService.listarTodos())
            total += t.getValorFinal();
        return total;
    }

    public Map<String, Integer> pasajerosPorTipo() {
        Map<String, Integer> mapa = new LinkedHashMap<>();
        mapa.put("Regular",     0);
        mapa.put("Estudiante",  0);
        mapa.put("AdultoMayor", 0);

        for (Ticket t : ticketService.listarTodos()) {
            String tipo = t.getPasajero().getTipo();
            mapa.put(tipo, mapa.getOrDefault(tipo, 0) + 1);
        }
        return mapa;
    }
    
     public Vehiculo vehiculoConMasTickets() {
        Map<String, Integer> conteo        = new HashMap<>();
        Map<String, Vehiculo> mapaVehiculos = new HashMap<>();

        for (Ticket t : ticketService.listarTodos()) {
            String placa = t.getVehiculo().getPlaca();
            conteo.put(placa, conteo.getOrDefault(placa, 0) + 1);
            mapaVehiculos.put(placa, t.getVehiculo());
        }

        String placaMax = null;
        int max = 0;
        for (Map.Entry<String, Integer> e : conteo.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                placaMax = e.getKey();
            }
        }
        return placaMax != null ? mapaVehiculos.get(placaMax) : null;
    }
    
}

