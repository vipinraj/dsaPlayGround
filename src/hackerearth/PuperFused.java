package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PuperFused {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int n = Integer.parseInt(line);

		for (int i = 0; i < n; i++) {
			String[] range = br.readLine().split(" ");
			BigInteger l = new BigInteger(range[0]);
			BigInteger r = new BigInteger(range[1]);

			BigInteger lastDigit = BigInteger.ZERO;
			if ((r.subtract(l)).mod(BigInteger.valueOf(2)) == BigInteger.ZERO) {
				lastDigit = r.multiply(r);
				lastDigit = lastDigit.add(BigInteger.ONE);
			}
			BigInteger sum = BigInteger.ZERO;

			BigInteger num = r.subtract(l).add(BigInteger.ONE).divide(new BigInteger("2"));
			Integer powOf2 = 0;

			// num*2n* + num/2(2*1+ (num-1)*4)
						
			
			System.out.println(
					num.multiply(BigInteger.valueOf(2)).multiply(l).add(num.divide(BigInteger.valueOf(2)).multiply(
							BigInteger.valueOf(2).add(num.subtract(BigInteger.ONE).multiply(BigInteger.valueOf(4))))).add(lastDigit));

			/*while (num != BigInteger.ZERO) {
				sum = sum.add(l.multiply(BigInteger.valueOf(2)).add(new BigInteger("2").pow(powOf2)));

				num = num.subtract(BigInteger.ONE);
				powOf2 = powOf2 + 2;
			}*/

			/*
			 * List<BigInteger> numbers = new ArrayList<>();
			 * 
			 * BigInteger k = l;
			 * 
			 * //System.out.println("l" +l);
			 * 
			 * for(int j = 0; j < r.subtract(l).add(BigInteger.ONE).intValue() ;
			 * j++){ numbers.add(k); k = k.add(BigInteger.ONE); }
			 * //System.out.println("l" +l);
			 */

			/*
			 * //System.out.println("lastDigit = " + lastDigit);
			 * 
			 * 
			 * 
			 * if(lastDigit != BigInteger.ZERO){
			 * 
			 * //System.out.println("Not zero"); for(int c = 0; c <
			 * numbers.size() - 1 ; c = c+2){ sum =
			 * sum.add((numbers.get(c+1).pow(2)).subtract(numbers.get(c).pow(2))
			 * ); } sum = sum.add(lastDigit); }else{
			 * 
			 * for(int c = 0; c <= numbers.size() - 1 ; c = c+2){ sum =
			 * sum.add((numbers.get(c+1).pow(2)).subtract(numbers.get(c).pow(2))
			 * ); } }
			 */
/*			System.out.println(sum.add(lastDigit));
*/		}

	}

}
