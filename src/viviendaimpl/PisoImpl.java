/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viviendaimpl;

/**
 *
 * @author pablo
 */
public class PisoImpl extends ViviendaImpl implements Piso{
    
    private int planta;
    private char puerta;

    @Override
    public int getPlanta() {
        return planta;
    }

    @Override
    public char getPuerta() {
        return puerta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public void setPuerta(char puerta) {
        this.puerta = puerta;
    }
    
    
//6. Implemente para el tipo Piso un constructor que reciba un argumento para cada atributo.

    public PisoImpl(int planta, char puerta, double superficie, double precio, TipoOperacion operacion, String direccion) {
        super(superficie, precio, operacion, direccion);
        this.planta = planta;
        this.puerta = puerta;
    }
    
    
//4. Repite la misma operación para el tipo Piso.  Dos pisos son iguales entre sí si tiene la misma dirección,
//misma planta y la misma puerta.

    public boolean equals(Object o){
        boolean r = false;
        if(o instanceof Piso){
            Piso p = (Piso) o;
                r = super.equals(p) && this.planta == p.getPlanta() && this.puerta == p.getPuerta();
        }
        return r;
    }
    
    public int compareTo(Piso p){
        int n;
        n = super.compareTo((p));
        if(n == 0){
            n = Integer.compare(this.planta, p.getPlanta());
            if(n == 0){
            n = Character.compare(this.puerta, p.getPuerta());
            }
        }
        return n;
    }
    
}
