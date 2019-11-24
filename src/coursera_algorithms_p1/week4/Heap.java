package week4;

import java.util.Arrays;

public class Heap {

    public static void sort(Comparable[] a) {
        int N = a.length;

        // construct heap
        for (int i = N / 2; i > 0; i--) {
            sink(a, i - 1, N);
        }

        // sort
        for (int i = N; i > 0; i--) {
            exch(a, i - 1, 0);
            sink(a, 0, i - 1);
        }

    }


    private static void sink(Comparable[] a,  int k, int N) {

        while(k * 2 + 1 < N ) {
            int largestIdx = k * 2 + 1; // left child
            if (largestIdx + 1 < N && less(a[largestIdx], a[largestIdx + 1] /*right child*/ )) {
                largestIdx++;
            }

            if (!less(a[k], a[largestIdx])) {
                break;
            }
            exch(a, k, largestIdx);
            k = largestIdx;
        }
    }
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable k = a[i];
        a[i] = a[j];
        a[j] = k;
    }
    public static void main(String[] args) {
        Integer[] a = { 4, 2, 3, 45, 2, 12, 32, 7, 43 };
        Heap.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
