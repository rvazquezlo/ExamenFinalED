/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfinaledmayo2018misolucion;

public class Divulgacion extends Revista{
    private int tiraje;

    public Divulgacion() {
        super();
    }     

    public Divulgacion(int tiraje, String periodicidad, int anioFundacion, int clave, String nombre, double precio) {
        super(periodicidad, anioFundacion, clave, nombre, precio);
        this.tiraje = tiraje;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTiraje= " + tiraje;
    }
    
    public int getTiraje(){
        return tiraje;
    }
}
