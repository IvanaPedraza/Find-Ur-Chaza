/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import Modelo.Cliente;

/**
 *
 * @author kelly
 */
public class ArregloDinamicoConColaCliente {
    private Cliente[] arrayInicial;
    private int tamano;
    private int conteo;

    public ArregloDinamicoConColaCliente() {
        this.conteo = 0;
        this.arrayInicial = new Cliente[1];
        this.tamano = 1;
    }

    public void pushBack(Cliente elemento) {
        if (estaLleno()) {
            incrementarTamano();
        }
        arrayInicial[conteo] = elemento;
        conteo++;

    }

    public void pushFront(Cliente elemento) {
        Cliente[] nuevaLista;
        if (estaLleno()) {
            incrementarTamano();
        }
        nuevaLista = new Cliente[this.conteo];
        nuevaLista[0] = elemento;
        for (int i = 1; i < tamano; i++) {
            nuevaLista[i] = arrayInicial[i - 1];
        }
        arrayInicial = nuevaLista;
        conteo++;
    }

    public void popBack() {
        Cliente[] nuevaLista;
        if (estaVacio()) {
            System.out.println("Esta vacio");
        }
        nuevaLista = new Cliente[this.tamano];
        for (int i = 0; i < this.tamano - 1; i++) {
            nuevaLista[i] = arrayInicial[i];
        }
        arrayInicial = nuevaLista;
        conteo--;
    }

    public boolean find(Cliente elemento) {
        boolean seEncuentra = false;
        for (int i = 0; i < tamano; i++) {
            if (arrayInicial[i] == elemento) {
                seEncuentra = true;
            }
        }
        return seEncuentra;
    }

    public void delete(Cliente elemento) {
        Cliente[] nuevaLista = new Cliente[this.tamano];
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
    
    public void update(Cliente elemento, Cliente elementoNuevo){
        int posicionElemento = 0;
        for(int i = 0;i < conteo;i++){
            if(arrayInicial[i] == elemento){
                posicionElemento = i;
            }
        }
        arrayInicial[posicionElemento] = elementoNuevo;
    }

    public void popFront() {
        Cliente[] nuevaLista;
        if (estaVacio()) {
            System.out.println("Esta vacio");
        } else {
            
            nuevaLista = new Cliente[this.conteo];
            for (int i = 0; i < tamano; i++) {
                nuevaLista[i] = arrayInicial[i++];
            }
            arrayInicial = nuevaLista;
            conteo--;
        }
    }
    
    public Cliente getElement(int index){
        return arrayInicial[index];
    }
    

    public boolean estaLleno() {
        return tamano == conteo;
    }

    public boolean estaVacio() {
        return this.tamano == 0;
    }

    public void incrementarTamano() {
        Cliente temporal[] = null;
        if (conteo == tamano) {
            temporal = new Cliente[tamano * 2];
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
