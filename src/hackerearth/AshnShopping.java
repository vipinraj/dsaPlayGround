package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class AshnShopping {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		BigInteger n = new BigInteger(line[0]);
				
		BigInteger k = new BigInteger(line[1]);

		BigInteger ways = BigInteger.ONE;

		for (BigInteger i = BigInteger.ONE; i.compareTo(n) == -1 || i.compareTo(n) == 0 ; i = i.add(BigInteger.ONE)) {
			if (i.mod(k).compareTo(BigInteger.ZERO) == 0) {
				//System.out.println("Inside if: n="+n+"i="+i);
				/*System.out.println("ways = " + ways);
				System.out.println(findNchooseK(n, i));*/
				ways = ways.add(findNchooseK(n, i));
				/*System.out.println("ways = " + ways);*/
			}
		}
		
		//System.out.println(ways);
				
		String waysStr = ways.toString(10);
		
		/*System.out.println(findNchooseK(3, 2));*/
		
		if (waysStr.length() > 5) {
			waysStr = waysStr.substring(waysStr.length()-5, waysStr.length());
		}
		
		System.out.println(Integer.parseInt(waysStr));
	}

	private static BigInteger findNchooseK(BigInteger n, BigInteger i) {
		BigInteger result = BigInteger.ZERO;
		//System.out.println("n=" + n + "c=" + i);
		
		//System.out.println(factorial(n) );
		
		result = result.add(factorial(n).divide(factorial(i).multiply(factorial(n.subtract(i)))))  ;

		return result;
	}

	private static BigInteger factorial(BigInteger i) {

		BigInteger result = BigInteger.ONE;
		for (BigInteger j = BigInteger.ONE; j.compareTo(i) == -1 || j.compareTo(i) == 0 ; j = j.add(BigInteger.ONE)) {
			result = result.multiply(j);
		}

		return result;
	}

}
