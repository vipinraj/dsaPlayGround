package epi.greedy;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IntervalCoveringProblem {
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(3, 4));
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(3, 4));
		intervals.add(new Interval(4, 5));

		System.out.println(getMinimumPoints(intervals));
	}

	public static List<Integer> getMinimumPoints(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				int result = Integer.compare(a.end, b.end);

				if (result == 0) {
					result = Integer.compare(a.start, b.start);
				}

				return result;
			}
		});

		List<Integer> result = new ArrayList<>();

		int currentPoint = intervals.get(0).end;
		result.add(currentPoint);
		
		for (Interval e : intervals) {
			if (e.start > currentPoint) {
				currentPoint = e.end;
				result.add(currentPoint);
			}
		}

		return result;
	}

	public static class Interval {
		public Integer start;
		public Integer end;

		public Interval(Integer start, Integer end) {
			this.start = start;
			this.end = end;
		}
	}
}