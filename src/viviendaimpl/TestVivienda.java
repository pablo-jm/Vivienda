/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viviendaimpl;

import java.util.Scanner;

/**
 *
 * @author DAW TARDE
 */
public class TestVivienda {
    
    public static void main(String[] args) {
        

//11.1 Crear una vivienda llamada v1 con los siguientes valores
Vivienda v1 = new ViviendaImpl(80, 850, TipoOperacion.ALQUILER, "Calle Gongora nº 58  - 4ºB, Cordoba");

//11.2 Cree una vivienda v2 con el constructor vacío
Vivienda v2 = new ViviendaImpl();

//11.3 Cree una nueva vivienda v3 con los siguientes datos
Vivienda v3 = new ViviendaImpl(90, 150000, TipoOperacion.VENTA, "");

//11.4 Recoja por terminal la superficie, el precio y la dirección. La operación será venta. Modifique  v2 a partir de los siguientes datos recogidos por terminal
Scanner sc = new Scanner(System.in);
System.out.println("Introduce superficie:");
    double s = sc.nextDouble();
System.out.println("Introduce precio:");
    double p = sc.nextDouble();
    sc.nextLine();
System.out.println("Introduzca dirección:");
    String d = sc.nextLine();

v2.setDireccion(d);
v2.setOperacion(TipoOperacion.VENTA);
v2.setPrecio(p);
v2.setSuperficie(s);


//11.5 
v3.setDireccion("Plaza de las flores nº 24, Úbeda");


//11.6 Se ha realizado una rebaja de un 10% de v1. Muestra por pantalla el precio actual
System.out.println(v1.calculaDescuento());

//11.7 Muestre por pantalla la comisión que se lleva la inmobiliaria por v2.
System.out.println(v2.calculaGestion());

//11.8 Calcule y muestre por pantalla el precio por metro cuadrado de v2.
System.out.println(v2.calculaPrecioM2());
        
//11.9 Muestre la localidad de v1 por pantalla.
System.out.println(v1.getLocalidad());

//11.10 Muestre por pantalla la dirección de la vivienda con mayor precio por metro cuadrado. Compare solo v2 y v3.
System.out.println(v2.getNombreMayorPrecioM2(v3));

//11.11 Repita el apartado anterior con v1 y v3.
System.out.println(v1.getNombreMayorPrecioM2(v3));

//11.12 Muestra por pantalla el tipo de vivienda que es v3: ¿pequeña, mediana o grande?
System.out.println(v3.getTamañoVivienda());

//11.13 Muestra por pantalla la vivienda con menor precio por metro cuadrado.
System.out.println(v1.calculaPrecioM2());
System.out.println(v2.calculaPrecioM2());
System.out.println(v3.calculaPrecioM2());



        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
