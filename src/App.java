import materia.controllers.AVLTree;

public class App {

    public static void  main(String[] args) {
        // BinaryTree ab = new BinaryTree(); 
        //     ab.insert(50);
        //     ab.insert(17);
        //     ab.insert(76);
        //     ab.insert(9);
        //     ab.insert(23);
        //     ab.insert(54);
        //     ab.insert(14);
        //     ab.insert(19);

        // System.out.println("Peso del arbol: " + ab.getSize());
        // System.out.println("Altura del arbol: " + ab.getHeight());
        // System.out.println("InOrden");
        // ab.printInOrden();
        // System.out.println("\nInOrden con altura");
        // ab.printInOrden2();
        // System.out.println("");
        // System.out.println("\nInOrden con factor de equilibrio");
        // ab.printInOrden3();
        // System.out.println("");
        // System.out.println("\nArbol esta equilibrado = " + ab.isBalanced());
        // System.out.println("Existe el nodo 15 = " + ab.findValue(15));
        // if (ab.findValue(23) != false) {
        //     ab.insert(15);
        //     System.out.println("Se inserto el nodo 15");
        // }
        // System.out.println("\nArbol esta equilibrado = " + ab.isBalanced());
        // System.out.println("\nInOrden con factor de equilibrio");
        // ab.printInOrden3();
        // System.out.println("");
        // ab.printUnbalancedNodes();


        // System.out.println("\nPosOrden");
        // ab.printPosOrden();
        // System.out.println("\nPreOrden");
        // ab.printPreOrden();

        // if (ab.findValue(23)) {
        //     System.out.println("\nEl nodo 23 se encuentra en el árbol.");
        // } else {
        //     System.out.println("El nodo 23 no se encuentra en el árbol.");
        // }
        // if (ab.findValue(77)) {
        //     System.out.println("El nodo 77 se encuentra en el árbol.");
        // } else {
        //     System.out.println("El nodo 77 no se encuentra en el árbol.");
        // }

        AVLTree tree = new AVLTree();

        tree.insert(5);
        tree.insert(20);
        tree.insert(15);
        

        System.out.println("Recorrido in-order del árbol AVL:");
        tree.inOrder();

    }
   
}