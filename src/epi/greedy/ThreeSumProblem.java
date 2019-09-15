package epi.greedy;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumProblem {
	public static void main(String[] args) {
		Integer[] input = {11, 2, 5, 7, 3};
		System.out.println(hasThreeSum(new ArrayList<Integer>(Arrays.asList(input)), 21));
		System.out.println(hasThreeSum(new ArrayList<Integer>(Arrays.asList(input)), 22));
	}

	public static boolean hasThreeSum(List<Integer> arr, int t) {
		for (Integer a : arr) {
			if (hasTwoSum(arr, t - a)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasTwoSum(List<Integer> arr, int t) {
		int i = 0;
		int j = arr.size() - 1;

		while (i <= j) {
			if (arr.get(i) + arr.get(j) == t) {
				return true;
			} else if (arr.get(i) + arr.get(j) < t) {
				i++;
			} else {
				j--;
			}
		}

		return false;
	}
}