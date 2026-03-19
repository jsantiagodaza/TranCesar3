package Modelo;

import java.time.LocalDate;

public class Ticket implements Imprimible, Calculable {
    private static int contadorId = 1;
    private int id;
    private Pasajero pasajero;
    private Vehiculo vehiculo;
    private LocalDate fechaCompra;
    private String origen;
    private String destino;
    private double valorFinal;
    
    
    
    public Ticket(Pasajero pasajero, Vehiculo vehiculo, String origen, String destino) {
    this.id = contadorId++;
    this.pasajero = pasajero;
    this.vehiculo = vehiculo;
    this.fechaCompra = LocalDate.now();
    this.origen = origen;
    this.destino = destino;
    this.valorFinal = calcularTotal();
}

// Constructor para cargar desde archivo
public Ticket(int id, Pasajero pasajero, Vehiculo vehiculo,
              LocalDate fechaCompra, String origen, String destino, double valorFinal) {
    this.id = id;
    this.pasajero = pasajero;
    this.vehiculo = vehiculo;
    this.fechaCompra = fechaCompra;
    this.origen = origen;
    this.destino = destino;
    this.valorFinal = valorFinal;
    if (id >= contadorId) contadorId = id + 1;
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

