package week4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Note: boundary conditions are not implemented
public class OrderedArrayST<Key extends Comparable<Key>, Value>{
    private Key[] keys;
    private Value[] values;
    private int size;

    public OrderedArrayST(int n) {
        keys = (Key[]) new Comparable[n];
        values = (Value[]) new Object[n];
    }

    public void put(Key key, Value value) {
        if (key == null) return;

        int rank = rank(key);

        if (rank < size) {
            if (key.compareTo(keys[rank]) != 0) {
                // shift right
                for (int i = size; i > rank; i--) {
                    keys[i] = keys[i - 1];
                    values[i] = values[i - 1];
                }
                size++;
            }
        } else {
            size++;
        }

        keys[rank] = key;
        values[rank] = value;

        System.out.println(Arrays.toString(keys));
        System.out.println(Arrays.toString(values));
    }


    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }

        int i = rank(key);

        if (i < size && keys[i].equals(key)) {
            return values[i];
        }
        return null;
    }

    public void delete(Key key) {
        int i = rank(key);
        if (i < size) {
            deleteKeyWithRank(i);
        }
        System.out.println(Arrays.toString(keys));
        System.out.println(Arrays.toString(values));
    }

    private void deleteKeyWithRank(int rank) {
        for (int j = rank; j < size - 1; j++) {
            keys[j] = keys[j+1];
            values[j] = values[j+1];
        }
        size--;
        values[size] = null;
        keys[size] = null;
    }

    public void deleteMin() {
        if (size > 1) {
            deleteKeyWithRank(0);
        }
        System.out.println(Arrays.toString(keys));
        System.out.println(Arrays.toString(values));
    }

    public void deleteMax() {
        if (size > 1) {
            deleteKeyWithRank(size - 1);
        }
        System.out.println(Arrays.toString(keys));
        System.out.println(Arrays.toString(values));
    }

    public int size(Key lo, Key hi) {
        int i = rank(lo);
        int j = rank(hi);
        return j - i + 1;
    }

    public int rank(Key key) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key.compareTo(keys[mid]) < 0) {
                hi = mid - 1;
            } else if(key.compareTo(keys[mid]) > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }

        }

        return lo;
    }

    public Key select(int rank) {
        if (rank >=0 && rank < size) {
            return keys[rank];
        }
        return null;
    }

    public Key floor(Key key) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key.compareTo(keys[mid]) < 0) {
                hi = mid - 1;
            } else if(key.compareTo(keys[mid]) > 0) {
                lo = mid + 1;
            } else {
                return keys[mid];
            }

        }

        if (hi < size) {
            return keys[hi];
        } else {
            return null;
        }
    }

    public boolean contains(Key key) {
        int i = rank(key);
        if (i < size && keys[i].equals(key)) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[size - 1];
    }

    public Key ceiling(Key key) {
        int i = rank(key);

        if (i >= 0 && i < size) {
            return keys[i];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        OrderedArrayST<String, Integer> st = new OrderedArrayST<>(10);
        st.put("B", 2);
        st.put("A", 1);
        st.put("D", 4);
        st.put("E", 4);
        st.put("C", 3);

        System.out.println(st.get("C"));

        st.delete("C");
        System.out.println(st.get("C"));
        System.out.println(st.get("B"));
        System.out.println("Contains C: " + st.contains("C"));
        System.out.println("Contains B: " + st.contains("B"));
        System.out.println("Size: " + st.size());
        System.out.println("Min: " + st.min());
        System.out.println("Max: " + st.max());
        System.out.println("Ceiling of C: " + st.ceiling("C"));
        System.out.println("Ceiling of A: " + st.ceiling("A"));
        System.out.println("Floor of C: " + st.floor("C"));
        System.out.println("Floor of A: " + st.floor("A"));

        System.out.println("Rank of B: " + st.rank("B"));
        System.out.println("Select key with rank 3: " + st.select(3));
        System.out.println("Delete Min: ");
        st.deleteMin();
        System.out.println("Delete Max: ");
        st.deleteMax();
        st.put("B", 2);
        st.put("A", 1);
        st.put("D", 4);
        st.put("E", 5);
        st.put("C", 3);
        System.out.println("Size of [B, D]: " + st.size("B", "D"));

        Iterator<String> it = st.keys();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        it = st.keys("B","D");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
    private class STIterator implements Iterator<Key> {
        private Key[] keysCopy;
        private int i = 0;
        private int s;

        STIterator(int start, int end) {
            s = end - start + 1;
            keysCopy = (Key[]) new Comparable[s];
            int l = 0;
            for (int j = start; j <= end; j++) {
                keysCopy[l++] = keys[j];
            }
        }

        @Override
        public boolean hasNext() {
            return i < s;
        }

        @Override
        public Key next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more element to iterate");
            }

            return keysCopy[i++];
        }
    }

    public Iterator<Key> keys() {
        return new STIterator(0, size - 1);
    }

    public Iterator<Key> keys(Key lo, Key hi) {
        return new STIterator(rank(lo), rank(hi));
    }
}
