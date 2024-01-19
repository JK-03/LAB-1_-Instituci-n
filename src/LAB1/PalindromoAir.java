/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB1;

import javax.swing.JOptionPane;

/**
 *
 * @author jenniferbueso
 */
public class PalindromoAir {
    private Ticket[] asientosCantidad;
    
    public PalindromoAir() {
         asientosCantidad = new Ticket[30];
    }
    
    public int firstAvailable() {
        return firstAvailable(0);
    }
    
    private int firstAvailable(int posicion) {
        if (posicion < asientosCantidad.length){
            if (asientosCantidad[posicion] == null) {
                return posicion;
            }
            return firstAvailable(posicion + 1);
        }
        return -1;
    } 
    
    public int searchPassenger(String name) {
        return searchPassenger(name, 0);
    }
    
    private int searchPassenger(String name, int posicion) {
        name = name.toUpperCase();
        if (posicion < asientosCantidad.length) {
            if (asientosCantidad[posicion] != null && asientosCantidad[posicion].getNombrePasajero().toUpperCase().equals(name)) {
                return posicion;
            }
            return searchPassenger(name, posicion + 1);
        }
        return -1;
    }
    
    private boolean isPalindromo(String name) {
        name = name.toUpperCase();
        return isPalindromo(name, 0, name.length() - 1);
    }
    
    public boolean isPalindromo(String name, int posicionInicial, int posicionFinal) {
        if (posicionFinal >= posicionInicial) {
            if (name.charAt(posicionInicial) == (name.charAt(posicionFinal))) {
                return isPalindromo(name, posicionInicial + 1, posicionFinal - 1);
            }
            return false;
        }
        return true;
    }
    
    public String printPassengers() {
        StringBuilder passengersInfo = new StringBuilder();
        printPassengers(passengersInfo, 0);
        return passengersInfo.toString();
    }
    
    private void printPassengers(StringBuilder passengersInfo, int posicion) {
        if (posicion < asientosCantidad.length) {
            if (asientosCantidad[posicion] != null) {
                passengersInfo.append(asientosCantidad[posicion].getNombrePasajero()).append(" - $. ").append(asientosCantidad[posicion].getTotalPagado()).append("\n");
                System.out.println(passengersInfo);
            }
            printPassengers(passengersInfo, posicion + 1);
        }
    }
    
    public double income() {
        return income(0, 0);
    }
    
    private double income(double numero, int posicion) {
        if (posicion >= asientosCantidad.length) {
            return numero;
        }
        if (asientosCantidad[posicion] != null) {
            numero += asientosCantidad[posicion].getTotalPagado();
        }
        return income(numero, posicion + 1);
    }
    
    
    public void reset(){
        reset(0);
    }
    
    private void reset(int pos){
        if(pos < asientosCantidad.length){
            asientosCantidad[pos] = null;
            reset(pos + 1);
        }
    }
    
    public void sellTicket(String name) {
        name = name.toUpperCase();
        String porcentaje = "0%";
        int asientoDisponible = firstAvailable();
        
        if (asientoDisponible != -1) {
            double total = 800;

            if (isPalindromo(name)) {
                porcentaje = "20%";
                double descuento = 800 * 0.2;
                total -= descuento;
            }

            asientosCantidad[asientoDisponible] = new Ticket(name, total);

            //Salidas de Pantalla
            JOptionPane.showMessageDialog(null, "Descuento aplicado: " + porcentaje + "\nComprador: " + name + "\nTotal pagado: $. " + total, "Compra Exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public Ticket[] getAsientosCantidad() {
        return asientosCantidad;
    }
    
    public boolean cancelTicket(String name) {
        if (searchPassenger(name) != -1) {
            asientosCantidad[searchPassenger(name)] = null;
            return true;
        }
        return false;
    }
    
    public void dispatch() {
        System.out.println("Detalles de los asientos comprados:");
        printPassengers();
        
        System.out.println("Ingresos generados con los asientos comprados: $. " + income());
        reset();
        
        System.out.println("");
        System.out.println("Avión despachado. Todos los asientos han sido reseteados.");
    }
    
    
}
