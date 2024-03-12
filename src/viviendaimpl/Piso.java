/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package viviendaimpl;

/**
 *
 * @author pablo
 */
public interface Piso extends Vivienda, Comparable<Piso>{

    int getPlanta();

    char getPuerta();
    
    public void setPlanta(int planta);
    
    public void setPuerta(char puerta);
    
}
