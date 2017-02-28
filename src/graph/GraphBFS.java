package graph;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;

public class GraphBFS {

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
		
		Queue<Integer> queue = new Queue<>();
		
		int src = 0;
		queue.enqueue(src);
		List<Integer> visited = new ArrayList();
		
		while(!queue.isEmpty()){
			int vertice = queue.dequeue();
			System.out.print( vertice + " ");
			visited.add(vertice);
			Bag<Integer> neighbours = (Bag<Integer>) g.adj(vertice);
			for (Integer node : neighbours) {
				if(visited.contains(node) || contains(queue, node)){
					//System.out.println("Contains");
				}else{
					queue.enqueue(node);
				}
				
			}
		}
	}
	
	private static boolean contains(Queue<Integer> queue, Integer element){
		for (Integer node : queue) {
			if(node.equals(element)){
				return true;
			}
		}
		return false;
	}

}
