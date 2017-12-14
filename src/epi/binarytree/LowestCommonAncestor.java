package epi.binarytree;

import java.util.HashMap;

public class LowestCommonAncestor {
  
  public static HashMap<BinaryTreeNode<String>,BinaryTreeNode<String>> parentMapping = new HashMap<BinaryTreeNode<String>,BinaryTreeNode<String>>();
  
  public static void main(String[] args) { 
     BinaryTreeNode<String> root = BinaryTreeTest.getSampleBinaryTree();
     getParents(root);   
     System.out.println(parentMapping.size());
     getCommonAncestor();
  }
  
  public static void getParents(BinaryTreeNode<String> node) {
    if (node == null) {
      return;
    }
    if (node.left != null) {
      parentMapping.put(node.left, node);
    }
    if (node.right != null) {
      parentMapping.put(node.right, node);
    }
    getParents(node.left);
    getParents(node.right);
  }
  
  public static BinaryTreeNode<String> getCommonAncestor(BinaryTreeNode<String> a, BinaryTreeNode<String> b) {
    List<BinaryTreeNode<String>> parentPathA = new ArrayList<BinaryTreeNode<String>>();
    List<BinaryTreeNode<String>> parentPathB = new ArrayList<BinaryTreeNode<String>>();
    
    BinaryTreeNode<String> tmp;
    
    tmp = a;
    while (tmp != null) {
      parentPathA.add(tmp);
      tmp = parentMapping.get(tmp);
    }
    
    tmp = b;
    while (tmp != null) {
      parentPathB.add(tmp);
      tmp = parentMapping.get(tmp);
    }
    
    BinaryTreeNode<String> ancestor;
    for (int i = 0; i < parentPathA.length(); i++ ) {
      for (int j = 0; j < parentPathB.length(); j++) {
        if (parentPathA.get(i).data == parentPathB.get(j).data) {
          ancestor = parentPathA.get(i);
          break;
        }
      }
    }
    return ancestor;
  }
}
