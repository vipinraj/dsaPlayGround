/**
 * 13.10
 */
package epi.hashtables;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class LengthOfLongestContainedInterval {
  
  
  public static void main(String[] args) { 
    List<Integer> input = new ArrayList<>(Arrays.asList(3,-2,7,9,8,1,2,0,-1,5,8));
    System.out.println(getLongestContainedIntervalLength(input));
  }
  
  public static int getLongestContainedIntervalLength(List<Integer> numbers) {
    Set<Integer> numberCollection = new HashSet<>();
    int result = 0;
    
    for (int i = 0; i < numbers.size(); i++) {
      numberCollection.add(numbers.get(i));
    }
    
    for (int i = 0; i < numbers.size(); i++) {
      boolean elementExist = numberCollection.contains(numbers.get(i));
      
      if (elementExist == true) {
        int e = numbers.get(i);
        numberCollection.remove(e);
        int iterBefore = e - 1;
        e++;
        
        while (numberCollection.contains(e)) {
          numberCollection.remove(e);
          e++;
        }
        
        while (numberCollection.contains(iterBefore)) {
          numberCollection.remove(iterBefore);
          iterBefore--;
        }
        
        result = Math.max(result, e - iterBefore - 1);
      }
    }
    
    return result;
  }
  
}