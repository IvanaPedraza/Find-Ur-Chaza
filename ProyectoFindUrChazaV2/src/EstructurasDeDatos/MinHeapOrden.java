/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import Modelo.Cliente;
import Modelo.Orden;
import java.util.Date;

/**
 *
 * @author kelly
 */
public class MinHeapOrden {

    CustomComparator cusComparator = new CustomComparator();
    private Orden[] Heap;
    private int index;
    private int size;

    public MinHeapOrden(int size) {
        this.size = size;
        this.index = 0;
        Heap = new Orden[size];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (i * 2) + 1;
    }

    private int rightChild(int i) {
        return (i * 2) + 2;
    }

    private boolean isLeaf(int i) {
        if (rightChild(i) >= size || leftChild(i) >= size) {
            return true;
        }
        return false;
    }

    public void insert(Orden element) {
        if (index >= size) {
            return;
        }
        Heap[index] = element;
        int current = index;

        while (cusComparator.compare(Heap[current].getFechaOrden(), Heap[parent(current)].getFechaOrden()) < 0) {
            swap(current, parent(current));
            current = parent(current);
        }
        index++;
    }

    // removes and returns the minimum element from the heap
    public Orden remove() {
        // since its a min heap, so root = minimum
        Orden popped = Heap[0];
        Heap[0] = Heap[--index];
        minHeapify(0);
        return popped;
    }
    
    public Orden remove(int i) {
        // since its a min heap, so root = minimum
        Orden popped = Heap[i];
        Heap[i] = Heap[--index];
        minHeapify(0);
        return popped;
    }
    
    public void remove(Orden orden){
        int index = find(orden);
        remove(index);
    }

    // heapify the node at i
    private void minHeapify(int i) {
        // If the node is a non-leaf node and any of its child is smaller
        if (!isLeaf(i)) {
            if (cusComparator.compare(Heap[i].getFechaOrden(), Heap[leftChild(i)].getFechaOrden()) > 0
                    || cusComparator.compare(Heap[i].getFechaOrden(), Heap[rightChild(i)].getFechaOrden()) > 0) {
                if (cusComparator.compare(Heap[leftChild(i)].getFechaOrden(), Heap[rightChild(i)].getFechaOrden()) < 0) {
                    swap(i, leftChild(i));
                    minHeapify(leftChild(i));
                } else {
                    swap(i, rightChild(i));
                    minHeapify(rightChild(i));
                }
            }
        }
    }

    // builds the min-heap using the minHeapify
    public void minHeap() {
        for (int i = (index - 1 / 2); i >= 1; i--) {
            minHeapify(i);
        }
    }

    // Function to print the contents of the heap
    public void printHeap() {
        for (int i = 0; i < (index / 2); i++) {
            System.out.print("Parent : " + Heap[i].getFechaOrden());
            if (leftChild(i) < index) {
                System.out.print(" Left : " + Heap[leftChild(i)].getFechaOrden());
            }
            if (rightChild(i) < index) {
                System.out.print(" Right :" + Heap[rightChild(i)].getFechaOrden());
            }
            System.out.println();
        }
    }
    // swaps two nodes of the heap

    private void swap(int x, int y) {
        Orden tmp;
        tmp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = tmp;
    }

    public void printHeap2() {
        for (int i = 0; i < index; i++) {
            System.out.println(Heap[i].getFechaOrden());
        }
    }

    public Orden findByNumOrden(long numOrden) {
        Orden orden = new Orden();
        int ordenEncontrada = 0;
        for (int i = 0; i < index; i++) {
            long ordenActual = Heap[i].getNumOrden();
            if (cusComparator.compare(ordenActual, numOrden) == 0) {
                ordenEncontrada = i;
            }
        }
        orden = Heap[ordenEncontrada];
        return orden;
    }
    
    public Orden[] findByCliente(Cliente cliente){
        int cantidad = numOrdenCliente(cliente);
        Orden[] ordenesPorCliente = new Orden[cantidad];
        int iterador = 0;
        for(int i = 0; i < index;i++){
            ordenesPorCliente[iterador++] = Heap[i];
        }
        return ordenesPorCliente;
    }
    
    public int numOrdenCliente(Cliente cliente){
        int cantidad = 0;
        for(int i = 0; i < index; i++){
            if(cusComparator.compare(Heap[i].getCliente().getCorreo(), cliente.getCorreo())==0){
                cantidad++;
            }
        }
        return cantidad;
    }
    
    public Orden findByFecha(Date fecha){
        Orden orden = new Orden();
        for (int i = 0; i < index; i++) {
            if (cusComparator.compare(Heap[i].getFechaOrden(), fecha) == 0 ) {
                orden = Heap[i];
                break;
            }
        }
        return orden;
    }
    
    public int find(Orden orden){
        int indexOrden = 0;
        for (int i = 0; i < index; i++) {
            long ordenActual = Heap[i].getNumOrden();
            if (cusComparator.compare(orden.getNumOrden(),ordenActual) == 0) {
                indexOrden = i;
                break;
            }
        }
        return indexOrden;
    }
    
    public void update(Orden ordenOld, Orden ordenNew){
        if(index != 0){
            int ordenUpd = find(ordenOld);
            Heap[ordenUpd] = ordenNew;
        }
    }

}
