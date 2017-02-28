package sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int a[]= {9,8,6,5,4,3,2,1,0};
		
		int comparisons = 0;
		
		for(int i=0; i<a.length -1; i++){
			
			for(int j=0; j<a.length-1-i; j++){
				comparisons ++;
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
		for(int i=0; i<a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("\nNo of comparisons: " +comparisons);
	}

}
