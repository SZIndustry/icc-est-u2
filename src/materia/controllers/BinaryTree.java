package materia.controllers;

import materia.models.Node;


public class BinaryTree {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            return new Node(value);
        }
        if (value <= padre.getValue()) {
           // Node newNode = insertRec(padre.getLeft(), value);
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public void printInOrden() {
        printInOrdenRec(root);
    }

    private void printInOrdenRec(Node node) {
        if(node != null) {
            printInOrdenRec(node.getLeft());
            System.out.println(node.getValue() + ", ");
            printInOrdenRec(node.getRight());
        }
    }
    
    public void printPosOrden() {
        printPosOrdenRec(root);
    }

    private void printPosOrdenRec(Node node) {
        if(node != null) {
            printPosOrdenRec(node.getLeft());
            printPosOrdenRec(node.getRight());
            System.out.println(node.getValue() + ", ");
        }
    }

    public void printPreOrden() {
        printPreOrdenRec(root);
    }

    private void printPreOrdenRec(Node node) {
        if(node != null) {
            System.out.println(node.getValue() + ", ");
            printPreOrdenRec(node.getLeft());
            printPreOrdenRec(node.getRight());
        }
    }

    public boolean findValue(int value) {
        return findValueRec(root, value);
    }

    private boolean findValueRec(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.getValue() == value) {
            return true;
        }
        return findValueRec(node.getLeft(), value) || findValueRec(node.getRight(), value);
    }

}
