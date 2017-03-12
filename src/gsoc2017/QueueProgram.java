package gsoc2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author vipin
 * -----
 * Input
 * -----
 * Number of commands that will be processed(N)
 * N commands(1 x -> Enqueue element x into the end of the queue, 
 * 			  2   -> Dequeue the element at the front of the queue,
 * 			  3   -> Print the element at the front of the queue.)
 * -------
 * Example
 * -------
 * Input
 * -----
 * 10
 * 1 42
 * 2
 * 1 14
 * 3
 * 1 28
 * 3
 * 1 60
 * 1 78
 * 2
 * 2
 * ------
 * Output
 * ------
 * 14
 * 14
  */
public class QueueProgram {

	public static void main(String[] args) throws NumberFormatException, Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);

		Queue<Integer> queue = new Queue<Integer>(N);

		for (int i = 0; i < N; i++) {
			line = br.readLine();
			if (line.split(" ")[0].equals("1")) {
				queue.put(Integer.parseInt(line.split(" ")[1]));
			} else if (line.split(" ")[0].equals("2")) {
				queue.pop();
			} else {
				System.out.println(queue.peek());
			}
		}

	}

}
