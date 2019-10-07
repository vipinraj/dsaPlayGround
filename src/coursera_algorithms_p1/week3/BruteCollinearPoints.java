/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

package week3;
import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private final Point[] points;
    private LineSegment[] lineSegments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }

        if (hasNull(points)) {
            throw new IllegalArgumentException();
        }

        this.points = points.clone();

        Arrays.sort(this.points);

        if (hasDuplicate(this.points)) {
            throw new IllegalArgumentException();
        }


        findSegments();
    }


    public int numberOfSegments() {
        return this.lineSegments.length;
    }

    public LineSegment[] segments() {
        return this.lineSegments.clone();
    }

    private void findSegments() {
        ArrayList<LineSegment> segments = new ArrayList<LineSegment>();
        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                double slopeIJ = points[i].slopeTo(points[j]);
                for(int k = j + 1; k < points.length; k++) {
                    double slopeJK = points[j].slopeTo(points[k]);
                    for (int l = k + 1; l < points.length; l++) {
                        double slopeKL = points[k].slopeTo(points[l]);
                        if (slopeIJ == slopeJK && slopeJK == slopeKL) {
                            segments.add(new LineSegment(points[i], points[l]));
                        }
                    }
                }
            }
        }

        LineSegment[] lineSegments = new LineSegment[segments.size()];
        this.lineSegments = segments.toArray(lineSegments);
    }

    private boolean hasDuplicate(Point[] points) {
        for (int i = 1; i < points.length; i++) {
            if (points[i - 1].compareTo(points[i]) == 0) {
                return true;
            }
        }

        return false;
    }

    private boolean hasNull(Point[] points) {
        for(int i = 0; i < points.length; i++) {
            if(points[i] == null) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Point[] points = new Point[] {
                new Point(1, 1), new Point(2, 2),
                new Point(3, 3), new Point(4, 4),
                new Point(2, 3), new Point(3, 1),
                new Point(2, 0), new Point(3, 0),
                new Point(5, 0), new Point(1, 0),
        };

        BruteCollinearPoints bcp = new BruteCollinearPoints(points);
        LineSegment[] collinearPointSegments = bcp.segments();

        for (LineSegment ls : collinearPointSegments) {
            System.out.println(ls);
            // ls.draw();
        }
    }
}
