import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		double data[][] = new double[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Double cellVal = s.nextDouble();
				data[i][j] = cellVal;
			}
		}

		Matrix matrix = new Matrix(data);

		// find inverse
		matrix = matrix.inverse(matrix);

		String plainText = "";

		// step 2 reverse
		matrix = matrix.transpose(matrix);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				plainText += (char) (96 + Math.round(matrix.getValueAt(i, j)));
			}
		}

		char lastChar = plainText.charAt(plainText.length() - 1);

		Pattern p = Pattern.compile(lastChar + "+$");
		Matcher m = p.matcher(plainText); // get a matcher object
		m.find();

		int start = m.start();

		String result = "";

		if (start != plainText.length() - 1) {

			for (int i = start; i < plainText.length(); i++) {
				result += plainText.substring(0, i + 1) + " ";
			}
			System.out.print(result.substring(0, result.length() - 1));
		} else {
			System.out.print(plainText);
		}
	}

	private int rows;
	private int cols;
	private double[][] data;

	public Matrix(double[][] dat) {
		this.data = dat;
		this.rows = dat.length;
		this.cols = dat[0].length;
	}

	public Matrix(int nrow, int ncol) {
		this.rows = nrow;
		this.cols = ncol;
		data = new double[nrow][ncol];
	}

	public int getrows() {
		return rows;
	}

	public void setrows(int rows) {
		this.rows = rows;
	}

	public int getNcols() {
		return cols;
	}

	public void setNcols(int cols) {
		this.cols = cols;
	}

	public static Matrix transpose(Matrix matrix) {
		Matrix transposedMatrix = new Matrix(matrix.getNcols(), matrix.getrows());
		for (int i = 0; i < matrix.getrows(); i++) {
			for (int j = 0; j < matrix.getNcols(); j++) {
				transposedMatrix.setValueAt(j, i, matrix.getValueAt(i, j));
			}
		}
		return transposedMatrix;
	}

	public static Matrix inverse(Matrix matrix) {
		return (transpose(cofactor(matrix)).constantMultiply(1.0 / determinant(matrix)));
	}

	public Matrix constantMultiply(double constant) {
		Matrix mat = new Matrix(rows, cols);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				mat.setValueAt(i, j, data[i][j] * constant);
			}
		}
		return mat;
	}

	public static Matrix createSubMat(Matrix matrix, int excluding_row, int excluding_col) {
		Matrix mat = new Matrix(matrix.getrows() - 1, matrix.getNcols() - 1);
		int r = -1;
		for (int i = 0; i < matrix.getrows(); i++) {
			if (i == excluding_row)
				continue;
			r++;
			int c = -1;
			for (int j = 0; j < matrix.getNcols(); j++) {
				if (j == excluding_col)
					continue;
				mat.setValueAt(r, ++c, matrix.getValueAt(i, j));
			}
		}
		return mat;
	}

	public double getValueAt(int row, int col) {
		return data[row][col];
	}

	public void setValueAt(int row, int col, double value) {
		data[row][col] = value;
	}

	private static int changeSign(int i) {
		if (i % 2 == 0)
			return 1;
		return -1;
	}

	public static Matrix cofactor(Matrix matrix) {
		Matrix mat = new Matrix(matrix.getrows(), matrix.getNcols());
		for (int i = 0; i < matrix.getrows(); i++) {
			for (int j = 0; j < matrix.getNcols(); j++) {
				mat.setValueAt(i, j, changeSign(i) * changeSign(j) * determinant(createSubMat(matrix, i, j)));
			}
		}

		return mat;
	}

	public int size() {
		if (isSquare())
			return rows;
		return -1;
	}

	public static double determinant(Matrix matrix) {
		if (!matrix.isSquare())
			System.out.println("Not a square matrix");
		if (matrix.size() == 1) {
			return matrix.getValueAt(0, 0);
		}

		if (matrix.size() == 2) {
			return (matrix.getValueAt(0, 0) * matrix.getValueAt(1, 1))
					- (matrix.getValueAt(0, 1) * matrix.getValueAt(1, 0));
		}
		double sum = 0.0;
		for (int i = 0; i < matrix.getNcols(); i++) {
			sum += changeSign(i) * matrix.getValueAt(0, i) * determinant(createSubMat(matrix, 0, i));
		}
		return sum;
	}

	public boolean isSquare() {
		return rows == cols;
	}

}