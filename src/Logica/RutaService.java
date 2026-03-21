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
        public String registrarRuta(String codigo, String origen, String destino,
                            double distancia, int tiempoMinutos) {
         if (buscarPorCodigo(codigo) != null)
        return "ERROR: Ya existe una ruta con el codigo " + codigo;
         if (codigo == null || codigo.trim().isEmpty())
        return "ERROR: El codigo no puede estar vacio.";
         
         Ruta r = new Ruta(codigo.toUpperCase(), origen, destino, distancia, tiempoMinutos);
        rutas.add(r);
        dao.guardar(r);
        return "OK: Ruta " + codigo + " (" + origen + " → " + destino + ") registrada.";
        
        }
        
        
        public Ruta buscarPorCodigo(String codigo) {
        for (Ruta r : rutas)
        if (r.getCodigo().equalsIgnoreCase(codigo)) return r;
    return null;
    }
        
        
        
        
        
    
    
    
    
    
    
}