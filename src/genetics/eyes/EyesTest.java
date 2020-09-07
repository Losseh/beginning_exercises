package genetics.eyes;

import static genetics.eyes.Color.BROWN;
import static genetics.eyes.Color.DARK_GREEN;
import static genetics.eyes.Color.LIGHT_GREEN;
import static genetics.eyes.Genotype.DarkAllele.DARK;
import static genetics.eyes.Genotype.DarkAllele.NONDARK;
import static genetics.eyes.Genotype.LightAllele.BLUE;
import static genetics.eyes.Genotype.LightAllele.GREEN;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import utils.TestUtils;

/**
 * Created by losseh on 16.08.17.
 */
public class EyesTest {

    private static final int SAMPLES = 10000;

    private static final Double TOLERANCE = 0.02;

    @Test
    public void testNoDarkEyesAndBothLightAllelesGreenResultsInDarkGreen()
    {
        //when
        final Eyes eyes = new Eyes(new Genotype(asList(NONDARK, NONDARK), asList(GREEN, GREEN)));

        //then
        assertThat(eyes.getColor(), is(DARK_GREEN));
    }

    @Test
    public void testNoDarkEyesAndOneLightAlleleGreenOneBlueResultsInLightGreen()
    {
        //when
        final Eyes eyes0 = new Eyes(new Genotype(asList(NONDARK, NONDARK), asList(BLUE, GREEN)));
        final Eyes eyes1 = new Eyes(new Genotype(asList(NONDARK, NONDARK), asList(BLUE, GREEN)));

        //then
        assertThat(eyes0.getColor(), is(LIGHT_GREEN));
        assertThat(eyes1.getColor(), is(LIGHT_GREEN));
    }

    @Test
    public void testNonDarkAndBothLightAllelesBlueResultsInBlue()
    {
        //when
        final Eyes eyes = new Eyes(new Genotype(asList(NONDARK, NONDARK), asList(BLUE, BLUE)));

        //then
        assertThat(eyes.getColor(), is(Color.BLUE));
    }

    @Test
    public void testAnyDarkAlleleActiveResultsInDarkEyes()
    {
        //when
        final Eyes eyes0 = new Eyes(new Genotype(asList(DARK, NONDARK), asList(BLUE, BLUE)));
        final Eyes eyes1 = new Eyes(new Genotype(asList(DARK, DARK), asList(GREEN, BLUE)));
        final Eyes eyes2 = new Eyes(new Genotype(asList(DARK, NONDARK), asList(BLUE, GREEN)));
        final Eyes eyes3 = new Eyes(new Genotype(asList(DARK, NONDARK), asList(GREEN, GREEN)));

        //then
        assertThat(eyes0.getColor(), is(BROWN));
        assertThat(eyes1.getColor(), is(BROWN));
        assertThat(eyes2.getColor(), is(BROWN));
        assertThat(eyes3.getColor(), is(BROWN));
    }

    @Test
    public void childrenOfBlueEyedParents()
    {
        //given
        final Eyes blueEyes = new Eyes(new Genotype(asList(NONDARK, NONDARK), asList(BLUE, BLUE)));
        final Eyes mother = blueEyes;
        final Eyes father = blueEyes;

        //when
        Map<Color, Double> colorsFrequency = countColorFrequency(getChildren(mother, father));

        //then
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.BLUE), 1.);
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.LIGHT_GREEN), 0.);
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.DARK_GREEN), 0.);
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.BROWN), 0.);
    }

    @Test
    public void childrenOfHeterozygousAtBothAlleles()
    {
        //given
        final Eyes brown0 = new Eyes(new Genotype(asList(DARK, NONDARK), asList(BLUE, GREEN)));
        final Eyes brown1 = new Eyes(new Genotype(asList(DARK, NONDARK), asList(GREEN, BLUE)));

        //when
        Map<Color, Double> colorsFrequency = countColorFrequency(getChildren(brown0, brown1));

        //then
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.BLUE), 1./16);
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.LIGHT_GREEN), 2./16);
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.DARK_GREEN), 1./16);
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.BROWN), 12./16);
    }

    @Test
    public void childrenOfBrownAndLightEyed()
    {
        //given
        final Eyes brown0 = new Eyes(new Genotype(asList(NONDARK, NONDARK), asList(BLUE, GREEN)));
        final Eyes brown1 = new Eyes(new Genotype(asList(DARK, NONDARK), asList(GREEN, BLUE)));

        //when
        Map<Color, Double> colorsFrequency = countColorFrequency(getChildren(brown0, brown1));

        //then
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.BLUE), 1./8);
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.LIGHT_GREEN), 1./4);
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.DARK_GREEN), 1./8);
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.BROWN), 1./2);
    }

    /**
     * ;)
     */
    @Test
    public void childrenOfJustynaAndAdrian()
    {
        //given
        final Eyes justyna = new Eyes(new Genotype(asList(NONDARK, NONDARK), asList(BLUE, BLUE)));
        final Eyes adrian = new Eyes(new Genotype(asList(NONDARK, NONDARK), asList(GREEN, BLUE)));

        //when
        Map<Color, Double> colorsFrequency = countColorFrequency(getChildren(justyna, adrian));

        //then
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.BLUE), 1./2);
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.LIGHT_GREEN), 1./2);
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.DARK_GREEN), 0.);
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.BROWN), 0.);
    }

    @Test
    public void childrenOfBrownHomozygousAtDarkAllele()
    {
        //given
        final Eyes brown0 = new Eyes(new Genotype(asList(DARK, DARK), asList(BLUE, GREEN)));
        final Eyes brown1 = new Eyes(new Genotype(asList(DARK, DARK), asList(GREEN, GREEN)));

        //when
        Map<Color, Double> colorsFrequency = countColorFrequency(getChildren(brown0, brown1));

        //then
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.BLUE), 0.);
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.LIGHT_GREEN), 0.);
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.DARK_GREEN), 0.);
        assertThatNumberIsCloseTo(colorsFrequency.get(Color.BROWN), 1.);
    }

    private Collection<Eyes> getChildren(final Eyes parent0, final Eyes parent1)
    {
        return IntStream
                .range(0, SAMPLES)
                .mapToObj(i -> Eyes.inherit(parent0, parent1)).collect(Collectors.toList());
    }

    private Map<Color, List<Eyes>> groupByColor(Collection<Eyes> eyesCollection)
    {
        return eyesCollection
                .stream()
                .collect(Collectors.groupingBy(Eyes::getColor));
    }

    private Map<Color, Double> countColorFrequency(Collection<Eyes> eyesCollection)
    {
        Map<Color, Double> result = new HashMap<>();
        result.put(Color.BLUE, 0.);
        result.put(Color.LIGHT_GREEN, 0.);
        result.put(Color.DARK_GREEN, 0.);
        result.put(Color.BROWN, 0.);

        for (Map.Entry<Color, List<Eyes>> colorListEntry : groupByColor(eyesCollection).entrySet()) {
            result.put(colorListEntry.getKey(), 1. * colorListEntry.getValue().size() / SAMPLES);
        }

        return result;
    }

    private void assertThatNumberIsCloseTo(Double actual, Double expected)
    {
        TestUtils.assertThatNumberIsCloseTo(actual, expected, TOLERANCE);
    }
}