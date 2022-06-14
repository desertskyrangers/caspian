package org.desertskyrangers.caspian.element;

import org.desertskyrangers.caspian.Cfd;
import org.desertskyrangers.caspian.assertion.DoubleArrayAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SourceTest {

	@ParameterizedTest
	@MethodSource( "velocityValues" )
	void velocity_ShouldCalculateTheSourceVelocity( double x, double y, double strength, double px, double py, double u, double v ) {
		DoubleArrayAssert.assertThat( new Source( x, y, strength ).velocity( px, py ) ).isCloseTo( new double[]{ u, v } );
	}

	@Test
	void testVelocity() {
		assertThat( new Source( 0, 0, 5 ).velocity( 7, 0 ) ).isEqualTo( new double[]{ 5 / (Cfd.TWO_PI * 7), 0 } );
	}

	//	@Test
	//	void testStream() {
	//		assertThat( new Source( 0, 0, 1 ).stream( 0, 0 ) ).isEqualTo( 0 );
	//
	//		assertThat( new Source( 0, 0, 1 ).stream( 1, 0 ) ).isEqualTo( 0 );
	//		assertThat( new Source( 0, 0, 1 ).stream( 0, 1 ) ).isEqualTo( -0.25 );
	//		assertThat( new Source( 0, 0, 1 ).stream( -1, 0 ) ).isEqualTo( -0.5 );
	//		assertThat( new Source( 0, 0, 1 ).stream( 0, -1 ) ).isEqualTo( 0.25 );
	//	}

	//	@Test
	//	void testPotential() {
	//		assertThat( new Source( 0, 0, 1 ).potential( 0, 0 ) ).isEqualTo( Double.POSITIVE_INFINITY );
	//		assertThat( new Source( 0, 0, 1 ).potential( 0.5, 0 ) ).isEqualTo( -Math.log( 0.5 ) / Cfd.TWO_PI );
	//		assertThat( new Source( 0, 0, 1 ).potential( 1, 0 ) ).isEqualTo( 0 );
	//		assertThat( new Source( 0, 0, 1 ).potential( 2, 0 ) ).isEqualTo( -Math.log( 2 ) / Cfd.TWO_PI );
	//	}

	private static Stream<Arguments> velocityValues() {
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

}
