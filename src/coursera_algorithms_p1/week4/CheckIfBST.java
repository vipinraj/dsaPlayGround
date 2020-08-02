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

import java.util.ArrayList;
import java.util.List;

public class CheckIfBST {
    private static class Node<Key extends Comparable, Value> {
        private Key key;
        private Value val;
        private Node left, right;
        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    private static class QueueEntry {
        public Node<Integer, Integer> node;
        public Integer min, max;

        public QueueEntry(Node<Integer, Integer> node, Integer min, Integer max) {
            this.node = node;
            this.max = max;
            this.min = min;
        }
    }

    public static void main(String[] args) {
        Node<Integer, Integer> root = new Node<Integer, Integer>(25, 25);
        root.left = new Node<Integer, Integer>(20, 20);
        root.left.left = new Node<Integer, Integer>(10, 10);
        root.left.right = new Node<Integer, Integer>(22, 22);
        root.left.left.left = new Node<Integer, Integer>(5, 5);
        root.left.left.right = new Node<Integer, Integer>(12, 12);

        root.right = new Node<Integer, Integer>(36, 36);
        root.right.left = new Node<Integer, Integer>(30, 30);
        root.right.right = new Node<Integer, Integer>(40, 40);
        root.right.left.left = new Node<Integer, Integer>(28, 28);
        root.right.right.left = new Node<Integer, Integer>(38, 38);
        root.right.right.right = new Node<Integer, Integer>(48, 48);

        boolean result = checkIfBSTRec(root);
        System.out.println(result);
        root.left.right = new Node<Integer, Integer>(26, 26);
        result = checkIfBSTRec(root);
        System.out.println(result);

        root.left.right = new Node<Integer, Integer>(22, 22);
        System.out.println(checkIsBST(root));
        root.left.right = new Node<Integer, Integer>(26, 26);
        System.out.println(checkIsBST(root));
        System.out.println(checkIfBstBfs(root));
        root.left.right = new Node<Integer, Integer>(22, 22);
        System.out.println(checkIfBstBfs(root));
    }

    public static boolean checkIfBstBfs(Node root) {
        if (root == null) {
            return true;
        }

        Queue<QueueEntry> q = new Queue<>();
        q.enqueue(new QueueEntry(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        while (!q.isEmpty()) {
            QueueEntry entry = q.dequeue();
            if (entry.node.key > entry.min && entry.node.key < entry.max) {
                if (entry.node.left != null)
                    q.enqueue(new QueueEntry(entry.node.left, entry.min, entry.node.key));
                if (entry.node.right != null)
                    q.enqueue(new QueueEntry(entry.node.right, entry.node.key, entry.max));
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean checkIfBSTRec(Node<Integer,Integer> root) {
        return checkIfBSTRecHelper(root, null, null);
    }

    private static boolean checkIfBSTRecHelper(Node<Integer,Integer> x,
                                               Integer min, Integer max) {
        if (x == null) {
            return true;
        }

        if ((min != null && x.key <= min) || (max != null && x.key >= max)) {
            return false;
        }

        return checkIfBSTRecHelper(x.left, min, x.key) &&
                checkIfBSTRecHelper(x.right, x.key, max);
    }


    public static boolean checkIsBST(Node<Integer, Integer> root) {
        List<Integer> list = new ArrayList<>();
        return checkIsBSTHelper(root,list);
    }

    // O(n) space solution
    private static boolean checkIsBSTHelper(Node<Integer,Integer> x, List<Integer> list) {
        if (x == null) {
            return true;
        }

        boolean result = checkIsBSTHelper(x.left, list);

        if (!result) return false;
        if (!list.isEmpty() && list.get(list.size() - 1) >= x.key) return false;
        // System.out.println("Added: " + x.key);
        list.add(x.key);
        result = checkIsBSTHelper(x.right, list);

        return result;
    }
}
