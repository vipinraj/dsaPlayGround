package epi.binarytree;
/**
 * Auto Generated Java Class.
 */
public class Kbalanced {
  
  
  public static void main(String[] args) { 
    BinaryTreeNode<String> root = BinaryTreeTest.getSampleBinaryTree();
    System.out.println("Non kbalanced node: " + getNonKBalanced(3, root).node.data);
  }
  
  public static SizeAndNode getNonKBalanced(int k, BinaryTreeNode<String> node) {
    if (node == null) {
      return new SizeAndNode(0, null);
    }
    
    SizeAndNode left = getNonKBalanced(k, node.left);
    SizeAndNode right = getNonKBalanced(k, node.right);
    
    BinaryTreeNode<String> nonKbalancedNode = left.node == null ? right.node : left.node;
    
    if (Math.abs(left.size - right.size) > k) {
//      System.out.println("Node: " + node.data + ", Kbalanced: false");
      return new SizeAndNode(left.size + right.size + 1, node);
    } else {
//      System.out.println("Node: " + node.data + ", Kbalanced: true");
      return new SizeAndNode(left.size + right.size + 1, nonKbalancedNode);
    }
  }
  
}

class SizeAndNode {
  public int size;
  public BinaryTreeNode<String> node;
  SizeAndNode(int size, BinaryTreeNode<String> node) {
    this.size = size;
    this.node = node;
  }
}