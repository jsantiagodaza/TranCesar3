/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Logica.EstadisticaService;
import Logica.TicketService;
import Logica.VehiculoService;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class ReporteView {
private EstadisticaService estadisticaService;
    private TicketService      ticketService;
    private VehiculoService    vehiculoService;
    private Scanner sc;
    
    
    public ReporteView(EstadisticaService estadisticaService,
                       TicketService ticketService,
                       VehiculoService vehiculoService,
                       Scanner sc) {
        this.estadisticaService = estadisticaService;
        this.ticketService      = ticketService;
        this.vehiculoService    = vehiculoService;
        this.sc = sc;
    }

    public void mostrarMenu() {

    }

    private void reporteTotalRecaudado() {

    }

    private void reporteVehiculoConMasTickets() {
    }

    private void reporteTicketsPorVehiculo() {
    }

    private int leerInt() {
        return 0;

    }
}
