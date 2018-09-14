package epi.greedy;

public class MaximumWaterTrapped {
	public static void main(String[] args) {
		int[] arr = {1, 2,1,3, 4, 4, 5, 6, 2, 1, 3, 1, 3, 2, 1, 2, 4, 1};
		System.out.println(maximumWaterTrapped(arr));
	}
	
	public static Pair maximumWaterTrapped(int[] heights) {
		Pair maxPair = new Pair();
		
		int i = 0;
		int j = heights.length - 1;
		
		while (i < j) {
			if ((j - i) * Math.min(heights[i], heights[j]) > 
				(maxPair.x2 - maxPair.x1) * (Math.min(heights[maxPair.x1], heights[maxPair.x2])) ) {
				maxPair.x1 = i;
				maxPair.x2 = j;
			}
			
			if (heights[i] == heights[j]) {
				i++;
				j--;
			} else if (heights[i] < heights[j]) {
				i++;
			} else {
				j--;
			}
		}
		
		return maxPair;
	}
	
	public static class Pair {
		int x1;
		int x2;
		
		public String toString() {
			return "[" + x1 + "," + x2 + "]";
		}
	}
}