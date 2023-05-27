/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import Modelo.Chaza;
import Modelo.Vendedor;

/**
 *
 * @author kelly
 */
public class AVLChaza{

    
    private NodeChaza root;
    CustomComparator cusComparator = new CustomComparator();

    public NodeChaza newNode(Chaza chaza) {
        NodeChaza temp = new NodeChaza();
        temp.setKey(chaza);
        temp.setLeft(null);
        temp.setRight(null);
        return temp;
    }

    public AVLChaza() {
        root = null;
    }

    public AVLChaza(Chaza chaza) {
        root = newNode(chaza);
    }

    private void updateHeight(NodeChaza node){
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
    }

    public int height(NodeChaza node){
        return (node == null) ? -1 : node.getHeight();
    }

    private int getBalance(NodeChaza node){
        return (node == null) ? 0 : height(node.getRight()) - height(node.getLeft());
    }

    private NodeChaza rotateRight(NodeChaza nodeY){
        NodeChaza nodeX = nodeY.getLeft();
        NodeChaza nodeZ = nodeX.getRight();
        nodeX.setRight(nodeY);
        nodeY.setLeft(nodeZ);
        updateHeight(nodeY);
        updateHeight(nodeX);
        return nodeX;
    }

    private NodeChaza rotateLeft(NodeChaza nodeY){
        NodeChaza nodeX = nodeY.getRight();
        NodeChaza nodeZ = nodeX.getLeft();
        nodeX.setLeft(nodeY);
        nodeY.setRight(nodeZ);
        updateHeight(nodeY);
        updateHeight(nodeX);
        return nodeX;
    }

    private NodeChaza rebalance(NodeChaza nodeZ){
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

    public void insert(Chaza chaza){
        this.root = insert(this.root,chaza);
    }
    private NodeChaza insert(NodeChaza node, Chaza chaza){
        if(node == null){
            node = newNode(chaza);
            return node;
        }else if(cusComparator.compare(chaza.getNombreChaza(), node.getKey().getNombreChaza()) < 0){
            node.setLeft(insert(node.getLeft(),chaza));
        }else if(cusComparator.compare(chaza.getNombreChaza(), node.getKey().getNombreChaza()) > 0){
            node.setRight(insert(node.getRight(),chaza));
        }else{
            System.out.println("La chaza está duplicada!");
        }
        return rebalance(node);
    }

    public void remove(Chaza chaza){
        this.root =  remove(this.root,chaza);
    }

    private NodeChaza remove(NodeChaza node, Chaza chaza){
        if(node == null){
            return node;
        }else if(cusComparator.compare(chaza.getNombreChaza(), node.getKey().getNombreChaza()) < 0){
            node.setLeft(remove(node.getLeft(),chaza));
        }else if(cusComparator.compare(chaza.getNombreChaza(), node.getKey().getNombreChaza()) > 0){
            node.setRight(remove(node.getRight(),chaza));
        }else{
            if(node.getLeft() == null || node.getRight() == null){
                node = (node.getLeft() == null) ? node.getRight() : node.getLeft();
            }else{
                NodeChaza mostLeftChild = findMin(node.getRight());
                node.setKey(mostLeftChild.getKey());
                node.setRight(remove(node.getRight(), (Chaza) node.getKey()));
            }
        }

        if(node != null){
            node = rebalance(node);
        }
        return node;
    }

    public NodeChaza find(Chaza chaza){
        NodeChaza current = root;
        System.out.println("current: " + current.getKey().getNombreChaza());
        while(current != null){
            if(cusComparator.compare(current.getKey().getIdChaza(), chaza.getIdChaza()) == 0){
                break;
            }
            current = (cusComparator.compare(current.getKey().getNombreChaza(),chaza.getNombreChaza()) < 0) ? current.getRight() : current.getLeft();
        }
        
        return current;
    }
    
    public Chaza findByName(String nombreChaza){
        NodeChaza current = root;
        System.out.println("current: " + current.getKey().getNombreChaza());
        while(current != null){
            if(cusComparator.compare(current.getKey().getNombreChaza(), nombreChaza) == 0){
                break;
            }
            current = (cusComparator.compare(current.getKey().getNombreChaza(),nombreChaza) < 0) ? current.getRight() : current.getLeft();
        }
        return current.getKey();
    }
    
    public Chaza findById(int idChaza){
        NodeChaza current = root;
        while(current != null){
            if(cusComparator.compare(current.getKey().getIdChaza(), idChaza) == 0){
                break;
            }
            current = (cusComparator.compare(current.getKey().getIdChaza(),idChaza) < 0) ? current.getLeft() : current.getRight();
        }
        return current.getKey();
    }
    
    public Chaza findByVendedor(Vendedor vendedor){
        NodeChaza current = root;
        while(current != null){
            if(cusComparator.compare(current.getKey().getVendedor().getCorreo(), vendedor.getCorreo()) == 0){
                break;
            }
            current = (cusComparator.compare(current.getKey().getVendedor().getCorreo(),vendedor.getCorreo()) < 0) ? current.getRight() : current.getLeft();
        }
        return current.getKey();
    }
    
    public int numChazaVendedor(Vendedor vendedor){
        NodeChaza current = root;
        int contador = 0;
        while(current != null){
            if(cusComparator.compare(current.getKey().getVendedor().getCorreo(), vendedor.getCorreo()) == 0){
                contador++;
            }
            current = (cusComparator.compare(current.getKey().getVendedor().getCorreo(),vendedor.getCorreo()) < 0) ? current.getRight() : current.getLeft();
        }
        return contador;
    }

    public NodeChaza findMin() {
        NodeChaza nodeMin = findMin(this.root);
        return nodeMin;
    }

    private NodeChaza findMin(NodeChaza node) {
        NodeChaza copyOfNode = node;
        if (copyOfNode != null) {
            while (copyOfNode.getLeft() != null) {
                copyOfNode = copyOfNode.getLeft();
            }
        }
        return copyOfNode;
    }

    public NodeChaza findMax() {
        NodeChaza nodeMax = findMax(this.root);
        return nodeMax;
    }

    private NodeChaza findMax(NodeChaza node) {
        NodeChaza copyOfNode = node;
        if (copyOfNode != null) {
            while (copyOfNode.getRight() != null) {
                copyOfNode = copyOfNode.getRight();
            }
        }
        return copyOfNode;
    }

    public void update(Chaza keyOld, Chaza keyNew){
        if(this.root != null){
            NodeChaza nodeUpd = find(keyOld);
            nodeUpd.setKey(keyNew);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(this.root);
    }

    private void inOrderTraversal(NodeChaza root) {
        if (root != null) {
            inOrderTraversal(root.getLeft());
            System.out.print(" " + root.getKey());
            inOrderTraversal(root.getRight());
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(this.root);
    }

    private void preOrderTraversal(NodeChaza root) {
        if (root != null) {
            System.out.print(" " + root.getKey());
            preOrderTraversal(root.getLeft());
            preOrderTraversal(root.getRight());
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(this.root);
    }

    private void postOrderTraversal(NodeChaza root) {
        if (root != null) {
            postOrderTraversal(root.getLeft());
            postOrderTraversal(root.getRight());
            System.out.print(" " + root.getKey());
        }
    }

    public void printGivenLevel(int level) {
        printGivenLevel(this.root, level);
    }

    private void printGivenLevel(NodeChaza root, int level) {
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

    private void levelTraversal(NodeChaza root) {
        if (root != null) {
            ListaEnlazada newQueue = new ListaEnlazada();
            newQueue.pushBack(root);
            while (!newQueue.isEmpty()) {
                NodeChaza tempNode = (NodeChaza) newQueue.popFront();
                System.out.println(tempNode.getKey().getIdChaza()+ " "+tempNode.getKey().getNombreChaza()+" "+tempNode.getKey().getDescripcion());
                if(tempNode.getLeft()!=null){
                    newQueue.pushBack(tempNode.getLeft());
                }
                
                if(tempNode.getRight()!=null){
                    newQueue.pushBack(tempNode.getRight());
                }
            }
        }
    }

    public NodeChaza findLCA(Chaza key1,Chaza key2){
        return findLCA(this.root,key1,key2);
    }

    private NodeChaza findLCA(NodeChaza node, Chaza key1, Chaza key2){
        if(node == null){
            return null;
        }

        if(cusComparator.compare(node.getKey(),key1) == 0 || cusComparator.compare(node.getKey().getNombreChaza(),key2.getNombreChaza()) == 0){
            return node;
        }

        NodeChaza leftLCA = findLCA(node.getLeft(),key1,key2);
        NodeChaza rightLCA = findLCA(node.getRight(),key1,key2);

        if(leftLCA != null && rightLCA != null){
            return node;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }

}

