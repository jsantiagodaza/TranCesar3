/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Logica.PersonaService;
import Logica.TicketService;
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
     }
     
         private void venderTicket() {
         }
             private void listarTickets() {
             }
             private int leerInt() {
             return 0;
             }
}
