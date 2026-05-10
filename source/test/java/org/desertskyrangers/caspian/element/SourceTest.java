package org.desertskyrangers.caspian.element;

import org.desertskyrangers.caspian.Cfd;
import org.desertskyrangers.caspian.assertion.DoubleArrayAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class SourceTest {

	@ParameterizedTest
	@MethodSource( "velocity" )
	void velocity( double x, double y, double strength, double px, double py, double u, double v ) {
		DoubleArrayAssert.assertThat( new Source( x, y, strength ).velocity( px, py ) ).isCloseTo( new double[]{ u, v } );
	}

	@ParameterizedTest
	@MethodSource( "stream" )
	void stream( double x, double y, double strength, double px, double py, double expected ) {
		assertThat( new Source( x, y, strength ).stream( px, py ) ).isCloseTo( expected, within( DoubleArrayAssert.DEFAULT_CLOSENESS ) );
	}

	@ParameterizedTest
	@MethodSource( "potential" )
	void potential( double x, double y, double strength, double px, double py, double expected ) {
		assertThat( new Source( x, y, strength ).potential( px, py ) ).isCloseTo( expected, within( DoubleArrayAssert.DEFAULT_CLOSENESS ) );
	}

	private static Stream<Arguments> velocity() {
		return Stream.of(
			// Y = 2
			Arguments.of( 0, 0, 1, -2, 2, -0.039788735772973836, 0.039788735772973836 ),
			Arguments.of( 0, 0, 1, -1, 2, -0.03183098861837907, 0.06366197723675814 ),
			Arguments.of( 0, 0, 1, 0, 2, 0, 0.07957747154594767 ),
			Arguments.of( 0, 0, 1, 1, 2, 0.03183098861837907, 0.06366197723675814 ),
			Arguments.of( 0, 0, 1, 2, 2, 0.039788735772973836, 0.039788735772973836 ),
			// Y = 1
			Arguments.of( 0, 0, 1, -2, 1, -0.06366197723675814, 0.03183098861837907 ),
			Arguments.of( 0, 0, 1, -1, 1, -0.07957747154594767, 0.07957747154594767 ),
			Arguments.of( 0, 0, 1, 0, 1, 0, 0.15915494309189535 ),
			Arguments.of( 0, 0, 1, 1, 1, 0.07957747154594767, 0.07957747154594767 ),
			Arguments.of( 0, 0, 1, 2, 1, 0.06366197723675814, 0.03183098861837907 ),
			// Y = 0
			Arguments.of( 0, 0, 1, -2, 0, -0.07957747154594767, 0 ),
			Arguments.of( 0, 0, 1, -1, 0, -0.15915494309189535, 0 ),
			Arguments.of( 0, 0, 1, 0, 0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( 0, 0, 1, 1, 0, 0.15915494309189535, 0 ),
			Arguments.of( 0, 0, 1, 2, 0, 0.07957747154594767, 0 ),
			// Y = -1
			Arguments.of( 0, 0, 1, -2, -1, -0.06366197723675814, -0.03183098861837907 ),
			Arguments.of( 0, 0, 1, -1, -1, -0.07957747154594767, -0.07957747154594767 ),
			Arguments.of( 0, 0, 1, 0, -1, 0, -0.15915494309189535 ),
			Arguments.of( 0, 0, 1, 1, -1, 0.07957747154594767, -0.07957747154594767 ),
			Arguments.of( 0, 0, 1, 2, -1, 0.06366197723675814, -0.03183098861837907 ),
			// Y = -2
			Arguments.of( 0, 0, 1, -2, -2, -0.039788735772973836, -0.039788735772973836 ),
			Arguments.of( 0, 0, 1, -1, -2, -0.03183098861837907, -0.06366197723675814 ),
			Arguments.of( 0, 0, 1, 0, -2, 0, -0.07957747154594767 ),
			Arguments.of( 0, 0, 1, 1, -2, 0.03183098861837907, -0.06366197723675814 ),
			Arguments.of( 0, 0, 1, 2, -2, 0.039788735772973836, -0.039788735772973836 )
		);
	}

	private static Stream<Arguments> stream() {
		return Stream.of(
			// Y = 2
			Arguments.of( 0, 0, 1, -2, 2, -0.25 * Math.atan2( 2, -2 ) / (Math.PI / 2) ),
			Arguments.of( 0, 0, 1, -1, 2, -0.25 * Math.atan2( 2, -1 ) / (Math.PI / 2) ),
			Arguments.of( 0, 0, 1, 0, 2, -0.25 ),
			Arguments.of( 0, 0, 1, 1, 2, -0.25 * Math.atan2( 2, 1 ) / (Math.PI / 2) ),
			Arguments.of( 0, 0, 1, 2, 2, -0.25 * Math.atan2( 2, 2 ) / (Math.PI / 2) ),
			// Y = 1
			Arguments.of( 0, 0, 1, -2, 1, -0.25 * Math.atan2( 1, -2 ) / (Math.PI / 2) ),
			Arguments.of( 0, 0, 1, -1, 1, -0.375 ),
			Arguments.of( 0, 0, 1, 0, 1, -0.25 ),
			Arguments.of( 0, 0, 1, 1, 1, -0.125 ),
			Arguments.of( 0, 0, 1, 2, 1, -0.25 * Math.atan2( 1, 2 ) / (Math.PI / 2) ),
			// Y = 0
			Arguments.of( 0, 0, 1, -2, 0, -0.5 ),
			Arguments.of( 0, 0, 1, -1, 0, -0.5 ),
			Arguments.of( 0, 0, 1, 0, 0, 0 ),
			Arguments.of( 0, 0, 1, 1, 0, 0 ),
			Arguments.of( 0, 0, 1, 2, 0, 0 ),
			// Y = -1
			Arguments.of( 0, 0, 1, -2, -1, -0.25 * Math.atan2( -1, -2 ) / (Math.PI / 2) ),
			Arguments.of( 0, 0, 1, -1, -1, 0.375 ),
			Arguments.of( 0, 0, 1, 0, -1, 0.25 ),
			Arguments.of( 0, 0, 1, 1, -1, 0.125 ),
			Arguments.of( 0, 0, 1, 2, -1, -0.25 * Math.atan2( -1, 2 ) / (Math.PI / 2) ),
			// Y = -2
			Arguments.of( 0, 0, 1, -2, -2, -0.25 * Math.atan2( -2, -2 ) / (Math.PI / 2) ),
			Arguments.of( 0, 0, 1, -1, -2, -0.25 * Math.atan2( -2, -1 ) / (Math.PI / 2) ),
			Arguments.of( 0, 0, 1, 0, -2, 0.25 ),
			Arguments.of( 0, 0, 1, 1, -2, -0.25 * Math.atan2( -2, 1 ) / (Math.PI / 2) ),
			Arguments.of( 0, 0, 1, 2, -2, -0.25 * Math.atan2( -2, 2 ) / (Math.PI / 2) )
		);
	}

	private static Stream<Arguments> potential() {
		double a = -Math.log( Math.sqrt( 8 ) ) / Cfd.TWO_PI;
		double b = -Math.log( Math.sqrt( 5 ) ) / Cfd.TWO_PI;
		double c = -Math.log( Math.sqrt( 2 ) ) / Cfd.TWO_PI;
		double d = -Math.log( 2 ) / Cfd.TWO_PI;

		return Stream.of(
			// Y = 2
			Arguments.of( 0, 0, 1, -2, 2, a ),
			Arguments.of( 0, 0, 1, -1, 2, b ),
			Arguments.of( 0, 0, 1, 0, 2, d ),
			Arguments.of( 0, 0, 1, 1, 2, b ),
			Arguments.of( 0, 0, 1, 2, 2, a ),
			// Y = 1
			Arguments.of( 0, 0, 1, -2, 1, b ),
			Arguments.of( 0, 0, 1, -1, 1, c ),
			Arguments.of( 0, 0, 1, 0, 1, 0 ),
			Arguments.of( 0, 0, 1, 1, 1, c ),
			Arguments.of( 0, 0, 1, 2, 1, b ),
			// Y = 0
			Arguments.of( 0, 0, 1, -2, 0, d ),
			Arguments.of( 0, 0, 1, -1, 0, 0 ),
			Arguments.of( 0, 0, 1, 0, 0, Double.POSITIVE_INFINITY ),
			Arguments.of( 0, 0, 1, 1, 0, 0 ),
			Arguments.of( 0, 0, 1, 2, 0, d ),
			// Y = -1
			Arguments.of( 0, 0, 1, -2, -1, b ),
			Arguments.of( 0, 0, 1, -1, -1, c ),
			Arguments.of( 0, 0, 1, 0, -1, 0 ),
			Arguments.of( 0, 0, 1, 1, -1, c ),
			Arguments.of( 0, 0, 1, 2, -1, b ),
			// Y = -2
			Arguments.of( 0, 0, 1, -2, -2, a ),
			Arguments.of( 0, 0, 1, -1, -2, b ),
			Arguments.of( 0, 0, 1, 0, -2, d ),
			Arguments.of( 0, 0, 1, 1, -2, b ),
			Arguments.of( 0, 0, 1, 2, -2, a )
		);
	}

}
