package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindromia {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		Integer N = Integer.parseInt(line[0]);
		Integer L = Integer.parseInt(line[1]);
		int count = 0;
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			if(isPalindrome(name)){
				count ++;
			}else if(canConvertToPalindrom(name)){
				count ++;
			}
		}
		//System.out.println(7 / 2);
		System.out.println(count);
	}

	public static boolean canConvertToPalindrom(String name) {
		int i1 = 2, i2 = 0;

		for (i1 = 0; i1 <= name.length(); i1++) {
			for (i2 = i1; i2 + i1 <= name.length(); i2++) {
				if (i1 <= 1 && i2 <= 1) {
					continue;
				}
				if (checkPalindrome(name, i1, i2)) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean checkPalindrome(String name, int i1, int i2) {

		for (int i = 0; i + i1 < name.length(); i++) {
			for (int j = i + i1; j + i2 < name.length(); j++) {
				// System.out.println("substring 1: (" + i + "," + (i + i1) + ")
				// Substring 2 : (" + j + "," + (j + i2));
				String newString, p1 = "", p2 = "", p3 = "", p4 = "", p5 = "";
				if (i > 0) {
					p1 = name.substring(0, i);
				}
				p2 = new StringBuffer(name.substring(i, (i + i1))).reverse().toString();
				if ((j - (i + i1)) > 0) {
					p3 = name.substring((i + i1), j);
				}
				p4 = new StringBuffer(name.substring(j, j + i2)).reverse().toString();
				if ((j + i2) <= name.length()) {
					p5 = name.substring(j + i2, name.length());
				}
				newString = p1 + p2 + p3 + p4 + p5;
				//System.out.println(newString);
				if (isPalindrome(newString)) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean isPalindrome(String str) {
		String p1, p2;
		if (str.length() == 1) {
			return true;
		}
		if (str.length() % 2 == 0) {
			p1 = str.substring(0, str.length() / 2);
			p2 = new StringBuffer(str.substring(str.length() / 2, str.length())).reverse().toString();
		} else {
			p1 = str.substring(0, str.length() / 2);
			p2 = new StringBuffer(str.substring(str.length() / 2 + 1, str.length())).reverse().toString();
		}
		if (p1.equals(p2)) {
			return true;
		} else {
			return false;
		}
	}

}
