/**
 * 10.9
 */
package epi.binarytree;

public class KthNodeInInorderTraversal {
  
  public static void main(String[] args) { 
    BinaryTreeNode<String> root = BinaryTreeTest.getSampleBinaryTree();
    int k = 9;
    BinaryTreeTest.inOrderTraversal(root);
    System.out.println();
    for (int i = 1 ; i < 17; i++) {
      System.out.print(getKthNode(root, i).data + ", ");
    }
    System.out.println();
    for (int i = 1 ; i < 17; i++) {
      System.out.print(getKthNodeMethod2(root, i).data + ", ");
    }
  }
  
  public static BinaryTreeNode<String> getKthNodeMethod2(BinaryTreeNode<String> root, int k) {
    BinaryTreeNode<String> kthNode = null;
    
    BinaryTreeNode<String> current = root;
    
    try {
      while (current != null) {
        int leftCount = current.left != null ? current.left.nodeCount : 0;
        if (leftCount+1 == k) {
          break;
        } else if(leftCount < k) {
          k = k -(leftCount+1);
          current = current.right;
        } else {
          current = current.left;
        }
      }
      kthNode = current;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return kthNode;
  }
   public static BinaryTreeNode<String> getKthNode(BinaryTreeNode<String> root, int k) {
    BinaryTreeNode<String> kthNode = null;
    
    BinaryTreeNode<String> current = root;
    
    try {
      while (current != null) {
        kthNode = current;
        if (current.left != null && current.left.nodeCount < k) {
          if (current.left.nodeCount + 1 == k) {
            break;
          } else {
            k = k - (current.left.nodeCount + 1);
            current = current.right;
          }
        } else if (current.left != null && current.left.nodeCount >= k) {
          current = current.left;
        } else {
          if (k == 1) {
            break;
          }
          current = current.right;
          k = k - 1;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return kthNode;
  }
  
}
