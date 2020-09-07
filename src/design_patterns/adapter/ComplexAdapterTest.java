package design_patterns.adapter;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.data.Percentage;
import org.junit.Test;

import complex.Complex;

/**
 * TODO ASZ: comment me!
 */
public class ComplexAdapterTest {
    @Test
    public void testOnlyReal() {
        final Complex adaptee = new Complex(1, 0);

        final ComplexToPolarAdapter adapter = new ComplexToPolarAdapter(adaptee);

        assertThat(adapter.getAbs()).isCloseTo(1, Percentage.withPercentage(1));
        assertThat(adapter.getAngle()).isCloseTo(0, Percentage.withPercentage(2));
    }

    @Test
    public void testOnlyImag() {
        final Complex adaptee = new Complex(0, 1);

        final ComplexToPolarAdapter adapter = new ComplexToPolarAdapter(adaptee);

        assertThat(adapter.getAbs()).isCloseTo(1, Percentage.withPercentage(1));
        assertThat(adapter.getAngle()).isCloseTo(Math.PI/2, Percentage.withPercentage(2));
    }

    @Test
    public void testMixed() {
        final Complex adaptee = new Complex(1, 1);

        final ComplexToPolarAdapter adapter = new ComplexToPolarAdapter(adaptee);

        assertThat(adapter.getAbs()).isCloseTo(1.4142, Percentage.withPercentage(1));
        assertThat(adapter.getAngle()).isCloseTo(Math.PI/4, Percentage.withPercentage(2));
    }
}
