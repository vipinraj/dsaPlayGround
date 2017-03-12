package gsoc2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author vipin
 * -----
 * Input
 * -----
 * Number of elements that will be added to the set(N)
 * N elements
 * -------
 * Example
 * -------
 * Input
 * -----
 * 10
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 * 10
 * ------
 * Output
 * ------
 * 1.00
 * 1.50
 * 2.00
 * 2.50
 * 3.00
 * 3.50
 * 4.00
 * 4.50
 * 5.00
 * 5.50
 */
public class RunningMedian {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Integer N = Integer.parseInt(line);
		MinHeap minHeap = new MinHeap(N / 2 + 1);
		MaxHeap maxHeap = new MaxHeap(N / 2 + 1);

		for (int i = 0; i < N; i++) {
			Integer k = Integer.parseInt(br.readLine());
			if (maxHeap.size() == 0 && minHeap.size() == 0) {
				System.out.printf("%.2f", (double) k);
				maxHeap.insert(k);
			} else if (maxHeap.size != 0) {
				if (k > maxHeap.peek()) {
					minHeap.insert(k);
				} else {
					maxHeap.insert(k);
				}
				System.out.printf("%.2f", getMedian(minHeap, maxHeap));
			}
			if (i < N - 1) {
				System.out.println();
			}
		}
	}

	private static Double getMedian(MinHeap minHeap, MaxHeap maxHeap) throws Exception {

		// balance
		if (minHeap.size() - maxHeap.size() > 1) {
			maxHeap.insert(minHeap.extractMin());
		} else if (maxHeap.size() - minHeap.size() > 1) {
			minHeap.insert(maxHeap.extractMax());
		}

		// get median
		if (minHeap.size() == maxHeap.size()) {
			return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
		} else if (maxHeap.size() > minHeap.size()) {
			return (double) maxHeap.peek();
		} else {
			return (double) minHeap.peek();
		}
	}

}
