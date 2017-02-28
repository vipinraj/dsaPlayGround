package datastructures.linkedlist;

public class LinkedListCircular {
	Node nil;

	public LinkedListCircular() {
		nil = new Node(null);
		nil.next = nil;
		nil.prev = nil;
	}
	
	public void insert(Node node) {
		node.next = nil.next;
		nil.next.prev = node;
		nil.next = node;
		node.prev = nil;

	}

	public void delete(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public Node search(Integer key) {

		Node x = nil.next;

		while (x != nil && x.data != key) {
			x = x.next;
		}

		return x;
	}
}
