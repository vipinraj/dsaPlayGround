package sorting;

public class SelectionSort {

	public static void main(String[] args) {

		int a[] = { 9, 7, 8, 6, 5, 4, 3, 2, 1, 0 };

		int comparisons = 0;
		int smallestPos = 0;

		for (int i = 0; i < a.length; i++) {
			smallestPos = i;
			for (int j = i; j < a.length - 1; j++) {
				comparisons ++;
				if (a[smallestPos] > a[j + 1]) {
					smallestPos = j + 1;
				}
			}
			if (smallestPos != i) {
				// swap
				int temp = a[i];
				a[i] = a[smallestPos];
				a[smallestPos] = temp;
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\nNo of comparisons: " + comparisons);
	}

}
