// 15.2 variant

package epi.bst;

class KeyEqualsK {
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(108, "A");
		root.left = new BinaryTreeNode<Integer>(108, "B");
		root.right = new BinaryTreeNode<Integer>(285, "G");
		root.left.left = new BinaryTreeNode<Integer>(-10, "C");
		root.left.left.left = new BinaryTreeNode<Integer>(-14, "D");
		root.left.left.right = new BinaryTreeNode<Integer>(2, "E");
		root.left.right = new BinaryTreeNode<Integer>(108, "F");
		root.right.left = new BinaryTreeNode<Integer>(243, "H");
		root.right.right = new BinaryTreeNode<Integer>(285, "I");
		root.right.right.right = new BinaryTreeNode<Integer>(401, "J");

		System.out.println(getFirstNodeInInorder(root, 108));
		System.out.println(getFirstNodeInInorder(root, 285));
		System.out.println(getFirstNodeInInorder(root, 143));
	}

	public static BinaryTreeNode<Integer> getFirstNodeInInorder(BinaryTreeNode<Integer> tree, int k) {

		BinaryTreeNode<Integer> result = null;
		BinaryTreeNode<Integer> iter = tree;

		while (iter != null) {
			if (iter.data == k) {
				result = iter;
				iter = iter.left;
			} else if (iter.data > k ) {
				iter = iter.left;
			} else if (result == null && iter.data < k) {
				iter = iter.right;
			} else {
				break;
			}
		}

		return result;
	} 
}

class BinaryTreeNode<T extends Comparable<T>> {
	T data;
	String id;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	BinaryTreeNode(T data, String id) {
		this.data = data;
		this.id = id;
	}

	public String toString() {
		return this.id + "(" + this.data + ")";
	}
}