// 16.5
package epi.recursion;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsOfSizeK {
	public static void main(String[] args) {
		List<Integer> set = new ArrayList(Arrays.asList(1,2,3,4));
		List<List<Integer>> result = generateKSets(set, 3);
		System.out.println(result);
		System.out.println(generateKSetsMethod2(4, 3));
	}

	// my Method
	public static List<List<Integer>> generateKSets(List<Integer> set, int k) {
		List<List<Integer>> result = new ArrayList<>();
		generateKSetsHelper(set, new ArrayList<>(), 0, k, result);
		return result;
	}

	// epi
	public static List<List<Integer>> generateKSetsMethod2(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		generateKSetsHelper2(n, k, 1, new ArrayList<Integer>(), result);
		return result;
	}


	public static void generateKSetsHelper(List<Integer> set, List<Integer> partialSubset, int itemToConsider, int k,  List<List<Integer>> result) {
		if (itemToConsider == set.size()) {
			result.add(new ArrayList<Integer>(partialSubset));
		} else {
			int setSize = set.size();

			partialSubset.add(set.get(itemToConsider));
			if (partialSubset.size() <= k && partialSubset.size() + (setSize - (itemToConsider + 1)) >= k) {
				generateKSetsHelper(set, partialSubset, itemToConsider + 1, k, result);
			}
			partialSubset.remove(partialSubset.size() - 1);
			if (partialSubset.size() <= k && partialSubset.size() + (setSize - (itemToConsider + 1)) >= k) {
				generateKSetsHelper(set, partialSubset, itemToConsider + 1, k, result);
			}

		}
	}

	public static void generateKSetsHelper2(int n, int k, int offset, List<Integer> partialCombination, List<List<Integer>> result){
		if (partialCombination.size() == k) {
			result.add(new ArrayList<>(partialCombination));
			return;
		}

		final int numRemaining = k - partialCombination.size();

		for (int i = offset; i <= n && numRemaining <= n - i + 1; i++) {
			partialCombination.add(i);
			generateKSetsHelper2(n, k, i + 1, partialCombination, result);
			partialCombination.remove(partialCombination.size() - 1);
		}
	}

}