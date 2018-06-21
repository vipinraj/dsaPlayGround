package epi.recursion;

import java.util.List;
import java.util.ArrayList;

public class GenerateBinaryTrees {
	public static void main(String[] args) {
		List<BinaryTreeNode<Integer>> trees;

		trees = generateAllTrees(3);

		for (BinaryTreeNode<Integer> tree : trees) {
			visualize(tree, 50);
			System.out.println("----");
		}
	}

	public static List<BinaryTreeNode<Integer>> generateAllTrees(int n) {
		List<BinaryTreeNode<Integer>> trees = new ArrayList<>();
		
		if (n == 0) {
			return null;
		}

		for (int i = 1; i <= n; i++) {
			List<BinaryTreeNode<Integer>> leftSubtrees = generateAllTrees(i - 1);
			List<BinaryTreeNode<Integer>> rightSubtrees = generateAllTrees(n - i);

			if (leftSubtrees != null && rightSubtrees != null) {
				for (BinaryTreeNode<Integer> left : leftSubtrees) {
					for (BinaryTreeNode<Integer> right : rightSubtrees) {
						trees.add(new BinaryTreeNode<>(i, left, right));
					}
				}
			} else if (leftSubtrees == null && rightSubtrees == null) {
				trees.add(new BinaryTreeNode<Integer>(i, null, null));
			} else if (leftSubtrees == null) {
				for (BinaryTreeNode<Integer> right : rightSubtrees) {
					trees.add(new BinaryTreeNode<Integer>(i, null, right));
				}
			} else {
				for (BinaryTreeNode<Integer> left : leftSubtrees) {
					trees.add(new BinaryTreeNode<Integer>(i, left, null));
				}
			}
		}

		return trees;

	}

	public static class BinaryTreeNode<T> {
		public T data;
		public BinaryTreeNode<T> left, right;
		BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	 public static void visualize(BinaryTreeNode<?> root, int noOfSpaces) {
	  if (root == null) {
	   return;
	  } 
	  visualize(root.left, noOfSpaces - 6);
	  for (int i = 0; i < noOfSpaces; i++) {
	    System.out.print(" ");
	  }  
	  System.out.println(root.data + "\n");
	  visualize(root.right, noOfSpaces - 6);
	 }
}