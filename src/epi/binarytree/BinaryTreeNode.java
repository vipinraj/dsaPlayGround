package epi.binarytree;

public class BinaryTreeNode<T> {
 public T data;
 public BinaryTreeNode<T> left, right;
 public BinaryTreeNode<T> parent; // optional
 public int nodeCount; // optional
 public BinaryTreeNode<T> next; // optional. Holds next node in the level
}
