// 6.2
package epi.arrays;

public class IncrementInteger {
	public static void main(String[] args) {
		int[] num = {1, 2, 3, 9, 9, 8, 7, 9, 9};

		increment(num);

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + ", ");
		}
	}

	// overflow is not handled ({9,9,9} will result in {0,0,0})
	public static void increment(int[] num) {
		int size = num.length - 1;

		int i  = size;
		int carryOut = 0;
		while (i >= 0) {
			if (num[i] == 9) {
				num[i] = 0;
				carryOut = 1;
				i--;
			} else {
				num[i] = num[i] + carryOut;
				break;
			}
		}
	}
}