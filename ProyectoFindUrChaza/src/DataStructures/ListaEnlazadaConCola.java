package DataStructures;

public class ListaEnlazadaConCola <T> {

    private int cantidad;
    private Node head,tail;

    public ListaEnlazadaConCola(Node data) {
        this.head =data;
        this.tail =data;
        cantidad++;
    }

    public void pushFront(T newHead){
        Node nuevoNodo = new Node(newHead);
        nuevoNodo.setNext(this.head);
        this.head=nuevoNodo;
        actualizarColaFronts();
        cantidad++;
    }

    public Node popFront(){
        Node elemBorrado = this.head;
        this.head=this.head.getNext();
        actualizarColaFronts();
        cantidad--;
        return elemBorrado;
    }

    public void pushBack(T data){
        Node referencia= this.head;
        while (referencia.getNext()!=null){
            referencia=referencia.getNext();
        }
        Node nuevoNuevoNodo = new Node(data);
        referencia.setNext(nuevoNuevoNodo);
        this.tail = nuevoNuevoNodo;
        cantidad++;
    }

    public Node popBack(){
            /*
            Node nuevaRef=this.head;
            Node elemBorrado = null;
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
        Node nuevaRef=this.head;
        Node elemBorrado = null;
        while(nuevaRef != null && nuevaRef.getNext() != null) {

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
        if(nuevaRef!=null){
            if(nuevaRef.getNext()==null){
                this.head=null;
                elemBorrado = nuevaRef;
                cantidad--;
            }
        }
        return elemBorrado;
    }
    public void printRecursive(Node node){
        if (node == null){
            return;
        }
        if(node.getNext() != null){
            System.out.print(node.getData() + " ");
        }else{
            System.out.print(node.getData());
        }

        printRecursive(node.getNext());
    }

    public String print(){
        String palabra = "";
        Node puntero=this.head;
        Node ultimoNodo=null;
        if(puntero!=null){
            while(puntero.getNext()!=null){
                if(puntero.getNext().getNext()==null){
                    ultimoNodo = puntero.getNext();
                }
                palabra = palabra + puntero.getData() + " ";
                puntero = puntero.getNext();
            }
            if(ultimoNodo==null){
                palabra = palabra + puntero.getData();
            }else{
                palabra = palabra + ultimoNodo.getData();
            }

        }else{
            palabra="";
        }
        return palabra;
    }




    //insertar al medio de la lista enlazada
    public void insertMiddle(T item){
        Node nuevaRef = this.head;
        Node prev = null;
        while(nuevaRef != null && nuevaRef.getData().toString().compareTo((String) item) < 0){
            prev = nuevaRef;
            nuevaRef = nuevaRef.getNext();
        }
        if(nuevaRef.getData() != item){
            Node nuevaPrev = new Node();
            nuevaPrev.setData(item);
            nuevaPrev.setNext(nuevaRef);
            prev.setNext(nuevaPrev);
        }
        cantidad++;
    }

    //insertar al final o al inicio de la lista enlazada
    public void insertEnd(T item){

        Node nuevaRef = this.head;
        Node prev = null;
        while(nuevaRef != null && nuevaRef.getData().toString().compareTo((String) item) < 0){
            prev = nuevaRef;
            nuevaRef = nuevaRef.getNext();
        }
        if(nuevaRef == null || nuevaRef.getData().toString().compareTo((String) item) != 0){
            Node nuevaPrev = new Node();
            nuevaPrev.setData(item);
            nuevaPrev.setNext(nuevaRef);
            prev.setNext(nuevaPrev);
        }
        cantidad++;


    }

    //metodo de eliminar

    public void delete(T item){
        Node nuevaRef = this.head;
        Node prev = null;
        while(nuevaRef != null && nuevaRef.getData().toString().compareTo((String) item) < 0){
            prev = nuevaRef;
            nuevaRef = nuevaRef.getNext();
        }
        if(this.head.getData() == item){
            prev = nuevaRef.getNext();
            this.head = prev;
        }else if(prev.getNext().getData() == item){
            prev.setNext(nuevaRef.getNext());
        }
        cantidad--;
    }



    public Node getHead() {
        return head;
    }
    public Node getTail() {
        return tail;
    }

    public int getCantidad(){
        return cantidad;
    }

    public boolean isEmpty(){
        boolean isEmpty = false;
        try{
            Node puntero=this.head;
            Node ultimoNodo=null;
            while(puntero.getNext()!=null){
                if(puntero.getNext().getNext()==null) {
                    ultimoNodo = puntero.getNext();
                }
                puntero = puntero.getNext();
            }
            System.out.println(ultimoNodo.getData());
        }catch(NullPointerException e){
            isEmpty = true;
        }

        return isEmpty;
    }

    public void actualizarColaFronts(){
        Node iterator = this.head;
        while(iterator != null && iterator.getNext()!=null){
            iterator = iterator.getNext();
        }
        if(iterator != null){
            if(iterator.getNext() == null){
                this.tail = iterator;
            }
        }
    }

}
