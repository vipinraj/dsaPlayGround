package epi.bst;
import java.util.List;
import java.util.ArrayList;

public class RangeLookup {
	public static void main (String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(19);
		root.left = new BinaryTreeNode<>(7);
		root.left.left = new BinaryTreeNode<>(3);
		root.left.right = new BinaryTreeNode<>(11);
		root.left.left.left = new BinaryTreeNode<>(2);
		root.left.left.right = new BinaryTreeNode<>(5);
		root.left.right.right = new BinaryTreeNode<>(17);
		root.left.right.right.left = new BinaryTreeNode<>(13);

		root.right = new BinaryTreeNode<>(43);
		root.right.left = new BinaryTreeNode<>(23);
		root.right.right = new BinaryTreeNode<>(47);
		root.right.left.right = new BinaryTreeNode<>(37);
		root.right.right.right = new BinaryTreeNode<>(53);
		root.right.left.right.left = new BinaryTreeNode<>(29);
		root.right.left.right.right = new BinaryTreeNode<>(41);
		root.right.left.right.left.right = new BinaryTreeNode<>(31);

		List<Integer> result = getElementInRange (root, 16, 31);

		System.out.println(result);
	}

	public static List<Integer> getElementInRange (BinaryTreeNode<Integer> tree, Integer lowerBound, Integer upperBound) {
		List<Integer> elements = new ArrayList<>();
		getElementInRangeHelper(tree, lowerBound, upperBound, elements);
		return elements;
	}

	public static void getElementInRangeHelper(BinaryTreeNode<Integer> node, Integer targetLowerBound, Integer targetUpperBound, List<Integer> result) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);

		if (node.data <= targetUpperBound && node.data >= targetLowerBound) {
			result.add(node.data);
		}

		if (targetLowerBound <= node.data) {
			getElementInRangeHelper(node.left, targetLowerBound, targetUpperBound, result);
		}
		if ( targetUpperBound >= node.data ) {
			getElementInRangeHelper(node.right, targetLowerBound, targetUpperBound, result);
		}
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