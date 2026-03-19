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
    protected String ruta;
    protected int capacidadMaxima;
    protected int pasajerosActuales;
    protected boolean disponible;
    protected double tarifaBase;  

    public Vehiculo(String placa, String ruta) {
        this.placa = placa;
        this.ruta = ruta;
        this.pasajerosActuales = 0;
        this.disponible = true;
    }

  
    
    
}
