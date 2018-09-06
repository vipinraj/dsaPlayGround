package epi.greedy;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class OptimumTaskAssignment {
	public static void main(String[] args) {
		int[] tasks = { 5, 2, 1, 6, 4, 4};
		
		System.out.println(getOptimumAssignment(tasks));
	}
	
	public static List<TaskPair> getOptimumAssignment(int[] taskDurations) {
		Arrays.sort(taskDurations);
		
		ArrayList<TaskPair> optimumAssigments = new ArrayList<>();
		int n = taskDurations.length;
		
		for (int i = 0; i < n / 2; i++) {
			optimumAssigments.add(new TaskPair(taskDurations[i], taskDurations[n - i - 1]));
		}
		
		return optimumAssigments;
	}
	
	public static class TaskPair {
		int task1Duration;
		int task2Duration;
		
		TaskPair(int task1Duration, int task2Duration) {
			this.task1Duration = task1Duration;
			this.task2Duration = task2Duration;
		}
		
		public String toString() {
			return "(" + task1Duration + ", " + task2Duration + ")";
		}
	}
}