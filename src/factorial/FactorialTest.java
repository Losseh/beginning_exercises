package factorial;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by losseh on 16.08.17.
 */
public class FactorialTest {
    @Test
    public void countMinusOne()
    {
        assertThat(Factorial.count(-1), is(1L));
    }

    @Test
    public void countZero()
    {
        assertThat(Factorial.count(0), is(1L));
    }

    @Test
    public void countOne()
    {
        assertThat(Factorial.count(1), is(1L));
    }

    @Test
    public void countTwo()
    {
        assertThat(Factorial.count(2), is(2L));
    }

    @Test
    public void countThree()
    {
        assertThat(Factorial.count(3), is(6L));
    }

    @Test
    public void countFour()
    {
        assertThat(Factorial.count(4), is(24L));
    }

    @Test
    public void countFive()
    {
        assertThat(Factorial.count(5), is(120L));
    }

    @Test
    public void countTwenty()
    {
        assertThat(Factorial.count(20), is(2432902008176640000L));
    }

}