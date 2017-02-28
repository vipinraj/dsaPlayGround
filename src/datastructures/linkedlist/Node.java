package datastructures.linkedlist;

public class Node<Type> {
	Node<Type> next;
	Node<Type> prev;
	Type data;
	
	public Node(Type data) {
		this.data = data;
	}
	
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public Object getData() {
		return data;
	}
	public void setData(Type data) {
		this.data = data;
	}
}
