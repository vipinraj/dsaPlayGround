import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

	List<Integer> fibNumbers  = new ArrayList<>();
	
	public static void main(String[] args) {
		
		int prevTerm1 = 1;
		int prevTerm2 = 1;
		int sum = 0;
		int term = 1;
		
		while(true){			
			
			term  = prevTerm1 + prevTerm2;
			prevTerm1 = prevTerm2;
			prevTerm2 = term;
			
			if(term > 4000000){
				break;
			}
			//System.out.println(term);
			if(term % 2 == 0){
				sum += term;
			}
						
		}
		
		System.out.println(sum);
	}
	
	/*int generateFibNumbers(int limit){
		
		if(fibNumbers.get(fibNumbers.size()-1) < limit){
			return generateFibNumbers(limit)
		}
		
	}*/

}
