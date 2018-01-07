package epi.heap;

public class MaxHeap<T extends Comparable<T>> {
  T[] nodes;
  int size;
  MaxHeap(int length) {
    nodes = (T[])new Comparable[length];
  }
  
  int getLeft(int index) {
    return index * 2 + 1;
  }
  
  int getRight(int index) {
    return index * 2 + 2;
  }
  
  int getParent(int index) {
    return index / 2;
  }
  
  void maxHeapify(int index) {
    int l = getLeft(index);
    int r = getRight(index);
    int largest;
    
    if (l < this.size && this.nodes[l].compareTo(this.nodes[index]) > 0) {
      largest = l;
    } else {
      largest = index;
    }
    
    if (r < this.size && nodes[r].compareTo(nodes[largest]) > 0) {
      largest = r;
    }
    
    if (largest != index) {
      T t = nodes[largest];
      nodes[largest] = nodes[index];
      nodes[index] = t;
      this.maxHeapify(largest);
    }
  }
  
  public void insert(T e) throws Exception {
    if (size >= nodes.length) {
      throw new Exception("Heap overflow!");
    }
    
    nodes[size] = e;
    int current = size;
    while (getParent(current) >= 0 && nodes[getParent(current)].compareTo(nodes[current]) < 0) {
      T t = nodes[getParent(current)];
      nodes[getParent(current)] = nodes[current];
      nodes[current] = t;
      current = getParent(current);
    }
    size++;
  }
  
  public T extractMax() throws Exception{
    if (size == 0) {
      throw new Exception("Heap underflow!");
    }
    
    T e = nodes[0];
    this.size--;
    nodes[0] = nodes[this.size];
    maxHeapify(0);
    return e;
  }
}
