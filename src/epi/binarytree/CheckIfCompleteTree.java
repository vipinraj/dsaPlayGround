package epi.binarytree;
/**
 * Auto Generated Java Class.
 */
public class CheckIfCompleteTree {
  
  
  public static void main(String[] args) { 
    BinaryTreeNode<String> root = BinaryTreeTest.getSampleBinaryTree();
    System.out.println("Is complete: " + checkIfComplete(root, 0, CountNumberOfNodes.countNodes(root)));
  }
  
  public static boolean checkIfComplete(BinaryTreeNode<String> node, int index, int totalNodes) {
    if (node == null) {
      return true;
    }
    
    if (index >= totalNodes) {
      return false;
    }
    
    return checkIfComplete(node.left, index*2 + 1, totalNodes) && checkIfComplete(node.right, index*2 + 2, totalNodes);
  }  
}
