// 16.9
package epi.recursion;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

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
								
	   int[][] result = solveSudoku(inputSudoku);
	   print(result);
	}

	public static int[][] solveSudoku(int[][] input) {
		int[][] solution = input.clone();
		
		if (solveSudokuHelper(input, solution, new Cell(0, 0))) {
		    return solution;
		}
		return null;
	}

	public static boolean solveSudokuHelper(int[][] input, int[][] solution, Cell c) {

		Cell nextEmptyCell = findNextEmptyCell(c, input);

		if (nextEmptyCell != null) {
			int i = nextEmptyCell.i;
			int j = nextEmptyCell.j;
			
			Integer[] allowedValues = getAllowedValues(solution, i, j);
			
			for (int l = 0; l < allowedValues.length; l++) {
			    solution[i][j] = allowedValues[l];
			    if (solveSudokuHelper(input, solution, nextEmptyCell)) {
			        return true;
			    } else {
			        solution[i][j] = 0;
			    }
			}
			return false;
		}
        return true;
	}

	public static Integer[] getAllowedValues(int[][] solution, int i, int j) {
		Set<Integer> values = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

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
		int iStart = (i / 3) * 3;
		int jStart = (j / 3) * 3;
		
		for (int l = iStart; l < iStart + 3; l++ ) {
		    for (int m = jStart; m < jStart + 3; m++) {
		        values.remove(solution[l][m]);
		    }
		}
		
		Integer[] result = new Integer[values.size()];
		
		values.toArray(result);
        
        return result;
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
	}

    public static void print(int[][] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print( arr[i][j] + " ");
            }
            System.out.println();
        }
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