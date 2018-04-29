package epi.bst;
import java.util.Arrays;
import java.util.List;

public class CostrcutBSTFromPreorder {
	public static void main(String[] args) {
		List<Integer> preOrderSequence = Arrays.asList(19, 7, 3, 2, 5, 11, 17, 13, 43, 23, 37, 29, 31, 41, 47, 53);

		BinaryTreeNode<Integer> tree = constructBST(preOrderSequence);
		inorderTraversal(tree);
	}

	public static BinaryTreeNode<Integer> constructBST(List<Integer> sequence) {
		return constructBSTHelper(sequence, 0, sequence.size());
	}

	public static BinaryTreeNode<Integer> constructBSTHelper(List<Integer> sequence, int start, int end) {
		if (start >= end) {
			return null;
		}

		int transitionIndx = start + 1;

		while (transitionIndx < end && Integer.compare(sequence.get(transitionIndx), sequence.get(start)) < 0) {
			transitionIndx++;
		}

		return new BinaryTreeNode(sequence.get(start), constructBSTHelper(sequence, start + 1, transitionIndx), constructBSTHelper(sequence, transitionIndx, end));
	}

	public static void inorderTraversal(BinaryTreeNode<Integer> tree) {
		if (tree == null) {
			return;
		}

		inorderTraversal(tree.left);
		System.out.print( tree.data + "," );
		inorderTraversal(tree.right);
	}
}

class BinaryTreeNode<T extends Comparable<T>> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}