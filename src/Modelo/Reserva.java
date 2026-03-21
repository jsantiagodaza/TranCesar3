/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author 2jcue
 */
public class Reserva implements Imprimible {

    private static int contadorId = 1;
    private String codigo;
    private Pasajero pasajero;
    private Vehiculo vehiculo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaViaje;
    private EstadoReserva estado;   
    
}
