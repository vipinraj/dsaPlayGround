// 12.10 
package epi.searching;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class FindMissingAndDuplicateElement {
    public static void main(String args[]) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(0,1,2,3,4,4,6,7,8,9));
        MissingAndDuplicateNum result = find(nums);
        System.out.println("Missing: " + result.missing + ", Duplicate: " +  result.duplicate);
    }
    
    // O(n)
    public static MissingAndDuplicateNum find(List<Integer> a) {
        // calculate XOR of 0, to a.size()-1 XOR (XOR of all integers in a)
        // this gives m ^ t (m-> missing number, t-> duplicate number)
        int mXorT = 0;
        for (int i = 0; i < a.size(); i++) {
            mXorT = mXorT ^ i ^ a.get(i);
        }
        
        // differBit holds the number with only the least significate 1 digit of mXorT set to 1
        int differBit = mXorT & ( ~(mXorT - 1));
        
        // get the subset of numbs where this perticular bit is 1, both from a and 0 to a.size()-1
        // XOR all these numbers will give missing or duplicate number
        int missOrDup = 0;
        for (int i = 0; i < a.size(); i++) {
            if ((a.get(i) & differBit) != 0) {
              missOrDup ^= a.get(i);
            }
            if ((i & differBit) != 0) {
                missOrDup ^= i;
            }
        }
        
        // check if missOrDup is in a
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == missOrDup) {
                // missOrDup is duplicate
                return new MissingAndDuplicateNum(mXorT ^ missOrDup, missOrDup);
            }
        }
        // missOrDup is missing
        return new MissingAndDuplicateNum(missOrDup, mXorT ^ missOrDup);
    }
}

class MissingAndDuplicateNum {
    int missing;
    int duplicate;
    public MissingAndDuplicateNum(int missing, int duplicate) {
        this.missing = missing;
        this.duplicate = duplicate;
    }
}
