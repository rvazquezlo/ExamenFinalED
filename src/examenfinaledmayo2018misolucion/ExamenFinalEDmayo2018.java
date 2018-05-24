/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfinaledmayo2018misolucion;

/**
 *
 * @author Regina Vazquez
 */
import java.util.*;

public class ExamenFinalEDmayo2018 {
    
    private static void obtieneListaRevistas(ListaOrdenada<MaterialBibliografico> revistas, int total, double precio, Iterator<MaterialBibliografico> iterador){
        MaterialBibliografico dato;
        Divulgacion revistaD;
        
        if(iterador.hasNext()){
            dato = iterador.next();
            if(dato instanceof Divulgacion){
               revistaD = (Divulgacion)dato; 
               if(revistaD.getPrecio() < precio && revistaD.getTiraje() > total)
                   revistas.add(revistaD);
            }
            obtieneListaRevistas(revistas, total, precio, revistas.iterator());
        }//si no, ya acabe
    }
    
    public static ListaOrdenada<MaterialBibliografico> obtieneListaRevistas(ListaOrdenada<MaterialBibliografico> material, int total, double precio){
        ListaOrdenada<MaterialBibliografico> revistas;
        
        revistas = null;
        if(total > 0 && precio > 0 && material != null){
            revistas = new ListaOrdenada();
            obtieneListaRevistas(revistas, total, precio, revistas.iterator());
        }
        return revistas;
    }
    
    public static void main(String[] args) {
        
        
        /*
         *  Problema 1
        */
        ListaOrdenada<Integer> lista1, lista2;
        
        lista1 = new ListaOrdenada();
        lista2 = new ListaOrdenada();
        
        for(int i = 0; i < 5; i++)
            lista1.add(i * 2);
        
        System.out.println("Problema 1");
        
        //imprime lista1 
        System.out.println("Lista1:\n" + lista1.toString());
        
        //1)parametro null. Imprime lista1 (0, 2, 4, 6, 8)
        lista1.combina(null);
        System.out.println("1) Lista1 sin afectar:\n" + lista1.toString());
        
        //2)parametro vacia. Imprime lista1 (0, 2, 4, 6, 8)
        lista1.combina(lista2);
        System.out.println("2) Lista1 sin afectar:\n" + lista1.toString());
        
        //3)this vacia. Imprime lista1 (0, 2, 4, 6, 8)
        lista2.combina(lista1);
        System.out.println("3) Lista1 sin afectar:\n" + lista2.toString());
        
        lista2 = new ListaOrdenada();
        for(int i = 0; i < 10; i++)
            lista2.add(i);
        //imprime lista2 
        System.out.println("Lista2:\n" + lista2.toString());
        
        //4) Combina las dos listas
        lista1.combina(lista2);
        System.out.println("4) Combina lista1 y lista2:\n" + lista1.toString());
        
        lista2 = new ListaOrdenada();
        for(int i = 5; i < 10; i++)
            lista2.add(i * 2);
        lista1 = new ListaOrdenada();
        for(int i = 0; i < 5; i++)
            lista1.add(i * 2);
        
        //imprime lista1 
        System.out.println("Lista1:\n" + lista1.toString());
        
        //imprime lista2 
        System.out.println("Lista2:\n" + lista2.toString());
        
       //5)lista1 es mas chica que lista2. Toda lista1 va antes
        lista1.combina(lista2);
        System.out.println("5) Combina lista1 y lista2. Toda lista1 va antes:\n"
                + lista1.toString());
        
        lista2 = new ListaOrdenada();
        for(int i = 5; i < 10; i++)
            lista2.add(i * 2);
        lista1 = new ListaOrdenada();
        for(int i = 0; i < 5; i++)
            lista1.add(i * 2);
        
        //imprime lista1 
        System.out.println("Lista1:\n" + lista1.toString());
        
        //imprime lista2 
        System.out.println("Lista2:\n" + lista2.toString());
        
        //6)lista1 es mas chica que lista2. Toda lista1 va antes
        lista2.combina(lista1);
        System.out.println("6) Combina lista1 y lista2. Toda lista1 va antes:\n"
                + lista2.toString());
        
        lista2 = new ListaOrdenada();
        for(int i = 5; i < 10; i++)
            lista2.add(i * 2);
        lista1 = new ListaOrdenada();
        for(int i = 0; i < 5; i++)
            lista1.add(i * 2);
        
        //imprime lista1 
        System.out.println("Lista1:\n" + lista1.toString());
        
        //imprime lista2 
        System.out.println("Lista2:\n" + lista2.toString());
        
        //7) Combina las dos listas
        lista2.combina(lista1);
        System.out.println("7) Combina lista1 y lista2:\n" + lista2.toString());
        
        lista2 = new ListaOrdenada();
        for(int i = 0; i < 5; i++)
            lista2.add(i * 2);
        lista1 = new ListaOrdenada();
        for(int i = 0; i < 5; i++)
            lista1.add(i * 2);
        
        //imprime lista1 
        System.out.println("Lista1:\n" + lista1.toString());
        
        //imprime lista2 
        System.out.println("Lista2:\n" + lista2.toString());
        
        //8) Combina las dos listas identicas
        lista2.combina(lista1);
        System.out.println("8) Combina dos listas iguales:\n" + 
                lista2.toString());
        
        
        /*
         *  Problema 2
        */
        
    }
}
