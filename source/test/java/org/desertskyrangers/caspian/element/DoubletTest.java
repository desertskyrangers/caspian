package org.desertskyrangers.caspian.element;

import org.desertskyrangers.caspian.Cfd;
import org.desertskyrangers.caspian.Vector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.desertskyrangers.caspian.assertion.DoubleArrayAssert.assertThat;

public class DoubletTest {

	@ParameterizedTest
	@MethodSource( "velocityValues" )
	void velocity_ShouldCalculateTheDoubletVelocity( double x, double y, double angle, double strength, double px, double py, double u, double v ) {
		assertThat( new Doublet( x, y, angle, strength ).velocity( px, py ) ).isCloseTo( new double[]{ u, v } );
	}

	@Test
	void testVelocity() {
		// Different strength, far location
		//assertThat( new Doublet( 0, 0, 0, 5 ).velocity( 7, 0 ) ).isEqualTo( new double[]{ -5.0 / (7 * 7), 0.0 } );

		//		// Angled doublets
		//		//assertThat( new Doublet( 0, 0, 0.25 * Math.PI, 1 ).velocity( -sqrtHalf, sqrtHalf )[ 0 ] ).isCloseTo( sqrtHalf * 1 / (Cfd.TWO_PI * 1 * 1), Offset.offset( 1e-16 ) );
		//		assertThat( new Doublet( 0, 0, 0.25 * Math.PI, 1 ).velocity( -sqrtHalf, sqrtHalf )[ 1 ] ).isCloseTo( sqrtHalf * 1 / (Cfd.TWO_PI * 1 * 1), Offset.offset( 1e-16 ) );
	}

	@Test
	void testVelocityAtSpecificRadius() {
		double u = 1;
		double r = 0.5;
		double mu = u * Cfd.TWO_PI * r * r;
		assertThat( new Doublet( 0, 0, 0, mu ).velocity( -r, 0 ) ).isCloseTo( new double[]{ -1.0, 0.0 } );
		assertThat( new Doublet( 0, 0, 0, mu ).velocity( r, 0 ) ).isCloseTo( new double[]{ -1.0, 0.0 } );
	}

	//	@Test
	//	void testStream() {
	//				assertThat( new Doublet( 0, 0, 1 ).stream( 0, 0 ) ).isEqualTo( 0 );
	//
	//				assertThat( new Doublet( 0, 0, 1 ).stream( 1, 0 ) ).isEqualTo( 0 );
	//				assertThat( new Doublet( 0, 0, 1 ).stream( 0, 1 ) ).isEqualTo( -0.25 );
	//				assertThat( new Doublet( 0, 0, 1 ).stream( -1, 0 ) ).isEqualTo( -0.5 );
	//				assertThat( new Doublet( 0, 0, 1 ).stream( 0, -1 ) ).isEqualTo( 0.25 );
	//	}
	//
	//	@Test
	//	void testPotential() {
	//				assertThat( new Doublet( 0, 0, 1 ).potential( 0, 0 ) ).isEqualTo( Double.POSITIVE_INFINITY );
	//				assertThat( new Doublet( 0, 0, 1 ).potential( 0.5, 0 ) ).isEqualTo( -Math.log( 0.5 ) / Cfd.TWO_PI );
	//				assertThat( new Doublet( 0, 0, 1 ).potential( 1, 0 ) ).isEqualTo( 0 );
	//				assertThat( new Doublet( 0, 0, 1 ).potential( 2, 0 ) ).isEqualTo( -Math.log( 2 ) / Cfd.TWO_PI );
	//	}

	private static Stream<Arguments> velocityValues() {
		return Stream.of(
			// Y = 2
			Arguments.of( 0, 0, 0, 1, -2, 2, 0.0, 0.019894367886486918 ),
			Arguments.of( 0, 0, 0, 1, -1, 2, 0.01909859317102744, 0.025464790894703257 ),
			Arguments.of( 0, 0, 0, 1, 0, 2, 0.039788735772973836, 0.0 ),
			Arguments.of( 0, 0, 0, 1, 1, 2, 0.01909859317102744, -0.025464790894703257 ),
			Arguments.of( 0, 0, 0, 1, 2, 2, 0.0, -0.019894367886486918 ),
			// Y = 1
			Arguments.of( 0, 0, 0, 1, -2, 1, -0.01909859317102744, 0.025464790894703257 ),
			Arguments.of( 0, 0, 0, 1, -1, 1, 0.0, 0.07957747154594767 ),
			Arguments.of( 0, 0, 0, 1, 0, 1, 0.15915494309189535, 0 ),
			Arguments.of( 0, 0, 0, 1, 1, 1, 0.0, -0.07957747154594767 ),
			Arguments.of( 0, 0, 0, 1, 2, 1, -0.01909859317102744, -0.025464790894703257 ),
			// Y = 0
			Arguments.of( 0, 0, 0, 1, -2, 0, -0.039788735772973836, 0 ),
			Arguments.of( 0, 0, 0, 1, -1, 0, -0.15915494309189535, 0 ),
			Arguments.of( 0, 0, 0, 1, 0, 0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( 0, 0, 0, 1, 1, 0, -0.15915494309189535, 0 ),
			Arguments.of( 0, 0, 0, 1, 2, 0, -0.039788735772973836, 0 ),
			// Y = -1
			Arguments.of( 0, 0, 0, 1, -2, -1, -0.01909859317102744, -0.025464790894703257 ),
			Arguments.of( 0, 0, 0, 1, -1, -1, 0.0, -0.07957747154594767 ),
			Arguments.of( 0, 0, 0, 1, 0, -1, 0.15915494309189535, 0.0 ),
			Arguments.of( 0, 0, 0, 1, 1, -1, 0.0, 0.07957747154594767 ),
			Arguments.of( 0, 0, 0, 1, 2, -1, -0.01909859317102744, 0.025464790894703257 ),
			// Y = -2
			Arguments.of( 0, 0, 0, 1, -2, -2, 0.0, -0.019894367886486918 ),
			Arguments.of( 0, 0, 0, 1, -1, -2, 0.01909859317102744, -0.025464790894703257 ),
			Arguments.of( 0, 0, 0, 1, 0, -2, 0.039788735772973836, 0.0 ),
			Arguments.of( 0, 0, 0, 1, 1, -2, 0.01909859317102744, 0.025464790894703257 ),
			Arguments.of( 0, 0, 0, 1, 2, -2, 0.0, 0.019894367886486918 )
		);
	}

}
