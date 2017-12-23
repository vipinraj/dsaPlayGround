/**
 * 10.7, 10.8
 */
package epi.binarytree;
import java.util.Stack;

public class TraverseWithoutRecursion {
  
  public static void main(String[] args) { 
    BinaryTreeNode<String> tree = BinaryTreeTest.getSampleBinaryTree();
    inOrderTraverseWithoutRecursion(tree);
    System.out.println();
    preOrderTraverseWithoutRecursionMyMethod(tree);
    System.out.println();
    preOrderTraverseWithoutRecursionMethod2(tree);
    System.out.println();
    postOrderTraverseWithoutRecursion(tree);
  }
  
  
  public static void inOrderTraverseWithoutRecursion(BinaryTreeNode<String> treeNode) {
  
    Stack<BinaryTreeNode<String>> s = new Stack<BinaryTreeNode<String>>();
    BinaryTreeNode<String> current = treeNode;
    
    while (!s.empty() || current != null) {
    
      if (current != null) {
        s.push(current);
        current = current.left;
      } else {
        current = s.pop();
        System.out.print(current.data + ", ");
        current = current.right;
      }
      
    }
  }
    public static void preOrderTraverseWithoutRecursionMyMethod(BinaryTreeNode<String> treeNode) {
      
      Stack<BinaryTreeNode<String>> s = new Stack<BinaryTreeNode<String>>();
      BinaryTreeNode<String> current = treeNode;
      while (!s.empty() || current != null) {
        if (current != null) {
          s.push(current);
          System.out.print(current.data + ", ");
          current = current.left;
        } else {
          current = s.pop();
          current = current.right;
        }
      }
    }
    
    public static void preOrderTraverseWithoutRecursionMethod2(BinaryTreeNode<String> treeNode) {
      
      Stack<BinaryTreeNode<String>> s = new Stack<BinaryTreeNode<String>>();
      s.push(treeNode);
      
      while (!s.empty()) {
        BinaryTreeNode<String> current = s.pop();
        if (current != null) {
          System.out.print(current.data + ", ");
          s.push(current.right);
          s.push(current.left);
        }
      }
    }
    
   public static void postOrderTraverseWithoutRecursion(BinaryTreeNode<String> treeNode) {
      
      Stack<BinaryTreeNode<String>> s1 = new Stack<BinaryTreeNode<String>>();
      Stack<BinaryTreeNode<String>> s2 = new Stack<BinaryTreeNode<String>>();
      BinaryTreeNode<String> current = treeNode;
      
      while (!s1.empty() || !s2.empty() || current != null) {
        if (current != null) {
          s1.push(current);
          current = current.left;
        } else {
          BinaryTreeNode<String> node = !s1.empty() ? s1.peek() : null;
          BinaryTreeNode<String> node2 = !s2.empty() ? s2.peek() : null;
          if (node != null && node2 != null && node == node2) {
            s1.pop();
            s2.pop();
            System.out.print(node.data + ",");
          } else {            
            current = node.right;
            if (node.right == null) {
              System.out.print(node.data + ",");
              s1.pop();
            } else {
              s2.push(node);
            }
          }
        }
      }
    }
}
