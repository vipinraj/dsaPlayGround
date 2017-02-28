package corejava;

import java.util.function.Predicate;

public class IntegerPredicate {
	 public static Predicate<Integer> isGreaterThan(int lowerbound) {
		    return p -> 
		      p > lowerbound; 
		 }
}
