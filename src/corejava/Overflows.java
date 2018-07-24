public class Overflows {
	public static void main(String[] args) {
		int a = Integer.MAX_VALUE + 1;
		System.out.println(a);
		long b = Integer.MAX_VALUE + 1;
		System.out.println(b);
		b = Integer.MAX_VALUE + (long)1; // type promotion int->long
		System.out.println(b);

		printBin(16);
	}

	public static void printBin(int num) {
		while (num != 0) {
			System.out.println(num & 1);
			num = num >> 1;
		}
	}
}

