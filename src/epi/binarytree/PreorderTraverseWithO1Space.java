/**
 * 10.11 variant
 */
package epi.binarytree;

public class PreorderTraverseWithO1Space {
  
  
  public static void main(String[] args) { 
    BinaryTreeNode<String> tree = BinaryTreeTest.getSampleBinaryTree();
    traverseMethod1(tree);
  }
  
  // my own
  public static void traverseMethod1(BinaryTreeNode<String> node) {
    BinaryTreeNode<String> current = node;
    BinaryTreeNode<String> next = null;
    BinaryTreeNode<String> prev = null;
    
    while (current != null) {
      if (prev == current.parent) {
        if (current.left != null) {
          System.out.print(current.data + ", ");
          next = current.left;
        } else {
          if (current.right != null) {
            next = current.right;
          } else {
            next = current.parent;
          }
          System.out.print(current.data + ", ");
        }
      } else if (prev == current.right) {
        next = current.parent;
      } else {
        next = current.right == null ? current.parent : current.right;
      }
      prev = current;
      current = next;
    }
  }
}
