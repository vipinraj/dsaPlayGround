package question;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fun2(8);
	}
	
	private static void fun2(int n){
		if(n==0)
			return;
		fun2(n/2);
		System.out.println(n%2);
	}

}
