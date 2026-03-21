/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Logica.VehiculoService;
import Modelo.Vehiculo;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class VehiculoView {
    private VehiculoService vehiculoService;
    private Scanner sc;
   public VehiculoView(VehiculoService vehiculoService, Scanner sc) {
        this.vehiculoService = vehiculoService;
        this.sc = sc;
    }

  public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n╔==============================+");
            System.out.println("|      GESTION DE VEHICULOS    |");
            System.out.println("+==============================+");
            System.out.println("|  1. Registrar vehiculo       |");
            System.out.println("|  2. Listar vehiculos         |");
            System.out.println("|  3. Buscar por placa         |");
            System.out.println("|  0. Volver                   |");
            System.out.println("+==============================+");
            System.out.print("  Opcion: ");
            opcion = leerInt();

            switch (opcion) {
                case 1: registrarVehiculo(); break;
                case 2: listarVehiculos();   break;
                case 3: buscarPorPlaca();    break;
                case 0: break;
                default: System.out.println("  Opcion invalida.");
            }
        } while (opcion != 0);
    }

       private void registrarVehiculo() {
        System.out.println("\n--- Registrar Vehiculo ---");
        System.out.println("  1) Buseta   2) MicroBus   3) Bus");
        System.out.print("Tipo     : ");
        int t = leerInt();
        String tipo;
        switch (t) {
            case 1: tipo = "buseta";   break;
            case 2: tipo = "microbus"; break;
            case 3: tipo = "bus";      break;
            default: System.out.println("  Tipo inválido."); return;
        }

        // Mostrar rutas disponibles
        if (rutaService.listarTodos().isEmpty()) {
            System.out.println("  No hay rutas registradas. Registre una ruta primero.");
            return;
        }
        System.out.println("  Rutas disponibles:");
        for (Modelo.Ruta r : rutaService.listarTodos())
            System.out.println("    [" + r.getCodigo() + "] "
                    + r.getCiudadOrigen() + " → " + r.getCiudadDestino());

        System.out.print("Placa        : ");
        String placa = sc.nextLine().trim().toUpperCase();
        System.out.print("Codigo ruta  : ");
        String codRuta = sc.nextLine().trim().toUpperCase();

        System.out.println(vehiculoService.registrarVehiculo(tipo, placa, codRuta));
    }


  private void listarVehiculos() {
        List<Vehiculo> lista = vehiculoService.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("  No hay vehiculos registrados.");
            return;
        }
        System.out.println("\n--- Vehiculos registrados (" + lista.size() + ") ---");
        for (Vehiculo v : lista) v.imprimirDetalle();
    }

      private void buscarPorPlaca() {
        System.out.print("Ingrese placa: ");
        String placa = sc.nextLine().trim().toUpperCase();
        Vehiculo v = vehiculoService.buscarPorPlaca(placa);
        if (v == null) System.out.println("  No se encontro vehiculo con placa " + placa);
        else v.imprimirDetalle();
    }

     private int leerInt() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
