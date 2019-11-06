package week3;

import java.util.Arrays;

public class NutsAndBolts {

    // O(2nlog(n)) == O(nlog(n))
    private static void findPairsHelper(int[] nuts, int[] bolts,
                                        int startIdx, int endIndx) {

        if (startIdx == endIndx) {
            return;
        }

        int nutsIdx = partition(nuts, bolts[startIdx], startIdx, endIndx);
        partition(bolts, nuts[nutsIdx], startIdx, endIndx);

        findPairsHelper(nuts, bolts, startIdx, nutsIdx);
        findPairsHelper(nuts, bolts, nutsIdx + 1, endIndx);
    }

    //hoare partition
    public static int partition(int[] a, int pivotVal, int startIdx, int endIdx) {
        int lo = startIdx;
        int hi = endIdx;

        int i = startIdx;
        while (i < hi) {
            if (a[i] < pivotVal) {
                exch(a, i, lo++);
                i++;
            } else if (a[i] > pivotVal) {
                exch(a, i, --hi);
            } else {
                i++;
            }
        }

        return lo;
    }

    public static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void findPairs(int[] nuts, int[] bolts) {
        findPairsHelper(nuts, bolts, 0, nuts.length);
    }

    public static void main(String[] args) {
        int[] nuts = { 1, 3, 5, 2, 4, 8, 0, 9, 6 };
        int[] bolts = { 3, 1, 2, 8, 6, 0, 9, 4, 5 };

        // partition(bolts, 5, 0, nuts.length);

        // System.out.println(Arrays.toString(bolts));
        findPairs(nuts, bolts);
        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }
}
