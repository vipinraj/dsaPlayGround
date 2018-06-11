// 16.4
// https://www.youtube.com/watch?v=bGC2fNALbNU
package epi.recursion;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet {
	
	public static void main(String[] args) {
		List<Integer> set = new ArrayList(Arrays.asList(1,2,3,4));
		List<List<Integer>> result = generatePowerSet(set);
		System.out.println(result);
		System.out.println(generatePowerSetMethod2(set));
	}

	public static List<List<Integer>> generatePowerSet(List<Integer> set) {
		List<List<Integer>> result = new ArrayList<>();

		generatePowerSetHelper(set, result, new ArrayList<Integer>(), 0);

		return result;
	}

	public static void generatePowerSetHelper(List<Integer> set, List<List<Integer>> result, List<Integer> partialSubset, int itemToConsider) {

		if (itemToConsider == set.size()) {
			result.add(new ArrayList(partialSubset));
		} else {
			partialSubset.add(set.get(itemToConsider));
			generatePowerSetHelper(set, result, partialSubset, itemToConsider + 1);
			partialSubset.remove(set.get(itemToConsider));
			generatePowerSetHelper(set, result, partialSubset, itemToConsider + 1);
		}
	}

	public static List<List<Integer>> generatePowerSetMethod2(List<Integer> set) {
		List<List<Integer>> result = new ArrayList<>();
		double log2baseE = Math.log(2);
		int size = set.size();

		for (int i = 0; i < (int)Math.pow(2, size); i++) {
			
			// find set bits
			List<Integer> subset = new ArrayList<>();
			int tmp = i;
			while (tmp > 0) {
				int r = ~(tmp - 1) & tmp;
				subset.add(set.get( (int) (Math.log(r) / log2baseE) ));
				tmp = tmp & (tmp - 1);
			}
			result.add(subset);
		}

		return result;
	}	
	
}