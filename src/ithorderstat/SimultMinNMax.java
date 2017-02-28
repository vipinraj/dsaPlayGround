package ithorderstat;

public class SimultMinNMax {

	public static void main(String[] args) {
		
		int[] A = {2,3,1,5,6,7,9,0,9,-1};

		int min,max;
		boolean isOdd = true;
		
		if(A.length % 2 == 0){
			min = A[0] > A[1] ? A[1] : A[0];
			max = A[0] > A[1] ? A[0] : A[1];
			isOdd = false;
		}else{
			min = A[0];
			max = A[0];
		}
		
		for(int i = isOdd ? 1 : 2; i< A.length; i += 2){
			int localMin, localMax;
			if(A[i] < A[i+1]){
				localMin = A[i];
				localMax = A[i+1];
			}else{
				localMin = A[i+1];
				localMax = A[i];
			}
			
			if(localMin < min){
				min = localMin;
			}
			
			if(localMax > max){
				max = localMax;
			}
		}
		
		System.out.println("Max : " + max + ", Min : " + min);
	}

}
