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

public class Insertion {

    public static void sort(Comparable[] items) {

        for (int i = 1; i < items.length; i++) {
            for (int j = i; j - 1 >= 0 &&
                    less(items[j], items[j - 1]); j--) {
                exch(items, j - 1, j);
            }
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
        String[] items = {"Z", "Y", "F", "G", "A"};
        Insertion.sort(items);

        for(String s: items) {
            System.out.print(s + ", ");
        }
    }
}
