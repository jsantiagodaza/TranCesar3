package Modelo;


import java.time.LocalDate;

public class PasajeroAdultoMayor extends Pasajero {

    public PasajeroAdultoMayor(String cedula, String nombre, LocalDate fechaNacimiento) {
        super(cedula, nombre, fechaNacimiento);
    }

    @Override
    public double calcularDescuento() { return 0.30; }

    @Override
    public void imprimirDetalle() {
        System.out.println("========== PASAJERO ==========");
        System.out.println("Cedula   : " + cedula);
        System.out.println("Nombre   : " + nombre);
        System.out.println("Edad     : " + getEdad() + " años");
        System.out.println("Tipo     : Adulto Mayor");
        System.out.println("Descuento: 30%");
        System.out.println("==============================");
    }
}