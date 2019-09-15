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

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int size;
    private Node front, back;

    private class Node {
        Item data;
        Node next;
        Node prev;
    }

    public Deque() {

    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {

        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }

        Node n = new Node();
        n.data = item;
        size++;

        if (isEmpty()) {
            front = back = n;
            return;
        }

        n.next = front;
        front.prev = n;
        front = n;
    }

    public void addLast(Item item) {

        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }

        Node n = new Node();
        n.data = item;
        size++;

        if (isEmpty()) {
            front = back = n;
            return;
        }

        n.prev = back;
        back.next = n;
        back = n;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("No elements to remove");
        }

        Item data = front.data;
        front = front.next;

        if (front != null) {
            front.prev = null;
        } else {
            back = null;
        }
        size--;
        return data;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("No elements to remove");
        }

        Item data = back.data;
        back = back.prev;

        if (back != null) {
            back.next = null;
        } else {
            front = null;
        }
        size--;
        return data;
    }


    private class ListIterator implements Iterator<Item> {
        private Node current = front;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation not supported");
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more items available");
            }

            Item item = current.data;
            current = current.next;
            return item;
        }
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        StdOut.println(deque.isEmpty());
        deque.addFirst("the");
        deque.addLast("best");
        deque.addLast("of");
        deque.addFirst("was");
        deque.addFirst("it");
        deque.addLast("times");
        StdOut.println(deque.size());

        Iterator<String> iterator = deque.iterator();

        while (iterator.hasNext()) {
           StdOut.print(iterator.next() + " ");
        }

        StdOut.println();
        StdOut.println(deque.removeFirst());
        StdOut.println(deque.removeFirst());
        StdOut.println(deque.removeLast());
        StdOut.println(deque.removeLast());
        StdOut.println(deque.removeLast());
        StdOut.println(deque.removeFirst());
        // StdOut.println(deque.removeFirst());
        StdOut.println(deque.size());


        deque = new Deque<>();
        deque.addFirst("the");
        deque.addLast("best");
        deque.addLast("of");
        deque.addFirst("was");
        deque.addFirst("it");
        deque.addLast("times");
        StdOut.println(deque.size());

        iterator = deque.iterator();

        while (iterator.hasNext()) {
            StdOut.print(iterator.next() + " ");
        }
    }
}
