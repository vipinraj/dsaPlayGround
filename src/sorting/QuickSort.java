package sorting;

public class QuickSort {

	int[] array;

	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] array = { 13, 19, 9, 5, 12, 8, 7, 4, 11, 2, 6, 21 };
		quickSort.array = array;
		quickSort.sort(array, 0, array.length - 1);

		for (int i = 0; i < quickSort.array.length; i++) {
			System.out.print(quickSort.array[i] + " ");
		}
	}

	void sort(int[] arr, int p, int r) {
		if (p < r) {
			int q = partition(arr, p, r);
			sort(arr, p, q);
			sort(arr, q + 1, r);
		}
	}

	private int partition(int[] array, int p, int r) {
		int piv = array[p];
		int low = p;
		int high = r ;

		while (true) {

			while (array[high] > piv) {
				high = high - 1;
			}

			while (array[low] < piv) {
				low++;
			}

			if (low < high) {
				int temp = array[low];
				array[low] = array[high];
				array[high] = temp;
			} else {
				return high;
			}
		}
	}
}
