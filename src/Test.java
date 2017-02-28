
public class Test {

	public static void main(String[] args) {

		/* Problem 1. Find the sum of all the multiples of 3 or 5 below 1000. */

		/* Solution 1 - brute force */

		int sum = 0;
		for (int i = 1; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);

		/* Solution 2 */
		int target = 999;
		
		System.out.println(sumDivisibleBy(5, target) + sumDivisibleBy(3, target) - sumDivisibleBy(15, target));

	}

	public static int sumDivisibleBy(int n, int target) {

		int p = target / n;

		return n * p * (p + 1) / 2;
	}

}
