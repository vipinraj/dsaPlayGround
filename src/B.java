import java.math.BigInteger;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String str = s.nextLine();

		String[] numbers = str.split(" ");

		int n = Integer.parseInt(numbers[0]);
		int k = Integer.parseInt(numbers[1]);
		
		BigInteger sum = BigInteger.ZERO;
		
		for(int i=0; i<=k; i++){
			
			if(i % 2 == 0){
				sum = sum.add(getBinomial(n, i));
			}						
		}
		
		System.out.println(sum.mod(new BigInteger("1000000007")));

	}

	static BigInteger getBinomial(final int n, final int k) {
		BigInteger result = BigInteger.ONE;
		for (int i = 0; i < k; i++) {
			result = result.multiply(BigInteger.valueOf(n - i)).divide(BigInteger.valueOf(i + 1));
		}
		return result;
	}

}
