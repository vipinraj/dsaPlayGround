/**
 * 11.4
 */
package epi.heap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class KClosestStars {
  
  
  public static void main(String[] args) { 
    List<Star> input = new ArrayList<>();
    
    Star s1 = new Star(1,2,3);
    Star s2 = new Star(3,2,3);
    Star s3 = new Star(45,6,77);
    Star s4 = new Star(12,45,12);
    Star s5 = new Star(3,2,4);
    Star s6 = new Star(9,2,3);
    Star s7 = new Star(3,2,7);
    Star s8 = new Star(11,4,34);
    Star s9 = new Star(41,24,34);
    Star s10 = new Star(51,2,343);
    input.add(s1);
    input.add(s2);
    input.add(s3);
    input.add(s4);
    input.add(s5);
    input.add(s6);
    input.add(s7);
    input.add(s8);
    input.add(s9);
    input.add(s10);
    
    List<Star> result = getClosestStars(input, 5);
    for (Star s : result) {
      System.out.println(s);
    }
  }
  
  /* O(nlogk), O(k) */
  public static List<Star> getClosestStars(List<Star> input, int k) {
    if (k > input.size()) {
      return null;
    }
    PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, new Comparator<Star> () {
      @Override
      public int compare(Star a, Star b) {
        return Double.compare(disatanceFromOrigin(b), disatanceFromOrigin(a));
      }
    });
    
    for (int i = 0; i < input.size(); i++ ) {
      maxHeap.add(input.get(i));
      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }
    List<Star> result = new ArrayList<>();
    while(!maxHeap.isEmpty()) {
      result.add(0, maxHeap.poll());
    }
    return result;
  }
  
  public static double disatanceFromOrigin(Star a) {
    return Math.sqrt(Math.pow(a.x, 2) + Math.pow(a.y, 2) + Math.pow(a.y, 2));
  }
  
}

class Star {
  int x;
  int y;
  int z;
  
  Star(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  public String toString() {
    return x + "," + y + "," + z;
  }
}