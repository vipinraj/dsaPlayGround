import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class G {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();

		int A = Integer.parseInt("" + str1.charAt(str1.length() - 1));

		String B = str1.split("\\|\\|")[1];
		B = B.substring(0, B.length() - 1);

	//	System.out.println(B);

		String C = str1.split("\\|\\|")[0];

		int[] bArrayInt = new int[B.length()];

		for (int i = 0; i < B.length(); i++) {
			bArrayInt[i] = Integer.parseInt("" + B.charAt(i));
			// System.out.println(bArrayInt[i]);
		}

		String[] cArray = C.split("\\|");

		List<String> passwordDigitsWithAllPositions = new ArrayList<>();
		List<String> passwordDigitsithFirstPosition = new ArrayList<>();

		int additional = 0;
		for (String item : cArray) {

			if (item.length() > 1) {
				passwordDigitsWithAllPositions.add(item);
				passwordDigitsithFirstPosition.add(item.substring(item.length() - 2, item.length()));
				if (item.length() > 2) {
					additional += item.length() - 1;
				}
			}
		}

		int[] passwordDigitsS4 = new int[passwordDigitsithFirstPosition.size() + additional - 1];

		for (String str : passwordDigitsWithAllPositions) {
			for (int i = 0; i < str.length() - 1; i++) {
				passwordDigitsS4[Integer.parseInt(str.charAt(i) + "")] = Integer
						.parseInt(str.charAt(str.length() - 1) + "");
			}
		}

		for (int i = 0; i < passwordDigitsS4.length; i++) {
			for (int j = 0; j < bArrayInt.length; j++) {
				if(i == bArrayInt[j]){
					passwordDigitsS4[i] += 10;
				}
			}			
		}

		passwordDigitsS4[passwordDigitsS4.length-1] -= A; 
		for(int i=passwordDigitsS4.length-2; i != -1; i--){
			passwordDigitsS4[i] -= passwordDigitsS4[i+1]; 
			//System.out.println(passwordDigitsS4[i]);
		}
		
		
		/*
		 * int l = 0; for (String i : passwordDigitsithFirstPosition) {
		 * passwordDigitsS4[l] = Integer.parseInt(i.charAt(1)+"");
		 * System.out.println(passwordDigitsS4[l]); l++;
		 * 
		 * }
		 */
		
		for(int i=0;i<passwordDigitsS4.length; i++){
			System.out.print(str2.charAt(passwordDigitsS4[i]));
		}
		
		//System.out.println(str1 + "   " + str2);
	}
}
