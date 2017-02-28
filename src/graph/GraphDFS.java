package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class GraphDFS {

	public static void main(String[] args) {

		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 4);
		g.addEdge(3, 6);
		g.addEdge(3, 6);
		g.addEdge(4, 6);
		g.addEdge(4, 7);
		g.addEdge(5, 7);
		g.addEdge(6, 7);
		g.addEdge(6, 8);
		g.addEdge(7, 8);
		
		Stack<Integer> stack = new Stack<>();
		
		int src = 0;
		
		stack.push(src);
		List<Integer> visited = new ArrayList<Integer>();
		
		while(!stack.isEmpty()){
			int node = stack.pop();
			System.out.print(node + " ");
			visited.add(node);
			List<Integer> elements = new ArrayList<Integer>();
			for (Integer elem : g.adj(node)) {
				elements.add(elem);
			}
			Collections.reverse(elements);
			for ( Integer elem : elements ) {
				if(!visited.contains(elem) && !contains(stack, elem)){
					stack.push(elem);
				}
			}
		}
	}

	private static boolean contains(Stack<Integer> stack, Integer element) {
		for (Integer node : stack) {
			if (node.equals(element)) {
				return true;
			}
		}
		return false;
	}
}
