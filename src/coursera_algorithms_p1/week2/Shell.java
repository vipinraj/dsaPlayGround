package week2;/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

import java.util.Arrays;

public class Shell {

    public static void sort(Comparable[] items) {
        int N = items.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            System.out.println("h = " + h);
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(items[j], items[j - h]); j -= h) {
                    exch(items, j, j - h    );
                }
            }
            System.out.println(Arrays.toString(items));
            h = h/3;
        }

    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }


    private static void exch(Comparable[] items, int i, int j) {
        Comparable item = items[i];
        items[i] = items[j];
        items[j] = item;
    }
    public static void main(String[] args) {
        String[] items = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
                           "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                           "W", "X", "Y", "Z"};
        int start = 0, end = items.length - 1;

        while (start < end) {
            exch(items, start++, end--);
        }

        for(String s : items) {
            System.out.print(s + ", ");
        }
        System.out.println();
        Shell.sort(items);
        System.out.println();

        for(String s : items) {
            System.out.print(s + ", ");
        }

    }
}
