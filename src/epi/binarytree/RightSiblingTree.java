/**
 * 10.16, variants
 */
package epi.binarytree;
import java.util.Queue;
import java.util.LinkedList;

public class RightSiblingTree {
  
  
  public static void main(String[] args) { 
    BinaryTreeNode<String> tree = BinaryTreeTest.getSamplePerfectBinaryTree();
    constructRightSibling(tree);
    System.out.println("RightNode of F: " + BinaryTreeTest.fNode.next.data);
    System.out.println("RightNode of J: " + BinaryTreeTest.jNode.next.data);
    BinaryTreeNode<String> tree2 = BinaryTreeTest.getSampleBinaryTree();
    constructRightSiblingForGeneralTree(tree2);
    System.out.println("RightNode of F: " + BinaryTreeTest.fNode.next.data);
    System.out.println("RightNode of J: " + BinaryTreeTest.jNode.next.data);
    tree = BinaryTreeTest.getSamplePerfectBinaryTree();
    constructRightSiblingVariant1(tree);
//    System.out.println("RightNode of F: " + BinaryTreeTest.fNode.right.data);
    System.out.println("RightNode of J: " + BinaryTreeTest.jNode.right.data);
    
  }
  
  public static void constructRightSibling(BinaryTreeNode<String> tree) {
    BinaryTreeNode<String>  leftStart = tree;
    while (leftStart != null && leftStart.left != null) {
      populateLowerLevelNextField(leftStart);
      leftStart = leftStart.left;
    }
  }
  
  public static void populateLowerLevelNextField(BinaryTreeNode<String> startNode) {
    BinaryTreeNode<String> iter = startNode;
    
    while (iter != null) {
      iter.left.next = iter.right;
      
      if (iter.next != null) {
        iter.right.next = iter.next.left;
      }
      iter = iter.next;
    }
  }
  
  // store next sibling in right child pointer (soultion is not correct?)
  public static void constructRightSiblingVariant1(BinaryTreeNode<String> tree) {
    if (tree == null) {
      return;
    }
    constructRightSiblingVariant1(tree.right);
    constructRightSiblingVariant1(tree.left);
    System.out.println(tree.data);
    if (tree.data == "I") {
      System.out.println("I->" + tree.right.data );
    }
    if (tree.left != null) { // not leaf
      tree.left.right = tree.right;
      tree.right = null;
    }
  }
  
  // variant
  public static void constructRightSiblingForGeneralTree(BinaryTreeNode<String> tree) {
    Queue<BinaryTreeNode<String>> q = new LinkedList<BinaryTreeNode<String>>();
    BinaryTreeNode<String> sentinal = new BinaryTreeNode<String>();
    sentinal.data = "END";
    q.add(tree);
    q.add(sentinal);
    while (!q.isEmpty()) {
      BinaryTreeNode<String> node = q.poll();
      boolean end = false;
      if (q.peek() != null && q.peek().data.equals("END")) {
        node.next = null;
        q.poll();
        end = true;
      } else {
        node.next = q.peek();
      }
      if (node.left != null) {
        q.add(node.left);
      }
      if (node.right != null) {
        q.add(node.right);
      }
      if (end) {
        q.add(sentinal);
      }
    }
  }
}
