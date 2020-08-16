package genetics.eyes;

/**
 * Created by losseh on 16.08.17.
 *
 * Class represents eyes' genotype and fenotype. Fenotype is stored within the class instance
 * and encapsulated so that noone has access to it (exactly as it is in nature). What the user
 * can get is only the fenotype (thus what is being seen from the outside world) by method {@link #getColor()}
 */
public class Eyes {
    private Genotype genotype;

    public Eyes(Genotype genotype)
    {
        this.genotype = genotype;
    }

    // TODO to fill
    /*
     * Eyes color (fenotype) is the result * of given genotype and results in eyes colors accordingly to the link below:
     *
     * http://sandwalk.blogspot.com/2007/02/genetics-of-eye-color.html
     */
    public Color getColor()
    {
        return null;
    }

    // TODO to fill
    public static Eyes inherit(final Eyes left, final Eyes right)
    {
        return null;
    }

    private static int draw()
    {
        return (int) Math.round(Math.random()) % 2;
    }
}
