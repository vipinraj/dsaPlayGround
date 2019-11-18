package week4;

public class OrderedMaxPQ<Key extends Comparable<Key>> {
    private int N;
    private Key[] pq;

    public OrderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key x) {
        int i = 0;
        while (i < N && x.compareTo(pq[i]) > 0) {
            i++;
        }

        for (int j = N; j > i; j--) {
            pq[j] = pq[j-1];
        }

        pq[i] = x;
        N++;
    }

    public Key delMax() {
        Key x = pq[--N];
        pq[N] = null;
        return x;
    }

    public static void main(String[] args) {
        OrderedMaxPQ<Integer> pq = new OrderedMaxPQ<Integer>(5);
        pq.insert(2);
        pq.insert(1);
        pq.insert(5);
        pq.insert(9);
        pq.delMax();
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
    }
}
