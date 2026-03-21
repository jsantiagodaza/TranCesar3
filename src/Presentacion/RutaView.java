/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

/**
 *
 * @author 2jcue
 */
import Modelo.Ruta;
import Logica.RutaService;
import java.util.List;
import java.util.Scanner;

public class RutaView {

    private RutaService rutaService;
    private Scanner sc;

    public RutaView(RutaService rutaService, Scanner sc) {
        this.rutaService = rutaService;
        this.sc = sc;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n╔==============================+");
            System.out.println("|       GESTION DE RUTAS       |");
            System.out.println("+==============================+");
            System.out.println("|  1. Registrar ruta           |");
            System.out.println("|  2. Listar rutas             |");
            System.out.println("|  0. Volver                   |");
            System.out.println("+==============================+");
            System.out.print("  Opcion: ");
            opcion = leerInt();

            switch (opcion) {
                case 1: registrarRuta(); 
                break;
                case 2: listarRutas();  
                break;
                case 0: break;
                default: System.out.println("  Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private void registrarRuta() {
        System.out.println("\n--- Registrar Ruta ---");
        System.out.print("Codigo      : ");
        String codigo  = sc.nextLine().trim().toUpperCase();
        System.out.print("Origen      : ");
        String origen  = sc.nextLine().trim();
        System.out.print("Destino     : ");
        String destino = sc.nextLine().trim();
        System.out.print("Distancia (km): ");
        double dist = leerDouble();
        System.out.print("Tiempo (min): ");
        int tiempo = leerInt();

        System.out.println(rutaService.registrarRuta(codigo, origen, destino, dist, tiempo));
    }

    private void listarRutas() {
        List<Ruta> lista = rutaService.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("  No hay rutas registradas.");
            return;
        }
        System.out.println("\n--- Rutas registradas (" + lista.size() + ") ---");
        for (Ruta r : lista) r.imprimirDetalle();
    }

    private int leerInt() {
        try { return Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException e) { return -1; }
    }

    private double leerDouble() {
        try { return Double.parseDouble(sc.nextLine().trim()); }
        catch (NumberFormatException e) { return 0; }
    }
}
