package epi.bst;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class KSmallestABSqrt {
	public static void main (String[] args) {
		System.out.println(getSmallestNumbers(10));
		System.out.println(getSmallestNumbersMehod2(10));
	}

	public static List<Double> getSmallestNumbers(int k) {
		List<Double> result = new ArrayList<>();

		NavigableSet<ABSqrt2> bst = new TreeSet<>();
		bst.add(new ABSqrt2(0,0));

		while (result.size() < k) {
		    ABSqrt2 smallest = bst.pollFirst();
			result.add(smallest.value);
			bst.add(new ABSqrt2(smallest.a + 1, smallest.b));
			bst.add(new ABSqrt2(smallest.a, smallest.b + 1));
		}
		return result;
	}

	// O(n) without BST
	public static List<Double> getSmallestNumbersMehod2(int k) {
		int j = 0;
		int i = 0;
		final double SQRT2 = Math.sqrt(2);
		List<Double> result = new ArrayList<>();
		result.add(0.0);

		while (result.size() < k) {
			if (result.get(i) + 1 < result.get(j) + SQRT2) {
				result.add(result.get(i) + 1);
				i++;
			} else if (result.get(i) + 1 > result.get(j) + SQRT2) {
				result.add(result.get(j) + SQRT2);
				j++;
			} else {
				result.add(result.get(j) + SQRT2);
				i++;
				j++;
			}
		}
		return result;
	}
}

class ABSqrt2 implements Comparable<ABSqrt2> {
	int a;
	int b;
	double value;

	public ABSqrt2(int a, int b) {
		this.a = a;
		this.b = b;
		this.value = a + b * (Math.sqrt(2));
	}

	@Override
	public int compareTo(ABSqrt2 that) {
		return Double.compare(this.value, that.value);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		ABSqrt2 that = (ABSqrt2)o;
		return that.a == this.a && that.b == this.b;
	}

}