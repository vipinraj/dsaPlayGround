/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

package week4;

import java.util.Collections;

public class BST<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }
    Node root;


    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value);
        }
        int cmp = x.key.compareTo(key);
        if (cmp == 0) {
            x.val = value;
        } else if (cmp > 0) {
            x.left = put(x.left, key, value);
        } else {
            x.right = put(x.right, key, value);
        }
        return x;
    }

    public Value get(Key key) {
        Node current = root;

        while (current != null) {
            int cmp = current.key.compareTo(key);
            if ( cmp > 0) {
                current = current.left;
            } else if (cmp < 0) {
                current = current.right;
            } else {
                return current.val;
            }
        }

        return null;
    }

    public Node min() {
        Node curentNode = root;

        while (curentNode.left != null) {
            curentNode = curentNode.left;
        }

        return curentNode;
    }

    public Node max() {
        Node curentNode = root;

        while (curentNode.right != null) {
            curentNode = curentNode.right;
        }

        return curentNode;
    }

    // Floor implementation here is little different here that
    // it wont return the same key if the key already present.
    // It will always return largest key LESS THAN the given key.
    public Key floor(Key key) {
        Node currentNode = root;
        Key floor = null;

        while (currentNode != null) {
            int cmp = currentNode.key.compareTo(key);
            if (cmp < 0) {
               if (floor == null || currentNode.key.compareTo(floor) > 0) {
                   floor = currentNode.key;
               }
               currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }

        return floor;
    }

    public Key floorRec(Key key) {
        Node floor = floor(root, key);
        if (floor == null) {
            return null;
        }
        return floor.key;
    }

    public Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        Node floor;
        if (x.key.compareTo(key) < 0) {
            floor = x;
            Node rightFloor = floor(x.right, key);
            if (rightFloor != null) {
                floor = rightFloor;
            }
        } else {
            floor = floor(x.left, key);
        }

        return floor;
    }

    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(5, "five");
        bst.put(8, "eight");
        bst.put(1, "one");
        bst.put(8, "Eight");
        bst.put(2, "two");
        bst.put(6, "six");

        System.out.println(bst.get(8));
        System.out.println(bst.get(1));
        System.out.println(bst.get(10));
        System.out.println("Min: " + bst.min().val);
        System.out.println("Max: " + bst.max().val);
        System.out.println("Floor(5): " + bst.floor(5));
        System.out.println("Floor(6): " + bst.floor(6));
        System.out.println("Floor(1): " + bst.floor(1));
        System.out.println("Floor(8): " + bst.floor(8));
        System.out.println("Floor(5): " + bst.floorRec(5));
        System.out.println("Floor(6): " + bst.floorRec(6));
        System.out.println("Floor(1): " + bst.floorRec(1));
        System.out.println("Floor(8): " + bst.floorRec(8));
    }
}
