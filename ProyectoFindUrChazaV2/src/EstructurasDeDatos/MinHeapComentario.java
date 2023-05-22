/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import Modelo.Comentario;
import Modelo.Orden;
import java.util.Date;

/**
 *
 * @author kelly
 */
public class MinHeapComentario {

    CustomComparator cusComparator = new CustomComparator();
    private Comentario[] Heap;
    private int index;
    private int size;

    public MinHeapComentario(int size) {
        this.size = size;
        this.index = 0;
        Heap = new Comentario[size];
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

    public void insert(Comentario element) {
        if (index >= size) {
            return;
        }
        Heap[index] = element;
        int current = index;

        while (cusComparator.compare(Heap[current].getFechaComentario(), Heap[parent(current)].getFechaComentario()) < 0) {
            swap(current, parent(current));
            current = parent(current);
        }
        index++;
    }

    // removes and returns the minimum element from the heap
    public Comentario remove() {
        // since its a min heap, so root = minimum
        Comentario popped = Heap[0];
        Heap[0] = Heap[--index];
        minHeapify(0);
        return popped;
    }
    
    public Comentario remove(int i) {
        // since its a min heap, so root = minimum
        Comentario popped = Heap[i];
        Heap[i] = Heap[--index];
        minHeapify(i);
        return popped;
    }
    
    public void remove(Comentario comentario){
        int index = find(comentario);
        remove(index);
    }

    // heapify the node at i
    private void minHeapify(int i) {
        // If the node is a non-leaf node and any of its child is smaller
        if (!isLeaf(i)) {
            if (cusComparator.compare(Heap[i].getFechaComentario(), Heap[leftChild(i)].getFechaComentario()) > 0
                    || cusComparator.compare(Heap[i].getFechaComentario(), Heap[rightChild(i)].getFechaComentario()) > 0) {
                if (cusComparator.compare(Heap[leftChild(i)].getFechaComentario(), Heap[rightChild(i)].getFechaComentario()) < 0) {
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
            System.out.print("Parent : " + Heap[i].getFechaComentario());
            if (leftChild(i) < index) {
                System.out.print(" Left : " + Heap[leftChild(i)].getFechaComentario());
            }
            if (rightChild(i) < index) {
                System.out.print(" Right :" + Heap[rightChild(i)].getFechaComentario());
            }
            System.out.println();
        }
    }
    // swaps two nodes of the heap

    private void swap(int x, int y) {
        Comentario tmp;
        tmp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = tmp;
    }

    public void printHeap2() {
        for (int i = 0; i < index; i++) {
            System.out.println(Heap[i].getFechaComentario());
        }
    }
    
    public Comentario findByIdComentario(long idComentario) {
        Comentario comentario = new Comentario();
        for (int i = 0; i < index; i++) {
            if (Heap[i].getIdComentario()== idComentario) {
                comentario = Heap[i];
            }
        }
        return comentario;
    }
    
    public Comentario findByFecha(Date fecha){
        Comentario comentario = new Comentario();
        for (int i = 0; i < index; i++) {
            if (cusComparator.compare(Heap[i].getFechaComentario(), fecha) == 0 ) {
                comentario = Heap[i];
                break;
            }
        }
        return comentario;
    }
    
    public int find(Comentario comentario){
        int indexComentario = 0;
        for (int i = 0; i < index; i++) {
            if (Heap[i].equals(comentario)) {
                indexComentario = i;
                break;
            }
        }
        return indexComentario;
    }
    
    public void update(Comentario comentarioOld, Comentario comentarioNew){
        if(index != 0){
            int comentarioUpd = find(comentarioOld);
            Heap[comentarioUpd] = comentarioNew;
        }
    }
}
