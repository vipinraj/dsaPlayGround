package hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class TestClass {

	private final static Random rand = new Random();

	public static void main(String args[]) throws Exception {
		/*
		 * Read input from stdin and provide input before running
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			int size = Integer.parseInt(br.readLine());

			List<Integer> primes = new ArrayList<Integer>();
			String[] items = br.readLine().split(" ");
			for (String string : items) {
				if(checkPrime(BigInteger.valueOf(Long.parseLong(string)), 20)){
					primes.add(Integer.parseInt(string));
				}
			}
			if(!primes.isEmpty()){
				Collections.sort(primes);
				int largestPrime = primes.get(primes.size()-1 );
				System.out.println(largestPrime*largestPrime);
			}else{
				System.out.println("-1");
			}
		}		
	}

	private static BigInteger getRandomFermatBase(BigInteger n) {
		while (true) {
			final BigInteger a = new BigInteger(n.bitLength(), rand);
			if (BigInteger.ONE.compareTo(a) <= 0 && a.compareTo(n) < 0) {
				return a;
			}
		}
	}

	public static boolean checkPrime(BigInteger n, int maxIterations) {
		if (n.equals(BigInteger.ONE))
			return false;

		for (int i = 0; i < maxIterations; i++) {
			BigInteger a = getRandomFermatBase(n);
			a = a.modPow(n.subtract(BigInteger.ONE), n);

			if (!a.equals(BigInteger.ONE))
				return false;
		}

		return true;
	}
}
