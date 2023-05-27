/*
 * Copyright 2023 Egui
 */

package EstructurasDeDatos;


 // @author Camilo

public class NodeLinear<T> {

        private T data;
        private NodeLinear<T> next;

        public NodeLinear() {

        }

        public NodeLinear(T data) {
            this.data = data;
            this.next = null;
        }

        public NodeLinear(T data, NodeLinear next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public NodeLinear getNext() {
            return next;
        }

        public void setNext(NodeLinear next) {
            this.next = next;
        }
}

