package week4;

public class MaxPQ<Key extends Comparable<Key>> {
    private int N = 1;
    private Key[] pq;

    public MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public Key delMax() {
        Key max = pq[1];
        pq[1] = pq[N - 1];
        sink(1);
        return max;
    }

    private void sink(int k) {
        int largestChildIdx;
        if (less(pq[k * 2], pq[k * 2 + 1])) {
            largestChildIdx = k * 2 + 1;
        } else {
            largestChildIdx = k * 2;
        }

        if (less(pq[k], pq[largestChildIdx])) {
            exch(k, largestChildIdx);
            sink(largestChildIdx);
        }
    }

    public void insert(Key x) {
        pq[N++] = x;
        swim(N - 1);
    }

    private void swim(int k) {
        int parent_idx = k / 2;
        while(parent_idx > 0 && less(pq[parent_idx], pq[k])) {
          exch(k, parent_idx);
          k = parent_idx;
          parent_idx = k/2;
        }
    }

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private void exch(int i, int j) {
        Key a = pq[i];
        pq[i] = pq[j];
        pq[j] = a;
    }

    public static void main(String[] args) {

    }
}
