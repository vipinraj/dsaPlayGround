/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

package week3;

import java.util.Arrays;

public class MergeBottomUp {
    private static void merge(Comparable[] items, Comparable[] copy, int i, int j, int mid) {
        for(int m = i; m <= j; m++) {
            copy[m] = items[m];
        }

        int first = i;
        int second = mid+1;
        int merged = i;


        for (int m = i; m <= j; m++) {
            if (first > mid) {
                items[merged++] = copy[second++];
            } else if (second > j) {
                items[merged++] = copy[first++];
            } else if (less(copy[second], copy[first])) {
                items[merged++] = copy[second++];
            } else {
                items[merged++] = copy[first++];
            }
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void sort(Comparable[] items) {

        Comparable[] copy = new Comparable[items.length];

        for (int j = 2; j < items.length; j = j + j ) {
            for (int i = 0; i < items.length; i = i + j) {
                int k = Math.min(i + j, items.length - 1);
                int mid = i + (k - i) / 2;
                merge(items, copy, i, k, mid);
            }
        }

    }

    public static void main(String[] args) {
        String[] items = "Z, Y, Z, X, W, W, V, U, T, S, R, Q, P, O, N, M, L, A, K, J, I, H, G, F, E, D, C, B, A, A".split(", ");
        MergeBottomUp.sort(items);

        System.out.println(Arrays.toString(items));
    }
}
