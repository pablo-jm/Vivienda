/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Catalogo;

import Exceptions.CatalogoException;
import Exceptions.PrecioException;
import ViviendaComparators.PrecioSupAscComparator;
import ViviendaComparators.SuperficieDescComparator;
import java.util.*;
import viviendaimpl.Piso;
import viviendaimpl.TipoOperacion;
import static viviendaimpl.ViviendaImpl.checkPrecio;

/**
 *
 * @author pablo
 */
public class CatalogoImpl implements Catalogo {
    
    private List<Piso> listaPisos;
    
/*7. Para el tipo Catálogo implemente un método para que: reciba una cadena de caracteres con “ALQUILER” o
“VENTA” y devuelva el número de pisos de esa operación.*/ 
    /**
 * Devuelve el número de pisos que pertenecen a ese tipo de operación.
 * 
 * @param tp tipo de operación
    
 */
    @Override
    public int getNumPisosForOperation(String tp){
        try{
            checkOperation(tp);
        }catch(CatalogoException e){
            System.out.println(e.getMessage());
        }
       
        int counter = 0;
        for(Piso piso: listaPisos) {
            if(piso.esOperacion(TipoOperacion.valueOf(tp.toUpperCase()))){
               counter++;
            }
        }
        return counter;
    }
        
public static void checkOperation(String tp) throws CatalogoException{
        if(TipoOperacion.ALQUILER == TipoOperacion.valueOf(tp.toUpperCase()) || TipoOperacion.VENTA == TipoOperacion.valueOf(tp.toUpperCase())){
            throw new CatalogoException("Operación inválida.");
        }
}   

/*8. Para el tipo Catálogo implemente un método que añada un nuevo piso al catálogo. Tenga en cuenta que no
se pueden incluir dos pisos iguales en el catálogo.*/ 
/**
 * Añade un piso al catálogo
 * 
 * @param piso piso a añadir en el catálogo
     * @throws Exceptions.CatalogoException
 */
    @Override
    public void addPiso(Piso piso) throws CatalogoException{
        if(listaPisos.contains(piso)){
            throw new CatalogoException("El piso ya existe.");
        }else{
            listaPisos.add(piso);
        }
    }
    
/*9. Para el tipo Catálogo implemente un método que elimine un piso existente del catálogo.
Si el piso no se encuentra en el catálogo entonces deberá lanzar una excepción indicando esto.*/
/**
 * Elimina un piso existente del catálogo
 * 
 * @param piso piso a eliminar del catálogo
     * @throws Exceptions.CatalogoException
 */   
    @Override
    public void removePiso(Piso piso) throws CatalogoException{
        if(listaPisos.contains(piso)){
           listaPisos.remove(piso);
        }else{
            throw new CatalogoException("El piso no existe.");
        }
    }
    
/*10. Para el tipo Catálogo implemente un método para que: reciba una planta y devuelva la suma
de precios de los pisos que están en esa planta.*/
/**
 * Calcula el precio total de los pisos de la misma planta
 * 
 * @param planta numero de planta de los pisos a sumar
     * @return precio total de los pisos de la misma planta
    
 */ 
    @Override
    public double getNumPisosPerPlanta(int planta){
    double totalPrice = 0;
    for (Piso piso: listaPisos) {
         if(piso.getPlanta() == planta){
            totalPrice = totalPrice + piso.getPrecio();
         }
    }
    return totalPrice;
}    


/*11. Para el tipo Catálogo implemente un método para que: devuelva la dirección
del piso con el menor precio por superficie (cociente de precio por superficie).*/
/**
 * Devuelve la dirección del piso con el menor precio por superficie
 * 
 * 
     * @return menor precio por superficie
    
 */ 
    @Override    
    public double getDireccionPisoMenorPrecioPerSuperficie(){    
    Collections.sort(this.listaPisos, new PrecioSupAscComparator());
    return this.listaPisos.get(0).calculaPrecioM2();
}

/*12. Para el tipo Catálogo implemente un método para que: dado un precio p y una superficie s
devuelve un Catálogo con los pisos con superficie mayor que s y precio menor que p.*/
/**
 * Devuelve un Catálogo con los pisos con superficie mayor que s y precio menor que p.
 * 
 * 
     * @param precio precio del piso
     * @param superficie superficie del piso
     * @return menor precio por superficie
     * @throws Exceptions.CatalogoException
    
 */ 
    @Override
    public List<Piso> getCatalogoPrecioMenorSuperficieMayor(double precio, double superficie) throws CatalogoException{
    List<Piso> catalogoPisos = null;
    for(Piso piso: listaPisos) {
        if(piso.getPrecio() < precio && piso.getSuperficie() > superficie){
           catalogoPisos.add(piso);
        }else{
            throw new CatalogoException("Ningún piso cumple las condiciones.");
        }
    }
    return catalogoPisos;
}

//13. Para el tipo Catálogo implemente un método para que: Ordena el Catálogo por superficie.
/**
 * Ordena la lista por superficie(Asc).
 */ 
    @Override
    public void getCatalogoOrdenSuperficie(){
   Collections.sort(listaPisos, new SuperficieDescComparator());
}

/*14. Para el tipo Catálogo implemente un método para que: Dado un precio p devuelva
si existe un piso con precio menor que p.*/
/**
 * Devuelve si existe un piso con precio menor que p.
     * @param precio precio a comprobar
     * @return true si existe piso con precio menor que p y false si no
 */ 
    @Override
    public boolean isGreaterThanPrice(double precio){
    boolean n = false;
try{
        checkPrecio(precio);
    for(Piso piso: listaPisos) {
        if(piso.getPrecio() < precio){
           n = true;
        }
    }
}catch(PrecioException e){
     System.out.println(e.getMessage());
    }
    return n;
}

/*15. Para el tipo Catálogo implemente un método para que: Dada una planta p devuelve
si todos los pisos están por debajo de esa planta.*/
/**
 * Devuelve si todos los pisos están por debajo de planta.
     * @param planta planta a comprobar
     * @return true si todos los pisos están por debajo y false si hay (mínimo) uno que no
 */ 
    @Override
    public boolean isPlantaLower(int planta){
    
    boolean n = true;
    for(Piso piso: listaPisos){
        if(listaPisos.contains(piso.getPlanta() > planta)){
           n = false;
        }
    }
    return n;
}

/*16. Para el tipo Catálogo implemente un método para que: Dado una superficie s y un
porcentaje p rebaja el precio de los pisos con superficie mayor que s un porcentaje p.*/
/**
 * Rebaja el precio de los pisos con superficie mayor que s un porcentaje p.
     * @param superficie superficie a comprobar
     * @param porcentaje porcentaje a rebajar
     * @return precio rebajado un porcentaje p
 */ 

    @Override
    public double getPrecioRebajaSuperficiePorcentaje(double superficie, int porcentaje){
    double precioRebajado = 0;
    for (Piso piso: listaPisos) {
        if(piso.getSuperficie() > superficie){
           precioRebajado = piso.getPrecio() * porcentaje/100;
        }  
    }
    return precioRebajado;   
}

    
    @Override
    public String toString() {
        return "listaPisos=" + listaPisos;
    }










}