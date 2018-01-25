// 13.6
package epi.hashtables;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NearestRepeatingPair {
    public static void main(String args[]) {
        List<String> list = new ArrayList<>(Arrays.asList("All", "work", "and", "no", "play", 
        "makes", "for", "no", "work", "fun", "and", "no", "result"));
        
        System.out.println(distanceBWNearestRepeatingpairs(list));
    }
    
    // O(n), O(d) 
    public static int distanceBWNearestRepeatingpairs(List<String> list) {
        Map<String, Integer> distances = new HashMap<String, Integer>();
        
        Integer minDistance = null;
        int i = 0;
        for (String s : list) {
            if (distances.containsKey(s)) {
                if (minDistance == null) {
                    minDistance = i - distances.get(s);
                } else {
                    if (i - distances.get(s) < minDistance) {
                        minDistance = i - distances.get(s);
                    }
                }
            }
            distances.put(s, i);
            i++;
        }
        
        return minDistance;
    }
}
