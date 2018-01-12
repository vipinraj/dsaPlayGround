// 12.4
package epi.searching;

public class IntegerSquareRoot {
    public static void main(String[] args) {
        int number = 5000;
        System.out.println(getLargestInteger(number));
        
    }
    
    public static int getLargestInteger(int number) {
        int l = 0;
        int r = number;
        int m;
        
        while (l <= r) {
            m = l + (r - l) / 2;
            int square = m * m;
            if (square < number) {
                l = m + 1;
            } else {
                r = m - 1;
            }
            
        }
        
        return l-1;
    }
}
