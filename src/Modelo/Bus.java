/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author 2jcue
 */
 public class Bus extends Vehiculo {

    public Bus(String placa, Ruta ruta) {
        super(placa, ruta);
        this.capacidadMaxima = 45;
        this.tarifaBase = 15000;
    }

    @Override
    public String getTipo() { return "Bus"; }

    @Override
    public void imprimirDetalle() {
        System.out.println("========== BUS ==========");
        System.out.println("Placa           : " + placa);
        System.out.println("Ruta            : " + ruta.getCiudadOrigen() + " → " + ruta.getCiudadDestino());
        System.out.println("Capacidad max.  : " + capacidadMaxima);
        System.out.println("Pasajeros act.  : " + pasajerosActuales);
        System.out.println("Cupos disponib. : " + getCuposDisponibles());
        System.out.println("Tarifa base     : $" + String.format("%,.0f", tarifaBase));
        System.out.println("Disponible      : " + (disponible ? "Sí" : "No"));
        System.out.println("=========================");
    }
}
