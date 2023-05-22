/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import Modelo.Orden;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

import java.util.Scanner;


public class PriorityQueueOrden{
    CustomComparator cusComparator = new CustomComparator();
    Orden[] colaOrden;
    int cantidad;
    int size;

    public PriorityQueueOrden(int numElements){
        colaOrden = new Orden[numElements];
        this.cantidad = numElements;
        this.size = -1;
    }
    
    public int getSize(){
        return size;
    }

    public int parent(int i){
        return (i - 1)/2;
    }

    public int leftChild(int i){
        return ((2 * i) + 1);
    }

    public int rightChild(int i){
        return ((2 * i) + 2);
    }

    private void shiftUp(int i){
        while(i > 0 && cusComparator.compare(colaOrden[parent(i)].getFechaOrden(), colaOrden[i].getFechaOrden()) < 0){
            swap(parent(i), i);
            i = parent(i);
        }
    }

    private void shiftDown(int i){
        int maxIndex = i;
        int l = leftChild(i);
        if(l <= size && cusComparator.compare(colaOrden[i].getFechaOrden(), colaOrden[maxIndex].getFechaOrden()) > 0){
            maxIndex = l;
        }


        int r = rightChild(i);
        if(r <= size && cusComparator.compare(colaOrden[r].getFechaOrden(), colaOrden[maxIndex].getFechaOrden()) > 0){
            maxIndex = r;
        }

        if(i != maxIndex){
            swap(i,maxIndex);
            shiftDown(maxIndex);
        }
    }

    public void insert(Orden orden){
        this.size++;
        colaOrden[size] = orden;
        shiftUp(size);
    }

    public Orden extractMax(){
        Orden ordenResultado = colaOrden[0];
        colaOrden[0] = colaOrden[size];
        this.size--;
        shiftDown(0);
        return ordenResultado;
    }

    public void changePriority(int i, Orden orden){
        Orden oldOrden = colaOrden[i];
        colaOrden[i] = orden;

        if(cusComparator.compare(orden.getFechaOrden(), oldOrden.getFechaOrden()) > 0){
            shiftUp(i);
        }else{
            shiftDown(i);
        }
    }

    public Orden getMax(){
        return colaOrden[0];
    }

    public void remove(int i){
        Orden temporal = getMax();
        temporal.setFechaOrden(Date.from(Instant.now()));
        colaOrden[0] = temporal;
        shiftUp(i);
        extractMax();
    }

    private void swap(int i, int j){
        Orden temp = colaOrden[i];
        colaOrden[i] = colaOrden[j];
        colaOrden[j] = temp;
    }

    public Orden[] heapSort(){
        PriorityQueueOrden newQueue = new PriorityQueueOrden(this.size + 1);
        Orden[] colaOrdenada = new Orden[this.size + 1];
        for(int i = 0; i < colaOrdenada.length;i++){
            newQueue.insert(this.colaOrden[i]);
        }
        for(int j = 0; j < newQueue.cantidad - 1;j++){
            colaOrdenada[j] = (Orden) newQueue.extractMax();
        }
        return colaOrdenada;
    }

    public Orden[] heapSort(Orden[] array){
        PriorityQueueOrden newQueue = new PriorityQueueOrden(this.size);
        for(int i = 0; i < newQueue.size;i++){
            newQueue.insert(array[i]);
        }
        for(int j = newQueue.size; j > 0;j--){
            array[j] = (Orden) newQueue.extractMax();
        }
        return array;
    }

    public void buildHeap(Orden[] array){
        size = array.length;
        for(int i = array.length/2;i <= 1;i--){
            shiftDown(i);
        }
    }

    public void printQueue() {
        Orden[] colaOrdenada = heapSort();
        for (int i = 0; i < colaOrdenada.length; i++) {
            if(colaOrdenada[i] != null){
                System.out.println(colaOrdenada[i].getNumOrden() + " " + colaOrdenada[i].getFechaOrden()+ " "+colaOrdenada[i].getChaza().getNombreChaza()+" "+colaOrdenada[i].getCliente().getNombre());
            }
            
        }
    }



}

