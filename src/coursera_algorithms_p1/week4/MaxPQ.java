package week4;

public class MaxPQ<Key extends Comparable<Key>> {
    private int N = 1;
    private Key[] pq;

    public boolean isEmpty() {
        return N == 1;
    }

    public MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public Key delMax() {
        Key max = pq[1];
        pq[1] = pq[--N];
        sink(1);
        pq[N] = null;
        return max;
    }

    private void sink(int k) {
        int largestIdx = k;

        if (k * 2 + 1  < N) {
            if (less(pq[largestIdx], pq[k * 2 + 1])) {
                largestIdx = k * 2 + 1;
            }
        }

        if (k * 2 < N) {
            if (less(pq[largestIdx], pq[k * 2])) {
                largestIdx = k * 2;
            }
        }

        if (k != largestIdx) {
            exch(k, largestIdx);
            sink(largestIdx);
        }
    }

    public void insert(Key x) {
        pq[N++] = x;
        swim(N - 1);
    }

    private void swim(int k) {
        int parent_idx = Math.max(1, k / 2);
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
        MaxPQ<Integer> maxPQ = new MaxPQ<>(10);
        maxPQ.insert(3);
        maxPQ.insert(1);
        maxPQ.insert(10);
        maxPQ.insert(78);
        maxPQ.insert(5);
        maxPQ.insert(3);
        maxPQ.insert(9);


        while(!maxPQ.isEmpty()) {
            System.out.println(maxPQ.delMax());
        }
    }
}
