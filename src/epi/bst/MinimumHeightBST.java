// 15.9
package epi.bst;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MinimumHeightBST {
	public static void main(String[] args) {
		List<Integer> sortedArray = Arrays.asList(2,3,5,7,11,13,17,19,23);

		BinaryTreeNode<Integer> tree = build(sortedArray);

		BinaryTreeNode<Integer> iter = tree;		
		inorderTraversal(tree);

	}

	public static BinaryTreeNode<Integer> build(List<Integer> sortedArray) {
		return buildHelper(sortedArray);
	}

	public static BinaryTreeNode<Integer> buildHelper(List<Integer> arr) {
		if (arr == null || arr.size() == 0) {
			return null;
		}

		Integer midIdx = arr.size()/2;
		return new BinaryTreeNode<Integer>(arr.get(midIdx), buildHelper(arr.subList(0, midIdx)), buildHelper(arr.subList(midIdx + 1, arr.size())));
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