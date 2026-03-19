/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author 2jcue
 */

public class Conductor extends Persona {
    private String numeroLicencia;
    private String categoriaLicencia;

    public Conductor(String cedula, String nombre, String numeroLicencia, String categoriaLicencia) {
        super(cedula, nombre);
        this.numeroLicencia = numeroLicencia;
        this.categoriaLicencia = categoriaLicencia;
    }
    
        public String getNumeroLicencia() { return numeroLicencia; }
    public void setNumeroLicencia(String numeroLicencia) { this.numeroLicencia = numeroLicencia; }
    public String getCategoriaLicencia() { return categoriaLicencia; }
    public void setCategoriaLicencia(String categoriaLicencia) { this.categoriaLicencia = categoriaLicencia; }

    public boolean tieneLicencia() {
        return numeroLicencia != null && !numeroLicencia.trim().isEmpty();
    }

    @Override
    public void imprimirDetalle() {
        System.out.println("========== CONDUCTOR ==========");
        System.out.println("Cedula      : " + cedula);
        System.out.println("Nombre      : " + nombre);
        System.out.println("N° Licencia : " + (numeroLicencia != null ? numeroLicencia : "Sin licencia"));
        System.out.println("Categoria   : " + (categoriaLicencia != null ? categoriaLicencia : "N/A"));
        System.out.println("================================");
    }

    public String toCSV() {
        return cedula + ";" + nombre + ";" +
               (numeroLicencia != null ? numeroLicencia : "") + ";" +
               (categoriaLicencia != null ? categoriaLicencia : "");
    }
}
