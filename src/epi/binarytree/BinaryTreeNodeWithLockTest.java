package epi.binarytree;

public class BinaryTreeNodeWithLockTest {
  
  public static void main(String args[]) {
    BinaryTreeNodeWithLock root = new BinaryTreeNodeWithLock("A");
    root.left = new BinaryTreeNodeWithLock("B");
    root.left.parent = root;
    root.right = new BinaryTreeNodeWithLock("D");
    root.right.parent = root;
    root.left.left = new BinaryTreeNodeWithLock("C");
    root.left.left.parent = root.left;
    root.right.left = new BinaryTreeNodeWithLock("E");
    root.right.left.parent = root.right;
    root.right.right = new BinaryTreeNodeWithLock("G");
    root.right.right.parent = root.right;
    root.right.left.left = new BinaryTreeNodeWithLock("F");
    root.right.left.left.parent = root.right.left;
    root.right.right.left = new BinaryTreeNodeWithLock("H");
    root.right.right.left.parent = root.right.right;
    root.right.right.right = new BinaryTreeNodeWithLock("I");
    root.right.right.right.parent = root.right.right;
    
    // lock I
    root.right.right.right.lock();
    System.out.println("Locked: I :" +  root.right.right.right.locked);
    //lock G
    System.out.println("Locked: G :" +  root.right.right.lock());
    // lock D
    System.out.println("Locked: D :" +  root.right.lock());
    // unlock I 
    root.right.right.right.unlock();
    // lock D
    System.out.println("Locked: D :" +  root.right.lock());
  }
  
}