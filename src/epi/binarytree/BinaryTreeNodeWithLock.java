/**
 * 10.17
 */
package epi.binarytree;

class BinaryTreeNodeWithLock {
  public BinaryTreeNodeWithLock left, right, parent;
  public String data;
  public Boolean locked = false;
  private int numLockedDescendants = 0;
  
  BinaryTreeNodeWithLock(String data) {
    this.data = data;
  }
  
  public boolean lock() {
    System.out.println(this.numLockedDescendants);
    if (this.numLockedDescendants > 0 || locked) {
      return false;
    }
    
    for (BinaryTreeNodeWithLock iter = parent; iter != null; iter = iter.parent) {
      if (iter.locked) {
        return false;
      }
    }
    // lock
    this.locked = true;
    for (BinaryTreeNodeWithLock iter = parent; iter != null; iter = iter.parent) {
      ++iter.numLockedDescendants;
    }
    
    return true;
  }
  
  public void unlock() {
    if (this.locked) {
      this.locked = false;
    }
    for (BinaryTreeNodeWithLock iter = parent; iter != null; iter = iter.parent) {
      --iter.numLockedDescendants;
    }
  }
}


