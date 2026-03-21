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
      public void mosrarMenu() {
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
