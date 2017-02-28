package tree;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Stack;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public class Node {
		private Key key;
		private Value val;
		private Node left, right;
		private int N;

		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}

	public BST() {

	}

	// --------------------------put----------------
	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size(root);
	}

	// return number of key-value pairs in BST rooted at x
	private int size(Node x) {
		if (x == null)
			return 0;
		else
			return x.N;
	}

	public Key min() {
		if (isEmpty())
			throw new NoSuchElementException("called min() with empty symbol table");
		return min(root).key;
	}

	private Node min(Node x) {
		if (x.left == null)
			return x;
		else
			return min(x.left);
	}

	public void delete(Key key) {
		if (key == null)
			throw new NullPointerException("argument to delete() is null");
		root = delete(root, key);
		// assert check();
	}

	public void deleteMin() {
		if (isEmpty())
			throw new NoSuchElementException("Symbol table underflow");
		root = deleteMin(root);
		// assert check();
	}

	private Node deleteMin(Node x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	/**
	 * Removes the largest key and associated value from the symbol table.
	 *
	 * @throws NoSuchElementException
	 *             if the symbol table is empty
	 */
	public void deleteMax() {
		if (isEmpty())
			throw new NoSuchElementException("Symbol table underflow");
		root = deleteMax(root);
		// assert check();
	}

	private Node deleteMax(Node x) {
		if (x.right == null)
			return x.left;
		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	private Node delete(Node x, Key key) {
		if (x == null)
			return null;

		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = delete(x.left, key);
		else if (cmp > 0)
			x.right = delete(x.right, key);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void put(Key key, Value val) {
		if (key == null)
			throw new NullPointerException("first argument to put() is null");
		if (val == null) {
			delete(key);
			return;
		}
		root = put(root, key, val);
		// assert check();
	}

	private Node put(Node x, Key key, Value val) {
		if (x == null)
			return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else
			x.val = val;
		x.N = 1 + size(x.left) + size(x.right);
		return x;
	}
	// -----------------------------------------------

	public void traversePreorder(Node x) {
		if (x != null) {
			System.out.print(x.key + " ");
			traversePreorder(x.left);
			traversePreorder(x.right);
		}
	}

	public void traversePreorderNonRecursive(Node x) {
		Stack<Node> stack = new Stack<Node>();
		Node presentNode = x;

		while (presentNode != null) {
			System.out.print(presentNode.key + " ");
			if (presentNode.getRight() != null) {
				stack.push(presentNode.getRight());
			}
			if (presentNode.getLeft() != null) {
				presentNode = presentNode.getLeft();
			} else {
				if (stack.isEmpty()) {
					presentNode = null;
					continue;
				}
				presentNode = stack.pop();
			}
		}

	}

	public void traverseInorderNonRecursive(Node x) {
		/*
		 * Stack<Node> stack = new Stack<Node>(); Node presentNode = x;
		 * stack.push(presentNode); while (presentNode != null) {
		 * while(presentNode == null){ presentNode = presentNode.getLeft();
		 * stack.push(presentNode); } if (presentNode !stack.isEmpty() ) {
		 * presentNode = stack.pop(); System.out.print(presentNode.key + " ");
		 * presentNode = presentNode.getRight(); } }
		 */
	}

	public void traversePostorderNonRecursive(Node x) {
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();

		stack1.push(x);
		while (!stack1.isEmpty()) {
			Node popedNode = stack1.pop();
			stack2.push(popedNode);
			if (popedNode.getLeft() != null)
				stack1.push(popedNode.getLeft());
			if (popedNode.getRight() != null)
				stack1.push(popedNode.getRight());
		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().key + " ");
		}

	}

	public void traversePostorder(Node x) {
		if (x != null) {
			traversePostorder(x.left);
			traversePostorder(x.right);
			System.out.print(x.key + " ");
		}
	}

	public void traverseInorder(Node x) {
		if (x != null) {
			traverseInorder(x.left);
			System.out.print(x.key + " ");
			traverseInorder(x.right);
		}
	}
}
