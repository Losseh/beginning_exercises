package complex;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import utils.TestUtils;

public class ComplexTest {
    @Test
    public void basicProperties()
    {
        final Complex a = new Complex(1, 2);

        assertThat(a.real(), is(1.0));
        assertThat(a.imag(), is(2.0));
        TestUtils.assertThatNumberIsCloseTo(a.abs(), 2.236, 0.001);
    }
}
