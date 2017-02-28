package datastructures.tree;

import datastructures.Stack;

public class TestBinaryTree {

	public static void main(String[] args) throws Exception {

		BinaryTree tree = new BinaryTree();
		Node rootNode = new Node();

		Node node1 = new Node();
		node1.data = 12;
		Node node2 = new Node();
		node2.data = 15;
		Node node3 = new Node();
		node3.data = 4;
		Node node4 = new Node();
		node4.data = 10;
		Node node5 = new Node();
		node5.data = 2;
		Node node7 = new Node();
		node7.data = 7;
		Node node8 = new Node();
		node8.data = 14;
		Node node9 = new Node();
		node9.data = 21;
		Node node10 = new Node();
		node10.data = 5;

		rootNode.setLeft(node1);
		rootNode.setRight(node4);

		node1.setLeft(node7);
		node1.setRight(node3);

		node2.setLeft(node8);

		node3.setLeft(node10);

		node4.setLeft(node5);
		node4.setRight(node9);

		node8.setLeft(rootNode);
		node8.setRight(node2);

		rootNode.setData(18);

		tree.root = rootNode;

		traverseRecursive(rootNode);
		System.out.println("---------------------");
		traverseNonRecursive(rootNode);

	}

	static void traverseRecursive(Node node) {
		if (node != null) {
			System.out.println(node.getData());
			traverseRecursive(node.getLeft());
			traverseRecursive(node.getRight());
		}
	}

	static void traverseNonRecursive(Node root) throws Exception {

		Node currentNode = root;
		Stack<Node> stack = new Stack<Node>(10);
		while (currentNode != null) {
			stack.push(currentNode);
			currentNode = currentNode.left;
		}
		while (!stack.isEmpty()) {
			currentNode = stack.pop();
			System.out.println(currentNode.data);
			currentNode = currentNode.right;
			while (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;				
			}
		}

	}
}
