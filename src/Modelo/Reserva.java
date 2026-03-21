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
         // Constructor para cargar desde archivo
      public Reserva(String codigo, Pasajero pasajero, Vehiculo vehiculo,
                   LocalDateTime fechaCreacion, LocalDateTime fechaViaje,
                   EstadoReserva estado) {
        this.codigo        = codigo;
        this.pasajero      = pasajero;
        this.vehiculo      = vehiculo;
        this.fechaCreacion = fechaCreacion;
        this.fechaViaje    = fechaViaje;
        this.estado        = estado;

        // Mantener contador coherente
        try {
            int num = Integer.parseInt(codigo.replace("RES-", ""));
            if (num >= contadorId) contadorId = num + 1;
        } catch (NumberFormatException ignored) {}
    }
      
       // ── Lógica de negocio ────────────────────────────────────

    public boolean estaVencida() {
        return estado == EstadoReserva.ACTIVA &&
               LocalDateTime.now().isAfter(fechaCreacion.plusHours(24));
    }

    public void cancelar() {
        if (estado == EstadoReserva.ACTIVA) {
            estado = EstadoReserva.CANCELADA;
            vehiculo.liberarPasajero();
        }
    }

    public void convertir() {
        if (estado == EstadoReserva.ACTIVA) {
            estado = EstadoReserva.CONVERTIDA;
            vehiculo.liberarPasajero(); // el ticket re-agrega por su cuenta
        }
    }

    
}
