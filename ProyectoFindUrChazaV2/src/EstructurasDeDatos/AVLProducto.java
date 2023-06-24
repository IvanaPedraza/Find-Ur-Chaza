/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import Modelo.Chaza;
import Modelo.Producto;

/**
 *
 * @author kelly
 */
public class AVLProducto{

    private NodeProducto root;
    CustomComparator cusComparator = new CustomComparator();

    public NodeProducto newNode(Producto producto) {
        NodeProducto temp = new NodeProducto();
        temp.setKey(producto);
        temp.setLeft(null);
        temp.setRight(null);
        return temp;
    }

    public AVLProducto() {
        root = null;
    }

    public AVLProducto(Producto producto) {
        root = newNode(producto);
    }
    
    public NodeProducto getRoot(){
        return root;
    }

    private void updateHeight(NodeProducto node){
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
    }

    public int height(NodeProducto node){
        return (node == null) ? -1 : node.getHeight();
    }

    private int getBalance(NodeProducto node){
        return (node == null) ? 0 : height(node.getRight()) - height(node.getLeft());
    }

    private NodeProducto rotateRight(NodeProducto nodeY){
        NodeProducto nodeX = nodeY.getLeft();
        NodeProducto nodeZ = nodeX.getRight();
        nodeX.setRight(nodeY);
        nodeY.setLeft(nodeZ);
        updateHeight(nodeY);
        updateHeight(nodeX);
        return nodeX;
    }

    private NodeProducto rotateLeft(NodeProducto nodeY){
        NodeProducto nodeX = nodeY.getRight();
        NodeProducto nodeZ = nodeX.getLeft();
        nodeX.setLeft(nodeY);
        nodeY.setRight(nodeZ);
        updateHeight(nodeY);
        updateHeight(nodeX);
        return nodeX;
    }

    private NodeProducto rebalance(NodeProducto nodeZ){
        updateHeight(nodeZ);
        int balance = getBalance(nodeZ);
        if(balance > 1){
            if(height(nodeZ.getRight().getRight()) > height(nodeZ.getRight().getLeft())){
                nodeZ = rotateLeft(nodeZ);
            }else{
                nodeZ.setRight(rotateRight(nodeZ.getRight()));
                nodeZ = rotateLeft(nodeZ);
            }
        }else if(balance < -1){
            if(height(nodeZ.getLeft().getLeft()) > height(nodeZ.getLeft().getRight())){
                nodeZ = rotateRight(nodeZ);
            }else{
                nodeZ.setLeft(rotateLeft(nodeZ.getLeft()));
                nodeZ = rotateRight(nodeZ);
            }
        }
        return nodeZ;
    }

    public void insert(Producto producto){
        this.root = insert(this.root,producto);
    }
    private NodeProducto insert(NodeProducto node, Producto producto){
        if(node == null){
            node = newNode(producto);
            return node;
        }else if(cusComparator.compare(producto.getCodigo(), node.getKey().getCodigo()) < 0){
            node.setLeft(insert(node.getLeft(),producto));
        }else if(cusComparator.compare(producto.getCodigo(), node.getKey().getCodigo()) > 0){
            node.setRight(insert(node.getRight(),producto));
        }else{
            System.out.println("El producto esta duplicado!");
        }
        return rebalance(node);
    }

    public void remove(Producto producto){
        this.root =  remove(this.root,producto);
    }

    private NodeProducto remove(NodeProducto node, Producto producto){
        if(node == null){
            return node;
        }else if(cusComparator.compare(producto.getCodigo(), node.getKey().getCodigo()) < 0){
            node.setLeft(remove(node.getLeft(),producto));
        }else if(cusComparator.compare(producto.getCodigo(), node.getKey().getCodigo()) > 0){
            node.setRight(remove(node.getRight(),producto));
        }else{
            if(node.getLeft() == null || node.getRight() == null){
                node = (node.getLeft() == null) ? node.getRight() : node.getLeft();
            }else{
                NodeProducto mostLeftChild = findMin(node.getRight());
                node.setKey(mostLeftChild.getKey());
                node.setRight(remove(node.getRight(), (Producto) node.getKey()));
            }
        }

        if(node != null){
            node = rebalance(node);
        }
        return node;
    }

    public NodeProducto find(Producto producto){
        NodeProducto current = root;
        while(current != null){
            if(current.getKey().equals(producto)){
                break;
            }
            current = (cusComparator.compare(current.getKey(),producto) < 0) ? current.getRight() : current.getLeft();
        }
        return current;
    }
    
    public Producto findByCode(Long codigo){
        NodeProducto current = root;
        while(current != null){
            if(cusComparator.compare(current.getKey().getCodigo(), codigo)==0){
                break;
            }
            current = (cusComparator.compare(current.getKey().getCodigo(),codigo) < 0) ? current.getRight() : current.getLeft();
        }
        return current.getKey();
    }
    
    public Producto[] findByChaza(Chaza chaza){
        NodeProducto nodo = root;
        int count = numProductoChaza(nodo, chaza);
        Producto[] productos = new Producto[count];
        inOrderTraversalChaza(nodo, chaza, productos, 0);
        return productos;
    }
    
    public int numProductoChaza(NodeProducto nodo, Chaza chaza){
        if(nodo == null){
            return 0;
        }
        int count = 0;
        if(cusComparator.compare(nodo.getKey().getChaza().getIdChaza(), chaza.getIdChaza()) == 0){
            count++;
        }
        count += numProductoChaza(nodo.getLeft(), chaza);
        count += numProductoChaza(nodo.getRight(), chaza);
        return count;
    }
    
    private int inOrderTraversalChaza(NodeProducto nodo, Chaza chaza, Producto[] productos, int index) {
        if (nodo == null) {
            return index;
        }
        index = inOrderTraversalChaza(nodo.getLeft(), chaza, productos, index);
        if (cusComparator.compare(nodo.getKey().getChaza().getIdChaza(), chaza.getIdChaza()) == 0) {
            productos[index++] = nodo.getKey();
        }
        index = inOrderTraversalChaza(nodo.getRight(), chaza, productos, index);
        return index;
    }

    public NodeProducto findMin() {
        NodeProducto nodeMin = findMin(this.root);
        return nodeMin;
    }

    private NodeProducto findMin(NodeProducto node) {
        NodeProducto copyOfNode = node;
        if (copyOfNode != null) {
            while (copyOfNode.getLeft() != null) {
                copyOfNode = copyOfNode.getLeft();
            }
        }
        return copyOfNode;
    }

    public NodeProducto findMax() {
        NodeProducto nodeMax = findMax(this.root);
        return nodeMax;
    }

    private NodeProducto findMax(NodeProducto node) {
        NodeProducto copyOfNode = node;
        if (copyOfNode != null) {
            while (copyOfNode.getRight() != null) {
                copyOfNode = copyOfNode.getRight();
            }
        }
        return copyOfNode;
    }

    public void update(Producto keyOld, Producto keyNew){
        if(this.root != null){
            NodeProducto nodeUpd = find(keyOld);
            nodeUpd.setKey(keyNew);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(this.root);
    }

    private void inOrderTraversal(NodeProducto root) {
        if (root != null) {
            inOrderTraversal(root.getLeft());
            System.out.print(" " + root.getKey());
            inOrderTraversal(root.getRight());
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(this.root);
    }

    private void preOrderTraversal(NodeProducto root) {
        if (root != null) {
            System.out.print(" " + root.getKey());
            preOrderTraversal(root.getLeft());
            preOrderTraversal(root.getRight());
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(this.root);
    }

    private void postOrderTraversal(NodeProducto root) {
        if (root != null) {
            postOrderTraversal(root.getLeft());
            postOrderTraversal(root.getRight());
            System.out.print(" " + root.getKey());
        }
    }

    public void printGivenLevel(int level) {
        printGivenLevel(this.root, level);
    }

    private void printGivenLevel(NodeProducto root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(" " + root.getKey());
        } else if (level > 1) {
            printGivenLevel(root.getLeft(), level - 1);
            printGivenLevel(root.getRight(), level - 1);
        }
    }

    public void levelTraversal() {
        levelTraversal(this.root);
    }

    private void levelTraversal(NodeProducto root) {
        if (root != null) {
            ListaEnlazada newQueue = new ListaEnlazada();
            newQueue.pushBack(root);
            while (!newQueue.isEmpty()) {

            }
        }
    }

    public NodeProducto findLCA(Producto key1,Producto key2){
        return findLCA(this.root,key1,key2);
    }

    private NodeProducto findLCA(NodeProducto node, Producto key1, Producto key2){
        if(node == null){
            return null;
        }

        if(cusComparator.compare(node.getKey().getCodigo(),key1.getCodigo()) == 0 || cusComparator.compare(node.getKey().getCodigo(),key2.getCodigo()) == 0){
            return node;
        }

        NodeProducto leftLCA = findLCA(node.getLeft(),key1,key2);
        NodeProducto rightLCA = findLCA(node.getRight(),key1,key2);

        if(leftLCA != null && rightLCA != null){
            return node;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }
    
    

}

