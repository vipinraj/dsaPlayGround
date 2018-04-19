package epi.sorting;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class SalaryCap {
	public static void main(String[] args) {
		List<Double> currentSalaries = Arrays.asList(new Double[]{90.0,30.0,100.0,40.0,20.0});
		Double targetPayroll = 210.0;

		System.out.println(findSalaryCap(currentSalaries, targetPayroll));
	}

	public static double findSalaryCap(List<Double> currSalaries, double targetPayroll) {

		Collections.sort(currSalaries);
		double unAdjustedSalrySum = 0;

		for (int i = 0; i < currSalaries.size(); i++) {
			final double adjustedSalarySum = currSalaries.get(i) * (currSalaries.size() - i);

			if (adjustedSalarySum + unAdjustedSalrySum >= targetPayroll) {
				return (targetPayroll - unAdjustedSalrySum) / (currSalaries.size() - i);
			}

			unAdjustedSalrySum += currSalaries.get(i);
		}
		return -1.0;
	}
}