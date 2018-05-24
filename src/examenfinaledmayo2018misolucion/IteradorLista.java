/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfinaledmayo2018misolucion;

import java.util.*;

public class IteradorLista <T> implements Iterator <T> {
    private NodoDoble <T> actual;

    public IteradorLista(NodoDoble <T> actual) {
        this.actual = actual;
    }

    // Regresa true si existe un elemento.
    public boolean hasNext() {
        return actual != null;
    }

    // Regresa el objeto apuntado por el iterador.
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();
        else {
            T resul = actual.getDato();
            actual = actual.getDer();
            return resul;
        }

    }
    /* Elimina el último elemento devuelto por el iterador.
     * Es una operación opcional.
     */
    public void remove() {
        throw new UnsupportedOperationException("No está implementada.");
    }
}
