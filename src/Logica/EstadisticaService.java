/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author 2jcue
 */
import Modelo.*;
import java.util.*;
  
    public class EstadisticaService {

    private TicketService ticketService;

    public EstadisticaService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public double calcularTotalRecaudado() {
        double total = 0;
        for (Ticket t : ticketService.listarTodos())
            total += t.getValorFinal();
        return total;
    }

}

