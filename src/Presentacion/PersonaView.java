/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Logica.PersonaService;
import Logica.VehiculoService;
import Modelo.Conductor;
import Modelo.Pasajero;
import Modelo.Vehiculo;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class PersonaView {

    private PersonaService personaService;
    private VehiculoService vehiculoService;
    private Scanner sc;

    public PersonaView(PersonaService personaService,
            VehiculoService vehiculoService, Scanner sc) {
        this.personaService = personaService;
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
                case 1:
                    registrarConductor();
                    break;
                case 2:
                    listarConductores();
                    break;
                case 3:
                    asignarConductorAVehiculo();
                    break;
                case 4:
                    registrarPasajero();
                    break;
                case 5:
                    listarPasajeros();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("  Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private void registrarConductor() {
        System.out.println("\n--- Registrar Conductor ---");
        System.out.print("Cedula      : ");
        String cedula = sc.nextLine().trim();
        System.out.print("Nombre      : ");
        String nombre = sc.nextLine().trim();
        System.out.print("N° Licencia : ");
        String numLic = sc.nextLine().trim();
        System.out.println("Categoria: 1) B1  2) B2  3) C1  4) C2");
        System.out.print("Seleccione  : ");
        int cat = leerInt();
        String categoria;
        switch (cat) {
            case 1:
                categoria = "B1";
                break;
            case 2:
                categoria = "B2";
                break;
            case 3:
                categoria = "C1";
                break;
            case 4:
                categoria = "C2";
                break;
            default:
                categoria = "B1";
        }
        System.out.println(personaService.registrarConductor(cedula, nombre, numLic, categoria));
    }

    private void asignarConductorAVehiculo() {
        System.out.println("\n--- Asignar Conductor a Vehículo ---");
        System.out.print("Cedula del conductor : ");
        String cedula = sc.nextLine().trim();
        System.out.print("Placa del vehiculo   : ");
        String placa = sc.nextLine().trim().toUpperCase();

        Vehiculo v = vehiculoService.buscarPorPlaca(placa);
        if (v == null) {
            System.out.println("  ERROR: No se encontro vehiculo con placa " + placa);
            return;
        }
        System.out.println(personaService.asignarConductorAVehiculo(cedula, v));
    }

    private void registrarPasajero() {
        System.out.println("\n--- Registrar Pasajero ---");
        System.out.print("Cedula  : ");
        String cedula = sc.nextLine().trim();
        System.out.print("Nombre  : ");
        String nombre = sc.nextLine().trim();
        System.out.println("Tipo: 1) Regular  2) Estudiante  3) Adulto Mayor");
        System.out.print("Seleccione: ");
        int t = leerInt();
        String tipo;
        switch (t) {
            case 2:
                tipo = "estudiante";
                break;
            case 3:
                tipo = "adultomayor";
                break;
            default:
                tipo = "regular";
        }
        System.out.println(personaService.registrarPasajero(cedula, nombre, tipo));
    }

    private void listarConductores() {
        List<Conductor> lista = personaService.listarConductores();
        if (lista.isEmpty()) {
            System.out.println("  No hay conductores registrados.");
            return;
        }
        System.out.println("\n--- Conductores registrados (" + lista.size() + ") ---");
        for (Conductor c : lista) {
            c.imprimirDetalle();
        }
    }

    private void listarPasajeros() {
        List<Pasajero> lista = personaService.listarPasajeros();
        if (lista.isEmpty()) {
            System.out.println("  No hay pasajeros registrados.");
            return;
        }
        System.out.println("\n--- Pasajeros registrados (" + lista.size() + ") ---");
        for (Pasajero p : lista) {
            p.imprimirDetalle();
        }
    }

    private int leerInt() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
