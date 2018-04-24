// 15.3
package epi.bst;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class KLargestElements {
	public static void main(String[] args) {
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

		List<Integer> result = findKLargest(root, 6);

		System.out.println(result);
	}

	public static List<Integer> findKLargest(BinaryTreeNode<Integer> tree, int k) {
		Deque<BinaryTreeNode<Integer>> stack = new LinkedList<>();
		List<Integer> result = new ArrayList<Integer>();

		BinaryTreeNode<Integer> prevElem = null;
		BinaryTreeNode<Integer> elem = tree;

		while (result.size() < k) {
			if (elem != null) {
				stack.push(elem);
				elem = elem.right;
			} else {
				elem = stack.pop();
				result.add(elem.data);
				elem = elem.left;
			}
		} 
		return result;
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