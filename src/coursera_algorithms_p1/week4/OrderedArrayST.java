package week4;

import java.util.Arrays;

// Note: boundary conditions are not implemented
public class OrderedArrayST<Key extends Comparable<Key>, Value> {
    Key[] keys;
    Value[] values;
    int size;

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
            for (int j = i; j < size - 1; j++) {
                keys[j] = keys[j+1];
                values[j] = values[j+1];
            }
            size--;
            values[size] = null;
            keys[size] = null;
        }
        System.out.println(Arrays.toString(keys));
        System.out.println(Arrays.toString(values));
    }

    public int rank(Key key) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi){
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
    }
}
