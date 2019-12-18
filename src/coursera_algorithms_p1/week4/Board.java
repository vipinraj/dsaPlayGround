package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private Integer hamming;
    private Integer manhattan;
    private final int[][] tiles;
    private Integer[] indexOfZero;

    public Board(int[][] tiles) {
        this.tiles = tiles.clone();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(Integer.toString(this.tiles.length));
        stringBuilder.append('\n');

        for(int[] row : tiles) {
            String rowAsStr = Arrays.stream(row)
                                    .mapToObj(String::valueOf)
                                    .collect(Collectors.joining("\t"));
            stringBuilder.append(rowAsStr);
            stringBuilder.append('\n');
        }

        return stringBuilder.toString();
    }

    public int dimension() {
        return tiles.length;
    }

    public int hamming() {
        if (this.hamming == null) {
            int t = 1;
            hamming = 0;

            for (int i = 0; i < tiles.length; i++) {
                for (int j = 0; j < tiles[i].length; j++) {
                    if (t++ != tiles[i][j] && tiles[i][j] != 0) {
                        hamming++;
                    }
                }
            }
        }

        return hamming;
    }

    public int manhattan() {

        if (manhattan == null) {
            manhattan = 0;

            for (int i = 0; i < tiles.length; i++) {
                for (int j = 0; j < tiles[i].length; j++) {
                    if (tiles[i][j] == 0) {
                        continue;
                    }

                    int[] targetIndex = getIndex(tiles[i][j]);
                    manhattan += Math.abs(i - targetIndex[0]) +
                            Math.abs(j - targetIndex[1]);
                }
            }
        }

        return manhattan;
    }

    // returns position of number in solved puzzle
    // [rowIndx, colIndx]
    private int[] getIndex(int number) {
        int rowIndx = (number - 1) / tiles.length;
        int colIndx = (number - 1) % tiles.length;
        return new int[] { rowIndx, colIndx };
    }

    public boolean isGoal() {
        int k = 1;
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles[i].length; j++) {
                if (tiles[i][j] != k++) {
                    if (i == tiles.length - 1 && j == tiles.length - 1) {
                        continue;
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public boolean equals(Object y) {

        if (y == null || y.getClass() != this.getClass()) {
            return false;
        }

        Board yBoard = (Board) y;

        if (this == yBoard || yBoard.toString().equals(this.toString())) {
            return true;
        }

        return false;
    }

    public int hashCode() {
        assert false: "Hash code not designed";
        return 43;
    }

    public Iterable<Board> neighbours() {
        List<Board> neighbours = new ArrayList<Board>();
        int[][] indexDeltas = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

        Integer[] indexOfZero = getIndexOfZero();

        for (int[] delta: indexDeltas) {
            int potentialI = delta[0] + indexOfZero[0];
            int potentialJ = delta[1] + indexOfZero[1];

            if (potentialI >= 0 && potentialI < tiles.length
                    && potentialJ >= 0 && potentialJ < tiles.length) {
                int[][] tilesCopy = deepCopy(this.tiles);
                exchange(tilesCopy, potentialI, potentialJ,
                         indexOfZero[0], indexOfZero[1]);
                neighbours.add(new Board(tilesCopy));
            }
        }

        return neighbours;
    }

    int[][] deepCopy(int[][] array) {
        return java.util.Arrays.stream(array).map(el -> el.clone()).toArray($ -> array.clone());
    }

    private void exchange(int[][] tilesCopy, int i1, int j1, int i2, int j2) {
        int temp = tilesCopy[i2][j2];
        tilesCopy[i2][j2] = tilesCopy[i1][j1];
        tilesCopy[i1][j1] = temp;
    }

    private Integer[] getIndexOfZero() {
        if (this.indexOfZero == null) {
            for (int i = 0; i < this.tiles.length; i++) {
                for (int j = 0; j < this.tiles[i].length; j++) {
                    if (this.tiles[i][j] == 0) {
                        this.indexOfZero = new Integer[] {i, j};
                        break;
                    }
                }
                if (this.indexOfZero != null) {
                    break;
                }
            }
        }

        return this.indexOfZero;
    }

    //
    // public Board twin() {
    //
    // }

    public static void main(String[] args) {
        Board b1 = new Board(new int[][] { {8, 1, 3}, {4,0,2}, {7,6,5}});
        Board b2 = new Board(new int[][] { {8, 1, 3}, {4,0,2}, {7,6,5}});
        Board b3 = new Board(new int[][] { {1, 0, 3}, {4,2,5}, {7,8,6}});
        System.out.println(b1.toString());
        System.out.println(b1.manhattan());
        System.out.println(b1.hamming());
        System.out.println(b1.equals(b1));
        System.out.println(b1.equals(b2));
        System.out.println(b1.equals(b3));
        b3.neighbours().forEach(item -> System.out.println(item));
    }
}
