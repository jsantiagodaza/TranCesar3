/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Logica.EstadisticaService;
import Logica.PersonaService;
import Logica.TicketService;
import Logica.VehiculoService;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class MenuPrincipal {
    private VehiculoService    vehiculoService;
    private PersonaService     personaService;
    private TicketService      ticketService;
    private EstadisticaService estadisticaService;

    private VehiculoView vehiculoView;
    private PersonaView  personaView;
    private TicketView   ticketView;
    private ReporteView  reporteView;

    private Scanner sc;

    
     public MenuPrincipal() {
        sc = new Scanner(System.in);

    }
     
      public void iniciar() {
     
    }
       private int leerInt() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
