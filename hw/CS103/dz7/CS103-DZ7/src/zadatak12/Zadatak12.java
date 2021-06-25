// Dato je binarno stablo celih brojeva.
// Napisati funkciju koja će prebrojati koliko elemenata
// ima vrednost veću od proseka elemenata svog levog podstabla.

package zadatak12;

public class Zadatak12 {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(4);
        root.right.left.left = new Node(5);
        root.right.left.right = new Node(5);
        root.right.right.right = new Node(7);
    }

    public static int countAverage (Node root) {

    }
}

