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

import edu.princeton.cs.algs4.Queue;

import java.util.Collections;

public class BST<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int count;
        public Node(Key key, Value val, int count) {
            this.key = key;
            this.val = val;
            this.count = count;
        }
    }
    Node root;


    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1);
        }

        int cmp = x.key.compareTo(key);
        if (cmp == 0) {
            x.val = value;
        } else if (cmp > 0) {
            x.left = put(x.left, key, value);
        } else {
            x.right = put(x.right, key, value);
        }


        x.count = 1 + size(x.left) +  size(x.right);
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

    public int size() {
        System.out.println(root.key);
        return size(root);
    }

    public int size(Node x) {
        if (x == null) return 0;
        return x.count;
    }

    public Key max() {
        return max(root).key;
    }

    public Node max(Node x) {
        Node curentNode = x;

        while (curentNode.right != null) {
            curentNode = curentNode.right;
        }

        return curentNode;
    }

    public Key min() {
        return min(root).key;
    }

    public Node min(Node x) {
        Node curentNode = x;

        while (curentNode.left != null) {
            curentNode = curentNode.left;
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

    public Key ceiling(Key key) {
        Node node = ceiling(root, key);

        if (node != null) {
            return node.key;
        }

        return null;
    }

    // recursive
    public Node ceiling(Node x, Key key) {
        if (x == null) {
            return  null;
        }

        Node ceilingNode = null;

        int cmp = x.key.compareTo(key);

        if (cmp > 0) {
            ceilingNode = x;
            Node leftCeiling = ceiling(x.left, key);

            if (leftCeiling != null) {
                ceilingNode = leftCeiling;
            }
        } else if (cmp < 0) {
            ceilingNode = ceiling(x.right, key);
        } else {
            return x;
        }

        return ceilingNode;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    public int rank(Key key, Node x) {
        if (x == null) return 0;

        int cmp = x.key.compareTo(key);
        if (cmp > 0) {
            return rank(key, x.left);
        } else if (cmp < 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node x, Queue<Key> q) {
        if (x == null) return;

        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right, q);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x == null) return null;

        if (x.left == null) {
            return x.right;
        }

        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x == null) return null;
        
        if (x.right == null) {
            return x.left;
        }

        x.right = deleteMax(x.right);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    private void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = x.key.compareTo(key);

        if (cmp > 0) {
            x.left = delete(x.left, key);
        } else if (cmp < 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.left == null && x.right == null) {
                return null;
            } else if (x.left == null) {
                return x.right;
            } else if (x.right == null) {
                return x.left;
            } else {
                Node t = x;
                x = min(x.right);
                x.right = deleteMin(x.right);
                x.left = t.left;
            }
        }

        x.count = 1 + size(x.right) + size(x.left);
        return x;
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
        System.out.println("Min: " + bst.min());
        System.out.println("Max: " + bst.max());
        System.out.println("Floor(5): " + bst.floor(5));
        System.out.println("Floor(6): " + bst.floor(6));
        System.out.println("Floor(1): " + bst.floor(1));
        System.out.println("Floor(8): " + bst.floor(8));
        System.out.println("Floor(5): " + bst.floorRec(5));
        System.out.println("Floor(6): " + bst.floorRec(6));
        System.out.println("Floor(1): " + bst.floorRec(1));
        System.out.println("Floor(8): " + bst.floorRec(8));
        System.out.println("Ceiling(1): " + bst.ceiling(1));
        System.out.println("Ceiling(2): " + bst.ceiling(3));
        System.out.println("Ceiling(8): " + bst.ceiling(7));
        System.out.println("Ceiling(9): " + bst.ceiling(9));
        System.out.println("Size: " + bst.size());
        System.out.println("Rank(5): " + bst.rank(5));
        System.out.println("Rank(1): " + bst.rank(1));
        System.out.println("Rank(9): " + bst.rank(9));
        System.out.println();

        for (int k : bst.keys()) {
            System.out.print(k + ", ");
        }

        // bst.deleteMin();
        // bst.deleteMin();
        // bst.deleteMin();
        System.out.println();

        for (int k : bst.keys()) {
            System.out.print(k + ", ");
        }

        // bst.deleteMax();
        // bst.deleteMax();
        bst.delete(5);
        bst.delete(1);
        bst.delete(8);
        System.out.println();

        for (int k : bst.keys()) {
            System.out.print(k + ", ");
        }

        System.out.println("\nRank(1): " + bst.rank(6));
    }
}
