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

import edu.princeton.cs.algs4.StdRandom;

public class ShuffleLinkedList {

    public static LinkedListNode shufle(LinkedListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // split into two
        LinkedListNode firstTemp = new LinkedListNode("f");
        LinkedListNode secondTemp = new LinkedListNode("s");
        LinkedListNode first = firstTemp;
        LinkedListNode second = secondTemp;

        int flip = 1;
        while (head != null) {
            if (flip == 1) {
                firstTemp.next = head;
                firstTemp = firstTemp.next;
            } else {
                secondTemp.next = head;
                secondTemp = secondTemp.next;
            }

            head = head.next;
            flip = (flip + 1) % 2;
        }

        firstTemp.next = null;
        secondTemp.next = null;

        // shuffle separately
        first = shufle(first.next);
        second = shufle(second.next);

        // merge shuffled on random
        LinkedListNode merged = new LinkedListNode("m");
        head = merged;
        while (true) {
            if (first == null || second == null) {
                break;
            }

            flip = StdRandom.uniform(2);
            if (flip == 0) {
                merged.next = first;
                first = first.next;
            } else {
                merged.next = second;
                second = second.next;
            }

            merged = merged.next;
        }

        if (first != null) {
            merged.next = first;
        }

        if (second != null) {
            merged.next = second;
        }

        head = head.next;
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode<Character> head = new LinkedListNode<>('A');
        head.next = new LinkedListNode('B');
        head.next.next = new LinkedListNode('C');
        head.next.next.next = new LinkedListNode('D');
        head.next.next.next.next = new LinkedListNode('E');
        head.next.next.next.next.next = new LinkedListNode('F');
        head.next.next.next.next.next.next = new LinkedListNode('G');
        head.next.next.next.next.next.next.next = new LinkedListNode('I');
        head.next.next.next.next.next.next.next.next = new LinkedListNode('J');
        head.next.next.next.next.next.next.next.next.next = new LinkedListNode('K');
        head.next.next.next.next.next.next.next.next.next.next = new LinkedListNode('L');
        head.next.next.next.next.next.next.next.next.next.next.next = new LinkedListNode('M');
        head.next.next.next.next.next.next.next.next.next.next.next.next = new LinkedListNode('N');


        head = shufle(head);

        while (head != null) {
            System.out.print(head.data + ", ");
            head = head.next;
        }

    }
}
