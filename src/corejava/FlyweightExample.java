package corejava;

public class FlyweightExample {
	public static void main(String[] args) {
		Integer a = Integer.valueOf(56);
		Integer b = Integer.valueOf(56);
		System.out.println(a==b);
		Integer c = 56;
		Integer d = new Integer(56);
		System.out.println(a == c);
		System.out.println(a == d );
	}
}