package epi.graph;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class SearchAMaze {
	public static void main(String[] args) {
		int[][] maze = {
						{0, 1, 1, 1, 1, 1, 0, 0, 1, 1},
						{1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
						{0, 1, 0, 1, 1, 0, 0, 1, 0, 0},
						{1, 1, 1, 0, 0, 0, 1, 1, 0, 1},
						{1, 0, 0, 1, 1, 1, 1, 1, 1, 1},
						{1, 0, 0, 1, 1, 0, 1, 0, 0, 1},
						{1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
						{0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
						{0, 1, 0, 0, 1, 1, 1, 0, 0, 0},
						{1, 1, 1, 1, 1, 1, 1, 0, 0, 1}
						};

		Coordinate start = new Coordinate(0, 9);
		Coordinate end = new Coordinate(9, 0);
		getPath(maze, start, end);
		
	}
	
	
	// my method
	public static List<Coordinate> getPath(int[][] maze, Coordinate start, Coordinate end) {
		
		Map<Coordinate, List<Coordinate>> graph = new HashMap<>();
		
		for (int y = 0; y < maze.length; y++) {
			for (int x = 0; x < maze[0].length; x++) {
				if (maze[y][x] == 1) {
					Coordinate c = new Coordinate(x, y);
					Coordinate left = null;
					Coordinate top = null;
					if (x - 1 >= 0 && maze[y][x - 1] == 1 ) {
						left = new Coordinate(x - 1, y);
						List<Coordinate> lst = graph.get(left);
						lst.add(c);
					}
					
					//System.out.println(c);
					
					if (y - 1 >= 0 && maze[y - 1][x] == 1) {
						top = new Coordinate(x, y - 1);
						List<Coordinate> lst = graph.get(top);
						lst.add(c);
					}
					
					List<Coordinate> lst = new ArrayList<>();
					
					if (top != null) {
						lst.add(top);
					}
					
					if (left != null) {
						lst.add(left);
					}
					graph.put(c, lst);
				}
			}
		}
		
		//System.out.println(graph);
		
		List<Coordinate> result = new ArrayList<>();
		List<Coordinate> pathSoFar = new ArrayList<>();
		Set<Coordinate> visited = new HashSet<Coordinate>();
		pathSoFar.add(start);
		visited.add(start);
		findPath(graph, start, end, result, pathSoFar, visited);
		System.out.println(result);
		
		return result;
	}
	
	
	public static void findPath(Map<Coordinate, List<Coordinate>> graph, Coordinate curr, Coordinate dest, 
								List<Coordinate> result, List<Coordinate> pathSoFar, Set<Coordinate> visited) {
		if (curr == null) {
			return;
		}
		visited.add(curr);
		if (curr.equals(dest) && result.size() == 0) {
			result.addAll(pathSoFar);
		}
		
		for (Coordinate c : graph.get(curr)) {
			if (!visited.contains(c)) {
				pathSoFar.add(c);
				findPath(graph, c, dest, result, pathSoFar, visited);
				pathSoFar.remove(pathSoFar.size() - 1);
			}
		}
	}
	
	static class Coordinate {
		int x;
		int y;
		
		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			
			if (this == o) {
				return true;
			}
			
			if (o == null || !(o instanceof Coordinate)) {
				return false;
			}
			
			if (((Coordinate)o).x == this.x && ((Coordinate)o).y == this.y ) {
				return true;
			}
			
			return false;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
		
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}
}

