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
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double[] experiments;
    private double confidenceFraction;
    private double mean;
    private double stddev;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }

        experiments = new double[trials];
        Percolation percolation;

        for(int i = 0; i < trials; i++) {
            percolation = new Percolation(n);
            int noOfOpenSites = 0;

            while(!percolation.percolates()) {
                int row;
                int col;

                do {
                    row = StdRandom.uniform(n) + 1;
                    col = StdRandom.uniform(n) + 1;
                } while(percolation.isOpen(row, col));

                percolation.open(row, col);
                noOfOpenSites++;
            }

            experiments[i] = noOfOpenSites / Math.pow(n, 2);
        }

        confidenceFraction = (1.96 * stddev()) / Math.sqrt(trials);
    }

    public double mean() {
        if (mean == 0.0d) {
            mean = StdStats.mean(experiments);
        }
        return mean;
    }

    public double stddev() {
        if (stddev == 0.0d) {
            stddev = StdStats.stddev(experiments);
        }
        return stddev;
    }

    public double confidenceLo() {
        return mean() - confidenceFraction;
    }

    public double confidenceHi() {
        return mean() + confidenceFraction;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        PercolationStats stats = new PercolationStats(N, T);
        System.out.println("mean                    = " + stats.mean());
        System.out.println("stddev                  = " + stats.stddev());
        System.out.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");

    }
}
