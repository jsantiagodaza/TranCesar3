/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author 2jcue
 */
import Persistencia.VehiculoDAO;
import Modelo.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoService {

    private VehiculoDAO dao;
    private List<Vehiculo> vehiculos;

    public VehiculoService() {
        this.dao = new VehiculoDAO();
        this.vehiculos = dao.cargarTodos();
    }
}
