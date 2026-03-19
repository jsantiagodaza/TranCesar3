package Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    
    @Override
public double calcularTotal() {
    double descuento = pasajero.calcularDescuento();
    return vehiculo.getTarifaBase() * (1 - descuento);
}

@Override
public void imprimirDetalle() {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    System.out.println("========== TICKET #" + id + " ==========");
    System.out.println("Pasajero  : " + pasajero.getNombre() + " (" + pasajero.getCedula() + ")");
    System.out.println("Tipo      : " + pasajero.getTipo());
    System.out.println("Vehiculo  : " + vehiculo.getTipo() + " - Placa: " + vehiculo.getPlaca());
    System.out.println("Ruta      : " + origen + " → " + destino);
    System.out.println("Fecha     : " + fechaCompra.format(fmt));
    System.out.println("Tarifa    : $" + String.format("%,.0f", vehiculo.getTarifaBase()));
    System.out.println("Descuento : " + (int)(pasajero.calcularDescuento() * 100) + "%");
    System.out.println("TOTAL     : $" + String.format("%,.0f", valorFinal));
    System.out.println("=====================================");
}
    
    public String toCSV() {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return id + ";" + pasajero.getCedula() + ";" + vehiculo.getPlaca() + ";" +
           fechaCompra.format(fmt) + ";" + origen + ";" + destino + ";" + valorFinal;
}

    public int getId() { return id; }
    public Pasajero getPasajero() { return pasajero; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public LocalDate getFechaCompra() { return fechaCompra; }
    public String getOrigen() { return origen; }
    public String getDestino() { return destino; }
    public double getValorFinal() { return valorFinal; }
    
    
    
}

