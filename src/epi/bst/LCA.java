// 15.4
package epi.bst;


public class LCA {
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

		System.out.println(getLCA(root, 23, 27).data);
	}


	public static BinaryTreeNode<Integer> getLCA(BinaryTreeNode<Integer> tree, int a, int b) {
		int large;
		int small;

		if (a > b) {
			large = a;
			small = b;
		} else {
			large = b;
			small = a;
		}

		BinaryTreeNode<Integer> iter = tree;

		while (iter != null) {
			if (iter.data == small || iter.data == large || (iter.data < large && iter.data > small) ) {
				return iter;
			} else if (iter.data > large) {
				iter = iter.left;
			} else {
				iter = iter.right;
			}
		}

		return null;

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