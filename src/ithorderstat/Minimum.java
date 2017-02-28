package ithorderstat;

public class Minimum {

	public static void main(String[] args) {
		int[] A = {8,1,3,5,9,2,6};
		
		int min = A[0];
		
		for(int i = 1; i<A.length; i++){
			if(A[i] < min){
				min = A[i];
			}
		}
		
		System.out.println("Min: "+min);
	}

}
