package epi.hashtables;
import epi.binarytree.BinaryTreeNode;
import epi.binarytree.BinaryTreeTest;
import java.util.Set;
import java.util.HashSet;

public class LCABinaryTree {
    public static void main(String args[]) {
        BinaryTreeNode<String> tree = BinaryTreeTest.getSampleBinaryTree();
        System.out.println(getLCA(BinaryTreeTest.mNode, BinaryTreeTest.nNode).data);
    }
    
    // O(D0+D1) time & space
    public static BinaryTreeNode<String> getLCA(BinaryTreeNode<String> a, BinaryTreeNode<String> b) {
        Set<BinaryTreeNode<String>> parents = new HashSet<>();
        
        BinaryTreeNode<String> iter1 = a;
        BinaryTreeNode<String> iter2 = b;
        while (iter1.parent != null || iter2.parent != null) {
            
            if (iter1.parent != null) {
                if (parents.contains(iter1.parent)) {
                    return iter1.parent;
                }
                parents.add(iter1.parent);
                iter1 = iter1.parent;
            }
            
            if (iter2.parent != null) {
                if (parents.contains(iter2.parent)) {
                    return iter2.parent;
                }
                parents.add(iter2.parent);
                iter2 = iter2.parent;
            }
        }

        return null;
    }
}
