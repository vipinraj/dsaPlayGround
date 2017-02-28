package datastructures.tree;

public class BSTNode<Type> {
	BSTNode<Type> left;
	BSTNode<Type> right;
	BSTNode<Type> parent;
	Type key;
	public BSTNode(Type key) {
		this.key = key;
	}
	public BSTNode<Type> getLeft() {
		return left;
	}
	public void setLeft(BSTNode<Type> left) {
		this.left = left;
	}
	public BSTNode<Type> getRight() {
		return right;
	}
	public void setRight(BSTNode<Type> right) {
		this.right = right;
	}
	public BSTNode<Type> getParent() {
		return parent;
	}
	public void setParent(BSTNode<Type> parent) {
		this.parent = parent;
	}
	public Type getKey() {
		return key;
	}
	public void setKey(Type data) {
		this.key = data;
	}	
}
