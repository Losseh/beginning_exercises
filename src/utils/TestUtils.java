package utils;

import static org.junit.Assert.assertTrue;

/**
 * Created by losseh on 18.08.17.
 */
final public class TestUtils {

    public static void assertThatNumberIsCloseTo(Double actual, Double expected, Double tolerance)
    {
        assertTrue(expected - tolerance < actual && actual < expected + tolerance);
    }
}
