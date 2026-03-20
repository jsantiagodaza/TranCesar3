/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Logica.PersonaService;
import Logica.TicketService;
import Modelo.Ticket;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class TicketView {
     private TicketService   ticketService;
    private PersonaService  personaService;
    private Scanner sc;
    
   public TicketView(TicketService ticketService,
                      PersonaService personaService, Scanner sc) {
        this.ticketService  = ticketService;
        this.personaService = personaService;
        this.sc = sc;
    }
     public void mostrarMenu() {
         int opcion;
         do {
            System.out.println("\n╔==============================+");
            System.out.println("|      VENTA DE TICKETS        |");
            System.out.println("+==============================+");
            System.out.println("|  1. Vender ticket            |");
            System.out.println("|  2. Listar todos los tickets |");
            System.out.println("|  0. Volver                   |");
            System.out.println("+==============================+");
            System.out.print("  Opcion: ");
            opcion = leerInt();

            switch (opcion) {
                case 1: venderTicket();  break;
                case 2: listarTickets(); break;
                case 0: break;
                default: System.out.println("  Opcion invalida.");
            }
        } while (opcion != 0);
     }
     
        private void venderTicket() {
        System.out.println("\n--- Vender Ticket ---");
        System.out.print("Cedula del pasajero : ");
        String cedula  = sc.nextLine().trim();
        System.out.print("Placa del vehiculo  : ");
        String placa   = sc.nextLine().trim().toUpperCase();
        System.out.print("Ciudad de origen    : ");
        String origen  = sc.nextLine().trim();
        System.out.print("Ciudad de destino   : ");
        String destino = sc.nextLine().trim();

        System.out.println(ticketService.venderTicket(
                cedula, placa, origen, destino, personaService));
    }
              private void listarTickets() {
        List<Ticket> lista = ticketService.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("  No hay tickets registrados.");
            return;
        }
        System.out.println("\n--- Tickets vendidos (" + lista.size() + ") ---");
        for (Ticket t : lista) t.imprimirDetalle();
    }
             private int leerInt() {
             return 0;
             }
}
