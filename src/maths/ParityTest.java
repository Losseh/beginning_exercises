package maths;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by losseh on 16.08.17.
 */
public class ParityTest {
    @Test
    public void isEven()
    {
        assertThat(Parity.isEven(1), is(false));
        assertThat(Parity.isEven(3), is(false));
        assertThat(Parity.isEven(17), is(false));
        assertThat(Parity.isEven(81), is(false));
        assertThat(Parity.isEven(18273891), is(false));

        assertThat(Parity.isEven(-1), is(false));

        assertThat(Parity.isEven(0), is(true));
        assertThat(Parity.isEven(2), is(true));
        assertThat(Parity.isEven(1238972), is(true));
        assertThat(Parity.isEven(-11112), is(true));
    }

    @Test
    public void isOdd()
    {
        assertThat(Parity.isOdd(1), is(true));
        assertThat(Parity.isOdd(111), is(true));
        assertThat(Parity.isOdd(2000+1), is(true));
        assertThat(Parity.isOdd(10981231), is(true));
        assertThat(Parity.isOdd(-1), is(true));
        assertThat(Parity.isOdd(-1111), is(true));

        assertThat(Parity.isOdd(0), is(false));
        assertThat(Parity.isOdd(2), is(false));
        assertThat(Parity.isOdd(1092832), is(false));
        assertThat(Parity.isOdd(-992), is(false));
    }

}