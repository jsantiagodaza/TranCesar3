/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Logica.EstadisticaService;
import Logica.TicketService;
import Logica.VehiculoService;
import Modelo.Ticket;
import Modelo.Vehiculo;
import java.time.LocalDate;
import java.util.List;
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
double total = estadisticaService.calcularTotalRecaudado();
        System.out.println("\n╔========================================+");
        System.out.printf ("|  TOTAL RECAUDADO : $%,14.0f  |%n", total);
        System.out.println("+========================================+");
    }

     private void reporteVehiculoConMasTickets() {
        Vehiculo v = estadisticaService.vehiculoConMasTickets();
        if (v == null) {
            System.out.println("  No hay tickets vendidos todavia.");
            return;
        }
        System.out.println("\n--- Vehiculo con más tickets ---");
        v.imprimirDetalle();
        System.out.println("  Tickets vendidos: " +
                estadisticaService.ticketsPorVehiculo(v.getPlaca()));
    }

    private void reporteTicketsPorVehiculo() {
        System.out.print("Ingrese placa del vehiculo: ");
        String placa = sc.nextLine().trim().toUpperCase();
        Vehiculo v = vehiculoService.buscarPorPlaca(placa);
        if (v == null) {
            System.out.println("  No se encontro vehiculo con placa " + placa);
            return;
        }
        System.out.println("\n  Vehiculo : " + v.getTipo() + " - " + placa);
        System.out.println("  Ruta     : " + v.getRuta());
        System.out.println("  Tickets  : " + estadisticaService.ticketsPorVehiculo(placa));
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
        private void reportePorTipoPasajero() {
        System.out.println("Tipo: 1) Regular  2) Estudiante  3) Adulto Mayor");
        System.out.print("Seleccione: ");
        int op = leerInt();
        String tipo;
        switch (op) {
            case 1: tipo = "Regular";     break;
            case 2: tipo = "Estudiante";  break;
            case 3: tipo = "AdultoMayor"; break;
            default: System.out.println("  Opcion invalida."); return;
        }
        List<Ticket> lista = ticketService.listarPorTipoPasajero(tipo);
        System.out.println("\n--- Tickets de pasajero tipo " + tipo + " (" + lista.size() + ") ---");
        if (lista.isEmpty()) { System.out.println("  Sin tickets para ese tipo."); return; }
        for (Ticket t : lista) t.imprimirDetalle();
    }
        private void resumenDiaActual() {
        LocalDate hoy = LocalDate.now();
        List<Ticket> lista = ticketService.listarPorFecha(hoy);
        double totalHoy = 0;
        for (Ticket t : lista) totalHoy += t.getValorFinal();

        System.out.println("\n======================================");
        System.out.println("|        RESUMEN DEL DIA: " + hoy + "  |");
        System.out.println("======================================");
        System.out.printf ("|  Tickets vendidos = %-17d|%n", lista.size());
        System.out.printf ("|  Total recaudado  = $%,14.0f  |%n", totalHoy);
        System.out.println("======================================");
    }
  private int leerInt() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
