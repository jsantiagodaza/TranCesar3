/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Logica.PersonaService;
import Logica.ReservaService;
import Logica.TicketService;
import Modelo.Reserva;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class ReservaView {
 
    private ReservaService reservaService;
    private PersonaService personaService;
    private TicketService  ticketService;
    private Scanner sc;

    public ReservaView(ReservaService reservaService,
                       PersonaService personaService,
                       TicketService ticketService,
                       Scanner sc) {
        this.reservaService = reservaService;
        this.personaService = personaService;
        this.ticketService  = ticketService;
        this.sc = sc;
    }
     public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n+=======================================+");
            System.out.println("|         MODULO DE RESERVAS            |");
            System.out.println("+=======================================+");
            System.out.println("|  1. Crear reserva                     |");
            System.out.println("|  2. Cancelar reserva                  |");
            System.out.println("|  3. Listar reservas activas           |");
            System.out.println("|  4. Historial de reservas (pasajero)  |");
            System.out.println("|  5. Convertir reserva en ticket       |");
            System.out.println("|  6. Verificar reservas vencidas       |");
            System.out.println("|  0. Volver                            |");
            System.out.println("+=======================================+");
            System.out.print("  Opcion: ");
            opcion = leerInt();

            switch (opcion) {
                case 1: crearReserva();          
                break;
                case 2: cancelarReserva();       
                break;
                case 3: listarActivas();         
                break;
                case 4: historialPasajero();      
                break;
                case 5: convertirEnTicket();      
                break;
                case 6: verificarVencidas();     
                break;
                case 0: break;
                default: System.out.println("  Opcion invalida.");
            }
        } while (opcion != 0);
    }
     
     private void crearReserva() {
        System.out.println("\n--- Crear Reserva ---");
        System.out.print("Cedula del pasajero : ");
        String cedula = sc.nextLine().trim();

        System.out.print("Placa del vehiculo  : ");
        String placa = sc.nextLine().trim().toUpperCase();

        System.out.print("Fecha y hora del viaje (yyyy-MM-ddTHH:mm, ej: 2025-08-15T08:00): ");
        String fechaStr = sc.nextLine().trim();

        LocalDateTime fechaViaje;
        try {
            fechaViaje = LocalDateTime.parse(fechaStr);
        } catch (DateTimeParseException e) {
            System.out.println("  ERROR: Formato de fecha invalido. Use yyyy-MM-ddTHH:mm");
            return;
        }

        if (fechaViaje.isBefore(LocalDateTime.now())) {
            System.out.println("  ERROR: La fecha del viaje debe ser futura.");
            return;
        }

        System.out.println(reservaService.crearReserva(
                cedula, placa, fechaViaje, personaService));
    }
      private void listarActivas() {
        List<Reserva> lista = reservaService.listarActivas();
        if (lista.isEmpty()) {
            System.out.println("\n  No hay reservas activas en este momento.");
            return;
        }
        System.out.println("\n--- Reservas activas (" + lista.size() + ") ---");
        for (Reserva r : lista) r.imprimirDetalle();
    }
      private void historialPasajero() {
        System.out.println("\n--- Historial de Reservas por Pasajero ---");
        System.out.print("Cedula del pasajero: ");
        String cedula = sc.nextLine().trim();

        List<Reserva> lista = reservaService.historialPasajero(cedula);
        if (lista.isEmpty()) {
            System.out.println("  No hay reservas registradas para ese pasajero.");
            return;
        }
        System.out.println("\n  Historial (" + lista.size() + " reserva(s)):");
        for (Reserva r : lista) r.imprimirDetalle();
    }

            private void convertirEnTicket() {
        System.out.println("\n--- Convertir Reserva en Ticket ---");
        System.out.print("Codigo de la reserva (ej: RES-0001): ");
        String codigo = sc.nextLine().trim().toUpperCase();

        String resultado = reservaService.convertirEnTicket(
                codigo, personaService, ticketService);
        System.out.println("  " + resultado);
    }
  private void cancelarReserva() {
        System.out.println("\n--- Cancelar Reserva ---");
        System.out.print("Codigo de la reserva (ej: RES-0001): ");
        String codigo = sc.nextLine().trim().toUpperCase();
        System.out.println(reservaService.cancelarReserva(codigo));
    }

                   private void verificarVencidas() {
                   }
                    
    private int leerInt() {
        try { return Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException e) { return -1; }
    }
}
