// 12.3
package epi.hashtables;

import java.util.LinkedHashMap;
import java.util.Map;
// O(1)
public class ISBNLRUCache {
    LinkedHashMap<Integer, Integer> isbnTopPriceMap;

    ISBNLRUCache(int capacity) {
        isbnTopPriceMap = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e) {
                return this.size() > capacity;
            }
        };
    }

    public Integer lookup(Integer isbn) {
        if (!isbnTopPriceMap.containsKey(isbn)) {
            return null;
        }
        return isbnTopPriceMap.get(isbn);
    }

    public void insert(Integer isbn, Integer price) {
        isbnTopPriceMap.get(isbn);
        if (!isbnTopPriceMap.containsKey(isbn)) {
            isbnTopPriceMap.put(isbn, price);
        }
    }

    public boolean erase(int isbn) {
        return isbnTopPriceMap.remove(isbn) != null;
    }

    public static void main(String args[]) {
        final int CAPACITY = 2;
        ISBNLRUCache c = new ISBNLRUCache(CAPACITY);
        System.out.println("c.insert(1, 1)");
        c.insert(1, 1);
        System.out.println("c.insert(1, 10)");
        c.insert(1, 10);
        System.out.println("c.lookup(2, val)");
        assert (null == c.lookup(2));
        System.out.println("c.lookup(1, val)");
        assert (c.lookup(1) == 1);
        c.erase(1);
        assert (null == c.lookup(1));

        // test capacity constraints honored, also FIFO ordering
        c = new ISBNLRUCache(CAPACITY);
        c.insert(1, 1);
        c.insert(2, 1);
        c.insert(3, 1);
        c.insert(4, 1);
        assert (null == c.lookup(1));
        assert (null == c.lookup(2));
        assert (1 == c.lookup(3));
        assert (1 == c.lookup(4));

        // test retrieval moves to front
        c = new ISBNLRUCache(CAPACITY);
        c.insert(1, 1);
        c.insert(2, 1);
        c.insert(3, 1);
        c.lookup(2);
        c.insert(4, 1);
        assert (null == c.lookup(1));
        assert (1 == c.lookup(2));
        assert (null == c.lookup(3));
        assert (1 == c.lookup(4));

        // test update moves to front
        c = new ISBNLRUCache(CAPACITY);
        c.insert(1, 1);
        c.insert(2, 1);
        c.insert(3, 1);
        c.insert(2, 2);
        c.insert(4, 1);
        assert (null == c.lookup(1));
        assert (1 == c.lookup(2));
        assert (null == c.lookup(3));
        assert (1 == c.lookup(4));

        // test erase
        c = new ISBNLRUCache(CAPACITY);
        c.insert(1, 1);
        c.insert(2, 1);
        c.erase(2);
        c.insert(3, 3);
        assert (1 == c.lookup(1));
        assert (null == c.lookup(2));
        assert (3 == c.lookup(3));
    }
}
