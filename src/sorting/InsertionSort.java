package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		
		int a[] = { 9, 7, 8, 6, 5, 4, 3, 2, 1, 0 };

		int comparisons = 0;
		
		for(int i=1; i<a.length; i++){
			int key = a[i];
			int j = i - 1;
			while(j >= 0 && key < a[j]){
				comparisons++;
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
		}
		for(int i=0; i<a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("\nNo of comparisons: " +comparisons);
	}

}
