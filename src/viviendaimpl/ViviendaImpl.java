/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viviendaimpl;

import Exceptions.PrecioException;

/**
 *
 * @author DAW TARDE
 */
public class ViviendaImpl implements Vivienda{

    private final double DESCUENTO = 0.10;
    private final double PEQUEÑA = 70;
    private final double MEDIANA = 95;
    private final double gestionAlquiler = 0.8;
    private final double gestionVenta = 0.14;
    private final double gestionAlquilerConVenta = 0.11;

//1. Crear la clase y la interfaz con sus métodos observables y modificables
    protected double superficie;
    protected double precio;
    protected TipoOperacion operacion;
    protected String direccion;

    public double getSuperficie() {
        return superficie;
    }

    public double getPrecio() {
        return precio;
    }

    public TipoOperacion getOperacion() {
        return operacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public void setPrecio(double precio) {
        try {
            checkPrecio(precio);
            this.precio = precio;
        } catch (PrecioException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setOperacion(TipoOperacion operacion) {
        this.operacion = operacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

//2. Crear tres constructores    
    public ViviendaImpl(double superficie, double precio, TipoOperacion operacion, String direccion) {
        
        try {
            checkPrecio(precio);
            this.precio = precio;
        } catch (PrecioException e) {
            System.out.println(e.getMessage());
        }
        this.superficie = superficie;
        this.operacion = operacion;
        this.direccion = direccion;
    }

    public ViviendaImpl(String direccion) {
        try {
            checkPrecio(precio);
            this.precio = 150000;
        } catch (PrecioException e) {
            System.out.println(e);
        }
        this.superficie = 90;
        this.operacion = TipoOperacion.VENTA;
        this.direccion = direccion;
    }

    public ViviendaImpl() {
        this.precio = 0;
        this.superficie = 0;
        this.operacion = TipoOperacion.VENTA;
        this.direccion = "";
    }

//3. Crear un método que rebaje el precio de la vivienda a un 10%. El valor de rebaja debe ser creado en una constante
/**
 * Obtiene el precio de la vivienda con descuento aplicado
 * 
 *
 * @return precio de la vivienda con descuento aplicado
 */
    public double calculaDescuento() {
        return this.precio - (this.precio * DESCUENTO);
    }

//4. Crear el método toString que muestre la información de la Vivienda en el siguiente formato    
    @Override
    public String toString() {
        return "Dirección = " + this.direccion + " - Precio = " + this.precio + " - Superficie = " + this.superficie + " - Operación = " + this.operacion;
    }

//5. Cree un método que dada una operación, alquiler, venta o alquiler con opción a compra, devuelva si la vivienda es de esa operación    
 /**
 * Obtiene si el tipo de operacion es el mismo
 * 
 * @param op tipo de operacion
 * 
 * @return true si el tipo de operacion son iguales
 */
    public boolean esOperacion(TipoOperacion op) {
        return (this.operacion.equals(op));
    }

//6. Crear un método que devuelva la cantidad que se lleva la inmobiliaria por la gestión. 
//En el caso de las viviendas en alquiler se lleva un 8% del precio, en el caso de las viviendas en venta se lleva un 14% y en el alquiler con opción a compra un 11%
   
    /**
 * Calcula la cantidad que se lleva la inmobiliaria por la gestión
 * 
 * @return cantidad que se lleva la inmobiliaria por la gestion
 */
    public double calculaGestion() {
        double gestion = 0;
        switch (this.operacion) {
            case ALQUILER:
                gestion = gestionAlquiler;
                break;
            case VENTA:
                gestion = gestionVenta;
                break;
            case ALQUILER_VENTA:
                gestion = gestionAlquilerConVenta;
                break;
        }
        return this.precio * gestion;
    }

/*7. Crear un método que dado otra Vivienda y sí únicamente la operación en ambas en la misma, es decir, ambas están en Venta o en alquiler nos 
devuelva la dirección de la vivienda con mayor precio por metro cuadrado. En el caso de que las viviendas  no tengan la misma operación  devuelva 
“Las viviendas no tienen la misma dirección”. Para ello, necesitará crear un método que calcule el precio por metro cuadrado. */
/**
 * Calcula el precio por m2
 * 
 * @return precio por m2
 */
    public double calculaPrecioM2() {
        return this.precio / this.superficie;
    }
/**
 * Obtiene el nombre de la vivienda con mayor precio por m2
 * 
 * @param v vivienda a comparar por el metodo
 * 
 * @return nombre de la vivienda con mayor precio por m2
 */
    public String getNombreMayorPrecioM2(Vivienda v) {
        String s = "";
        if (this.operacion == v.getOperacion()) {
            if (this.calculaPrecioM2() > v.calculaPrecioM2()) {
                s = this.direccion;
            } else if (this.calculaPrecioM2() < v.calculaPrecioM2()) {
                s = "Las viviendas no tienen la misma dirección";
            }
        }
        return s;
    }

//8 Cree un método que devuelva un String que diga si la vivienda es pequeña, mediana o grande.  
/**
 * Obtiene el tamaño de la vivienda
 * 
 * @return String con el tamaño de la vivienda
 */
    public String getTamañoVivienda() {
        String s = "";

        if (this.superficie < PEQUEÑA) {
            s = "Vivienda pequeña";
        } else if (this.superficie >= PEQUEÑA && this.superficie <= MEDIANA) {
            s = "Vivienda mediana";
        } else {
            s = "Vivienda grande";
        }
        return s;
    }

//9 Cree un método que devuelva la localidad en la que se encuentra la vivienda. El formato de la dirección siempre se escribirá así:
 /**
 * Obtiene la localidad a la que pertenece la vivienda
 * 
 * @return nombre de la localidad a la que pertenece la vivienda
 */    
    public String getLocalidad() {
        String[] arrayDireccion = this.direccion.split(",");
        String localidad = arrayDireccion[1];
        return localidad;
    }

//10 Cree un método que dado un array con las superficies de cada una de las estancias de la vivienda te calcule la superficie total y modifique la superficie.
/**
 * Obtiene el nombre de la vivienda con mayor precio por m2
 * 
 * @param arraySuperficie array con las superficies de toda la vivienda
 */    
    public void getAndSetSuperficieTotal(int[] arraySuperficie) {
        int superficieTotal = 0;
        for(int i = 0;i<arraySuperficie.length;i++){
           superficieTotal = superficieTotal + arraySuperficie[i];
           this.superficie = superficieTotal;
        }
    }
    
//3. Implemente en Vivienda el método equals y el compareTo. Dos viviendas son iguales si tienen la misma dirección.
//Se ordenan por dirección. 

    public boolean equals(Object o){
        boolean r = false;
        if(o instanceof Vivienda){
            Vivienda v = (Vivienda) o;
                r = this.direccion.equals(v.getDireccion());
        }
        return r;
    }
    
    public int compareTo(Vivienda v){
        int n;
        n = this.direccion.compareTo(v.getDireccion());
        return n;
    }
    
//5. Una vivienda no puede tener un precio negativo. Cree una excepción verificada que muestre un mensaje por
//pantalla que indique que el precio no puede ser negativo. Lance la excepción en el constructor.

    /**
 * Comprueba que el precio no sea negativo.
 * 
 * @param precio int que representa el precio de la vivienda
 * @throws Exceptions.PrecioException
 * 
 */  
    public static void checkPrecio(double precio) throws PrecioException{
        if(precio < 0){
            throw new PrecioException("El precio no puede ser negativo");
        }
    }
    
    
    
}
