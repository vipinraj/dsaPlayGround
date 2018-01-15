/**
 * 12.6
 */
package epi.searching;
import java.util.List;
import java.util.ArrayList;

public class SearchIn2DSortedArray {
  
  public static void main(String[] args) { 
    Integer[][] input = { 
      {-1, 2, 4, 4, 6},
      {1, 5, 5, 9, 21},
      {3, 6, 6, 9,22},
      {3, 6, 8, 10, 24},
      {6, 8, 9, 12, 25},
      {8, 10, 12, 13, 40}
    };
    
    System.out.println(isElementPresent(input, 0) );
    System.out.println(isElementPresentMethod2(input, 7) );
  }
  
  // my method
  public static boolean isElementPresent(Integer[][] a, Integer e) {
    for (int r = 0; r < a.length; r++) {
      for (int c = 0; c < a[r].length; c ++) {
        System.out.println("row: " + r + ", col: " + c);
        if (a[r][c] == e) {
          return true;
        } else if (a[r][c] > e) {
          if (c == 0) {
            return false;
          } else {
            break;
          }
        } 
      }
    }
    
    return false;
  }
  
  // epi methd O(r+c)
  public static boolean isElementPresentMethod2(Integer[][] a, Integer e) {
    int row = 0;
    int col = a[0].length - 1;
    
    while (row < a.length && col >= 0) {
      if (a[row][col] == e) {
        return true;
      }
      
      if (e > a[row][col]) {
        row++;
      } else {
        col --;
      }
    }
    
    return false;
  }
}
