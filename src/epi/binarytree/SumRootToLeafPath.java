/**
 * 10.5
 */
package epi.binarytree;

import java.util.ArrayList;
import java.util.Collections;

public class SumRootToLeafPath {
  
  
  public static void main(String[] args) { 
    BinaryTreeNode<Integer> root = BinaryTreeTest.getSampleBinaryDigitTree();
    Integer sum[] = {0};
    ArrayList<Integer> parentDigits = new ArrayList<Integer>();
    getSumMyMethod(root, parentDigits, sum);
    System.out.println("Sum: " + sum[0]);
    System.out.println("Sum: " + getSumMethod2(root, 0));
  }
  
  // O(n), O(h)
  public static void getSumMyMethod(BinaryTreeNode<Integer> node, ArrayList<Integer> parentDigits, Integer sum[]) {
    if (node == null ) {
      return;
    }
    
    ArrayList<Integer> newList = new ArrayList<Integer>(parentDigits);
    newList.add(node.data);
    if (node.left == null && node.right == null) {
      // is leaf
      System.out.println(newList);
      sum[0] += getDecimel(newList);      
      return;
    }
    getSumMyMethod(node.left, newList, sum);
    getSumMyMethod(node.right, newList, sum);
  }
  
  private static int getDecimel(ArrayList<Integer> binaryDigits) {
    int dec = 0;
    ArrayList<Integer> tmp = new ArrayList<Integer>(binaryDigits);
    Collections.reverse(tmp);
    System.out.println(tmp);
    for (int i = 0; i < tmp.size(); i++ ) {
      dec = dec + tmp.get(i) * (int)( Math.pow(2, i) ) ;
    }
    System.out.println(dec);
    return dec;
  }
  
  // O(n), O(h)
  public static int getSumMethod2(BinaryTreeNode<Integer> node, int partialPathSum) {
    if (node == null) {
      return 0;
    }
    
    partialPathSum = 2 * partialPathSum + node.data;
    if (node.left == null && node.right == null) {
      return partialPathSum;
    }
    
    return getSumMethod2(node.left, partialPathSum) + getSumMethod2(node.right, partialPathSum);
  }
}
