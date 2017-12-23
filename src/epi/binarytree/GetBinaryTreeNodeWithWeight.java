/**
 * 10.6 + variant
 */
package epi.binarytree;
import java.util.ArrayList;

public class GetBinaryTreeNodeWithWeight {
  
  
  public static void main(String[] args) { 
    
    BinaryTreeNode<Integer> root = BinaryTreeTest.getSampleIntegerBinaryTree();
    System.out.println(checkNodeWithWeightExistMyMethod(root, 0, 591).data);
    ArrayList<String> paths = new ArrayList<String>();
    getAllLeaftPathOfWeight(root, 0, 619, "", paths);
    
    for (String s : paths) {
      System.out.println(s);
    }
  }
  
  // O(n), O(h)
  public static BinaryTreeNode<Integer> checkNodeWithWeightExistMyMethod(BinaryTreeNode<Integer> node, int pathWeight, int targetWeight) {
    
    if (node == null) {
      return null;
    }
    
    pathWeight += node.data;
    
    if (node.left == null && node.right == null && pathWeight == targetWeight) {
      return node;
    }
    BinaryTreeNode<Integer> leftResult;
    BinaryTreeNode<Integer> rightResult;
    return ((leftResult = checkNodeWithWeightExistMyMethod(node.left, pathWeight, targetWeight)) != null) ? leftResult :
      (((rightResult = checkNodeWithWeightExistMyMethod(node.right, pathWeight, targetWeight)) != null) ? rightResult : null);
  }

   // variant   O(n), O(h)
   public static void getAllLeaftPathOfWeight(BinaryTreeNode<Integer> node, int pathWeight, int targetWeight, String path, ArrayList<String> paths) {
    
    if (node == null) {
      return;
    }
    
    pathWeight += node.data;
    path = path + "," + node.data;
    
    if (node.left == null && node.right == null && pathWeight == targetWeight) {
      paths.add(path);
    }
    getAllLeaftPathOfWeight(node.left, pathWeight, targetWeight, path, paths);
    getAllLeaftPathOfWeight(node.right, pathWeight, targetWeight, path, paths);
  }
}
