/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfinaledmayo2018misolucion;

public class Revista extends MaterialBibliografico {
    private String periodicidad;
    private int anioFundacion;

    public Revista() {
        super();
    }
    
    public Revista(String periodicidad, int anioFundacion, int clave, String nombre, double precio) {
        super(clave, nombre, precio);
        this.periodicidad = periodicidad;
        this.anioFundacion = anioFundacion;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nPeriodicidad=" + periodicidad + ", - Año de fundación: " + anioFundacion;
    }
}
