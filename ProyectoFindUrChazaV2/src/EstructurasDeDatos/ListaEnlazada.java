/*
 * Copyright 2023 Egui
 */

package EstructurasDeDatos;


 // @author Camilo
//LinkedList simplemente enlazada
public class ListaEnlazada <T> {
    
    NodeLinear<T> head;
    int size = 0;

   
    public void printList() {
        NodeLinear ref = this.head;
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

    private void printR(NodeLinear p) {
        if (p != null) {
            System.out.print(p.getData() + ", ");
            printR(p.getNext());
        }
    }

    public void pushFront(T newElement) {
        NodeLinear<T> newHead = new NodeLinear(newElement);
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
        NodeLinear<T> ptr = this.head;
        NodeLinear<T> newTail = new NodeLinear(newElement);
        if (ptr == null) {
            this.head = newTail;
        } else {
            while (ptr.getNext() != null) {
                ptr = ptr.getNext();
            }
            ptr.setNext(newTail);
        }
        this.size++;
    }

    public T topBack() {
        NodeLinear<T> ptr = this.head;
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

        NodeLinear<T> ptr = this.head;
        NodeLinear<T> prev = null;

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
        NodeLinear<T> ptr = this.head;
        while (ptr != null) {
            if (ptr.getData().equals(key)) {
                return true;
            }
            ptr = ptr.getNext();
        }
        return false;
    }
     public void ActualizarData(T anteriorValuer, T nuevoValor) {
         NodeLinear<T> current = head;

         while (current != null) {
             if (current.getData() == anteriorValuer) {
                 current.setData(nuevoValor);
                 return;
             }
             current = current.getNext();
         }
     }
     
     public void delete(T item){
        NodeLinear nuevaRef = this.head;
        NodeLinear prev = null;
        if(nuevaRef != null && nuevaRef.getData()==item){
            this.head = nuevaRef.getNext();
            return;
        }
        while(nuevaRef!=null && nuevaRef.getData() != item){
            prev = nuevaRef;
            nuevaRef = nuevaRef.getNext();
        }
        
        if(nuevaRef==null){
            return;
        }
        prev.setNext(nuevaRef.getNext());
    }
     
    public T getElement(int i) {
        if (i < 0 || this.head == null) {
            return null;
        }

        NodeLinear<T> nodoActual = this.head;
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
