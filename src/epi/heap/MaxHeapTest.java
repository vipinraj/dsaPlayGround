package epi.heap;

public class MaxHeapTest {
  
  
  public static void main(String[] args) throws Exception { 
    MaxHeap<Integer> h = new MaxHeap(10);
    for (int i = 0; i < 10; i++) {
      h.insert(i);
    }
    System.out.println("Max: " + h.extractMax());
    System.out.println("Max: " + h.extractMax());
    System.out.println("Size: " + h.size);
    
    MaxHeap<String> h2 = new MaxHeap(5);
    h2.insert("ABCD");
    h2.insert("AB");
    h2.insert("ABCDE");
    h2.insert("A");
    h2.insert("AB");
    System.out.println("Max: " + h2.extractMax());
    System.out.println("Max: " + h2.extractMax());
    System.out.println("Size: " + h2.size);
  }
  
}
