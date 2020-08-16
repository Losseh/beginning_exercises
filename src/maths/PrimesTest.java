package maths;

import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by losseh on 16.08.17.
 */
public class PrimesTest {
    @Test
    public void isPrime()
    {
        assertThat(Primes.isPrime(0), is(false));
        assertThat(Primes.isPrime(1), is(false));
        assertThat(Primes.isPrime(4), is(false));
        assertThat(Primes.isPrime(30), is(false));
        assertThat(Primes.isPrime(96), is(false));
        assertThat(Primes.isPrime(910), is(false));

        assertThat(Primes.isPrime(2), is(true));
        assertThat(Primes.isPrime(3), is(true));
        assertThat(Primes.isPrime(17), is(true));
        assertThat(Primes.isPrime(29), is(true));
        assertThat(Primes.isPrime(89), is(true));
        assertThat(Primes.isPrime(97), is(true));
        assertThat(Primes.isPrime(911), is(true));
    }

    @Test
    public void getOneFirstPrimes()
    {
        Collection<Integer> firstPrimes = Primes.getFirstPrimes(1);

        assertThat(firstPrimes.size(), is(1));
        assertThat(firstPrimes, hasItem(2));
    }

    @Test
    public void getFiveFirstPrimes()
    {
        Collection<Integer> firstPrimes = Primes.getFirstPrimes(5);

        assertThat(firstPrimes.size(), is(5));
        assertThat(firstPrimes, hasItem(2));
        assertThat(firstPrimes, hasItem(3));
        assertThat(firstPrimes, hasItem(5));
        assertThat(firstPrimes, hasItem(7));
        assertThat(firstPrimes, hasItem(11));
    }

    @Test
    public void getTenFirstPrimes()
    {
        Collection<Integer> firstPrimes = Primes.getFirstPrimes(10);

        assertThat(firstPrimes.size(), is(5));
        assertThat(firstPrimes, hasItem(2));
        assertThat(firstPrimes, hasItem(3));
        assertThat(firstPrimes, hasItem(5));
        assertThat(firstPrimes, hasItem(7));
        assertThat(firstPrimes, hasItem(11));
        assertThat(firstPrimes, hasItem(13));
        assertThat(firstPrimes, hasItem(17));
        assertThat(firstPrimes, hasItem(19));
        assertThat(firstPrimes, hasItem(23));
        assertThat(firstPrimes, hasItem(29));
    }

}