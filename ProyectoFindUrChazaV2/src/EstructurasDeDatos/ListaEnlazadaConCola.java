package EstructurasDeDatos;

public class ListaEnlazadaConCola<T> {

    private int cantidad;
    private NodeLinear head, tail;

    public ListaEnlazadaConCola(NodeLinear data) {
        this.head = data;
        this.tail = data;
        cantidad = 0;
    }

    public ListaEnlazadaConCola() {

    }

    public void pushFront(T newHead) {
        NodeLinear nuevoNodo = new NodeLinear(newHead);
        nuevoNodo.setNext(this.head);
        this.head = nuevoNodo;
        actualizarColaFronts();
        cantidad++;
    }

    public NodeLinear popFront() {
        NodeLinear elemBorrado = this.head;
        this.head = this.head.getNext();
        actualizarColaFronts();
        cantidad--;
        return elemBorrado;
    }

    public void pushBack(T value) {
        NodeLinear<T> newNode = new NodeLinear<>(value);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        cantidad++;
    }

    public NodeLinear popBack() {
        /*
            NodeLinear nuevaRef=this.head;
            NodeLinear elemBorrado = null;
            if(nuevaRef != null) {
                while (nuevaRef.getNext().getNext() != null) {
                    nuevaRef = nuevaRef.getNext();

                }
                if (nuevaRef.getNext().getNext() == null) {
                    elemBorrado = nuevaRef.getNext();
                }
                nuevaRef.setNext(null);
                this.tail = nuevaRef;
                cantidad--;
            }
            return elemBorrado;

         */
        NodeLinear nuevaRef = this.head;
        NodeLinear elemBorrado = null;
        while (nuevaRef != null && nuevaRef.getNext() != null) {

            while (nuevaRef.getNext().getNext() != null) {
                nuevaRef = nuevaRef.getNext();
            }
            if (nuevaRef.getNext().getNext() == null && nuevaRef.getNext() != null) {
                elemBorrado = nuevaRef.getNext();
            }

            nuevaRef.setNext(null);
            this.tail = nuevaRef;
            cantidad--;

        }
        if (nuevaRef != null) {
            if (nuevaRef.getNext() == null) {
                this.head = null;
                elemBorrado = nuevaRef;
                cantidad--;
            }
        }
        return elemBorrado;
    }

    public void printRecursive(NodeLinear node) {
        if (node == null) {
            return;
        }
        if (node.getNext() != null) {
            System.out.print(node.getData() + " ");
        } else {
            System.out.print(node.getData());
        }

        printRecursive(node.getNext());
    }

    public String print() {
        String palabra = "";
        NodeLinear puntero = this.head;
        NodeLinear ultimoNodo = null;
        if (puntero != null) {
            while (puntero.getNext() != null) {
                if (puntero.getNext().getNext() == null) {
                    ultimoNodo = puntero.getNext();
                }
                palabra = palabra + puntero.getData() + " ";
                puntero = puntero.getNext();
            }
            if (ultimoNodo == null) {
                palabra = palabra + puntero.getData();
            } else {
                palabra = palabra + ultimoNodo.getData();
            }

        } else {
            palabra = "";
        }
        return palabra;
    }

    //insertar al medio de la lista enlazada
    public void insertMiddle(T item) {
        NodeLinear nuevaRef = this.head;
        NodeLinear prev = null;
        while (nuevaRef != null && nuevaRef.getData().toString().compareTo((String) item) < 0) {
            prev = nuevaRef;
            nuevaRef = nuevaRef.getNext();
        }
        if (nuevaRef.getData() != item) {
            NodeLinear nuevaPrev = new NodeLinear();
            nuevaPrev.setData(item);
            nuevaPrev.setNext(nuevaRef);
            prev.setNext(nuevaPrev);
        }
        cantidad++;
    }

    //insertar al final o al inicio de la lista enlazada
    public void insertEnd(T item) {

        NodeLinear nuevaRef = this.head;
        NodeLinear prev = null;
        while (nuevaRef != null && nuevaRef.getData().toString().compareTo((String) item) < 0) {
            prev = nuevaRef;
            nuevaRef = nuevaRef.getNext();
        }
        if (nuevaRef == null || nuevaRef.getData().toString().compareTo((String) item) != 0) {
            NodeLinear nuevaPrev = new NodeLinear();
            nuevaPrev.setData(item);
            nuevaPrev.setNext(nuevaRef);
            prev.setNext(nuevaPrev);
        }
        cantidad++;

    }

    //metodo de eliminar
    public void delete(T item) {
        /*
        NodeLinear nuevaRef = this.head;
        NodeLinear prev = null;
        while (nuevaRef != null && nuevaRef.getData().toString().compareTo((String) item) < 0) {
            prev = nuevaRef;
            nuevaRef = nuevaRef.getNext();
        }
        if (this.head.getData() == item) {
            prev = nuevaRef.getNext();
            this.head = prev;
        } else if (prev.getNext().getData() == item) {
            prev.setNext(nuevaRef.getNext());
        }
        cantidad--;
*/
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
        this.tail = prev;
        cantidad--;
    }

    public NodeLinear getHead() {
        return head;
    }

    public NodeLinear getTail() {
        return tail;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean isEmpty() {
        boolean isEmpty = false;
        try {
            NodeLinear puntero = this.head;
            NodeLinear ultimoNodo = null;
            while (puntero.getNext() != null) {
                if (puntero.getNext().getNext() == null) {
                    ultimoNodo = puntero.getNext();
                }
                puntero = puntero.getNext();
            }
            System.out.println(ultimoNodo.getData());
        } catch (NullPointerException e) {
            isEmpty = true;
        }

        return isEmpty;
    }

    public void actualizarColaFronts() {
        NodeLinear iterator = this.head;
        while (iterator != null && iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        if (iterator != null) {
            if (iterator.getNext() == null) {
                this.tail = iterator;
            }
        }
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

    public int cantidad() {
        return this.cantidad;
    }

}
