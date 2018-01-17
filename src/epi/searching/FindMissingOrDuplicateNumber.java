// extra
package epi.searching;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FindMissingOrDuplicateNumber {
    public static void main(String args[]) {
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,6,7,8));
        System.out.println(getMissingNumber(nums));
        nums = new ArrayList<Integer>(Arrays.asList(0,1,2,3,3,4,5,6,7,8));
        System.out.println(getDuplicateNumber(nums));
    }
    
    public static Integer getMissingNumber(List<Integer> a) {
        
        int actualNoOfElems = a.size() + 1;
        
        // calculate XOR of elements from 0 to actualNoOfElems-1
        int actualXor = 0;
        for (int i = 0; i < actualNoOfElems; i++) {
            actualXor = actualXor ^ i;
        }
        
        // calculate the XOR of all elements in array
        int aXor = 0;
        for (int n: a) {
            aXor = aXor ^ n;
        }
        
        return actualXor ^ aXor;
    }
    
    public static Integer getDuplicateNumber(List<Integer> a) {
        
        int actualNoOfElems = a.size() - 1;
        // calculate XOR of elements from 0 to actualNoOfElems-1
        int actualXor = 0;
        for (int i = 0; i < actualNoOfElems; i++) {
            actualXor = actualXor ^ i;
        }        
        // calculate the XOR of all elements in array
        int aXor = 0;
        for (int n: a) {
            aXor = aXor ^ n;
        }
        
        return actualXor ^ aXor;
    }
}
