package epi.bst;

public class BinarySearchTree {
    private static class TreeNode {
        Integer data;
        TreeNode right;
        TreeNode left;
        
        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    private TreeNode root = null;
    
    public boolean insert(int key) {
        if (root == null) {
            root = new TreeNode(key, null, null);
            return true;
        }
        
        TreeNode iter = root;
        TreeNode prevNode = null;
        
        while(iter != null) {
            prevNode = iter;
            if (iter.data > key) {
                iter = iter.left;
            } else if (iter.data < key) {
                iter = iter.right;
            } else {
                // node with same key exist, can't insert
                return false;
            }
        }
        
        if (prevNode.data > key) {
            prevNode.left =  new TreeNode(key, null, null);
        } else {
            prevNode.right =  new TreeNode(key, null, null);
        }
        
        return true;
    }
    
    public boolean delete(int key) { 
        
        // find the node with data = key

        TreeNode node = null;
        TreeNode parent = null;
        TreeNode iter = root;
        
        while (iter != null) {
            int cmp = Integer.compare(iter.data, key);
            if (cmp == 0) {
                node = iter;
                break;
            } else if (cmp > 0) {
                parent = iter;
                iter = iter.left;
            } else {
                parent = iter;
                iter = iter.right;
            }
        }
        
        if (node == null) {
            // key not found
            return false;
        }
        
        if (node.left == null && node.right == null) {
            if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (node.left != null && node.right != null) {
            // find the successor of the node
            TreeNode successor;
            TreeNode successorParent = node;
            iter = node.right;
            
            while (iter.left != null) {
                successorParent = iter;
                iter = iter.left;
            }
            successor = iter;
            
            // delete successor
            if () {
                
            }
            
        } else if (node.left == null) {
            if (parent.left == node) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
        } else if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        }

        
        return true;
    }
    
    
}
