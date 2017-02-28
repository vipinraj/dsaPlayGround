package question;

import java.util.HashMap;

/*
 * Fibonacci using Dynamic Programming, Memois
 */
public class Fibonacci {

	static HashMap<Integer, Integer> memo = new HashMap<>();

	public static void main(String[] args) {

		System.out.println(getFibonacci(25));

		System.out.println(getFibonacciBottomUp(25));

	}

	public static int getFibonacci(int n) {
		if (n <= 2) {
			return 1;
		}
		if (memo.containsKey(n)) {
			return memo.get(n);
		} else {
			int f = getFibonacci(n - 1) + getFibonacci(n - 2);
			memo.put(n, f);
			return f;
		}

	}

	public static int getFibonacciBottomUp(int n) {
		for (int i = 1; i <= n; i++) {
			int f;
			if (i <= 2) {
				f = 1;
			} else {
				f = memo.get(i - 1) + memo.get(i - 2);
			}
			memo.put(i, f);			
		}
		return memo.get(n);
	}
}
