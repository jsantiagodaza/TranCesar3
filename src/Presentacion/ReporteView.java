/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Logica.EstadisticaService;
import Logica.TicketService;
import Logica.VehiculoService;
import java.util.Map;
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
 int opcion;
        do {
            System.out.println("\n╔========================================+");
            System.out.println("|      REPORTES Y ESTADISTICAS           |");
            System.out.println("+========================================+");
            System.out.println("|  1. Total dinero recaudado             |");
            System.out.println("|  2. Pasajeros por tipo                 |");
            System.out.println("|  3. Veiculo con mas tickets           |");
            System.out.println("|  4. Tickets vendidos por vehiculo      |");
            System.out.println("|  0. Volver                             |");
            System.out.println("+========================================+");
            System.out.print("  Opcion: ");
            opcion = leerInt();

            switch (opcion) {
                case 1: reporteTotalRecaudado();        break;
                case 2: reportePasajerosPorTipo();      break;
                case 3: reporteVehiculoConMasTickets(); break;
                case 4: reporteTicketsPorVehiculo();    break;
                case 0: break;
                default: System.out.println("  Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private void reporteTotalRecaudado() {

    }

    private void reporteVehiculoConMasTickets() {
    }

    private void reporteTicketsPorVehiculo() {
    }
    private void reportePasajerosPorTipo() {
        Map<String, Integer> mapa = estadisticaService.pasajerosPorTipo();
        int total = ticketService.listarTodos().size();
        System.out.println("\n--- Pasajeros por tipo ---");
        System.out.printf("  %-15s : %d%n", "Regular",      mapa.getOrDefault("Regular",     0));
        System.out.printf("  %-15s : %d%n", "Estudiante",   mapa.getOrDefault("Estudiante",  0));
        System.out.printf("  %-15s : %d%n", "Adulto Mayor", mapa.getOrDefault("AdultoMayor", 0));
        System.out.printf("  %-15s : %d%n", "TOTAL tickets", total);
    }
    private int leerInt() {
        return 0;

    }
}
