package design_patterns.adapter;

import complex.Complex;

/**
 * TODO ASZ: comment me!
 */
public class ComplexToPolarAdapter {
    private Complex adaptee;

    public ComplexToPolarAdapter(final Complex complex) {
        this.adaptee = complex;
    }

    public double getAbs() {
        return 0;
    }

    public double getAngle() {
        return 0;
    }
}
