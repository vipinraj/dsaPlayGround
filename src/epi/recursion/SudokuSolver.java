public class SudokuSolver {
	public static void main(String[] args) {
		int[][] inputSudoku = 	{
									{ 5, 3, 0, 0, 7, 0, 0, 0, 0 },
									{ 6, 0, 0, 1, 9, 5, 0, 0, 0 },
									{ 0, 9, 8, 0, 0, 0, 0, 6, 0 },
									{ 8, 0, 0, 0, 6, 0, 0, 0, 3 },
									{ 4, 0, 0, 8, 0, 3, 0, 0, 1 },
									{ 7, 0, 0, 0, 2, 0, 0, 0, 6 },
									{ 0, 6, 0, 0, 0, 0, 2, 8, 0 },
									{ 0, 0, 0, 4, 1, 9, 0, 0, 5 },
									{ 0, 0, 0, 0, 8, 0, 0, 7, 9 }
								};
	}

	public static int[][] solveSudoku(int[][] input) {
		int[][] solution = input.clone();
		solveSudokuHelper(input, solution, new Cell(0, 0));
	}

	public static boolean solveSudokuHelper(int[][] input, int[][] solution, Cell c) {

		Cell nextEmptyCell = findNextEmptyCell(c, input);

		if (nextEmptyCell != null) {
			int i = nextEmptyCell.i;
			int j = nextEmptyCell.j;
		}

	}

	public static int[] getAllowedValues(int[][] solution, int i, int j) {
		Set<Integer> values = new HashSet(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

		// row
		for (int l = 0; l < 9; l++) {
			values.remove(solution[i][l]);
		}

		// col
		for (int l = 0; l < 9; l++) {
			values.remove(solution[l][j]);
		}

		// 3x3 array
		// 0, 1, 2, 3, 4, 5, 6, 7, 8
		int iStart = (((i + 1) / 3) - 1) * 3;

	}

	// including c
	public static Cell findNextEmptyCell(Cell c, int[][] arr) {
		int i = c.i;
		int j = c.j;
		
		while (true) {
			if (arr[i][j] == 0) {
				return new Cell(i, j);
			}

			if (j < 8) {
				j++;
			} else {
				j = 0;
				i++;
			}

			if (i > 8) {
				return null;
			}

		}
		return null;
	}

	public static class Cell {
		int i;
		int j;

		Cell(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}