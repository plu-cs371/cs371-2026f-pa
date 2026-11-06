package convexhull;

import java.awt.geom.Point2D;
import java.util.*;

public class QuickHullSolver {

    private List<Point2D.Double> pts;

    public QuickHullSolver(List<Point2D.Double> points) {
        pts = points;
    }

    public List<Point2D.Double> getPoints() {
        return new ArrayList<>(pts);
    }

    /**
     * Find the convex hull of the points in this object (variable points)
     * using the divide-and-conquer "quick-hull" algorithm.  For full credit, your
     * solution must produce the points in the order requested without post-sorting or
     * reordering.
     *
     * @return a list of the indices of the points that make up the convex hull
     * starting with the point with the minimum x coordinate and proceeding
     * clockwise around the hull.
     */
    public List<Integer> solve( ) {
        // Implement this method

        return null;
    }

}
