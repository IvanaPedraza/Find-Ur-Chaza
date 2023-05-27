/*
 * Copyright 2023 Egui
 */

package EstructurasDeDatos;

import Modelo.Orden;


 // @author Camilo

public class NodeLinearOrden {

        private Orden data;
        private NodeLinearOrden next;

        public NodeLinearOrden() {

        }

        public NodeLinearOrden(Orden orden) {
            this.data = orden;
            this.next = null;
        }

        public NodeLinearOrden(Orden orden, NodeLinearOrden next) {
            this.data = orden;
            this.next = next;
        }

        public Orden getData() {
            return data;
        }

        public void setData(Orden orden) {
            this.data = orden;
        }

        public NodeLinearOrden getNext() {
            return next;
        }

        public void setNext(NodeLinearOrden next) {
            this.next = next;
        }
}

