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

import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FastCollinearPoints {
    private Point[] points;
    private int numberOfSegments;

    public FastCollinearPoints(Point[] points) {
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
        return numberOfSegments;
    }

    public LineSegment[] segments() {
        ArrayList<LineSegment> segments = new ArrayList<>();
        Point[] tempArray = new Point[points.length - 1];

        for(int i = 0; i < points.length; i++) {
            Comparator<Point> comparator = points[i].slopeOrder();
            copyToTempArray(tempArray, i);
            Arrays.sort(tempArray, comparator);

            // find segments
            double prevSlope = 0;
            int count = 1;
            for (int j = 0; j < tempArray.length; j++) {
                double slope = tempArray[j].slopeTo(points[i]);
                if (j > 0) {
                    if (slope == prevSlope) {
                        count++;
                    } else {
                        if (count >= 3 && points[i].compareTo(tempArray[j - count]) < 0) {
                            segments.add(new LineSegment(points[i], tempArray[j - 1]));
                        }
                        count = 1;
                    }
                }
                prevSlope = slope;
            }
            if (count >= 3 && points[i].compareTo(tempArray[tempArray.length - count]) < 0) {
                segments.add(new LineSegment(points[i], tempArray[tempArray.length - 1]));
            }
        }

        LineSegment[] lineSegments = new LineSegment[segments.size()];
        numberOfSegments = segments.size();
        return segments.toArray(lineSegments);
    }

    private void copyToTempArray(Point[] tempArray, int excludeIdx) {
        int idx = 0;
        for (int i = 0; i < points.length; i++) {
            if (i == excludeIdx) {
                continue;
            }

            tempArray[idx++] = points[i];
        }
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

        FastCollinearPoints fcp = new FastCollinearPoints(points);
        LineSegment[] collinearPointSegments = fcp.segments();
        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (LineSegment ls : collinearPointSegments) {
            System.out.println(ls);
            ls.draw();
        }
        StdDraw.show();
    }
}
