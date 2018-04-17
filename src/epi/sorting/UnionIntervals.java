// 14.5
package epi.sorting;
import java.util.List;
import java.util.ArrayList;


public class UnionIntervals {
	
	public static void main(String[] args) {
		List<Interval> input = new ArrayList<>();
		Interval a = new Interval(new Endpoint(0, true), new Endpoint(3, true));
		Interval b = new Interval(new Endpoint(1, false), new Endpoint(1, false));
		Interval c = new Interval(new Endpoint(2, false), new Endpoint(4, false));
		Interval d = new Interval(new Endpoint(3, false), new Endpoint(4, true));
		Interval e = new Interval(new Endpoint(5, false), new Endpoint(7, true));
		Interval f = new Interval(new Endpoint(7, false), new Endpoint(8, true));
		Interval g = new Interval(new Endpoint(8, false), new Endpoint(11, true));
		Interval h = new Interval(new Endpoint(9, true), new Endpoint(11, false));
		Interval i = new Interval(new Endpoint(12, false), new Endpoint(14, false));
		Interval j = new Interval(new Endpoint(12, true), new Endpoint(16, false));
		Interval k = new Interval(new Endpoint(13, true), new Endpoint(15, true));
		Interval l = new Interval(new Endpoint(16, true), new Endpoint(17, true));
		input.add(a);
		input.add(b);
		input.add(c);
		input.add(d);
		input.add(e);
		input.add(f);
		input.add(g);
		input.add(h);
		input.add(i);
		input.add(j);
		input.add(k);
		input.add(l);

		List<Interval> result = getUnion(input);

		for (Interval in : result) {
			System.out.println(in);
		}

	}

	public static List<Interval> getUnion(List<Interval> intervals) {

		List<Interval> result = new ArrayList<>();

		Interval curr = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {			
			if (intervals.get(i).start.value < curr.end.value || 
				(intervals.get(i).start.value == curr.end.value && (!(intervals.get(i).start.isOpen) || !(curr.end.isOpen)))) {
				// intersecting
				if (curr.end.value < intervals.get(i).end.value) {
					curr.end.value = intervals.get(i).end.value;
					curr.end.isOpen = intervals.get(i).end.isOpen;
				} else if (curr.end.value == intervals.get(i).end.value) {
					curr.end.isOpen = (intervals.get(i).end.isOpen && curr.end.isOpen);
				}
			} else {
				// not intersecting
				result.add(curr);
				curr = intervals.get(i);
			}
		}
		result.add(curr);
		return result;
	}
}

class Interval {
	Endpoint start;
	Endpoint end;
	
	Interval(Endpoint start, Endpoint end) {
		this.start = start;
		this.end = end;
	}
	public String toString() {
		String str = (start.isOpen ? "(" : "[") + start.value + "," + end.value + (end.isOpen ? ")" : "]")	;
		return str;
	}
}

class Endpoint {
	int value;
	boolean isOpen;

	Endpoint(int value, boolean isOpen) {
		this.value = value;
		this.isOpen = isOpen;
	}
}
