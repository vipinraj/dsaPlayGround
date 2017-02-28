import java.util.Scanner;

public class ChristmasTree {

	public static void main(String[] args) {
		
		
		Scanner s = new Scanner(System.in);
		try {
			int n = s.nextInt();
			
			if(n <= 1){
				System.out.println("You cannot generate christmas tree");
				return;
			}
			if(n > 20){
				System.out.println("Tree is no more");
				return;
			}
			int parts = n-1;
			
			int totalLength = 1 + n * 2;
			
			for(int i = 0; i<parts; i++){
				printPart(i+1, n);			
			}
			printALine(totalLength, 1, false);
			printALine(totalLength, 1, true);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void printPart(int partNo, int days){
		int totalLength = 1 + days * 2;
		if(partNo > 1){
			int leaves = 3;

				for (int i = 0; i <= days-partNo; i++) {
					printALine(totalLength, leaves, false);
					leaves += 2;
				}
			
			
		}else{			
			int leaves = 1;
			for(int j=0; j<=days; j++){
				printALine(totalLength, leaves, false);
				leaves += 2;
			}
		}
	}
	public static void printALine(int totalLength, int leaves, boolean isLast){
		int whiteSpace = (totalLength - leaves) / 2;
		
		for(int i = 0; i< whiteSpace; i++){
			System.out.print(" ");
		}
		for(int i = 0; i< leaves; i++){
			System.out.print("*");
		}
		
		if(!isLast){
			System.out.println();
		}
		
	}

}
