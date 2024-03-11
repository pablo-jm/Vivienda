/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Catalogo.Catalogo;
import Catalogo.CatalogoImpl;
import Exceptions.CatalogoException;
import Exceptions.MenuException;
import java.util.*;
import viviendaimpl.Piso;
import viviendaimpl.PisoImpl;
import viviendaimpl.TipoOperacion;

/**
 *
 * @author pablo
 */
public class Menu {
    
    
    
    private static void optionOne(Scanner sc, Catalogo catalogo) throws CatalogoException{
        System.out.println("Introduzca la planta: ");
        int planta = Integer.parseInt(sc.nextLine());
        System.out.println("Introduzca la puerta: ");
        String stringPuerta= "";
        
        try{
            String comprueba = sc.nextLine();
            checkStringLength(stringPuerta);
            stringPuerta= comprueba;
            
        }catch(MenuException e){
            System.out.println(e.getMessage());
        }
        char puerta = stringPuerta.charAt(0);
        
        System.out.println("Introduzca la superficie: ");
        double superficie = Double.parseDouble(sc.nextLine());
        
        System.out.println("Introduzca la precio: ");
        double precio = Double.parseDouble(sc.nextLine());

        System.out.println("Introduzca el número de la Operación que tendrá: ");
        System.out.println("1. Venta");
        System.out.println("2. Alquiler");
        System.out.println("3. Alquiler con opción a venta");
        int option = Integer.parseInt(sc.nextLine());
        TipoOperacion operacion= null;
        switch(option){
            case 1:
                operacion = TipoOperacion.VENTA;
                break;
            case 2:
                operacion = TipoOperacion.ALQUILER;
                break;
            case 3:
                operacion = TipoOperacion.ALQUILER_VENTA;
                break;
            default:
                System.out.println("Debe ser una operación válida");
                break;
        }
        
        System.out.println("Introduzca la dirección: ");
        String direccion = sc.nextLine();
        
        Piso piso = new PisoImpl(planta, puerta, superficie, precio, operacion, direccion);
        catalogo.addPiso(piso);
        
        //Creando el toString en CatálagoImpl
        System.out.println(catalogo);
    }
    
    
    public static void checkStringLength(String s) throws MenuException{
        if(s.length() > 1){
           throw new MenuException("La opción debe ser válida");
        }
    }
    
    
    
    private static void optionTwo(Scanner sc, Catalogo catalogo) throws CatalogoException{
        
        System.out.println("Introduzca la dirección: ");
        String direccion= "";
        System.out.println("Introduzca la planta: ");
        int planta = Integer.parseInt(sc.nextLine());
        System.out.println("Introduzca la puerta: ");
        String stringPuerta= "";
  
        try{
            String comprueba = sc.nextLine();
            checkStringLength(stringPuerta);
            stringPuerta= comprueba;
            
        }catch(MenuException e){
            System.out.println(e.getMessage());
        }
        char puerta = stringPuerta.charAt(0);
        
        Piso piso = new PisoImpl(planta, puerta, 0, 0, null, direccion);
        catalogo.removePiso(piso);

        checkOperación(piso, catalogo);
        
        System.out.println(catalogo);
        
    }
    
    
   private static void checkOperación(Piso p, Catalogo catalogo){
        
    }
    
    
    
    
    
    
}
