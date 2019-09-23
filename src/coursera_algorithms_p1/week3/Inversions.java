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

public class Inversions {
    public static void main(String[] args) {
        Integer arr[] = { 1, 20, 6, 4, 5 };
        System.out.println(count(arr));
        System.out.println(Arrays.toString(arr));

        arr = new Integer[] {8, 4, 2, 1};
        System.out.println(Arrays.toString(arr));
        System.out.println(count(arr));
    }


    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static int mergeWithCount(Comparable[] items, Comparable[] temp,
                                      int start, int mid, int end) {
        // copy to temp
        for (int i = 0; i <= end; i++) {
            temp[i] = items[i];
        }

        // compare and merge

        int left = start;
        int right = mid + 1;
        int inversions = 0;

        for (int i = start; i <= end; i++) {
            if (left > mid) {
                items[i] = temp[right++];
            } else if (right > end) {
                items[i] = temp[left++];
            } else {
                if (less(temp[left], temp[right])) {
                    items[i] = temp[left++];
                } else {
                    items[i] = temp[right++];
                    inversions += mid + 1 - left ;
                }
            }
        }

        return inversions;
    }

    private static int countBySort(Comparable[] items, Comparable[] temp, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int count = 0;

        int mid = start + (end - start) / 2;

        count += countBySort(items, temp, start, mid);
        count += countBySort(items, temp,mid + 1, end);
        count += mergeWithCount(items, temp, start, mid, end);

        return count;
    }
    public static int count(Comparable[] items) {
        Comparable[] temp = new Comparable[items.length];
        return countBySort(items, temp, 0, items.length - 1);
    }
}
