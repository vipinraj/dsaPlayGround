package epi.recursion;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GeneratePermutations {
	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(2, 3, 5, 7);

		List<List<Integer>> result = getPermutations(arr);

		System.out.println(result);
		System.out.println(result.size());
	}

	public static List<List<Integer>> getPermutations(List<Integer> arr) {
		List<List<Integer>> result = new ArrayList<>();
		getPermutationsHelper(arr, 1, result);
		return result;
	}

	public static void getPermutationsHelper(List<Integer> arr, int level, List<List<Integer>> result) {
		if (arr.size() == level) {
			result.add(new ArrayList<Integer>(arr));
		} else {
			for (int i = level - 1; i < arr.size(); i++) {
				Collections.swap(arr, level - 1, i);
				getPermutationsHelper(arr, level + 1, result);
				Collections.swap(arr, level - 1, i);
			}
		}
	}
}