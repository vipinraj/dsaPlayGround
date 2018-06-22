package epi.recursion;

import java.util.List;
import java.util.ArrayList;

public class GrayCode {
	public static void main(String[] args) {
		System.out.println(getGrayCode(4));
	}
	
	public static List<Integer> getGrayCode(int n) {
		List<Integer> result = new ArrayList<>();
		List<String> resultAsBin = computeGrayCodeHelper(n);
		System.out.println(resultAsBin);
		
		for (String bin : resultAsBin) {
			result.add(Integer.parseInt(bin, 2));
		}
		
		return result;
	}
	
	public static List<String> computeGrayCodeHelper(int n) {
		List<String> result = new ArrayList<>();
		
		if (n == 1) {
			result.add("0");
			result.add("1");
			return result;
		}
		
		List<String> partialResult = computeGrayCodeHelper(n - 1);
		
		for (String s : partialResult) {
			result.add("0" + s);
		}
		
		for (int i = partialResult.size() - 1; i >=0; i--) {
			result.add("1" + partialResult.get(i));
		}
		return result;
	}
}


/*
0
1
0 0
0 1
1 1
1 0
0 0 0
0 0 1
0 1 1
0 1 0
1 1 0
1 1 1
1 0 1
1 0 0
0 0 0 0
0 0 0 1
0 0 1 1
0 0 1 0
0 1 1 0
0 1 1 1
0 1 0 1
0 1 0 0
1 1 0 0
1 1 0 1
1 1 1 1
1 1 1 0
1 0 1 0
1 0 1 1
1 0 0 1
1 0 0 0
*/