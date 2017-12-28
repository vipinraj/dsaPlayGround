/**
 * 10.11
 */
package epi.binarytree;

public class InorderTraverseWithO1Space {
  
  
  public static void main(String[] args) { 
    BinaryTreeNode<String> tree = BinaryTreeTest.getSampleBinaryTree();
    traverseMethod1(tree);
  }
  
  public static void traverseMethod1(BinaryTreeNode<String> node) {
    // find the first node
    BinaryTreeNode<String> current = node;
    while (current.left != null) {
      current = current.left;
    }
    System.out.print(current.data + ", " );
    
    while (current != null) {
      current = SuccessorInInorderTraversal.getSuccessor(current);
      System.out.print(current.data + ", ");
    }
  }
  
  public static void traverseMethod2(BinaryTreeNode<String> node) {
    BinaryTreeNode<String> current = node;
    BinaryTreeNode<String> prev = null;
    
    while (current != null) {
      if (current.parent.left == current) {
      
      }
    }
  }
}
