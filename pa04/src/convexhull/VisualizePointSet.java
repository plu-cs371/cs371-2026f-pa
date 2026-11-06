package convexhull;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Use this to display a graphical image of the point set.
 */
public class VisualizePointSet {

    public static void main(String[] args) throws IOException {

        // Update the Path below to point to the desired set to visualize
        Path file = Path.of("test-data", "convexhull", "big_square.dat");

        List<Point2D.Double> points = DataLoader.load(file);
        QuickHullSolver solver = new QuickHullSolver(points);
        List<Integer> hull = solver.solve();
        List<Point2D.Double> allPts = solver.getPoints();
        ConvexHullVisualizer vis = new ConvexHullVisualizer(allPts, hull, true);
        vis.setVisible(true);
    }

}
