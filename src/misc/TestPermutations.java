package misc;

import java.util.Arrays;

public class TestPermutations {

	public static void main(String[] args) {
		
		 Permutations<Integer> perm = new Permutations<Integer>(new Integer[]{3,3,4,4,4,5,5});
		    int count = 0;
		    while(perm.hasNext()){
		        System.out.println(Arrays.toString(perm.next()));
		        count++;
		    }
		    System.out.println("total: " + count);

	}

}
