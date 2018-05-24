/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfinaledmayo2018misolucion;

public class Cientifica extends Revista {
    private String editor;

    public Cientifica() {
        super();
    }

    public Cientifica(String editor, String periodicidad, int anioFundacion, int clave, String nombre, double precio) {
        super(periodicidad, anioFundacion, clave, nombre, precio);
        this.editor = editor;
    }
}
