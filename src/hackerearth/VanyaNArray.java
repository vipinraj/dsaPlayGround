package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class VanyaNArray {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		int N = Integer.parseInt(line[0]);
		int K = Integer.parseInt(line[1]);
		
		line = br.readLine().split(" ");
		
		Integer A[] = new Integer[line.length];
		int AF[] = new int[line.length];
		
		int i = 0;
		for (String string : line) {
			A[i] = Integer.parseInt(string);
			i++;
		}
		
		for(int j= 0; j < N ; j++){
			AF[j] = F(A[j], N, A);
		}
		int k = 2;                          

		List<int[]> subsets = new ArrayList<>();

		int[] s = new int[k];                 

		if (k <= AF.length) {
		    for (int m = 0; (s[m] = m) < k - 1; m++);  
		    subsets.add(getSubset(AF, s));
		    for(;;) {
		        int m;
		        
		        for (m = k - 1; m >= 0 && s[m] == AF.length - k + m; m--); 
		        if (m < 0) {
		            break;
		        } else {
		            s[m]++;                   
		            for (++m; m < k; m++) {   
		                s[m] = s[m - 1] + 1; 
		            }
		            subsets.add(getSubset(AF, s));
		        }
		    }
		}
		int count = 0;
		for (int[] pair : subsets) {
			if(pair[0]+pair[1] >= K){
				count ++;
			}
		}
		System.out.println(count);
	}

	public static Integer F(Integer i, Integer N, Integer A[]) {

		Integer sum = 0;
		for (int j = i; j < N; j++) {
			if (A[i - 1] < A[j]) {
				sum += 1;
			}
		}
		return sum;
	}
	
	public static int[] getSubset(int[] input, int[] subset) {
	    int[] result = new int[subset.length]; 
	    for (int i = 0; i < subset.length; i++) 
	        result[i] = input[subset[i]];
	    return result;
	}
}
