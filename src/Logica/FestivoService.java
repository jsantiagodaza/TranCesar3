package Logica;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.HashSet;
import java.util.Set;

public class FestivoService {

    // Festivos fijos Colombia (día/mes)
    private static final Set<MonthDay> FESTIVOS_FIJOS = new HashSet<>();
    
    static {
    FESTIVOS_FIJOS.add(MonthDay.of(1,  1));  // Año Nuevo
    FESTIVOS_FIJOS.add(MonthDay.of(5,  1));  // Día del Trabajo
    FESTIVOS_FIJOS.add(MonthDay.of(7,  20)); // Independencia
    FESTIVOS_FIJOS.add(MonthDay.of(8,  7));  // Batalla de Boyacá
    FESTIVOS_FIJOS.add(MonthDay.of(12, 8));  // Inmaculada Concepción
    FESTIVOS_FIJOS.add(MonthDay.of(12, 25)); // Navidad
        }
    
    public boolean esFestivo(LocalDate fecha) {
    return FESTIVOS_FIJOS.contains(MonthDay.of(fecha.getMonth(), fecha.getDayOfMonth()));
}
    
    
}