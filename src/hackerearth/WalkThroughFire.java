package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

public class WalkThroughFire {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
 	*/
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
		
		
        for(int i = 0; i < N ; i++){
        	int totalTime = 0;
        	int blockCount = 0;
        	int length = Integer.parseInt(br.readLine());
        	if(length == 1){
        		System.out.println(1);
        		continue;
        	}
        	int arr[] = new int[length];
        	String timesStr[] = br.readLine().split(" ");
        	for(int j = 0; j<length; j++){
        		arr[j] = Integer.parseInt(timesStr[j]);
        	}
        	int k = 0;
        	while(k < length){
        		if(arr[k] > totalTime){
        			totalTime = (arr[k] - totalTime) + totalTime;
        			if(blockCount > 0){
        				totalTime++;
        				blockCount = 0;
        			}
        		}else{
        			blockCount++;
        		}
        		k++;
        	}
        	System.out.println(totalTime);
        }
    }
}

