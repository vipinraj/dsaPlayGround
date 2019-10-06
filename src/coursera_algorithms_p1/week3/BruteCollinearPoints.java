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
    private int numOfSegments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(points);

        if (hasDuplicate(points)) {
            throw new IllegalArgumentException();
        }


        this.points = points;
    }


    public int numberOfSegments() {
        return numOfSegments;
    }

    public LineSegment[] segments() {
        ArrayList<LineSegment> segments = new ArrayList<LineSegment>();
        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                double slopeIJ = points[i].slopeTo(points[j]);
                for(int k = j + 1; k < points.length; k++) {
                    double slopeJK = points[j].slopeTo(points[k]);
                    for (int l = k + 1; l < points.length; l++) {
                        double slopeKL = points[k].slopeTo(points[l]);
                        if (slopeIJ == slopeJK && slopeJK == slopeKL) {
                            numOfSegments++;
                            segments.add(new LineSegment(points[i], points[l]));
                        }
                    }
                }
            }
        }

        LineSegment[] lineSegments = new LineSegment[segments.size()];

        return segments.toArray(lineSegments);
    }

    private boolean hasDuplicate(Point[] points) {
        Point prev = points[0];

        for (int i = 1; i < points.length; i++) {
            if (prev.compareTo(points[i]) == 0) {
                return true;
            }

            prev = points[i];
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
