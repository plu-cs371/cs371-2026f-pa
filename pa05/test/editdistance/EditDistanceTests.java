package editdistance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class EditDistanceTests {

    @ParameterizedTest
    @MethodSource("argSource")
    public void testBottomUp(String start, String end, int expected) {
        EditDistanceSolver solver = new EditDistanceSolver(start, end);
        assertEquals(expected, solver.editDistance());
    }

    @ParameterizedTest
    @MethodSource("argSource")
    public void testRecursiveWithMemo(String start, String end, int expected) {
        EditDistanceSolver solver = new EditDistanceSolver(start, end);
        assertEquals(expected, solver.editDistanceMemo());
    }

    private static Stream<Arguments> argSource() {
        return Stream.of(
                arguments("horse","ros",3),
                        arguments("intention","execution",5),
                        arguments("algorithm","altruistic",6),
                        arguments("abcdef","axbxcdf",3),
                        arguments("food","money",4),
                        arguments("food","mono",3),
                        arguments("oeofandvawefojn349bdfeubnsdfsdifbvkjdfwqrigsag","faoienw3u98sbdvbwe7vdhiwebfuebiwm",37),
                        arguments("pywtbcesgwudskcijhyotkxcqqrfddxtnfpduusclrgiilfliz","pywbcesgudskcijhyotkxcqaaaqrxtnfpduuscrgiilfliz",8)
        );
    }

}
