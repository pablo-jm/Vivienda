/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Catalogo;

import Exceptions.CatalogoException;
import java.util.List;
import viviendaimpl.Piso;

/**
 *
 * @author pablo
 */
public interface Catalogo {

    void addPiso(Piso piso) throws CatalogoException;

    
    void getCatalogoOrdenSuperficie();

    
    List<Piso> getCatalogoPrecioMenorSuperficieMayor(double precio, double superficie) throws CatalogoException;

   
    double getDireccionPisoMenorPrecioPerSuperficie();

    
    int getNumPisosForOperation(String tp);

    
    double getNumPisosPerPlanta(int planta);

   
    double getPrecioRebajaSuperficiePorcentaje(double superficie, int porcentaje);

    
    boolean isGreaterThanPrice(double precio);

    
    boolean isPlantaLower(int planta);

   
    void removePiso(Piso piso) throws CatalogoException;
    
}
