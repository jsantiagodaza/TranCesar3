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
}