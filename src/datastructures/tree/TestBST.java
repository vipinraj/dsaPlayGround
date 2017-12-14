package datastructures.tree;

import java.util.ArrayList;

import org.omg.CORBA.Current;

import datastructures.Stack;

public class TestBST {

	public static void main(String[] args) throws Exception {

		BinarySearchTree bst = new BinarySearchTree();

		BSTNode<Integer> n1 = new BSTNode<Integer>(5);
		BSTNode<Integer> n2 = new BSTNode<Integer>(3);
		BSTNode<Integer> n3 = new BSTNode<Integer>(6);
		BSTNode<Integer> n4 = new BSTNode<Integer>(1);
		BSTNode<Integer> n5 = new BSTNode<Integer>(45);
		BSTNode<Integer> n6 = new BSTNode<Integer>(0);

		bst.insert(n1);
		bst.insert(n2);
		bst.insert(n3);
		bst.insert(n4);
		bst.insert(n5);
		bst.insert(n6);

		inorderTreeWalk(bst.root);
		System.out.println("------------------------------");
		postorderTreeWalk(bst.root);
		System.out.println("------------------------------");
		inorderTreeWalkUsingStack(bst.root);
		System.out.println("--------------search----------------");
		System.out.println(bst.search(5).key);
		System.out.println("--------------minimum----------------");
		System.out.println(bst.minimum().key);
		System.out.println("--------------maximum----------------");
		System.out.println(bst.maximum().key);
		System.out.println("--------------successor----------------");
		System.out.println(bst.successor(n4).key);
		System.out.println("--------------predecessor----------------");
		System.out.println(bst.predecessor(n5).key);
		System.out.println("--------------delete----------------");
		bst.delete(n1);
		System.out.println(bst.search(5).key);
		
	}

	static void inorderTreeWalk(BSTNode<Integer> node) {
		if (node != null) {
			inorderTreeWalk(node.left);
			System.out.println(node.key);
			inorderTreeWalk(node.right);
		}
	}
	static void preorderTreeWalk(BSTNode<Integer> node) {
		if (node != null) {
			System.out.println(node.key);
			preorderTreeWalk(node.left);			
			preorderTreeWalk(node.right);
		}
	}
	
	static void postorderTreeWalk(BSTNode<Integer> node) {
		if (node != null) {
			postorderTreeWalk(node.left);			
			postorderTreeWalk(node.right);
			System.out.println(node.key);
		}
	}

	static void inorderTreeWalkUsingStack(BSTNode<Integer> root) throws Exception {
		Stack<BSTNode<Integer>> stack = new Stack<>(100);

		BSTNode<Integer> currentNode = null;
		
		if(root == null){
			return;
		}
		
		if(root.left != null)
				currentNode = root.left;
		
		stack.push(root);
		
		while (!stack.isEmpty()) {
			while (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			}
			BSTNode<Integer> node = stack.pop();
			System.out.println(node.key);
			
			if(node.right != null){
				currentNode = node.right;
				stack.push(currentNode);
				currentNode = currentNode.left;
			}
		}

	}
}
