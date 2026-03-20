/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author 2jcue
 */
public class Microbus extends Vehiculo {

    public Microbus(String placa, String ruta) {
        super(placa, ruta);
        this.capacidadMaxima = 25;
        this.tarifaBase = 10000;
    }

    @Override
    public String getTipo() { return "MicroBus"; }

    @Override
    public void imprimirDetalle() {
        System.out.println("========== MICROBUS ==========");
        System.out.println("Placa           : " + placa);
        System.out.println("Ruta            : " + ruta);
        System.out.println("Capacidad max.  : " + capacidadMaxima);
        System.out.println("Pasajeros act.  : " + pasajerosActuales);
        System.out.println("Cupos disponib. : " + getCuposDisponibles());
        System.out.println("Tarifa base     : $" + String.format("%,.0f", tarifaBase));
        System.out.println("Disponible      : " + (disponible ? "Sí" : "No"));
        System.out.println("==============================");
    }
}

  


