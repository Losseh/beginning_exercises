package design_patterns.builder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import complex.Complex;

/**
 * TODO ASZ: comment me!
 */
public class ComplexBuilderTest {

    @Test
    public void simpleGetReturnsZeroComplex() {
        final ComplexBuilder builder = new ComplexBuilder();

        final Complex builtObject = builder.get();

        assertThat(builtObject).isNotNull();
        assertThat(builtObject.real()).isEqualTo(0);
        assertThat(builtObject.imag()).isEqualTo(0);
    }

    @Test
    public void onlyWithReal() {
        final ComplexBuilder builder = new ComplexBuilder();

        final Complex builtObject = builder.withReal(2).get();

        assertThat(builtObject).isNotNull();
        assertThat(builtObject.real()).isEqualTo(2);
        assertThat(builtObject.imag()).isEqualTo(0);
    }

    @Test
    public void onlyWithImag() {
        final ComplexBuilder builder = new ComplexBuilder();

        final Complex builtObject = builder.withImag(2).get();

        assertThat(builtObject).isNotNull();
        assertThat(builtObject.real()).isEqualTo(0);
        assertThat(builtObject.imag()).isEqualTo(2);
    }

    @Test
    public void withBothRealAndImag() {
        final ComplexBuilder builder = new ComplexBuilder();

        final Complex builtObject = builder
                .withReal(3)
                .withImag(2)
                .get();

        assertThat(builtObject).isNotNull();
        assertThat(builtObject.real()).isEqualTo(3);
        assertThat(builtObject.imag()).isEqualTo(2);
    }

    @Test
    public void checksWithCalls() {
        final ComplexBuilder builder = new ComplexBuilder();

        assertThat(builder.withReal(3)).isNotNull();
        assertThat(builder.withImag(3)).isNotNull();
    }
}
