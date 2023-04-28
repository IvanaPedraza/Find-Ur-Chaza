/*
 * Copyright 2023 Egui
 */

package DataStructures;


 // @author Camilo

public class Node<T> {

        private T data;
        private Node<T> next;

        public Node() {

        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
}

