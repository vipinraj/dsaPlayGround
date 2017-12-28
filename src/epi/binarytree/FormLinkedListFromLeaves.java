/**
 * 10.14
 */
package epi.binarytree;
import java.util.LinkedList;
import java.util.List;

public class FormLinkedListFromLeaves {
  
  
  public static void main(String[] args) { 
    List<BinaryTreeNode<String>> leaves = new LinkedList<>();
    BinaryTreeNode<String> tree = BinaryTreeTest.getSampleBinaryTree();
    addLeavesLeftToright(tree, leaves);
    for (BinaryTreeNode<String> leave: leaves) {
      System.out.print(leave.data + ", ");
    }
  }
  
  public static void addLeavesLeftToright(BinaryTreeNode<String> node, List leaves) {
    if (node == null) {
      return;
    }
    if (node.right == null && node.left == null) {
      leaves.add(node);
    } else {
      addLeavesLeftToright(node.left, leaves);
      addLeavesLeftToright(node.right, leaves);
    }
  }
  
}
