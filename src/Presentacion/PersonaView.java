/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Logica.PersonaService;
import Logica.VehiculoService;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class PersonaView {
    private PersonaService  personaService;
    private VehiculoService vehiculoService;
    private Scanner sc;
    
     public PersonaView(PersonaService personaService,
                       VehiculoService vehiculoService, Scanner sc) {
        this.personaService  = personaService;
        this.vehiculoService = vehiculoService;
        this.sc = sc;
    }
    public void mostrarMenu() {
     
    }
    private void registrarConductor() {
        
    }
    private void asignarConductorAVehiculo() {
    }
        private void registrarPasajero() {
        }
            private void listarPasajeros() {
            }
                private int leerInt() {
                return 0;
                }
}
