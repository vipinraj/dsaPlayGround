package week1;/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final WeightedQuickUnionUF unionFinder;
    private boolean[] isOpen;
    private final int N;
    private final int totalSites;
    private int openSites;

    private int[] getOpenNeighbours(int row, int col) {
        // 0 - top
        // 1 - bottom
        // 2 - left
        // 3 - right
        int[] result = {-1, -1, -1, -1};
        int num = getSiteNumber(row, col);

        int topSite = Math.max(num - N, 0);
        result[0] = isOpen[topSite] ? topSite : -1;

        int bottomSite = num + N;
        if (bottomSite <= totalSites - 1) {
            result[1] = isOpen[bottomSite] ? bottomSite : -1;
        }

        if (col > 1) {
            result[2] = isOpen[num - 1] ? num - 1 : -1;
        }

        if (col < N) {
            result[3] = isOpen[num + 1] ? num + 1 : -1;
        }

        return result;
    }

    private int getSiteNumber(int row, int col) {
        return (row - 1) * N + col;
    }

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
          throw new IllegalArgumentException();
        }

        N = n;
        totalSites = n * n + 1;
        unionFinder = new WeightedQuickUnionUF(totalSites);
        isOpen = new boolean[totalSites];
        // open virtual sites
        isOpen[0] = true;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row <= 0 || col <= 0 || row > N || col > N) {
            throw new IllegalArgumentException();
        }

        int siteNum = getSiteNumber(row, col);
        if (isOpen[siteNum]) {
            return;
        } else {
           isOpen[siteNum] = true;
            openSites++;
        }

        int[] openNeighbours = getOpenNeighbours(row, col);

        for (int i = 0; i < 4; i ++) {
            if (openNeighbours[i] >= 0) {
                unionFinder.union(siteNum, openNeighbours[i]);
                // System.out.println("Connecting " + siteNum + " & " + openNeighbours[i]);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row <= 0 || col <= 0 || row > N || col > N) {
            throw new IllegalArgumentException();
        }

        return isOpen[getSiteNumber(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row <= 0 || col <= 0 || row > N || col > N) {
            throw new IllegalArgumentException();
        }

        if (!unionFinder.connected(getSiteNumber(row, col), 0)) {
            return false;
        }

        // for (int i = totalSites - 1; i >= totalSites - N; i--) {
        //
        //     if (isOpen[i] && unionFinder.connected(getSiteNumber(row, col), i)) {
        //         return true;
        //     }
        // }

        return true;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        for (int i = totalSites - 1; i >= totalSites - N; i--) {
            if (unionFinder.connected(0, i)) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        In in = new In("input3.txt");
        int n = in.readInt();
        Percolation percolation = new Percolation(n);


        while (!in.isEmpty()) {
            int row = in.readInt();
            int col = in.readInt();
            percolation.open(row, col);
        }

        for(int i = 0; i < percolation.totalSites; i++) {
            System.out.print(percolation.isOpen[i] + ", ");
        }

        System.out.println(percolation.isFull(1, 1));
    }
}
