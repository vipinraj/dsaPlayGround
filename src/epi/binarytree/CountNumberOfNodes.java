package epi.binarytree;
/**
 * Auto Generated Java Class.
 */
public class CountNumberOfNodes {
  
  /* ADD YOUR CODE HERE */
  public static void main(String args[]) {
    BinaryTreeNode<String> root = BinaryTreeTest.getSampleBinaryTree();
    System.out.println("No of nodes: " + countNodes(root));
  }
  
  public static int countNodes(BinaryTreeNode<String> node) {
    if (node == null) {
      return 0;
    }
    return countNodes(node.left) + countNodes(node.right) + 1;
  }
  
}
