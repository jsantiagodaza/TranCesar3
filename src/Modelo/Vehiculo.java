/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author 2jcue
 */
public abstract class Vehiculo implements Imprimible {
    protected String placa;
    protected Ruta ruta;
    protected int capacidadMaxima;
    protected int pasajerosActuales;
    protected boolean disponible;
    protected double tarifaBase;

    public Vehiculo(String placa, Ruta ruta) {
        this.placa = placa;
        this.ruta  = ruta;
        this.pasajerosActuales = 0;
        this.disponible = true;
    }

    public boolean tieneCupos() {
        return pasajerosActuales < capacidadMaxima;
    }

    public int getCuposDisponibles() {
        return capacidadMaxima - pasajerosActuales;
    }

    public void agregarPasajero() {
        if (tieneCupos()) pasajerosActuales++;
    }

    public void liberarPasajero() {
        if (pasajerosActuales > 0) pasajerosActuales--;
    }

    public String getPlaca()              { return placa; }
    public void setPlaca(String p)        { this.placa = p; }
    public Ruta getRuta()                 { return ruta; }
    public void setRuta(Ruta r)           { this.ruta = r; }
    public int getCapacidadMaxima()       { return capacidadMaxima; }
    public int getPasajerosActuales()     { return pasajerosActuales; }
    public void setPasajerosActuales(int n) { this.pasajerosActuales = n; }
    public boolean isDisponible()         { return disponible; }
    public void setDisponible(boolean d)  { this.disponible = d; }
    public double getTarifaBase()         { return tarifaBase; }

    public abstract String getTipo();

    public String toCSV() {
        return placa + ";" + ruta.getCodigo() + ";"
               + pasajerosActuales + ";" + (disponible ? "1" : "0");
    }
}