/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import Modelo.Producto;

/**
 *
 * @author kelly
 */
public class NodeProducto{
    private Producto key;
    private int height;
    private NodeProducto left, right;

    public NodeProducto(){
        this.left = null;
        this.right = null;
    }
    public NodeProducto(Producto key) {
        this.key = key;
        this.right = null;
        this.left = null;
    }

    public Producto getKey() {
        return key;
    }

    public void setKey(Producto key) {
        this.key = key;
    }

    public NodeProducto getLeft() {
        return left;
    }

    public void setLeft(NodeProducto left) {
        this.left = left;
    }

    public NodeProducto getRight() {
        return right;
    }

    public void setRight(NodeProducto right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

