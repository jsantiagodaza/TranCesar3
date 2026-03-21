/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author 2jcue
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Reserva implements Imprimible {

    private static int contadorId = 1;
    private String codigo;
    private Pasajero pasajero;
    private Vehiculo vehiculo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaViaje;
    private EstadoReserva estado;   
    
     public Reserva(Pasajero pasajero, Vehiculo vehiculo, LocalDateTime fechaViaje) {
        this.codigo        = "RES-" + String.format("%04d", contadorId++);
        this.pasajero      = pasajero;
        this.vehiculo      = vehiculo;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaViaje    = fechaViaje;
        this.estado        = EstadoReserva.ACTIVA;
    }
}
