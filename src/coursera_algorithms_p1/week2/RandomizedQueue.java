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
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int size, capacity = 1;
    private Item[] itemArray;

    public RandomizedQueue() {
        itemArray = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {

        if (item == null) {
            throw new IllegalArgumentException("Can not insert null elements");
        }

        if (size >= capacity) {
            resize(size * 2);
        }

        itemArray[size++] = item;
    }

    private void resize(int newCapacity) {
        Item[] newItemArray = (Item[]) new Object[newCapacity];

        for(int i = 0; i < size; i++) {
            newItemArray[i] = itemArray[i];
        }

        itemArray = newItemArray;
        capacity = newCapacity;
    }

    public Item dequeue() {

        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        int randIndx = StdRandom.uniform(size);
        Item item = itemArray[randIndx];
        itemArray[randIndx] = itemArray[--size];
        itemArray[size] = null;

        if (size > 0 && size == capacity / 4) {
            resize(capacity/2);
        }

        return item;
    }

    public Item sample() {

        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        int randIndx = StdRandom.uniform(size);
        return itemArray[randIndx];
    }


    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {

        Item[] copyArray;
        int currentPos = 0;

        public QueueIterator() {
            copyArray = (Item[]) new Object[size];
            int[] permutations = StdRandom.permutation(size);

            for (int i = 0; i < copyArray.length; i++) {
                copyArray[permutations[i]] = itemArray[i];
            }
        }
        public boolean hasNext() {
            return currentPos != copyArray.length;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {

            if (!hasNext()) {
                throw new NoSuchElementException("No more element to iterate");
            }

            return copyArray[currentPos++];
        }
    }


    public static void main(String[] args) {
        RandomizedQueue<String> q = new RandomizedQueue<>();
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");
        q.enqueue("E");
        q.enqueue("F");
        StdOut.println(q.sample());
        StdOut.println(q.dequeue());
        StdOut.println(q.isEmpty());
        StdOut.println(q.size());
        StdOut.println();

        for (String s : q) {
            StdOut.print(s + ", ");
        }

        StdOut.println();

        for (String s : q) {
            StdOut.print(s + ", ");
        }

        StdOut.println();
    }
}
