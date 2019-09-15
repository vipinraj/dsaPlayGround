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

public class Selection {

    public static void sort(Comparable[] items) {

        for(int i = 0; i < items.length; i++) {

            int min = i;
            for (int j = i + 1; j < items.length; j++) {
                if (less(items[j], items[min])) {
                    min = j;
                }
            }
            exch(items, i, min);
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
        Selection.sort(items);

        for(String s: items) {
            System.out.print(s + ", ");
        }
    }
}
