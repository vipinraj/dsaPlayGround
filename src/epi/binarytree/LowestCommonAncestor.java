package epi.binarytree;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class LowestCommonAncestor {
  
  public static HashMap<BinaryTreeNode<String>,BinaryTreeNode<String>> parentMapping = new HashMap<BinaryTreeNode<String>,BinaryTreeNode<String>>();
  
  public static void main(String[] args) { 
     BinaryTreeNode<String> root = BinaryTreeTest.getSampleBinaryTree();
     getParents(root);   
     System.out.println(parentMapping.size());
     System.out.println("LCA:" + getCommonAncestor(BinaryTreeTest.mNode, BinaryTreeTest.nNode).data);
     System.out.println("LCA:" + getCommonAncestorImproved(BinaryTreeTest.mNode, BinaryTreeTest.nNode).data);
     System.out.println("LCA:" + getCommonAncestorMethod3(BinaryTreeTest.mNode, BinaryTreeTest.nNode).data);
     System.out.println("LCA:" + getCommonAncestorMethod4(BinaryTreeTest.mNode, BinaryTreeTest.nNode, root).data);
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
  
  // store path for node a and b then get the first common path O(h^2)
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
    
    BinaryTreeNode<String> ancestor = null;
    for (int i = 0; i < parentPathA.size(); i++ ) {
      if (ancestor != null) {
        break;
      }
      for (int j = 0; j < parentPathB.size(); j++) {
        if (parentPathA.get(i).data == parentPathB.get(j).data) {
          ancestor = parentPathA.get(i);
          break;
        }
      }
    }
    return ancestor;
  }
  
  // create a hashtable of one of the path and stop on first hit on hashtable O(h)
  public static BinaryTreeNode<String> getCommonAncestorImproved(BinaryTreeNode<String> a, BinaryTreeNode<String> b) {
    List<BinaryTreeNode<String>> parentPathA = new ArrayList<BinaryTreeNode<String>>();
    HashMap<BinaryTreeNode<String>, String> bPathMap = new HashMap<BinaryTreeNode<String>, String>();
    
    BinaryTreeNode<String> tmp;
    
    tmp = a;
    while (tmp != null) {
      parentPathA.add(tmp);
      tmp = parentMapping.get(tmp);
    }
    
    tmp = b;
    while (tmp != null) {
      bPathMap.put(tmp, null);
      tmp = parentMapping.get(tmp);
    }
    
    BinaryTreeNode<String> ancestor = null;
    for (int i = 0; i < parentPathA.size(); i++ ) {
      if (bPathMap.containsKey(parentPathA.get(i))) {
        ancestor = parentPathA.get(i);
        break;
      }
    }
    return ancestor;
  }
  
  // calculate paths for a and b; make the length of paths equal by removing nodes from larger path;
  // compare nodes from paths in tandem.
  public static BinaryTreeNode<String> getCommonAncestorMethod3(BinaryTreeNode<String> a, BinaryTreeNode<String> b) {
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
    int parentPathAlen = parentPathA.size();
    int parentPathBlen = parentPathB.size();
    int diff = Math.abs(parentPathAlen - parentPathBlen);
    // todo: multiple while loop can be avoided
    if ( parentPathAlen > parentPathBlen) {
      while (diff-- > 0) {
        a = parentMapping.get(a);
      }
    } else {
      while (diff-- > 0) {
        b = parentMapping.get(b);
      }
    }
    
    BinaryTreeNode<String> ancestor = null;
    while (a != b) {
      a = parentMapping.get(a);
      b = parentMapping.get(b);
    }
    return a;
  }
  
  // recursive method time O(n) , space O(h)
  public static BinaryTreeNode<String> getCommonAncestorMethod4(BinaryTreeNode<String> a, BinaryTreeNode<String> b, BinaryTreeNode<String> root) {
    return LCAHelper(root, a, b).ancestor;
  }
  
  private static Status LCAHelper(BinaryTreeNode<String> tree, BinaryTreeNode<String> node0, BinaryTreeNode<String> node1) {
    if (tree == null) {
      return new Status(0, null);
    }
    
    Status leftResult = LCAHelper(tree.left, node0, node1);
    if (leftResult.numTargetNodes == 2) {
      return leftResult;
    }
    
    Status rightResult = LCAHelper(tree.right, node0, node1);
    if (rightResult.numTargetNodes == 2) {
      return rightResult;
    }
    
    int numTargetNodes = leftResult.numTargetNodes + rightResult.numTargetNodes +
      (tree == node0 ? 1 : 0) + (tree == node1 ? 1 : 0);
    
    return new Status(numTargetNodes, numTargetNodes == 2 ? tree : null);
  }
}

class Status {
  public int numTargetNodes;
  public BinaryTreeNode<String> ancestor;
  public Status(int numTargetNodes, BinaryTreeNode<String> ancestor) {
    this.ancestor = ancestor;
    this.numTargetNodes = numTargetNodes;
  }
}
