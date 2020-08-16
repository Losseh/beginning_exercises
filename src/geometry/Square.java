package geometry;

/**
 * Created by losseh on 18.08.17.
 */
public class Square implements Shape {
    private Double width;

    public Square(Double width)
    {
        this.width = width;
    }

    @Override
    public Double getArea() {
        return null;
    }

    public Double getWidth() {
        return width;
    }
}
