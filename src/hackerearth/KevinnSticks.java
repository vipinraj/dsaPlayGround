package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class KevinnSticks {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			int size = Integer.parseInt(br.readLine());
			
			String[] items = br.readLine().split(" ");
			List<Integer> stickHights = new ArrayList<Integer>();
			for (String string : items) {
				stickHights.add(Integer.parseInt(string));
			}
			
			Collections.sort(stickHights);
			Integer min = stickHights.get(0);
			Integer max = stickHights.get(stickHights.size()-1);			
			int minsteps = 0;
			
			for(int j=min ; j <= max; j++){
				
				if(j==min){
					minsteps = getStepCount(j, stickHights,  0, true);
				}else{
					int newstepcount = getStepCount(j, stickHights, minsteps, false);
					if(newstepcount < minsteps){
						minsteps = newstepcount;
					}
				}
			}
			System.out.println(minsteps);
		}

	}

	private static Integer getStepCount(int baseHeight, List<Integer> stickHights, Integer currentminsteps, boolean isFirstPas) {
		
		
		int stepCount = 0;
		
		for (Integer stickHeight : stickHights) {			
			if(stickHeight != baseHeight){
				while(stickHeight != baseHeight){
					if(stickHeight > baseHeight){						
						while(stickHeight > baseHeight){
							stickHeight /= 2;
							stepCount ++;
							if(!isFirstPas  && stepCount == currentminsteps){
								return currentminsteps;
							}
						}											
					}else {
						stepCount += (baseHeight - stickHeight);
						stickHeight = baseHeight;
						if(!isFirstPas  && stepCount == currentminsteps){
							return currentminsteps;
						}
					}
					
				}
			}
		}
		
		return stepCount;
	}

}
