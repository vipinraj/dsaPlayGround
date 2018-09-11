package epi.greedy;

import java.util.Arrays;

public class ScheduleToMinimizeWaitingTime {
	public static void main(String[] args) {
		int[] processingTimes = {2, 5, 1, 3};
		System.out.println(scehduleForMinimumWaitingTime(processingTimes));
	}
	
	public static int scehduleForMinimumWaitingTime(int[] processingTimes) {
		Arrays.sort(processingTimes);
		
		int totalWaitingTime = 0;
		
		for (int i = 0; i < processingTimes.length; i++) {
			totalWaitingTime += (processingTimes.length - 1 - i) * processingTimes[i];
		}
		
		return totalWaitingTime;
	}
}