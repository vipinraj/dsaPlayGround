// 16.2
package epi.recursion;
import java.util.List;
import java.util.ArrayList;

public class NQueens {
	public static void main(String[] args) {
		List<List<Integer>> result = getNQueensPlacements(4);
		System.out.println(result);

	}

	public static List<List<Integer>> getNQueensPlacements(int n) {
		List<List<Integer>> result = new ArrayList<>();

		solveNQueens(n, result, 0, new ArrayList<Integer>() );

		return result;
	}

	public static void solveNQueens(int n, List<List<Integer>> result, int rowIndx, List<Integer> colPlacements) {
		if (rowIndx == n) {
			result.add(new ArrayList(colPlacements));
		} else {
			for (int colIndx = 0; colIndx < n; colIndx++) {
				colPlacements.add(colIndx);

				if (isValid(colPlacements)) {
					solveNQueens(n, result, rowIndx + 1, colPlacements);
				}

				colPlacements.remove(colPlacements.size() - 1);
			}
		}
	}

	public static boolean isValid(List<Integer> colPlacements) {
		int lastPlacedRowIndx = colPlacements.size() - 1;

		// check each row is not conflicting with last (placed) row
		for (int rowIndx = 0; rowIndx < lastPlacedRowIndx; rowIndx++) {
			int diff = Math.abs(colPlacements.get(rowIndx) - colPlacements.get(lastPlacedRowIndx));
			if (diff == 0 || diff == lastPlacedRowIndx - rowIndx) {
				return false;
			}
		}

		return true;
	}
}