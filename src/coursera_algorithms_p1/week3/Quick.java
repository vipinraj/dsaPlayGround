package week3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Quick {

    // get kth smallest element
    public static Comparable select(Comparable[] a, int k) {
        k--;
        int hi = a.length - 1;
        int lo = 0;

        while (hi > lo) {
            int i = partition(a, lo, hi);

            if (i == k) {
                return a[i];
            } else if (i > k) {
                hi = i - 1;
            } else {
                lo = i + 1;
            }
        }

        return a[k];
    }


    private static void sort(Comparable[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        int i = partition(a, start, end);
        System.out.println(i);
        sort(a, start, i - 1);
        sort(a, i + 1, end);
    }

    private static int partition(Comparable[] a, int start, int end) {
        int lo = start + 1;
        int hi = end;

        while (lo <= hi) {
            while (lessOrEqual(a[lo], a[start])) {
                lo++;

                if (lo > end) {
                    break;
                }
            }

            while (lessOrEqual(a[start], a[hi])) {
                hi--;

                if (hi < start + 1) {
                    break;
                }
            }

            if (lo >= hi) {
                break;
            }

            exch(a, lo, hi);

        }

        exch(a, start, hi);
        return hi;
    }

    private static void exch(Comparable[] a, int lo, int hi) {
        Comparable l = a[lo];
        a[lo] = a[hi];
        a[hi] = l;
    }

    private static boolean lessOrEqual(Comparable a, Comparable b) {
        // Note: used <= here
        return a.compareTo(b) <= 0;
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
    public static void main(String[] args) {
        String[] items = "Z, Y, X, W, A, V, U, A, T, S, S, R, Q, P, O, N, M, L, K, J, I, H, G, F, E, D, C, B, A".split(", ");
        Quick.sort(items);

        System.out.println(Arrays.toString(items));

        Integer[] nums = { 10, 11, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

        System.out.println(select(nums, 11));
    }
}

// 3, 2, 1
// 2, 1, 3
// hi = 1
// lo = 1
// 1, 2, 3
