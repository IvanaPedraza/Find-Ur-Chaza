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

    private T arreglo[];
    private int conteo; //conteo es la misma cola 
    private int tamano;

    public ArregloDinamicoConCola() {
        this.arreglo = (T[]) new Object[1];
        this.conteo = 0;
        this.tamano = 1;
    }

    public void agregarElemento(T elemento) {
        if (conteo == tamano) {
            incrementarTamano();
        }
        this.arreglo[conteo] = elemento;
        conteo++;
    }

    public void incrementarTamano() {
        T temporal[] = null;
        if (conteo == tamano) {
            temporal = (T[]) new Object[tamano * 2];
            for (int i = 0; i < tamano; i++) {
                temporal[i] = arreglo[i];
            }
        }
        this.arreglo = temporal;
        this.tamano = tamano * 2;
    }
    
    public void agregarElemento(int index, T elemento){
        if(conteo==tamano){
            incrementarTamano();
        }
        for(int i = conteo - 1;i>= index;i--){
            arreglo[i + 1] = arreglo[i];
        }
        arreglo[index] = elemento;
        conteo++;
    }
    
    public T eliminarElemento(){
        if(conteo > 0){
        }
    }

}
