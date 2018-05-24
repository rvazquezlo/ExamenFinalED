/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfinaledmayo2018misolucion;

import java.util.*;

public class ListaOrdenada<T extends Comparable<T>> implements Iterable<T> {
    private NodoDoble<T> primero;
    private NodoDoble<T> ultimo;
    
    public ListaOrdenada() {
        primero=null;
        ultimo=null;
    }
    
    public void add(T dato) {
        NodoDoble<T> nuevo=new NodoDoble(dato);        
        // Si está vacía la lista:
        if(primero==null) {
            primero=nuevo;
            ultimo=nuevo;
        }
        // En caso contrario, si hay un solo nodo en la lista:
        else if(primero==ultimo) {
            // Hay que insertar a la izq. del nodo si el valor a agregar es
            // menor que el que está en el nodo:
            if(dato.compareTo(primero.getDato())<0) {
                nuevo.setDer(primero);
                primero.setIzq(nuevo);
                primero=nuevo;
            }
            // En caso contrario hay que insertar a la der. del nodo:
            else {
                primero.setDer(nuevo);
                nuevo.setIzq(primero);
                ultimo=nuevo;
            }
        }
        // En caso contrario hay que buscar el primer nodo que tenga un valor
        // mayor al valor que se va a agregar (ahí se detendrá "aux"):
        else {
            NodoDoble<T> aux=primero;
            while(aux!=null&&dato.compareTo(aux.getDato())>0)
                aux=aux.getDer();
            // Si "aux" resulta ser "primero" quiere decir que hay que insertar
            // el nuevo valor a la izq. de todos los que ya estaban:
            if(aux==primero) {
                nuevo.setDer(primero);
                primero.setIzq(nuevo);
                primero=nuevo;
            }
            // En caso contrario, si "aux" resulta ser igual a "null" quiere
            // decir que hay que insertar el nuevo valor a la der. de todos los
            // que ya estaban:
            else if(aux==null) {
                ultimo.setDer(nuevo);
                nuevo.setIzq(ultimo);
                ultimo=nuevo;
            }
            // En caso contrario hay que insertar en algún lugar intermedio de
            // la secuencia de nodos enlazados:
            else {
                nuevo.setIzq(aux.getIzq());
                nuevo.getIzq().setDer(nuevo);
                aux.setIzq(nuevo);
                nuevo.setDer(aux);
            }
        }
    }
    
    private boolean combina(NodoDoble<T> aux, NodoDoble<T> ap, NodoDoble<T> 
            aux2, NodoDoble<T> ap2, NodoDoble<T> actual){//Regina Vazquez
        int comparacion;
        
        if(aux2 == null){//llegue al fin de otra
            actual.setDer(ap);
            ap.setIzq(actual);
            return false;//ultimo se queda igual
        }
        else if(aux == null){
            actual.setDer(ap2);
            ap2.setIzq(actual);
            return true; //ultimo se tiene que mover a lista.ultimo
        }
        else{
            comparacion = aux.getDato().compareTo(aux2.getDato());
            if(comparacion <= 0){
                aux = aux.getDer();
                actual.setDer(ap);
                ap.setIzq(actual);
                return combina(aux, aux, aux2, ap2, ap);
            }
            else{
                aux2 = aux2.getDer();
                actual.setDer(ap2);
                ap2.setIzq(actual);
                return combina(aux, ap, aux2, aux2, ap2);
            }
        }  
    }
    
    public void combina(ListaOrdenada<T> lista) { //Regina Vazquez 173803
        NodoDoble<T> actual, aux, aux2, ap, ap2;
        
        if(lista != null && !lista.isEmpty()){
            if(isEmpty()){//lista se convierte en mi unica lista
                primero = lista.primero;
                ultimo = lista.ultimo;
            }
            else{
                
                //ultimo <= lista.primero
                if(ultimo.getDato().compareTo(lista.primero.getDato()) <= 0){
                    
                    //en este caso, solo se conecta ultimo con lista.primero
                    ultimo.setDer(lista.primero);
                    lista.primero.setIzq(ultimo);
                    ultimo = lista.ultimo;
                }
                
                //lista.ultimo <= primero
                else if(lista.ultimo.getDato().compareTo(primero.getDato()) <= 
                        0){
                    
                    //en este caso se conecra primero con lista.ultimo
                    lista.ultimo.setDer(primero);
                    primero.setIzq(lista.ultimo);
                    primero = lista.primero;
                }
                else{
                    if(primero.getDato().compareTo(lista.primero.getDato()) < 0){
                        actual = primero;
                        aux = primero.getDer();
                        ap = aux;
                        aux2 = lista.primero;
                        ap2 = aux2;
                    }
                    else{
                        actual = lista.primero;
                        aux = primero;
                        ap = primero;
                        aux2 = lista.primero.getDer();
                        ap2 = aux2;
                        primero = lista.primero;
                    }
                    if(combina(aux, ap, aux2, ap2, actual))
                        ultimo = lista.ultimo;
                }
                
            }
        }
    }
    
    public Iterator<T> iterator() {
        return new IteradorLista(primero);
    }

    public boolean isEmpty() {
        return primero==null;
    }
    
    public String toString() {
        StringBuilder sb=new StringBuilder("");
        NodoDoble<T> aux=primero;
        
        while(aux!=null) {
            sb.append(aux.getDato().toString()+"\n");
            aux=aux.getDer();
        }
        
        return sb.toString();
    }
}
