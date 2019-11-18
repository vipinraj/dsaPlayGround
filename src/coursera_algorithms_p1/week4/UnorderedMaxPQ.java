package week4;

public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public UnorderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key x) {
        pq[N++] = x;
    }

    public Key delMax() {
        int maxIndx = 0;
        for (int i = 1; i < N; i++) {
            if (pq[i].compareTo(pq[maxIndx]) > 0) {
                maxIndx = i;
            }
        }

        Key max = pq[maxIndx];
        pq[maxIndx] = pq[--N];

        if (N > 0) {
            pq[N] = null;
        }

        return max;
    }

    public static void main(String[] args) {
        UnorderedMaxPQ<Integer> pq = new UnorderedMaxPQ<Integer>(5);
        pq.insert(2);
        pq.insert(1);
        pq.insert(5);
        pq.insert(9);
        pq.delMax();
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
    }
}
