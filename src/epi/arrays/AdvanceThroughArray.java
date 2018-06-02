// 6.4
package epi.arrays;

public class AdvanceThroughArray {
	public static void main(String[] args) {
		int[] input1 = {3, 3, 1, 0, 2, 0, 1};
		System.out.println(canAdvance(input1));
		int[] input2 = {3, 2, 0, 0, 2, 0, 1};
		System.out.println(canAdvance(input2));
		System.out.println(canAdvance2(input1));
		System.out.println(canAdvance2(input2));
	}

	// O(n^2)
	public static boolean canAdvance(int[] arr) {

		int i = 0;

		while (i < arr.length) {
			
			if (arr[i] == 0) {
				return false;
			}

			int nextPosIndx = i + arr[i];
			int maxSteps = i + arr[i];

			for (int j = i + 1; j <= i + arr[i]; j++) {
				if (j == arr.length - 1) {
					return true;
				}

				if (arr[j] != 0 && arr[j] + j > maxSteps) {
					maxSteps = arr[j] + j;
					nextPosIndx = j;
				}
			}

			i = nextPosIndx;
		}

		return true;
	}

	// O(n)
	public static boolean canAdvance2(int arr[]) {
		int farthestReachedSofar = 0;
		int lastIndex = arr.length - 1;

		for (int i = 0; i <= farthestReachedSofar && i < lastIndex; i++) {
			farthestReachedSofar = Math.max(farthestReachedSofar, i + arr[i]);
		}

		return farthestReachedSofar >= lastIndex;
	}
}