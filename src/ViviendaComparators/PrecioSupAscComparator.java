/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViviendaComparators;

import java.util.Comparator;
import viviendaimpl.Piso;

/**
 *
 * @author pablo
 */
public class PrecioSupAscComparator implements Comparator<Piso> {
    public int compare(Piso p1, Piso p2){
        int n = Double.compare(p1.calculaPrecioM2(), p2.calculaPrecioM2());
        return n;
    }
}
