/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfinaledmayo2018misolucion;

public class Libro extends MaterialBibliografico {
    private String autor;

    public Libro() {
        super();
    }

    public Libro(String autor, int clave, String nombre, double precio) {
        super(clave, nombre, precio);
        this.autor = autor;
    }
}
