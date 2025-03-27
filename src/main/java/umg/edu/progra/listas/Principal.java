package umg.edu.progra.listas;

import umg.edu.progra.listas.doblementeEnlazada.DoblementeEnlazada;

/**
 *
 * @author Walter Cordova
 */
public class Principal {

    public static void main(String[] args) {

        listaenlazadaDoble();

    }

    public static void listaenlazadaDoble() {
        DoblementeEnlazada dll = new DoblementeEnlazada();
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtBeginning(5);

        System.out.println("Lista en orden:");
        dll.displayForward();

        System.out.println("Lista en orden inverso:");
        dll.displayBackward();

        System.out.println("Eliminando 20: " + dll.delete(20));
        dll.displayForward();

        System.out.println("Buscando 10: " + dll.search(10));
        System.out.println("Buscando 50: " + dll.search(50));

        System.out.println("Número de nodos: " + dll.countNodes());

        dll.insertAfter(10, 15);
        System.out.println("Lista después de insertar 15 después de 10:");
        dll.displayForward();

        dll.reverse();
        System.out.println("Lista después de invertir:");
        dll.displayForward();
    }
}