package geometry;

/**
 * Created by losseh on 18.08.17.
 */
public class Rectangle implements Shape{
    private Double width;
    private Double height;

    public Rectangle(Double width, Double height)
    {
        this.width = width;
        this.height = height;
    }

    @Override
    public Double getArea() {
        return null;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }
}
