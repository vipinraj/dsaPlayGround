package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class VelmaAndTriplets {
	static BigInteger result = BigInteger.ZERO;
	public static void main(String args[]) throws IOException {		
		int tempTriplet[] = new int[3];
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		int[] array = new int[N];
		
		String[] numStr = br.readLine().split(" ");
		
		for(int i=0; i<N; i++){
			array[i] = Integer.parseInt(numStr[i]);
		}
		
		combinationFinder(array, tempTriplet, 0, array.length-1, 0, 3);
		System.out.println(result);
		
		
	}

	static void combinationFinder(int arr[], int data[], int start, int end, int index, int r) {
		if (index == r) {
			BigDecimal val = new BigDecimal(Math.floor((data[0] + data[1] + data[2])/(data[0] * data[1] * data[2])));
			
			result = result.add(val.toBigInteger());							
			return;
		}

		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			combinationFinder(arr, data, i + 1, end, index + 1, r);
		}
	}
}

