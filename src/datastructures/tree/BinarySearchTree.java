package datastructures.tree;

public class BinarySearchTree {
	BSTNode<Integer> root;

	void insert(BSTNode<Integer> z) {

		BSTNode<Integer> currentNode = root;
		BSTNode<Integer> prevNode = null;

		while (currentNode != null) {
			prevNode = currentNode;
			if (currentNode.getKey() > z.getKey()) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}

		z.parent = prevNode;

		if (prevNode == null) { // empty tree
			root = z;
		} else if (prevNode.key > z.key) {
			prevNode.left = z;
		} else {
			prevNode.right = z;
		}
	}

	// iterative search
	BSTNode<Integer> search(Integer key) {

		BSTNode<Integer> currentNode = root;

		while (currentNode != null) {
			if (currentNode.key == key) {
				break;
			} else if (currentNode.key < key) {
				currentNode = currentNode.right;
			} else {
				currentNode = currentNode.left;
			}
		}

		return currentNode;
	}

	BSTNode<Integer> minimum() {
		return minimum(root);
	}

	BSTNode<Integer> minimum(BSTNode<Integer> node) {
		BSTNode<Integer> currentNode = node;

		if (currentNode == null) {
			return null;
		}
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return currentNode;
	}

	BSTNode<Integer> maximum() {
		return maximum(root);
	}

	BSTNode<Integer> maximum(BSTNode<Integer> node) {
		BSTNode<Integer> currentNode = node;

		if (currentNode == null) {
			return null;
		}
		while (currentNode.right != null) {
			currentNode = currentNode.right;
		}
		return currentNode;
	}

	BSTNode<Integer> successor(BSTNode<Integer> node) {

		if (node.right != null) {
			return minimum(node.right);
		}

		BSTNode<Integer> currentNode = node;

		while (currentNode.parent != null && currentNode.parent.left != currentNode) {
			currentNode = currentNode.parent;
		}

		return currentNode.parent;
	}

	BSTNode<Integer> predecessor(BSTNode<Integer> node) {

		if (node.left != null) {
			return maximum(node.left);
		}

		BSTNode<Integer> currentNode = node;

		while (currentNode.parent != null && currentNode.parent.right != currentNode) {
			currentNode = currentNode.parent;
		}

		return currentNode.parent;
	}

	void transplant(BSTNode<Integer> u, BSTNode<Integer> v) {
		if (u.parent == null) { // u is root
			root = v;
		} else if (u.parent.left == u) {
			u.parent.left = v;
		} else if (u.parent.right == u) {
			u.parent.right = v;
		}
		if (v != null) {
			v.parent = u.parent;
		}
	}

	void delete(BSTNode<Integer> z) {
		if(z.left == null){
			transplant(z, z.right);
		}else if(z.right == null){
			transplant(z, z.left);
		}else{
			BSTNode<Integer> y = minimum(z.right);
			
			if(y.parent != z){
				transplant(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			
			transplant(z, y);
			y.left = z.left;
			y.left.parent = y;
			
		}
	}
}
