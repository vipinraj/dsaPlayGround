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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TaxiCabNumbers {

    static final class Pair {
        Integer a;
        Integer b;
        Pair(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }
    }


    static final class QubeSum implements Comparable<QubeSum> {
        Integer a;
        Integer b;
        Integer cubeSum;

        QubeSum(Integer a, Integer b) {
            this.a = a;
            this.b = b;
            cubeSum = a*a*a + b * b * b;
        }

        @Override
        public int compareTo(QubeSum qubeSum) {
            return this.cubeSum.compareTo(qubeSum.cubeSum);
        }

        public String toString() {
            return "a= " + a + ", b= " + b + ", sum = " + cubeSum;
        }
    }

    // Todo: implement `run`
    // refer: https://algs4.cs.princeton.edu/24pq/Taxicab.java.html
    public static List<Integer> getTaxicabNumbersUsingPQ(Integer n) {
        MinPQ<QubeSum> minPQ = new MinPQ<>();
        Set<Integer> resultSet = new HashSet<>();

        for (int i = 1; i < n; i++) {
            minPQ.insert(new QubeSum(i, i));
        }

        QubeSum prevMin = minPQ.delMin();

        while(!minPQ.isEmpty()) {
            QubeSum curentMin = minPQ.delMin();

            System.out.println(prevMin);
            System.out.println(curentMin);
            System.out.println("----");
            if (curentMin.cubeSum.equals(prevMin.cubeSum)) {
                resultSet.add(curentMin.cubeSum);
                System.out.println("matched");
            }

            if (curentMin.b < n) {
                minPQ.insert(new QubeSum(prevMin.a, prevMin.b + 1));
            }

            prevMin = curentMin;
        }

        List<Integer> resultArr = new ArrayList<>(resultSet);
        return resultArr;
    }

    public static List<Integer> getTaxicabNumbers(Integer n) {
        HashMap<Integer, List<Pair>> twoCubeSums = new HashMap<>();
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                Integer sum = i * i * i + j * j * j;

                if (twoCubeSums.containsKey(sum)) {
                    twoCubeSums.get(sum).add(new Pair(i, j));
                } else {
                    List<Pair> pairs = new ArrayList<Pair>();
                    pairs.add(new Pair(i, j));
                    twoCubeSums.put(sum, pairs);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, List<Pair>> entry : twoCubeSums.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getTaxicabNumbers(500));
        System.out.println(getTaxicabNumbersUsingPQ(20));
    }
}
