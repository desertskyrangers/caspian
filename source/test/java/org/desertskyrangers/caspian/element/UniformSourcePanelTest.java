package org.desertskyrangers.caspian.element;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.desertskyrangers.caspian.assertion.DoubleArrayAssert.assertThat;

public class UniformSourcePanelTest {

	@ParameterizedTest
	@MethodSource( "velocityValues" )
	void testVelocity( double x, double y, double x1, double y1, double strength, double px, double py, double u, double v ) {
		assertThat( new UniformSourcePanel( x, y, x1, y1, strength ).velocity( px, py ) ).isCloseTo( new double[]{ u, v } );
	}

	private static Stream<Arguments> velocityValues() {
		return Stream.of(
			// Y = 2
			Arguments.of( -1, 0, 1, 0, 1, -2, 2, -0.07603718482849817, 0.08262467026928397 ),
			Arguments.of( -1, 0, 1, 0, 1, -1, 2, -0.05515890003816289, 0.125 ),
			Arguments.of( -1, 0, 1, 0, 1, 0, 2, 0, 0.1475836176504333 ),
			Arguments.of( -1, 0, 1, 0, 1, 1, 2, 0.05515890003816289, 0.125 ),
			Arguments.of( -1, 0, 1, 0, 1, 2, 2, 0.07603718482849817, 0.08262467026928395 ),
			// Y = 1
			Arguments.of( -1, 0, 1, 0, 1, -2, 1, -0.12807499968169406, 0.07379180882521665 ),
			Arguments.of( -1, 0, 1, 0, 1, -1, 1, -0.12807499968169403, 0.17620819117478337 ),
			Arguments.of( -1, 0, 1, 0, 1, 0, 1, 0.0, 0.25 ),
			Arguments.of( -1, 0, 1, 0, 1, 1, 1, 0.12807499968169403, 0.17620819117478337 ),
			Arguments.of( -1, 0, 1, 0, 1, 2, 1, 0.12807499968169406, 0.07379180882521665 ),
			// Y = Double.MIN_NORMAL
			Arguments.of( -1, 0, 1, 0, 1, -2, Double.MIN_NORMAL, -0.1748495762830299, 0.0 ),
			Arguments.of( -1, 0, 1, 0, 1, -1, Double.MIN_NORMAL, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( -1, 0, 1, 0, 1, -0.5, Double.MIN_NORMAL, -0.1748495762830299, 0.5 ),
			Arguments.of( -1, 0, 1, 0, 1, 0, Double.MIN_NORMAL, 0.0, 0.5 ),
			Arguments.of( -1, 0, 1, 0, 1, 0.5, Double.MIN_NORMAL, 0.1748495762830299, 0.5 ),
			Arguments.of( -1, 0, 1, 0, 1, 1, Double.MIN_NORMAL, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( -1, 0, 1, 0, 1, 2, Double.MIN_NORMAL, 0.1748495762830299, 0.0 ),
			// Y = 0
			Arguments.of( -1, 0, 1, 0, 1, -2, 0, -0.1748495762830299, 0.0 ),
			Arguments.of( -1, 0, 1, 0, 1, -1, 0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( -1, 0, 1, 0, 1, -0.5, 0, -0.1748495762830299, 0.5 ),
			Arguments.of( -1, 0, 1, 0, 1, 0, 0, 0.0, 0.5 ),
			Arguments.of( -1, 0, 1, 0, 1, 0.5, 0, 0.1748495762830299, 0.5 ),
			Arguments.of( -1, 0, 1, 0, 1, 1, 0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( -1, 0, 1, 0, 1, 2, 0, 0.1748495762830299, 0.0 ),
			// Y = -Double.MIN_NORMAL
			Arguments.of( -1, 0, 1, 0, 1, -2, -Double.MIN_NORMAL, -0.1748495762830299, 0.0 ),
			Arguments.of( -1, 0, 1, 0, 1, -1, -Double.MIN_NORMAL, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( -1, 0, 1, 0, 1, -0.5, -Double.MIN_NORMAL, -0.1748495762830299, -0.5 ),
			Arguments.of( -1, 0, 1, 0, 1, 0, -Double.MIN_NORMAL, 0.0, -0.5 ),
			Arguments.of( -1, 0, 1, 0, 1, 0.5, -Double.MIN_NORMAL, 0.1748495762830299, -0.5 ),
			Arguments.of( -1, 0, 1, 0, 1, 1, -Double.MIN_NORMAL, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( -1, 0, 1, 0, 1, 2, -Double.MIN_NORMAL, 0.1748495762830299, 0.0 ),
			// Y = -1
			Arguments.of( -1, 0, 1, 0, 1, -2, -1, -0.12807499968169406, -0.07379180882521665 ),
			Arguments.of( -1, 0, 1, 0, 1, -1, -1, -0.12807499968169403, -0.17620819117478337 ),
			Arguments.of( -1, 0, 1, 0, 1, 0, -1, 0.0, -0.25 ),
			Arguments.of( -1, 0, 1, 0, 1, 1, -1, 0.12807499968169403, -0.17620819117478337 ),
			Arguments.of( -1, 0, 1, 0, 1, 2, -1, 0.12807499968169406, -0.07379180882521665 ),
			// Y = -2
			Arguments.of( -1, 0, 1, 0, 1, -2, -2, -0.07603718482849817, -0.08262467026928397 ),
			Arguments.of( -1, 0, 1, 0, 1, -1, -2, -0.05515890003816289, -0.125 ),
			Arguments.of( -1, 0, 1, 0, 1, 0, -2, 0, -0.1475836176504333 ),
			Arguments.of( -1, 0, 1, 0, 1, 1, -2, 0.05515890003816289, -0.125 ),
			Arguments.of( -1, 0, 1, 0, 1, 2, -2, 0.07603718482849817, -0.08262467026928397 )
		);
	}

}
