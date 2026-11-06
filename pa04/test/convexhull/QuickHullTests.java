package convexhull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.geom.Point2D;
import java.nio.file.Path;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class QuickHullTests {

    private Path testDataPath = Path.of("test-data", "convexhull");

    @ParameterizedTest
    @ValueSource(strings = {"triangle", "square_uniform", "square", "square2", "square3",
            "small_square", "med_square", "big_square",
            "disk1", "disk2", "disk3", "disk_50000"})
    public void hullTest(String fileName) throws Exception {
        List<Point2D.Double> pts = DataLoader.load(testDataPath.resolve( fileName + ".dat"));
        QuickHullSolver solver = new QuickHullSolver(pts);
        List<Integer> hull = solver.solve();
        List<Integer> expected = new ArrayList<>();
        try( Scanner scan = new Scanner(testDataPath.resolve(fileName + ".ans")) ) {
            while(scan.hasNext()) expected.add(scan.nextInt());
        }
        assertEquals(expected, hull);
    }
}
