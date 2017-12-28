/**
 * 10.13, variant
 */

package epi.binarytree;
import java.util.List;
import java.util.Arrays;

public class ConstructTreeFromPreorederWithMarkers {
  private static Integer subtreeIdx;
    
  public static void main(String[] args) { 
    List<String> preorder = Arrays.asList(new String[] {"H","B","F",null,null,"E","A",null,null,null,"C",null,"D",null,"G","I",null,null,null});
    subtreeIdx = 0;
    BinaryTreeNode<String> tree = reconstructPreorderSubtree(preorder);
    BinaryTreeTest.visualize(tree, 30);
  }
  
  private static BinaryTreeNode<String> reconstructPreorderSubtree(List<String> preorder) {
    String data = preorder.get(subtreeIdx);
    subtreeIdx++;
    if (data == null) {
      return null;
    }
    
    BinaryTreeNode<String> leftSubtree = reconstructPreorderSubtree(preorder);
    BinaryTreeNode<String> rightSubtree = reconstructPreorderSubtree(preorder);
    BinaryTreeNode<String> node = new BinaryTreeNode<String>();
    node.data = data;
    node.left = leftSubtree;
    node.right = rightSubtree;
    return node;
  }
  // variant to do
  
}
