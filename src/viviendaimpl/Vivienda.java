/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package viviendaimpl;

/**
 *
 * @author DAW TARDE
 */
public interface Vivienda extends Comparable<Vivienda>{
    
    public double getSuperficie();
    public double getPrecio();
    public TipoOperacion getOperacion();
    public String getDireccion();
    public void setSuperficie(double superficie);
    public void setPrecio(double precio);
    public void setOperacion(TipoOperacion operacion);
    public void setDireccion(String direccion);
    public boolean esOperacion(TipoOperacion op);
    public double calculaDescuento();
    public double calculaGestion();
    public double calculaPrecioM2();
    public String getNombreMayorPrecioM2(Vivienda v);
    public String getTamañoVivienda();
    public String getLocalidad();
    public void getAndSetSuperficieTotal(int[] arraySuperficie);
}
