/*
 * Copyright 2023 Egui
 */

package EstructurasDeDatos;


 // @author Camilo
//LinkedList simplemente enlazada
public class ListaEnlazada <T> {
    
    Node<T> head;
    int size = 0;

   
    public void printList() {
        Node ref = this.head;
        while (ref != null) {
            System.out.print(ref.getData() + ", ");
            ref = ref.getNext();
        }
        System.out.println();

    }

    public void printRecursive() {
        printR(head);
        System.out.println();
    }

    private void printR(Node p) {
        if (p != null) {
            System.out.print(p.getData() + ", ");
            printR(p.getNext());
        }
    }

    public void pushFront(T newElement) {
        Node<T> newHead = new Node(newElement);
        if (this.head != null) {
            newHead.setNext(this.head);
        }
        this.head = newHead;
        this.size++;
    }

    public T topFront() {
        if (this.head == null) {
            System.out.println("la lista está vacía");
            return null;
        } else {
            return this.head.getData();
        }
    }

    public T popFront() {
        if (this.head != null) {
            T data = this.topFront();
            this.head = this.head.getNext();
            this.size--;
            return data;
        } else {
            System.out.println("no hay nada que remover");
            return null;
        }
    }

    public void pushBack(T newElement) {
        Node<T> ptr = this.head;
        Node<T> newTail = new Node(newElement);
        if (ptr == null) {
            this.head = newTail;
        } else {
            while (ptr.getNext() != null) {
                ptr = ptr.getNext();
            }
            ptr.setNext(newTail);
        }

    }

    public T topBack() {
        Node<T> ptr = this.head;
        if (ptr == null) {
            System.out.println("la lista está vacía");
            return null;
        } else {
            while (ptr.getNext() != null) {
                ptr = ptr.getNext();
            }
            return ptr.getData();
        }
    }

    public T popBack() {

        Node<T> ptr = this.head;
        Node<T> prev = null;

        if (ptr == null) {
            System.out.println("no hay nada que remover");
            return null;
        } else {
            while (ptr.getNext() != null) {
                prev = ptr;
                ptr = ptr.getNext();

            }
            T data = this.topBack();
            if (prev == null) {
                this.head = null;
            } else {
                prev.setNext(ptr.getNext());
            }
            size--;
            return data;

        }
    }

    public boolean find(T key) {
        Node<T> ptr = this.head;
        while (ptr != null) {
            if (ptr.getData().equals(key)) {
                return true;
            }
            ptr = ptr.getNext();
        }
        return false;
    }
     public void ActualizarData(T anteriorValuer, T nuevoValor) {
         Node<T> current = head;

         while (current != null) {
             if (current.getData() == anteriorValuer) {
                 current.setData(nuevoValor);
                 return;
             }
             current = current.getNext();
         }
     }
     
     public void delete(T item){
        Node nuevaRef = this.head;
        while(nuevaRef != null && nuevaRef.getData().toString().compareTo((String) item) < 0){
            nuevaRef = nuevaRef.getNext();
        }
        size--;
    }
     
    public T getElement(int i) {
        if (i < 0 || this.head == null) {
            return null;
        }

        Node<T> nodoActual = this.head;
        int posicionActual = 0;

        while (nodoActual != null) {
            if (posicionActual == i) {
                return nodoActual.getData();
            }

            posicionActual++;
            nodoActual = nodoActual.getNext();
        }
        return null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void emptyList() {
        this.head = null;
    }
    
    public int size(){
        return this.size;
    }
}
