package datastructures.linkedlist;

public class LinkedList<Type> {
	Node head = null;
	Integer listCount;

	public LinkedList() {
		// head = new Node(null);
		listCount = 0;
	}

	// node
	public void insert(Node node) {
		node.next = head;
		if (head != null) {
			head.prev = node;
		}
		head = node;
		node.prev = null;
	}

	public void delete(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {//node is head
			head = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		} 
	}

	public Node search(Type key) {
		Node x = head;
		while (x != null && (Type) x.data != key) {
			x = x.next;
		}
		return x;
	}
	
	//reverse assuming the list is singly linked
	public void reverse(){
		Node prevNode = null;
		Node currentNode = head.next;
		Node nextNode = null;
		
		while(currentNode != null){
			nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		head = prevNode;
	}
	
	public String toString(){
		
		String output = "";
		Node<Type> currentNode = head;
		
		while(currentNode!=null){			
			output += ", " + currentNode.data.toString();
			currentNode = currentNode.next;
		}
		return output;
	}
}
