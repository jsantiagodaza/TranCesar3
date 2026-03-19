package Modelo;


public class PasajeroRegular extends Pasajero {

    public PasajeroRegular(String cedula, String nombre) {
        super(cedula, nombre, "Regular");
    }

    @Override
    public double calcularDescuento() { return 0.0; }

    @Override
    public void imprimirDetalle() {
        System.out.println("========== PASAJERO ==========");
        System.out.println("Cedula   : " + cedula);
        System.out.println("Nombre   : " + nombre);
        System.out.println("Tipo     : Regular");
        System.out.println("Descuento: 0%");
        System.out.println("==============================");
    }
}
