import java.util.Scanner;

public class A {
	public static void main(String args[]) {
				
		Scanner s = new Scanner(System.in);
				
		int n = s.nextInt();		
		s.close();
		
		Integer matrix[][] = new Integer[n][n];		
		int l = 0, t = 0;
	    int r = n-1, b = n-1;
	    int i = t, j = l;	    	    
	    int count = 0, value = 1, powerPoint = 0; 	    	    
	    String coordinates= "";
	    
		for(int a = 0; a < n * n; ++a) {
			
			matrix[i][j] = value;
	        			
			if(value % 11 == 0 || (i==0&&j==0)){
				powerPoint ++;
				coordinates += "("+i+","+j+")\n";
			}
			
			value ++;
				
	        if (i == t && j < r) {
	            if(++j == r)
	                t++;
	        }
	        else if (j == r && i < b) {
	            if(++i == b)
	                r--;
	        }
	        else if (i == b && j > l) {
	            if(--j == l)
	                b--;
	        }
	        else if (j == l && i > t) {
	            if(--i == t)
	                l++;
	        }
	    }
		
		for(int p = 0; p<n; p++){
			for(int q =0; q<n ; q++){
				
				System.out.print(matrix[p][q]);				
				
				if(count < n-1){
					System.out.print("\t");
				}						
				
				if(count == n-1){
					System.out.println();
				}
				count = (count + 1) % n;
			}						
		}
		
		System.out.println("Total Power points : " + powerPoint);
		coordinates =  coordinates.substring(0, coordinates.length()-1);
		System.out.println(coordinates);
	}
}
