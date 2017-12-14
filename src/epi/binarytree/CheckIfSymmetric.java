package epi.binarytree;

public class CheckIfSymmetric {
  
  public static void main(String[] args) { 
    BinaryTreeNode<Integer> tree1 = BinaryTreeTest.getSampleSymmetricBinaryTree();
    System.out.println("Is symmetric: " + isSymmetric(tree1.left, tree1.right));
    BinaryTreeNode<Integer> tree2 = BinaryTreeTest.getSampleNonSymmetricBinaryTree();
    System.out.println("Is symmetric: " + isSymmetric(tree2.left, tree2.right));
  }
  
  public static boolean isSymmetric(BinaryTreeNode<Integer> a, BinaryTreeNode<Integer> b) {
    if (a == null && b == null) {
      return true;
    }
    
    if (a == null && b != null || b == null && a != null) {
      return false;
    }
    
    if (a.data == b.data && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left)) {
      return true;
    } else {
      return false;
    }
  }
}
