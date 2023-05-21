/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import Modelo.Orden;
import java.util.*;

import java.util.Scanner;

public class PriorityQueueOrden {
    public NodeLinearOrden head, tail;
    public int size;
    public final int MAX_SIZE;

    public PriorityQueueOrden(int maxSize) {
        head = null;
        tail = null;
        size = 0;
        MAX_SIZE = maxSize;
    }

    public boolean offer(Orden orden){
        if (size == MAX_SIZE) {
            return false;
        }
        NodeLinearOrden newNode = new NodeLinearOrden(orden);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
        return true;
    }

    public Orden poll() {
        if (head == null) {
            return null;
        }
        Orden value = head.getData();
        head = head.getNext();
        size--;
        return value;
    }

    public Orden peek() {
        if (head == null) {
            return null;
        }
        return head.getData();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }
    public void print() {
        NodeLinearOrden current = head;
        while (current != null) {
            if (current.getNext() != null) {
                System.out.print(current.getData() + " ");
            } else {
                System.out.print(current.getData());
            }
            current = current.getNext();
        }
    }

}

