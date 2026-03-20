/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Logica.PersonaService;
import Logica.VehiculoService;
import Modelo.Conductor;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class PersonaView {
    private PersonaService  personaService;
    private VehiculoService vehiculoService;
    private Scanner sc;
    
     public PersonaView(PersonaService personaService,
                       VehiculoService vehiculoService, Scanner sc) {
        this.personaService  = personaService;
        this.vehiculoService = vehiculoService;
        this.sc = sc;
    }
    public void mostrarMenu() {
      int opcion;
        do {
            System.out.println("\n╔===================================+");
            System.out.println("|       GESTION DE PERSONAS         |");
            System.out.println("+===================================+");
            System.out.println("|  1. Registrar conductor           |");
            System.out.println("|  2. Listar conductores            |");
            System.out.println("|  3. Asignar conductor a vehiculo  |");
            System.out.println("|  4. Registrar pasajero            |");
            System.out.println("|  5. Listar pasajeros              |");
            System.out.println("|  0. Volver                        |");
            System.out.println("+===================================+");
            System.out.print("  Opcion: ");
            opcion = leerInt();

            switch (opcion) {
                case 1: registrarConductor();        break;
                case 2: listarConductores();         break;
                case 3: asignarConductorAVehiculo(); break;
                case 4: registrarPasajero();         break;
                case 5: listarPasajeros();           break;
                case 0: break;
                default: System.out.println("  Opcion invalida.");
            }
        } while (opcion != 0);
    }
    private void registrarConductor() {
        
    }
    private void asignarConductorAVehiculo() {
    }
        private void registrarPasajero() {
            
        }
        
         private void listarConductores() {
        List<Conductor> lista = personaService.listarConductores();
        if (lista.isEmpty()) {
            System.out.println("  No hay conductores registrados.");
            return;
        }
        System.out.println("\n--- Conductores registrados (" + lista.size() + ") ---");
        for (Conductor c : lista) c.imprimirDetalle();
    }
         
            private void listarPasajeros() {
            }
                private int leerInt() {
                return 0;
                }
}
