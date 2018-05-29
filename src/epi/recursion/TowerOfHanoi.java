package epi.recursion;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;

public class TowerOfHanoi {
	private static final int NUM_PEGS = 3;

	public static void main(String[] args) {
		computeTowerOfHanoi(3);
	}

	public static void computeTowerOfHanoi(int numRings) {
		List<Deque<Integer>> pegs = new ArrayList<>();

		for (int i = 0; i < NUM_PEGS; i++) {
			pegs.add(new LinkedList<Integer>());
		}

		for (int i = 0; i < numRings; i++) {
			pegs.get(0).addFirst(i);
		}

		computeSteps(numRings, pegs, 0, 1, 2);
	}

	public static void computeSteps(int nums, List<Deque<Integer>> pegs, int from, int to, int use) {
		
		if (nums > 0) {
			computeSteps(nums - 1, pegs, from, use, to);
			pegs.get(to).addFirst(pegs.get(from).removeFirst());
			System.out.println(from + " -> " + to);
			computeSteps(nums - 1, pegs, use, to, from);
		}
	}
}