package Modelo;


//JEMG :D

import java.time.LocalDate;

public class PasajeroEstudiante extends Pasajero {

    public PasajeroEstudiante(String cedula, String nombre, LocalDate fechaNacimiento) {
        super(cedula, nombre, fechaNacimiento);
    }

    @Override
    public double calcularDescuento() { return 0.15; }

    @Override
    public void imprimirDetalle() {
        System.out.println("========== PASAJERO ==========");
        System.out.println("Cedula   : " + cedula);
        System.out.println("Nombre   : " + nombre);
        System.out.println("Edad     : " + getEdad() + " años");
        System.out.println("Tipo     : Estudiante");
        System.out.println("Descuento: 15%");
        System.out.println("==============================");
    }
}
