package materia.controllers;

import materia.models.Node;

public class AVLTree {

    private Node root;

    public AVLTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

        private Node insertRec(Node node, int value) {

        if (node == null) {
            Node newNode = new Node(value);
            newNode.setHeight(1);
            System.out.println("Nodo insertado -> " + value + " con balance 0");
            return newNode;
        }

        if (value < node.getValue()) {
            node.setLeft(insertRec(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insertRec(node.getRight(), value));
        } else {
            return node;
        }

        int altura = 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
        node.setHeight(altura);

        int balance = getBalanceFactor(node);

        System.out.println("Nodo actual -> " + node.getValue());
        System.out.println("\tAltura -> " + altura);
        System.out.println("\tBalance -> " + balance);

        if (balance > 1 && value < node.getLeft().getValue()) {
            System.out.println("Rotacion Simple Derecha");
            return rightRotation(node);
        
        }

        if (balance < -1 && value > node.getRight().getValue()) {
            System.out.println("Rotacion Simple Izquierda");
            return  leftRotation(node);
        
        }

        if (balance > 1 && value > node.getLeft().getValue()) {
            System.out.println("Cambio");
            System.out.println();
            System.out.println("Rotacion DER en nodo: " + node.getLeft().getValue() + ", con balance = " + getBalanceFactor(node.getLeft()));
            node.setLeft(leftRotation(node.getLeft()));
            System.out.println("Nueva raiz despues de la rotación " + node.getLeft().getValue());
            System.out.println("Rotacion Simple Derecha");
                return rightRotation(node);
        }

        if (balance < -1 && value < node.getRight().getValue()) {
            System.out.println("Cambio");
            System.out.println();
            System.out.println("Rotacion IZQ en nodo: " + node.getRight().getValue() + ", con balance = " + getBalanceFactor(node.getRight()));
            node.setRight(rightRotation(node.getRight()));
            System.out.println("Nueva raiz despues de la rotación " + node.getRight().getValue());
            System.out.println("Rotacion Simple Izquierda");
                return leftRotation(node);
}


        return node;
    }

    private Node rightRotation(Node y) {
        Node x = y.getLeft();
        Node temp = x.getRight();

        

        x.setRight(y);
        y.setLeft(temp);

        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);
        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);

        System.out.println("Nueva raiz despues de la rotación " + x.getValue());

        return x;
}


    private Node leftRotation(Node x) {
        Node y = x.getRight();
        Node temp = y.getLeft();

        System.out.println("Rotacion IZQ en nodo: " + x.getValue() + ", con balance = " + getBalanceFactor(x));

        y.setLeft(x);
        x.setRight(temp);

        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);
        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);

        System.out.println("Nueva raiz despues de la rotación " + y.getValue());

        return y;
}



    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    public int getBalanceFactor(Node node) {
        if (node == null) return 0;
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.getLeft());
            System.out.print(node.getValue() + " ");
            inOrderRec(node.getRight());
        }
    }


    
}