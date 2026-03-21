package Logica;

import Persistencia.RutaDAO;
import Modelo.Ruta;
import java.util.ArrayList;
import java.util.List;

public class RutaService {

    private RutaDAO dao;
    private List<Ruta> rutas;
    
    public RutaService() {
    this.dao   = new RutaDAO();
    this.rutas = dao.cargarTodos();
}
    
    
    
    
    
    
    
}