package org.desertskyrangers.caspian.element;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.desertskyrangers.caspian.assertion.DoubleArrayAssert.assertThat;

public class UniformVortexPanelTest {

	@ParameterizedTest
	@MethodSource( "velocityValues" )
	void testVelocity( double x, double y, double x1, double y1, double strength, double px, double py, double u, double v ) {
		assertThat( new UniformVortexPanel( x, y, x1, y1, strength ).velocity( px, py ) ).isCloseTo( new double[]{ u, v } );
	}

	private static Stream<Arguments> velocityValues() {
		return Stream.of(
			// Y = 2
			Arguments.of( -1, 0, 1, 0, 1, -2, 2, -0.08262467026928397, -0.07603718482849817 ),
			Arguments.of( -1, 0, 1, 0, 1, -1, 2, -0.125, -0.05515890003816289 ),
			Arguments.of( -1, 0, 1, 0, 1, 0, 2, -0.1475836176504333, 0 ),
			Arguments.of( -1, 0, 1, 0, 1, 1, 2, -0.125, 0.05515890003816289 ),
			Arguments.of( -1, 0, 1, 0, 1, 2, 2, -0.08262467026928395, 0.07603718482849817 ),
			// Y = 1
			Arguments.of( -1, 0, 1, 0, 1, -2, 1, -0.07379180882521665, -0.12807499968169406 ),
			Arguments.of( -1, 0, 1, 0, 1, -1, 1, -0.17620819117478337, -0.12807499968169403 ),
			Arguments.of( -1, 0, 1, 0, 1, 0, 1, -0.25, 0.0 ),
			Arguments.of( -1, 0, 1, 0, 1, 1, 1, -0.17620819117478337, 0.12807499968169403 ),
			Arguments.of( -1, 0, 1, 0, 1, 2, 1, -0.07379180882521665, 0.12807499968169406 ),
			// Y = Double.MIN_NORMAL
			Arguments.of( -1, 0, 1, 0, 1, -2, Double.MIN_NORMAL, 0.0, -0.1748495762830299 ),
			Arguments.of( -1, 0, 1, 0, 1, -1, Double.MIN_NORMAL, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( -1, 0, 1, 0, 1, -0.5, Double.MIN_NORMAL, -0.5, -0.1748495762830299 ),
			Arguments.of( -1, 0, 1, 0, 1, 0, Double.MIN_NORMAL, -0.5, 0.0 ),
			Arguments.of( -1, 0, 1, 0, 1, 0.5, Double.MIN_NORMAL, -0.5, 0.1748495762830299 ),
			Arguments.of( -1, 0, 1, 0, 1, 1, Double.MIN_NORMAL, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( -1, 0, 1, 0, 1, 2, Double.MIN_NORMAL, 0.0, 0.1748495762830299 ),
			// Y = 0
			Arguments.of( -1, 0, 1, 0, 1, -2, 0, 0.0, -0.1748495762830299 ),
			Arguments.of( -1, 0, 1, 0, 1, -1, 0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( -1, 0, 1, 0, 1, -0.5, 0, -0.5, -0.1748495762830299 ),
			Arguments.of( -1, 0, 1, 0, 1, 0, 0, -0.5, 0.0 ),
			Arguments.of( -1, 0, 1, 0, 1, 0.5, 0, -0.5, 0.1748495762830299 ),
			Arguments.of( -1, 0, 1, 0, 1, 1, 0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( -1, 0, 1, 0, 1, 2, 0, 0.0, 0.1748495762830299 ),
			// Y = -Double.MIN_NORMAL
			Arguments.of( -1, 0, 1, 0, 1, -2, -Double.MIN_NORMAL, 0.0, -0.1748495762830299 ),
			Arguments.of( -1, 0, 1, 0, 1, -1, -Double.MIN_NORMAL, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( -1, 0, 1, 0, 1, -0.5, -Double.MIN_NORMAL, 0.5, -0.1748495762830299 ),
			Arguments.of( -1, 0, 1, 0, 1, 0, -Double.MIN_NORMAL, 0.5, 0.0 ),
			Arguments.of( -1, 0, 1, 0, 1, 0.5, -Double.MIN_NORMAL, 0.5, 0.1748495762830299 ),
			Arguments.of( -1, 0, 1, 0, 1, 1, -Double.MIN_NORMAL, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( -1, 0, 1, 0, 1, 2, -Double.MIN_NORMAL, 0.0, 0.1748495762830299 ),
			// Y = -1
			Arguments.of( -1, 0, 1, 0, 1, -2, -1, 0.07379180882521665, -0.12807499968169406 ),
			Arguments.of( -1, 0, 1, 0, 1, -1, -1, 0.17620819117478337, -0.12807499968169403 ),
			Arguments.of( -1, 0, 1, 0, 1, 0, -1, 0.25, 0.0 ),
			Arguments.of( -1, 0, 1, 0, 1, 1, -1, 0.17620819117478337, 0.12807499968169403 ),
			Arguments.of( -1, 0, 1, 0, 1, 2, -1, 0.07379180882521665, 0.12807499968169406 ),
			// Y = -2
			Arguments.of( -1, 0, 1, 0, 1, -2, -2, 0.08262467026928397, -0.07603718482849817 ),
			Arguments.of( -1, 0, 1, 0, 1, -1, -2, 0.125, -0.05515890003816289 ),
			Arguments.of( -1, 0, 1, 0, 1, 0, -2, 0.1475836176504333, 0 ),
			Arguments.of( -1, 0, 1, 0, 1, 1, -2, 0.125, 0.05515890003816289 ),
			Arguments.of( -1, 0, 1, 0, 1, 2, -2, 0.08262467026928397, 0.07603718482849817 )
		);
	}

}
