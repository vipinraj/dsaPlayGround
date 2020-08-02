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

public class MorrisInorderTraversal {
    private static class Node<Key extends Comparable, Value> {
        private Key key;
        private Value val;
        private Node left, right;
        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
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
        traverse(root);
    }

    // O(1) space, O(n) time
    public static void traverse(Node root) {
        Node currentNode = root;
        Node preNode;

        while (currentNode != null) {
            if (currentNode.left == null) {
                System.out.print(currentNode.key + ", ");
                currentNode = currentNode.right;
            } else {
                preNode = currentNode.left;

                while (preNode.right != null && preNode.right != currentNode) {
                    preNode = preNode.right;
                }

                if (preNode.right == null) {
                    preNode.right = currentNode;
                    currentNode = currentNode.left;
                } else {
                    preNode.right = null;
                    System.out.print(currentNode.key + ", ");
                    currentNode = currentNode.right;
                }
            }
        }
    }
}
