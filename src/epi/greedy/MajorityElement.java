package epi.greedy;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// 18.5 - Boyer–Moore majority vote algorithm
public class MajorityElement {
    public static void main(String[] args) {
        List<Character> input = new ArrayList<Character>(Arrays.asList('b', 'a', 'c', 'a', 'a', 'b', 'a', 'a', 'a', 'c'));
        
        System.out.println(getMajorityElement(input));
    }
    
    public static Character getMajorityElement(List<Character> elems) {
        Character candidate = elems.get(0);
        int candidateCount = 1;
        
        for (int i = 1; i < elems.size(); i++) {
            if (candidateCount == 0) {
                candidate = elems.get(i);
                candidateCount = 1;
            } else if (candidate.equals(elems.get(i))) {
                candidateCount++;
            } else {
                candidateCount--;
            }
        }
        
        return candidate;
    }
}
