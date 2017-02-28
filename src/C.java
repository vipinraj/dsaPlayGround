import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class C {
	public static void main(String args[]) {

		try {
			Stack<Character> stack = new Stack<Character>();

			String str = "{:[{},{}]}";

			HashMap<String, List<String>> allowedChars = new HashMap<String, List<String>>();

			List<String> list1 = new ArrayList<String>();
			list1.add(":");
			list1.add("[");
			list1.add(",");
			allowedChars.put("{", list1);
			List<String> list2 = new ArrayList<String>();
			list2.add("{");
			list2.add("]");
			list2.add(":");
			allowedChars.put("}", list2);
			List<String> list3 = new ArrayList<String>();
			list3.add(":");
			allowedChars.put("[", list3);
			List<String> list4 = new ArrayList<String>();
			list4.add("}");
			allowedChars.put("]", list4);
			List<String> list5 = new ArrayList<String>();
			list5.add("{");
			allowedChars.put(":", list5);
			List<String> list6 = new ArrayList<String>();
			list6.add(":");
			list6.add("}");
			allowedChars.put(",", list6);

			if (str.charAt(0) != '{' || str.charAt(str.length() - 1) != '}') {
				System.out.println("-1");
				return;
			}

			Character currentChar = null;
			Character prevChar = '{';

			stack.push('{');

			for (int i = 1; i < str.length(); i++) {
				currentChar = str.charAt(i);
				System.out.println(currentChar);
				Boolean valid = false;
				for (String s : allowedChars.get(currentChar+"")) {
					if (prevChar.equals(s)) {
						valid = true;
					}
				}
				if (!valid) {
					System.out.println("-1");
					return;
				}
				prevChar = currentChar;

				if (!currentChar.equals(":") && !currentChar.equals(",")) {
					stack.push(currentChar);
				}
			}
			Stack<Character> stack2 = new Stack<>();
			for (int i = 0; i < stack.size(); i++) {
				Character ch = stack.pop();
				if(ch != '}' && ch != ']'){
					stack2.push(ch);
				}else{
					stack2.pop();
				}
			}
			
			if(stack2.isEmpty()){
				System.out.println("1");
			}else{
				System.out.println("-1");
			}
			
		} catch (Exception e) {
			System.out.println("-1");
			e.printStackTrace();
		}
	}
}
