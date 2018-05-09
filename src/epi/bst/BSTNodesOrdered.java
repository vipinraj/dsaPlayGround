package epi.bst;
import java.util.Set;
import java.util.HashSet;

public class BSTNodesOrdered {
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

		System.out.println(isOrdered(root, 5, 7, 3));
		System.out.println(isOrderedNode(root.right, root.right.left.right.right, root.right.left.right));
		System.out.println(isOrderedNode(root.right, root.right.left.right.right, root.right.left.right.left.right));
	}

	// with only keys given
	public static boolean isOrdered (BinaryTreeNode<Integer> root, Integer key1, Integer key2, Integer mid) {
		Set<Integer> nodeKeys = new HashSet<>();
		nodeKeys.add(key1);
		nodeKeys.add(key2);

		BinaryTreeNode<Integer> iter = root;
		Integer leftBound = Integer.MIN_VALUE;
		Integer rightBound = Integer.MAX_VALUE;
		boolean midFound = false;
		Integer keyToFind = mid;

		while (iter != null) {
			if (!midFound) {
				if (nodeKeys.contains(iter.data)) {
					nodeKeys.remove(iter.data);
				}
				if (iter.data == mid) {
					midFound = true;
					if (nodeKeys.size() == 2) {
						return false;
					}
					keyToFind = nodeKeys.iterator().next();
				} else if (iter.data > mid) {
					iter = iter.left;
				} else {
					iter = iter.right;
				}
			} else {
				// find remaining key
				if (iter.data == keyToFind) {
					return true;
				} else if (iter.data > keyToFind) {
					iter = iter.left;
				} else {
					iter = iter.right;
				}
			}
		}
		return false;
	}

	public static boolean isOrderedNode (BinaryTreeNode<Integer> n1, BinaryTreeNode<Integer> n2, BinaryTreeNode<Integer> mid) {
		BinaryTreeNode<Integer> iter1 = n1;
		BinaryTreeNode<Integer> iter2 = n2;

		while ( (iter1 != null || iter2 != null) && (iter1 != n2 & iter1 != mid) && (iter2 != n1 & iter2 != mid) ) {
			if (iter1 != null) {
				if (iter1.data > mid.data) {
					iter1 = iter1.left;
				} else {
					iter1 = iter1.right;
				}
			}

			if (iter2 != null) {
				if (iter2.data > mid.data) {
					iter2 = iter2.left;
				} else {
					iter2 = iter2.right;
				}
			}
		}

		if (iter1 == n2 || iter2 == n1 || (iter1 != mid && iter2 != mid)) {
			return false;
		}

		return iter1 == mid ? searchTarget(iter1, n2) : searchTarget(iter2, n1);
	}

	public static boolean searchTarget(BinaryTreeNode<Integer> from, BinaryTreeNode<Integer> target) {

		while (from != null) {
			if (from == target) {
				return true;
			} else if (from.data > target.data) {
				from = from.left;
			} else {
				from = from.right;
			}
		}

		return false;
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