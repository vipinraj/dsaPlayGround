package week3;

import java.util.Arrays;

public class DijksrtaQuick {

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        // 3 way partition(Dutch national flag)
        int lt = lo;
        int gt = hi;
        int i = lo;
        Comparable p = a[lo];

        while (i <= gt) {
            int c = a[i].compareTo(p);
            if (c > 0) {
                exch(a, gt--, i);
            } else if (c < 0) {
                exch(a, lt++, i++);
            } else {
                i++;
            }
        }

        sort(a, lo, --lt);
        sort(a, ++gt, hi);
    }

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void exch(Comparable[] a, int lo, int hi) {
        Comparable l = a[lo];
        a[lo] = a[hi];
        a[hi] = l;
    }

    public static void main(String[] args) {
        String[] items = "Z, Y, X, W, A, V, U, A, T, S, S, R, Q, P, O, N, M, L, K, J, I, H, G, F, E, D, C, B, A".split(", ");
        DijksrtaQuick.sort(items);

        System.out.println(Arrays.toString(items));
    }
}


// 1 2 0 1 0 2 0 1 1

// 0 1 1 1 0 2 0 1 2
// l       i       g