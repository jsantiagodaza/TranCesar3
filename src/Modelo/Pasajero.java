package Modelo;


import java.time.LocalDate;
import java.time.Period;

public abstract class Pasajero extends Persona {
    protected String tipo;
    protected LocalDate fechaNacimiento;

    public Pasajero(String cedula, String nombre, LocalDate fechaNacimiento) {
        super(cedula, nombre);
        this.fechaNacimiento = fechaNacimiento;
        this.tipo = determinarTipo();
    }

    private String determinarTipo() {
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        if (edad >= 60) return "AdultoMayor";
        return "Regular"; // subclase puede sobrescribir
    }

    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public String getTipo() { return tipo; }

    public abstract double calcularDescuento();

    public String toCSV() {
        return cedula + ";" + nombre + ";" + tipo + ";" + fechaNacimiento.toString();
    }
}