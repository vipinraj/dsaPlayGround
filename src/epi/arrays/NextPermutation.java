// 6.10
package epi.arrays;

public class NextPermutation {
	public static void main(String args[]) {
		Integer[] input = {6, 2, 1, 5, 4, 3, 0};

		getNext(input);

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + ", ");
		}

		System.out.println();

		Integer[] input2 = {6, 2, 3, 0, 1, 4, 5};

		getNext(input2);

		for (int i = 0; i < input2.length; i++) {
			System.out.print(input2[i] + ", ");
		}

		System.out.println();

		Integer[] input3 = {6, 2, 1};

		Integer[] result = getNext(input3);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}

	}
	// O(n)
	public static Integer[] getNext(Integer[] permutation) {

		// find largest increasing subsequence starting from right most element.
		int size = permutation.length - 1;

		int i;
		for ( i = size - 1; i >= 0; i--) {
			if (permutation[i] < permutation[i + 1]) {
				break;
			}
		}

		// this is the maximum permutation
		if (i == -1) {
			return new Integer[]{};
		}

		// find the smallest element in increasing sequence which is larger than permutation[i];
		// then swap them;
		for (int j = size; j > i; j--) {
			if (permutation[j] > permutation[i]) {
				// swap them
				swap(permutation, i, j);
				break;
			}
		}

		// reverse the sub array [i+1, size]
		int k = size;
		for (int j = i + 1; j < i + 1 + (size + 1 - (i + 1))/2; j++ ) {
			swap(permutation, j, k--);
		}

		return permutation;

	}

	public static void swap(Integer arr[], int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}