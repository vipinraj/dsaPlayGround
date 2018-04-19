package epi.bst;
import java.lang.Comparable;

public class CheckIfBST {
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
		root.left = new BinaryTreeNode<>(5);
		root.left.left = new BinaryTreeNode<>(4);
		root.left.right = new BinaryTreeNode<>(11);
		root.right = new BinaryTreeNode<>(20);
		root.right.left = new BinaryTreeNode<>(12);
		root.right.right = new BinaryTreeNode<>(25);

		System.out.println(isBst(root));
		root.left.right = new BinaryTreeNode<>(11);
		System.out.println(isBst(root));
	}

	public static boolean isBst(BinaryTreeNode<Integer> tree) {
		if (tree == null) {
			return true;
		}

		boolean isLeftBst = true;
		boolean isRightBst = true;
		System.out.println(tree.data);
		if (tree.left != null) {
			isLeftBst = !(tree.data.compareTo(tree.left.data) < 0);
		}
		
		if (tree.right != null) {
			isRightBst = !(tree.data.compareTo(tree.right.data) > 0);
		}

		return isBst(tree.left) && isBst(tree.right) && isLeftBst && isRightBst;
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