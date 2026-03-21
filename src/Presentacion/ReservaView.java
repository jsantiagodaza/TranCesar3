/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Logica.PersonaService;
import Logica.ReservaService;
import Logica.TicketService;
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
      public void crearReserva(){
      }
       private void listarActivas() {
       }
           private void historialPasajero() {
           }
               private void convertirEnTicket() {
               }
                   private void verificarVencidas() {
                   }
                       private int leerInt() {
                       return 0;
                       }
}
