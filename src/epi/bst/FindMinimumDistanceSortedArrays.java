package epi.bst;
import java.util.List;
import java.util.ArrayList;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.SortedSet;
import java.util.Arrays;
import java.util.Objects;

public class FindMinimumDistanceSortedArrays {
	public static void main(String[] args) {
		List<List<Integer>> sortedArrays = new ArrayList<>();
		sortedArrays.add(Arrays.asList(5,10,15));
		sortedArrays.add(Arrays.asList(3,6,9,12,15));
		sortedArrays.add(Arrays.asList(8,16,24));

		System.out.println(findMinimumDistance(sortedArrays));
	}

	public static int findMinimumDistance(List<List<Integer>> sortedArrays) {
		int result = Integer.MAX_VALUE;
		List<Integer> heads = new ArrayList<>();
		NavigableSet<ArrayData> currentHeads = new TreeSet<>(); 

		for (int i = 0; i < sortedArrays.size(); i++) {
			heads.add(0);
		}

		for (int i = 0; i < sortedArrays.size(); i++) {
			currentHeads.add(new ArrayData(i, sortedArrays.get(i).get(heads.get(i))));
		}

		while (true) {
			result = Math.min(result, currentHeads.last().data - currentHeads.first().data);
			int idxNextMin = currentHeads.first().index;
			heads.set(idxNextMin, heads.get(idxNextMin) + 1);

			if (heads.get(idxNextMin) >= sortedArrays.get(idxNextMin).size()) {
				return result;
			}

			currentHeads.pollFirst();
			currentHeads.add(new ArrayData(idxNextMin, sortedArrays.get(idxNextMin).get(heads.get(idxNextMin))));
		}
	}
}

class ArrayData implements Comparable<ArrayData> {
	int index; // array index 
	int data;

	ArrayData(int index, int data) {
		this.index = index;
		this.data = data;
	}

	@Override
	public int compareTo(ArrayData that) {
		int result = Integer.compare(this.data, that.data);

		if (result == 0) {
			result = Integer.compare(this.index, that.index);
		}

		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof ArrayData)) {
			return false;
		}

		ArrayData that = (ArrayData)o;

		return that.data == this.data && that.index == this.index;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, index);
	}
}