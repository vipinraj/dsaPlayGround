public class 3SumProblem {
	public static void main(String[] args) {
		int[] 
	}

	public static hasThreeSum(List<Integer> arr, int t) {
		for (Integer a : arr) {
			if (hasTwoSum(arr, t - a)) {
				return true;
			}
		}
	}

	public static hasTwoSum(List<Integer> arr, int t) {
		int i = 0;
		int j = arr.size() - 1;

		while (i <= j) {
			if (arr.get(i) + arr.get(j) == t) {
				return true;
			} else if (arr.get(i) + arr.get(j) < t) {
				i++;
			} else {
				j++;
			}
		}

		return false;
	}
}