package genetics.eyes;

import java.util.Collections;
import java.util.List;

/**
 * Created by losseh on 16.08.17.
 *
 * Class represents two gene genotype for eyes coloring.
 */
public class Genotype {
    private List<DarkAllele> darkAlleles;
    private List<LightAllele> lightAlleles;

    public Genotype(List<DarkAllele> darkAlleles, List<LightAllele> lightAlleles)
    {
        assert darkAlleles != null && darkAlleles.size() == 2;
        assert lightAlleles != null && lightAlleles.size() == 2;

        this.darkAlleles = darkAlleles;
        this.lightAlleles = lightAlleles;
    }

    public List<DarkAllele> getDarkAlleles() {
        return Collections.unmodifiableList(darkAlleles);
    }

    public List<LightAllele> getLightAlleles() {
        return Collections.unmodifiableList(lightAlleles);
    }

    @Override
    public boolean equals(Object other)
    {
        if (other instanceof Genotype)
        {
            Genotype otherGenotype = (Genotype) other;
            return this.darkAlleles.equals(otherGenotype.darkAlleles) &&
                    this.lightAlleles.equals(otherGenotype.lightAlleles);
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return darkAlleles.hashCode() * 31 + lightAlleles.hashCode();
    }

    public enum DarkAllele
    {
        DARK, NONDARK
    }

    public enum LightAllele
    {
        GREEN, BLUE
    }

}
