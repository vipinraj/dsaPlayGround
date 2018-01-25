// 13.1
package epi.hashtables;
import java.util.HashMap;
import java.util.Map;

public class PalindromicPermutation {
    public static void main(String args[]) {
        String str = "edified";
        System.out.println(        palindromEligible(str));
    }
    
    // O(n), O(c) c -> distinct characters in string
    public static boolean palindromEligible(String str) {
        
        Map<Character, Integer> parityMap = new HashMap<>();
        
        for (char c : str.toCharArray()) {
            if (parityMap.containsKey(c)) {
               parityMap.put(c, (parityMap.get(c) + 1) % 2);
            } else {
                parityMap.put(c, 1);
            }
        }
        
       
        // count 1s
        int count = 0;
        for (char c : parityMap.keySet()) {
            if (parityMap.get(c) == 1) {
                count ++;
            }
        }
        
        if (count > 1) {
            return false;
        }
        return true;
    }
}
