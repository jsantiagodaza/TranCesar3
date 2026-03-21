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


    private VehiculoService vehiculoService;
    private PersonaService personaService;
    private TicketService ticketService;
    private EstadisticaService estadisticaService;

    private VehiculoView vehiculoView;
    private PersonaView personaView;
    private TicketView ticketView;
    private ReporteView reporteView;

    private Scanner sc;

    public MenuPrincipal() {
        sc = new Scanner(System.in);

        vehiculoService    = new VehiculoService();
        personaService     = new PersonaService();
        ticketService      = new TicketService(vehiculoService, personaService);
        estadisticaService = new EstadisticaService(ticketService);

        vehiculoView = new VehiculoView(vehiculoService, sc);
        personaView  = new PersonaView(personaService, vehiculoService, sc);
        ticketView   = new TicketView(ticketService, personaService, sc);
        reporteView  = new ReporteView(estadisticaService, ticketService, vehiculoService, sc);
    }

public void iniciar() {
    System.out.println("+===========================================+");
    System.out.println("|         TRANSCESAR S.A.S.                 |");
    System.out.println("|   Sistema de Gestion de Tickets v2        |");
    System.out.println("+===========================================+");

    int opcion;
    do {
        System.out.println("\n+====================================+");
        System.out.println("|          MENU PRINCIPAL            |");
        System.out.println("+====================================+");
        System.out.println("|  1. Gestion de Rutas               |");
        System.out.println("|  2. Gestion de Vehiculos           |");
        System.out.println("|  3. Gestion de Personas            |");
        System.out.println("|  4. Venta de Tickets               |");
        System.out.println("|  5. Reportes y Estadisticas        |");
        System.out.println("|  0. Salir                          |");
        System.out.println("+====================================+");
        System.out.print("  Opcion: ");
        opcion = leerInt();

        switch (opcion) {
            case 1: rutaView.mostrarMenu();     break;
            case 2: vehiculoView.mostrarMenu(); break;
            case 3: personaView.mostrarMenu();  break;
            case 4: ticketView.mostrarMenu();   break;
            case 5: reporteView.mostrarMenu();  break;
            case 0: System.out.println("\n  Hasta luego!"); break;
            default: System.out.println("  Opcion invalida.");
        }
    } while (opcion != 0);

    sc.close();
}

    private int leerInt() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
