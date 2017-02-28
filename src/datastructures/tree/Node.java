package datastructures.tree;

public class Node {
	Node left;
	Node right;
	Node parent;
	Object data;
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
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}		
}
