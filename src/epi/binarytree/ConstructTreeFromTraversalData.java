/**
 * 10.12 and variant
 */
package epi.binarytree;
import java.util.HashMap;

public class ConstructTreeFromTraversalData {
  
  public static void main(String args[]) {
    String[] inOrderList = "D,C,E,B,F,H,G,A,J,L,M,K,N,I,O,P".split(",");
    String[] preOrderList = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P".split(",");
    String[] postOrderList = "D,E,C,H,G,F,B,M,L,N,K,J,P,O,I,A".split(",");
    HashMap<String,Integer> inOrderMap = new HashMap<String, Integer>();
    
    for (int i = 0; i < inOrderList.length; i++) {
      inOrderMap.put(inOrderList[i], i);
    }
    BinaryTreeNode<String> tree = fromInorderPreorder(inOrderList, preOrderList, inOrderMap, 0, inOrderList.length-1, 0, preOrderList.length-1);
    BinaryTreeTest.preOrderTraversal(tree);
    System.out.println();
    BinaryTreeTest.inOrderTraversal(tree);
    System.out.println();
    BinaryTreeTest.postOrderTraversal(tree);
    BinaryTreeNode<String> tree2 = fromInorderPostorder(inOrderList, postOrderList, inOrderMap, 0, inOrderList.length-1, 0, postOrderList.length-1);
    System.out.println();
    BinaryTreeTest.preOrderTraversal(tree2);
    System.out.println();
    BinaryTreeTest.inOrderTraversal(tree2);
    System.out.println();
    BinaryTreeTest.postOrderTraversal(tree2);
    
    // construct tree from integer array
    Integer[] intArr = {10,11,12,43,55,56,54,1,0,7,8,9,3,6,34,13,23};
    BinaryTreeNode<Integer> tree3 = fromIntegerArray(intArr, 0, intArr.length - 1);
    System.out.println();
    BinaryTreeTest.preOrderTraversal(tree3);
    System.out.println();
    BinaryTreeTest.visualize(tree3, 60);
  }
  
  public static BinaryTreeNode<String> fromInorderPreorder(String[] inOrderList, String[] preOrderList, HashMap<String,Integer> inOrderMap, int inStart, int inEnd, int preStart, int preEnd) {
    if (inStart <= inEnd && preStart <= preEnd) {
      BinaryTreeNode<String> node = new BinaryTreeNode<String>();
      node.data = preOrderList[preStart];
      int rootPositionInInorderList = inOrderMap.get(preOrderList[preStart]);
      int leftTreeNodeCount = rootPositionInInorderList - inStart;
      int rightTreeNodeCount = inEnd - rootPositionInInorderList;
      node.left = fromInorderPreorder(inOrderList, preOrderList, inOrderMap, inStart, rootPositionInInorderList - 1, preStart + 1, preStart + leftTreeNodeCount);
      node.right = fromInorderPreorder(inOrderList, preOrderList, inOrderMap, rootPositionInInorderList + 1, inEnd,  preStart + leftTreeNodeCount +1, preStart + leftTreeNodeCount + rightTreeNodeCount); 
      return node;
    }
    return null;
  }
  
  public static BinaryTreeNode<String> fromInorderPostorder(String[] inOrderList, String[] postOrderList, HashMap<String,Integer> inOrderMap, int inStart, int inEnd, int postStart, int postEnd) {
    if (inStart <= inEnd && postStart <= postEnd) {
      BinaryTreeNode<String> node = new BinaryTreeNode<String>();
      node.data = postOrderList[postEnd];
      int rootPositionInInorderList = inOrderMap.get(postOrderList[postEnd]);
      int leftTreeNodeCount = rootPositionInInorderList - inStart;
      int rightTreeNodeCount = inEnd - rootPositionInInorderList;
      node.left = fromInorderPostorder(inOrderList, postOrderList, inOrderMap, inStart, rootPositionInInorderList - 1, postEnd - (rightTreeNodeCount + leftTreeNodeCount), postEnd - (rightTreeNodeCount + 1));
      node.right = fromInorderPostorder(inOrderList, postOrderList, inOrderMap, rootPositionInInorderList + 1, inEnd, postEnd - rightTreeNodeCount , postEnd - 1); 
      return node;
    }
    return null;
  }
    // to be verified
  public static BinaryTreeNode<Integer> fromIntegerArray(Integer[] intArr, int startIndx, int endIndx) {
    if (startIndx > endIndx) {
      return null;
    }
    
    int largestIndx = getLargestElementIndx(intArr, startIndx, endIndx);
    
    BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>();
    node.data = intArr[largestIndx];
    node.left = fromIntegerArray(intArr, startIndx, largestIndx - 1);
    node.right = fromIntegerArray(intArr, largestIndx + 1, endIndx);
    return node;
  }
  private static int getLargestElementIndx(Integer[] intArr, int startIndx, int endIndx) {
    int largest = intArr[startIndx];
    int largestIndx = startIndx;
    for (int i = startIndx + 1; i <= endIndx; i++) {
      if (intArr[i] > largest) {
        largest = intArr[i];
        largestIndx = i;
      }
    }
    return largestIndx;
  }
}
