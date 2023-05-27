/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import Modelo.Chaza;

/**
 *
 * @author kelly
 */
public class NodeChaza{
    private Chaza key;
    private int height;
    private NodeChaza left, right;

    public NodeChaza(){
        this.left = null;
        this.right = null;
    }
    public NodeChaza(Chaza key) {
        this.key = key;
        this.right = null;
        this.left = null;
    }

    public Chaza getKey() {
        return key;
    }

    public void setKey(Chaza key) {
        this.key = key;
    }

    public NodeChaza getLeft() {
        return left;
    }

    public void setLeft(NodeChaza left) {
        this.left = left;
    }

    public NodeChaza getRight() {
        return right;
    }

    public void setRight(NodeChaza right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

