/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB1;

/**
 *
 * @author jenniferbueso
 */
public class Ticket {
    private String nombrePasajero;
    private double totalPagado;
    
    public Ticket(String nombrePasajero, double totalPagado) {
        this.nombrePasajero = nombrePasajero;
        this.totalPagado = totalPagado;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public double getTotalPagado() {
        return totalPagado;
    }
    
    public String print() {
        StringBuilder infoTickets = new StringBuilder();
        
        infoTickets.append("Nombre de Pasajero: ").append(nombrePasajero).append("\n");
        infoTickets.append("Total Pagado: $. ").append(totalPagado).append("\n");
        
        return infoTickets.toString();
    }
    
}
