/**
 * 10.15
 */
package epi.binarytree;
import java.util.ArrayList;

public class ExteriorOfBinaryTree {
  
  
  public static void main(String[] args) {
    
    BinaryTreeNode<String> tree = BinaryTreeTest.getSampleBinaryTree();
    for (BinaryTreeNode<String> node :  getExterior(tree)) {
      System.out.print(node.data + ", ");
    }
    System.out.println();
    for (BinaryTreeNode<String> node :  getExteriorMethod2(tree)) {
      System.out.print(node.data + ", ");
    }
  }
  
  // my method
  public static ArrayList<BinaryTreeNode<String>> getExterior(BinaryTreeNode<String> root) {
    ArrayList<BinaryTreeNode<String>> rootToLeftLeaf = new ArrayList<>();
    ArrayList<BinaryTreeNode<String>> rootToRightLeaf = new ArrayList<>();
    ArrayList<BinaryTreeNode<String>> leftLeafToRightLeaf = new ArrayList<>();
    ArrayList<BinaryTreeNode<String>> exterior = new ArrayList<>();
    BinaryTreeNode<String> currentNode;
    
    if (root == null) {
      return null;
    }
    
    // get root to left most leaf path
    currentNode = root;
    while (currentNode.left != null || currentNode.right != null) {
      rootToLeftLeaf.add(currentNode);
      if (currentNode.left != null) {
        currentNode = currentNode.left;
      } else {
        currentNode = currentNode.right;
      }
    }
    rootToLeftLeaf.add(currentNode);
    
    // get root to right most leaf path
    currentNode = root;
    while (currentNode.left != null || currentNode.right != null) {
      if (currentNode.right != null) {
        currentNode = currentNode.right;
      } else {
        currentNode = currentNode.left;
      }
      rootToRightLeaf.add(0, currentNode);
    }
    rootToRightLeaf.add(0, currentNode);
    
    if (rootToLeftLeaf.get(rootToLeftLeaf.size()-1) == rootToRightLeaf.get(0)) {
      rootToRightLeaf.remove(0);
      rootToLeftLeaf.addAll(rootToRightLeaf);
      return rootToLeftLeaf;
    }
    
    // calculate the left most leaf to right most leaf
    rootToLeftLeaf.addAll(getSuccessorLeafs(rootToLeftLeaf.get(rootToLeftLeaf.size()-1), rootToRightLeaf.get(0)));
    rootToRightLeaf.remove(0);
    rootToLeftLeaf.addAll(rootToRightLeaf);
    return rootToLeftLeaf;
  }
  // FormLinkedListFromLeaves can also be used instead
  public static ArrayList<BinaryTreeNode<String>> getSuccessorLeafs(BinaryTreeNode<String> fromNode, BinaryTreeNode<String> toNode) {
    ArrayList<BinaryTreeNode<String>> leafs = new ArrayList<>();
    BinaryTreeNode<String> currentNode;
    
    currentNode = fromNode;
    while (currentNode != null && currentNode != toNode) {
      currentNode = SuccessorInInorderTraversal.getSuccessor(currentNode);
      if (currentNode.left == null && currentNode.right == null) {
        leafs.add(currentNode);
      }
    }
    leafs.remove(leafs.size() - 1);
    return leafs;
  }
  
  public static ArrayList<BinaryTreeNode<String>> getExteriorMethod2(BinaryTreeNode<String> tree) {
    ArrayList<BinaryTreeNode<String>> exterior = new ArrayList<BinaryTreeNode<String>>();
    if (tree != null) {
      exterior.add(tree);
      exterior.addAll(leftBoundaryAndLeaves(tree.left, true));
      exterior.addAll(rightBoundaryAndLeaves(tree.right, true));
    }
    return exterior;
  }
  
  private static ArrayList<BinaryTreeNode<String>> leftBoundaryAndLeaves(BinaryTreeNode<String> subtreeRoot, boolean isBoundary) {
    ArrayList<BinaryTreeNode<String>> result = new ArrayList<>();
    if (subtreeRoot != null) {
      if (isBoundary || isLeaf(subtreeRoot)) {
        result.add(subtreeRoot);
      }
      result.addAll(leftBoundaryAndLeaves(subtreeRoot.left, isBoundary));
      result.addAll(leftBoundaryAndLeaves(subtreeRoot.right, isBoundary &&  subtreeRoot.left == null));
    }
    return result;
  }
  
  private static ArrayList<BinaryTreeNode<String>> rightBoundaryAndLeaves(BinaryTreeNode<String> subtreeRoot, boolean isBoundary) {
    ArrayList<BinaryTreeNode<String>> result = new ArrayList<>();
    if (subtreeRoot != null) {
      result.addAll(rightBoundaryAndLeaves(subtreeRoot.left, isBoundary  &&  subtreeRoot.right == null));
      result.addAll(rightBoundaryAndLeaves(subtreeRoot.right, isBoundary));
      if (isBoundary || isLeaf(subtreeRoot)) {
        result.add(subtreeRoot);
      }
    }
    return result;
  }
  
  private static boolean isLeaf(BinaryTreeNode<String> node) {
    return node.left == null && node.right == null;
  }
}
