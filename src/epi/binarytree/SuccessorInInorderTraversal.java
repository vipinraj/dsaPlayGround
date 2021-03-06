/**
 * 10.10
 */
package epi.binarytree;
public class SuccessorInInorderTraversal {
  
  
  public static void main(String[] args) {
    BinaryTreeTest.getSampleBinaryTree(); 
    System.out.println("Successor of N: " + getSuccessor(BinaryTreeTest.nNode).data);
    System.out.println("Successor of A: " + getSuccessor(BinaryTreeTest.aNode).data);
    System.out.println("Successor of N: " + getSuccessor(BinaryTreeTest.nNode).data);
    System.out.println("Successor of O: " + getSuccessor(BinaryTreeTest.oNode).data);
    //D, C, E, B, F, H, G, A, J, L, M, K, N, I, O, P,
  }
  
  public static BinaryTreeNode<String> getSuccessor(BinaryTreeNode<String> node) {
    if (node.right == null) {
      while (node.parent.left != node && node != null) {
        node = node.parent;
      }
      return node.parent;
    } else {
      node = node.right;
      
      while (node.left != null) {
        node = node.left;
      }
      return node;
    }
  }
   
}
