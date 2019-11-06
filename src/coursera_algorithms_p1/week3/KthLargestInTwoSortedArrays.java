package week3;

/*
    Note: This is an importan question, struggled a lot (a day) to make the code working.
    Todo: Write the iterative version of the solution.
 */

public class KthLargestInTwoSortedArrays {

    // O(log(k))
    public static Comparable findNthMethod2(Comparable[] a, Comparable[] b, int k,
                                            int aStart, int aEnd, int bStart, int bEnd) {
        if (aStart == aEnd) {
            return b[bStart + k - 1];
        }

        if (bStart == bEnd) {
            return a[aStart + k - 1];
        }

        int aSizeToConsider = Math.min(k, aEnd - aStart);
        int bSizeToConsider = Math.min(k, bEnd - bStart);

        int aMid = aStart + (aSizeToConsider / 2);
        int bMid = bStart + (bSizeToConsider / 2);

        if (k >= aMid - aStart + bMid - bStart + 2) {
            if (less(a[aMid], b[bMid])) {
                return findNthMethod2(a, b, k - (aMid - aStart + 1),
                               aMid + 1, aEnd, bStart, bEnd);
            } else {
                return findNthMethod2(a, b, k - (bMid - bStart + 1),
                               aStart, aEnd, bMid + 1, bEnd);
            }
        } else {
            if (less(a[aMid], b[bMid])) {
                return findNthMethod2(a, b, k, aStart, aEnd, bStart, bMid);
            } else {
                return findNthMethod2(a, b, k, aStart, aMid, bStart, bEnd);
            }
        }
    }

    // O(log(n) + O(log(m)))
    public static Comparable findNth(Comparable[] a, Comparable[] b, int k,
                                     int aStart, int aEnd, int bStart, int bEnd) {
        if (aStart == aEnd) {
            return b[bStart + k - 1];
        }

        if (bStart == bEnd) {
            return a[aStart + k  - 1];
        }

        int aMid = aStart + (aEnd - aStart) / 2;
        int bMid = bStart + (bEnd - bStart) / 2;

        // System.out.println("K = " + k + "\naStart = " + aStart + " aMid = " + aMid + " aEnd = " + aEnd);
        // System.out.println("bStart = " + bStart + " bMid = " + bMid + " bEnd = " + bEnd);

        if (k >= (aMid - aStart + bMid - bStart + 2)) {
            if (less(a[aMid], b[bMid])) {
                return findNth(a, b, k - (aMid + 1 - aStart), aMid + 1, aEnd, bStart, bEnd);
            } else {
                return findNth(a, b, k - (bMid + 1 - bStart), aStart, aEnd, bMid + 1, bEnd);
            }
        } else {
            if (less(a[aMid], b[bMid])) {
                return findNth(a, b, k, aStart, aEnd, bStart, bMid );
            } else {
                return findNth(a, b, k, aStart, aMid, bStart, bEnd);
            }
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        Comparable[] a1 = { 100, 112, 256, 349, 770 };
        Comparable[] a2 = { 72, 86, 113, 119, 265, 445, 892 };

        for (int i = 1; i <= a1.length + a2.length; i++) {
            System.out.print("k = " + i + ": ");
            System.out.println(findNth(a1, a2, i, 0, a1.length, 0, a2.length));
        }

        System.out.println("-----------------");

        for (int i = 1; i <= a1.length + a2.length; i++) {
            System.out.print("k = " + i + ": ");
            System.out.println(findNthMethod2(a1, a2, i, 0, a1.length, 0, a2.length));
        }
    }
}
