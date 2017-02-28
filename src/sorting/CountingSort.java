package sorting;

public class CountingSort {

	public static void main(String[] args) {
	
		Integer[] A = {9,9,8,4,2,1,0,6,8,7,6};
		Integer[] B = new Integer[11];
		Integer[] C = new Integer[10];
		
		for(int i=0; i<C.length; i++){
			C[i] = 0;
		}
		
		for(int j=0; j<A.length; j++){
			C[A[j]]++;
		}
		
		for(int i=1; i< C.length; i++){
			C[i] = C[i] + C[i-1];
		}
		
		for(int i = A.length-1; i >= 0; i--){
			B[C[A[i]]-1] = A[i];
			C[A[i]]--;
		}
		
		for(int i=0; i< B.length; i++){
			System.out.print(B[i] + " ");
		}
	}

}
