/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

/**
 *
 * @author kelly
 */
public class ArregloDinamicoConCola<T> {

    private T[] arrayInicial;
    private int tamano;
    private int conteo;

    public ArregloDinamicoConCola() {
        this.conteo = 0;
        this.arrayInicial = (T[]) new Object[1];
        this.tamano = 1;
    }

    public void pushBack(T elemento) {
        if (estaLleno()) {
            incrementarTamano();
        }
        arrayInicial[conteo] = elemento;
        conteo++;

    }

    public void pushFront(T elemento) {
        T[] nuevaLista;
        if (estaLleno()) {
            incrementarTamano();
        }
        nuevaLista = (T[]) new Object[this.conteo];
        nuevaLista[0] = elemento;
        for (int i = 1; i < tamano; i++) {
            nuevaLista[i] = arrayInicial[i - 1];
        }
        arrayInicial = nuevaLista;
        conteo++;
    }

    public void popBack() {
        T[] nuevaLista;
        if (estaVacio()) {
            incrementarTamano();
        }
        
        nuevaLista = (T[]) new Object[this.conteo];
        for (int i = 0; i < this.tamano; i++) {
            nuevaLista[i] = arrayInicial[i];
        }
        arrayInicial = nuevaLista;
        conteo--;

    }

    public boolean find(T elemento) {
        boolean seEncuentra = false;
        for (int i = 0; i < tamano; i++) {
            if (arrayInicial[i] == elemento) {
                seEncuentra = true;
            }
        }
        return seEncuentra;
    }

    public void delete(T elemento) {
        T[] nuevaLista = (T[]) new Object[this.conteo];
        int i = 0;
        while (i < tamano) {
            if (arrayInicial[i] == elemento) {
                for (int k = i; k < tamano - 1; k++) {
                    nuevaLista[k] = arrayInicial[k + 1];
                }
                break;
            } else {
                nuevaLista[i] = arrayInicial[i];
            }
            i++;
        }
        arrayInicial = nuevaLista;
        conteo--;

    }
    
    public void update(T elemento, T elementoNuevo){
        int posicionElemento = 0;
        for(int i = 0;i < conteo;i++){
            if(arrayInicial[i] == elemento){
                posicionElemento = i;
            }
        }
        arrayInicial[posicionElemento] = elementoNuevo;
    }

    public void popFront() {
        T[] nuevaLista;
        if (estaVacio()) {
            System.out.println("Esta vacio");
        } else {
            
            nuevaLista = (T[]) new Object[this.conteo];
            for (int i = 0; i < tamano; i++) {
                nuevaLista[i] = arrayInicial[i++];
            }
            arrayInicial = nuevaLista;
            conteo--;
        }
    }
    
    
    public T getElement(int index){
        return arrayInicial[index];
    }
    

    public boolean estaLleno() {
        return tamano == conteo;
    }

    public boolean estaVacio() {
        return this.tamano == 0;
    }

    public void incrementarTamano() {
        T temporal[] = null;
        if (conteo == tamano) {
            temporal = (T[]) new Object[tamano * 2];
        }
        for (int i = 0; i < tamano; i++) {
            temporal[i] = arrayInicial[i];
        }
        this.arrayInicial = temporal;
        this.tamano = tamano * 2;
    }

    public void imprimir() {
        for (int i = 0; i < this.conteo; i++) {
            System.out.println(arrayInicial[i]);
        }
    }

    public int getConteo() {
        return conteo;
    }
    
    

}
