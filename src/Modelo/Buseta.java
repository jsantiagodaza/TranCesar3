/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author 2jcue
 */

public class Buseta extends Vehiculo {

    public Buseta(String placa, String ruta) {
        super(placa, ruta);
        this.capacidadMaxima = 19;
        this.tarifaBase = 8000;
    }

    @Override
    public String getTipo() { return "Buseta"; }

    @Override
    public void imprimirDetalle() {
        System.out.println("========== BUSETA ==========");
        System.out.println("Placa           : " + placa);
        System.out.println("Ruta            : " + ruta);
        System.out.println("Capacidad máx.  : " + capacidadMaxima);
        System.out.println("Pasajeros act.  : " + pasajerosActuales);
        System.out.println("Cupos disponib. : " + getCuposDisponibles());
        System.out.println("Tarifa base     : $" + String.format("%,.0f", tarifaBase));
        System.out.println("Disponible      : " + (disponible ? "Sí" : "No"));
        System.out.println("============================");
    }
}
