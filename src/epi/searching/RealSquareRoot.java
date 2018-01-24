// 12.5, variant
package epi.searching;

public class RealSquareRoot {
    public static void main(String args[]) {
        double n = .125;
        System.out.println(realSquareRoot(n));
        System.out.println(devide(21, 121));
    }
    
    public static double realSquareRoot(double n) {
        double left;
        double right;
        
        if (n >= 0 && n < 1) {
            left = 0;
            right = 1.0;
        } else {
            left = 1;
            right = n;
        }
        
        while (compare(left, right) == COMPARERESULT.SMALLER) {
            double mid = (right - left) / 2 + left;
            double midSquare = mid * mid;
            if (compare(midSquare, n) == COMPARERESULT.LARGER) {
                right = mid;
            } else if (compare(midSquare, n) == COMPARERESULT.SMALLER) {
                left = mid;
            } else {
                return mid;
            }
            
        }
        
        return left;
    }
    
    public enum COMPARERESULT {
        EQUAL, LARGER, SMALLER
    }
    
    public static COMPARERESULT compare(double a, double b) {
        double EPSILON = 0.00001;
        double difference = (a-b)/b;
        return difference < -EPSILON ? COMPARERESULT.SMALLER :
        difference > EPSILON ? COMPARERESULT.LARGER : COMPARERESULT.EQUAL;
    }
    
    public static double devide(double a, double b) {
        
        double left;
        double right;
        
        if (a > b) {
            left = 1;
            right = a;
        } else {
            left = 0;
            right = 1;
        }
        
        while (compare(left, right) == COMPARERESULT.SMALLER) {
            double mid = (right - left) / 2 + left;
            if (compare(b * mid, a) == COMPARERESULT.EQUAL) {
                return mid;
            } else if (compare(b * mid, a) == COMPARERESULT.SMALLER) {
                left = mid;
            } else {
                right = mid;
            }
            
        }
        
        return left;
    }
}

