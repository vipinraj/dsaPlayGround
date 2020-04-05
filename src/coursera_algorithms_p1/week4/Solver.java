package week4;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class Solver {
    private LinkedList<Board> solution = new LinkedList<Board>();

    public Solver(Board initial) {
        if (initial == null)
            throw new IllegalArgumentException();

        SearchNode initialSearchNode = new SearchNode(initial, 0, null);
        SearchNode initialSearchNodeTwin = new SearchNode(initial.twin(), 0, null);

        Comparator<SearchNode> comparator = new Comparator<SearchNode>() {
            @Override
            public int compare(SearchNode o, SearchNode t1) {
                return Integer.compare(o.board.manhattan() + o.noOfMoves,
                                       t1.board.manhattan() + t1.noOfMoves);
            }
        };

        MinPQ<SearchNode> minPQ = new MinPQ<SearchNode>(comparator);
        MinPQ<SearchNode> minPQTwin = new MinPQ<SearchNode>(comparator);
        minPQ.insert(initialSearchNode);
        minPQTwin.insert(initialSearchNodeTwin);

        while (!minPQ.min().board.isGoal() && !minPQTwin.min().board.isGoal()) {
            SearchNode currentSearchNode = minPQ.delMin();
            Iterator<Board> neighbourBoardsIter = currentSearchNode.board.neighbors().iterator();

            while (neighbourBoardsIter.hasNext()) {
                Board neighbourBoard = neighbourBoardsIter.next();

                if (currentSearchNode.prevNode == null ||
                        !neighbourBoard.equals(currentSearchNode.prevNode.board)) {
                    minPQ.insert(new SearchNode(neighbourBoard,
                                                currentSearchNode.noOfMoves + 1,
                                                currentSearchNode));
                }
            }

            currentSearchNode = minPQTwin.delMin();
            neighbourBoardsIter = currentSearchNode.board.neighbors().iterator();

            while (neighbourBoardsIter.hasNext()) {
                Board neighbourBoard = neighbourBoardsIter.next();

                if (currentSearchNode.prevNode == null ||
                        !neighbourBoard.equals(currentSearchNode.prevNode.board)) {
                    minPQTwin.insert(new SearchNode(neighbourBoard,
                                                    currentSearchNode.noOfMoves + 1,
                                                    currentSearchNode));
                }
            }
        }

        if (minPQ.min().board.isGoal()) {
            SearchNode currentSearchNode = minPQ.delMin();
            while (currentSearchNode != null) {
                solution.addFirst(currentSearchNode.board);
                currentSearchNode = currentSearchNode.prevNode;
            }
        }
    }

    public boolean isSolvable() {
        return solution.size() > 0;
    }

    public int moves() {
        return solution.size() - 1;
    }

    public Iterable<Board> solution() {
        return solution;
    }

    public static void main(String[] args) {

        // create initial board from file
        // In in = new In(args[0]);
        // int n = in.readInt();
        // int[][] tiles = new int[n][n];
        // for (int i = 0; i < n; i++)
        //     for (int j = 0; j < n; j++)
        //         tiles[i][j] = in.readInt();
        // Board initial = new Board(tiles);
        Board initial = new Board(new int[][] { { 0, 1, 3 }, { 4, 2, 5 }, { 7, 8, 6 } });
        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

    private class SearchNode {
        Board board;
        int noOfMoves;
        SearchNode prevNode;

        SearchNode(Board board, int noOfMoves, SearchNode prevNode) {
            this.board = board;
            this.noOfMoves = noOfMoves;
            this.prevNode = prevNode;
        }
    }
}
