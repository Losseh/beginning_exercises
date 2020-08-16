package geometry;

import org.junit.Test;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static geometry.ShapeUtils.findMaxAreaShape;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by losseh on 18.08.17.
 */
public class ShapeTest {
    private static final Double TOLERANCE = 10e-3;

    @Test
    public void squareGetters()
    {
        //given
        Double width = 5.1;
        Square a = new Square(width);

        //then
        assertThat(a.getWidth(), is(width));
    }

    @Test
    public void getSquareArea() {
        //given
        Shape square = new Square(2.2);

        //when
        Double area = square.getArea();

        //then
        assertThatNumberIsCloseTo(area, 4.84);
    }

    @Test
    public void RectangleGetters()
    {
        //given
        Double width = 5.1;
        Double height = 12.1;
        Rectangle a = new Rectangle(width, height);

        //then
        assertThat(a.getWidth(), is(width));
        assertThat(a.getHeight(), is(height));
    }

    @Test
    public void getRectangleArea() {
        //given
        Shape Rectangle = new Rectangle(2.2, 1.5);

        //when
        Double area = Rectangle.getArea();

        //then
        assertThatNumberIsCloseTo(area, 3.3);
    }

    @Test
    public void discGetters()
    {
        //given
        Double radius = 5.1;
        Disc a = new Disc(radius);

        //then
        assertThat(a.getRadius(), is(radius));
    }

    @Test
    public void getDiscArea() {
        //given
        Shape disc = new Disc(2.2);

        //when
        Double area = disc.getArea();

        //then
        assertThatNumberIsCloseTo(area, 15.205);
    }

    @Test
    public void discFractionGetters()
    {
        //given
        Double radius = 5.1;
        Double angle = 0.2;

        DiscFraction a = new DiscFraction(radius, angle);

        //then
        assertThat(a.getRadius(), is(radius));
        assertThat(a.getAngle(), is(angle));
    }

    @Test
    public void getDiscFractionArea() {
        //given
        Shape disc = new DiscFraction(2.2, Math.PI/6);

        //when
        Double area = disc.getArea();

        //then
        assertThatNumberIsCloseTo(area, 1.267095);
    }
    
    @Test
    public void testFindMaxAreaShape()
    {
        //given
        Square square = new Square(2.);
        Disc disc = new Disc(1.15);
        DiscFraction discFraction = new DiscFraction(4.1, 0.5);
        Rectangle rectangle = new Rectangle(2.1, 1.61);

        Collection<Shape> shapes = new HashSet<>();
        shapes.add(square);
        shapes.add(discFraction);
        shapes.add(rectangle);
        shapes.add(disc);

        //when
        Shape biggestShape = findMaxAreaShape(shapes);

        //then
        assertThat(biggestShape, is(discFraction));
    }


    private void assertThatNumberIsCloseTo(Double actual, Double expected)
    {
        TestUtils.assertThatNumberIsCloseTo(actual, expected, TOLERANCE);
    }
}