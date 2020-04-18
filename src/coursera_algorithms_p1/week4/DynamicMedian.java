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

package week4;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.MaxPQ;
public class DynamicMedian {
    private final MinPQ<Integer> minPQ;
    private final MaxPQ<Integer> maxPQ;

    public DynamicMedian() {
        minPQ = new MinPQ<>();
        maxPQ = new MaxPQ<>();
    }

    public void insert(Integer k) {
        if (maxPQ.isEmpty() || k <= maxPQ.max()) {
            maxPQ.insert(k);
        } else {
            minPQ.insert(k);
        }
        balance();
    }

    private void balance() {
        if(maxPQ.size() < minPQ.size()) {
            maxPQ.insert(minPQ.delMin());
        }
    }


    public Integer findMedian() {
        if (isEmpty()) {
            return null;
        }

        if (minPQ.size() == maxPQ.size()) {
            return (minPQ.min() + maxPQ.max()) / 2;
        } else {
            return maxPQ.max();
        }
    }


    public Integer removeMedian() {
        Integer removedKey = null;
        if (!isEmpty()) {
            removedKey = maxPQ.delMax();
            balance();
        }
        return removedKey;
    }

    public boolean isEmpty() {
        return maxPQ.size() + minPQ.size() == 0;
    }

    public static void main(String[] args) {
        DynamicMedian dm = new DynamicMedian();
        dm.insert(1);
        dm.insert(3);
        dm.insert(5);
        System.out.println(dm.findMedian());
        dm.insert(7);
        dm.insert(9);
        System.out.println(dm.findMedian());
        System.out.println(dm.removeMedian());
        System.out.println(dm.findMedian());
        dm.insert(2);
        dm.insert(4);
        dm.insert(6);
        System.out.println(dm.findMedian());
        System.out.println(dm.removeMedian());
        dm.insert(8);
        dm.insert(10);
        System.out.println(dm.findMedian());
        System.out.println(dm.removeMedian());
        System.out.println(dm.findMedian());
    }
}
