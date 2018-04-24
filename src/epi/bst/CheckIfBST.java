package epi.bst;
import java.lang.Comparable;
import java.util.Queue;
import java.util.LinkedList;

public class CheckIfBST {
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
		root.left = new BinaryTreeNode<>(6);
		root.left.left = new BinaryTreeNode<>(4);
		root.left.right = new BinaryTreeNode<>(8);
		root.right = new BinaryTreeNode<>(20);
		root.right.left = new BinaryTreeNode<>(12);
		root.right.right = new BinaryTreeNode<>(25);
		
		System.out.println(isBst(root));
		System.out.println(checkIfBstUsingInorder(root));
		root.left.right = new BinaryTreeNode<>(11);
		System.out.println(isBst(root));
		System.out.println(checkIfBstUsingInorder(root));
	}

	public static boolean isBst(BinaryTreeNode<Integer> tree) {
		Queue<QueueEntry> queue = new LinkedList<>();
		queue.add(new QueueEntry(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));

		while (!queue.isEmpty()) {
			QueueEntry e = queue.poll();
			if (e.node.data < e.lowerBound || e.node.data > e.upperBound) {
				return false;
			}
			
			if (e.node.left != null) {
				queue.add(new QueueEntry(e.node.left, e.lowerBound, e.node.data));
			}
			
			if (e.node.right != null) {
				queue.add(new QueueEntry(e.node.right, e.node.data, e.upperBound));
			}
		}

		return true;
	}
	
	public static boolean isBst = true;
	public static BinaryTreeNode<Integer> prevNode = null;
	public static boolean checkIfBstUsingInorder(BinaryTreeNode<Integer> tree) {

		checkIfBstUsingInorderRec(tree);
		return isBst;
	}

	public static void checkIfBstUsingInorderRec(BinaryTreeNode<Integer> node) {
		if (node == null) {
			return;
		}

		checkIfBstUsingInorderRec(node.left);
		if (prevNode != null) {
			if (node.data < prevNode.data) {
				isBst = false;
			}
		}
		prevNode = node;
		checkIfBstUsingInorderRec(node.right);
	}
}

class BinaryTreeNode<T extends Comparable<T>> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	BinaryTreeNode(T data) {
		this.data = data;
	}
}

class QueueEntry {
	BinaryTreeNode<Integer> node;
	Integer upperBound;
	Integer lowerBound;

	QueueEntry(BinaryTreeNode<Integer> node, Integer lowerBound, Integer upperBound) {
		this.node = node;
		this.upperBound = upperBound;
		this.lowerBound = lowerBound;
	}
}