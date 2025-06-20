package materia.controllers;

import java.util.Stack;
import materia.models.Node;

public class BinaryTree {

    private Node root;
    private int size = 0;
    private Stack<Node> desequilibrados;

    public BinaryTree() {
        this.root = null;
        this.desequilibrados = new Stack<Node>();
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            size++;
            return new Node(value);
        }
        if (value <= padre.getValue()) {
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public void printInOrden() {
        printInOrdenRec(root);
        System.out.println();
    }

    private void printInOrdenRec(Node node) {
        if (node != null) {
            printInOrdenRec(node.getLeft());
            System.out.print(node.getValue() + ", ");
            printInOrdenRec(node.getRight());
        }
    }

    public void printInOrden2() {
        printInOrdenRec2(root);
    }

    private void printInOrdenRec2(Node node) {
        if(node != null) {
            printInOrdenRec2(node.getLeft());
            System.out.print(node.getValue() + " h = " + getHeightRec(node) + ", ");
            printInOrdenRec2(node.getRight());
        }
    }

    public void printInOrden3() {
        printInOrdenRec3(root);
    }

    private void printInOrdenRec3(Node node) {
        if(node != null) {
            printInOrdenRec3(node.getLeft());
            System.out.print(node.getValue() + " E = " + equilibre(node) + ", ");
            printInOrdenRec3(node.getRight());
        }
         int balance = equilibre(node);
        if (Math.abs(balance) > 1) {
            desequilibrados.push(node);
        }
    }

    public void printPosOrden() {
        printPosOrdenRec(root);
    }

    private void printPosOrdenRec(Node node) {
        if(node != null) {
            printPosOrdenRec(node.getLeft());
            printPosOrdenRec(node.getRight());
            System.out.print(node.getValue() + ", ");
        }
    }

    public void printPreOrden() {
        printPreOrdenRec(root);
    }

    private void printPreOrdenRec(Node node) {
        if(node != null) {
            System.out.print(node.getValue() + ", ");
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

    public int getHeight() {
        return getHeightRec(root);
    }

    private int getHeightRec(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
    }

    public int equilibre(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeightRec(node.getLeft()) - getHeightRec(node.getRight());
    }

    public int getSize() {
        return size;
    }

    public boolean isBalanced() {
        return isBalancedRec(root);
    }

    private boolean isBalancedRec(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = equilibre(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalancedRec(node.getLeft()) && isBalancedRec(node.getRight());
    }

    public Stack<Node> getUnbalancedNodes() {
        return desequilibrados;
    }

    public void printUnbalancedNodes() {
        if (desequilibrados.isEmpty()) {
            System.out.println("Nodos desiquilibrados: ninguno");
            return;
        }
        System.out.print("Nodos desiquilibrados: ");
        for (int i = 0; i < desequilibrados.size(); i++) {
            Node n = desequilibrados.get(i);
            int fe = equilibre(n);
            System.out.print(n.getValue() + "(fE = " + fe + ")");
            if (i < desequilibrados.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
