package geometry;

/**
 * Created by losseh on 18.08.17.
 */
public class Disc implements Shape {
    private Double radius;

    public Disc(Double radius)
    {
        this.radius = radius;
    }

    @Override
    public Double getArea() {
        return null;
    }

    public Double getRadius() {
        return radius;
    }
}
