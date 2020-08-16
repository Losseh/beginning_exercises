package geometry;

/**
 * Created by losseh on 18.08.17.
 */
public class DiscFraction extends Disc {
    private Double angle;

    public DiscFraction(Double radius, Double angle) {
        super(radius);

        assert angle >= 0 && angle <= 2 * Math.PI;
        this.angle = angle;
    }

    @Override
    public Double getArea()
    {
        return null;
    }

    public Double getAngle() {
        return null;
    }
}
