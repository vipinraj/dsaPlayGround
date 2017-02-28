package tree;

import tree.BST.Node;

public class testBST {

	public static void main(String[] args) {

		BST<String, Integer> st = new BST<String, Integer>();
		BST.Node n0 = st.new Node("A", 0, 9);
		BST.Node n1 = st.new Node("B", 1, 4);
		BST.Node n2 = st.new Node("C", 2, 3);
		BST.Node n3 = st.new Node("D", 3, 0);
		BST.Node n4 = st.new Node("E", 4, 2);
		BST.Node n5 = st.new Node("F", 5, 0);
		BST.Node n6 = st.new Node("G", 6, 1);
		BST.Node n7 = st.new Node("H", 7, 0);
		BST.Node n8 = st.new Node("I", 8, 0);
		BST.Node n9 = st.new Node("J", 9, 0);				
		
		
		n6.setLeft(n9);
		n4.setRight(n8);
		n4.setLeft(n7);
		n2.setRight(n6);
		n2.setLeft(n5);
		n1.setRight(n4);
		n1.setLeft(n3);
		n0.setRight(n2);
		n0.setLeft(n1);
		st.setRoot(n0);
		
		
		st.traversePreorder(st.getRoot());
		System.out.println("\n");
		st.traversePostorder(st.getRoot());
		System.out.println("\n");
		st.traverseInorder(st.getRoot());
		System.out.println("\ntraversePreorderNonRecursive:");
		st.traversePreorderNonRecursive(st.getRoot());
		System.out.println("\ntraverseInorderNonRecursive:");
		st.traverseInorderNonRecursive(st.getRoot());
		System.out.println("\ntraversePostorderNonRecursive:");
		st.traversePostorderNonRecursive(st.getRoot());

	}

}
