package week4;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solver {
    LinkedList<Board> solution;

    public Solver(Board initial) {
        if (initial == null)
            throw new IllegalArgumentException();

        SearchNode initialSearchNode = new SearchNode();
        initialSearchNode.board = initial;
        initialSearchNode.noOfMoves = 0;
        initialSearchNode.prevNode = null;

        MinPQ<SearchNode> minPQ = new MinPQ<SearchNode>(new Comparator<SearchNode>() {
            @Override
            public int compare(SearchNode o, SearchNode t1) {
                return Integer.compare(o.board.manhattan(), t1.board.manhattan());
            }
        });

        minPQ.insert(initialSearchNode);

        while (!minPQ.isEmpty()) {
            SearchNode currentSearchNode = minPQ.delMin();
            if (currentSearchNode.board.isGoal()) {
                solution = new LinkedList<Board>();
                while (currentSearchNode != null) {
                    solution.addFirst(currentSearchNode.board);
                    currentSearchNode = currentSearchNode.prevNode;
                }
                break;
            }

            Iterator<Board> neighbourBoardsIter = currentSearchNode.board.neighbours().iterator();

            while(neighbourBoardsIter.hasNext()) {
                Board neighbourBoard = neighbourBoardsIter.next();

                if (currentSearchNode.prevNode == null ||
                        !neighbourBoard.equals(currentSearchNode.prevNode.board)) {
                    minPQ.insert(new SearchNode(neighbourBoard,
                                                currentSearchNode.noOfMoves + 1,
                                                currentSearchNode));
                }
            }


        }
    }

    public boolean isSolvable() {

    }

    public int moves() {

    }

    public Iterable<Board> solution() {
        return solution;
    }

    public static void main(String[] args) {

    }

    private class SearchNode {
        SearchNode(Board board, int noOfMoves, SearchNode prevNode) {
            this.board = board;
            this.noOfMoves = noOfMoves;
            this.prevNode = prevNode;
        }
        Board board;
        int noOfMoves;
        SearchNode prevNode;
    }
}
