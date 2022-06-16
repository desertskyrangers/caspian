package org.desertskyrangers.caspian.element;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.desertskyrangers.caspian.assertion.DoubleArrayAssert.assertThat;

public class SourceSheetTest {

	@ParameterizedTest
	@MethodSource( "velocityValues" )
	void testVelocity( double x, double y, double x1, double y1, double strength, double px, double py, double u, double v ) {
		assertThat( new SourceSheet( x, y, x1, y1, strength ).velocity( px, py ) ).isCloseTo( new double[]{ u, v } );
	}

	private static Stream<Arguments> velocityValues() {
		return Stream.of(
			// Y = 2
			//			Arguments.of( -1, 0, 1, 0, 1, -2, 2, -0.039788735772973836, 0.039788735772973836 ),
			//			Arguments.of( -1, 0, 1, 0, 1, -1, 2, -0.03183098861837907, 0.06366197723675814 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 0, 2, 0, 0.07957747154594767 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 1, 2, 0.03183098861837907, 0.06366197723675814 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 2, 2, 0.039788735772973836, 0.039788735772973836 ),
			// Y = 1
			//			Arguments.of( -1, 0, 1, 0, 1, -2, 1, -0.06366197723675814, 0.03183098861837907 ),
			//			Arguments.of( -1, 0, 1, 0, 1, -1, 1, -0.07957747154594767, 0.07957747154594767 ),
						Arguments.of( -1, 0, 1, 0, 1, 0, 1, 0, 0.15915494309189535 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 1, 1, 0.07957747154594767, 0.07957747154594767 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 2, 1, 0.06366197723675814, 0.03183098861837907 ),
			// Y = 0

			// FIXME This should not be bigger than 1
			Arguments.of( -1, 0, 1, 0, 1, -2, 0, -1.0986122886681098, 0.0 ),
			Arguments.of( -1, 0, 1, 0, 1, -1, 0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( -1, 0, 1, 0, 1, 0, 0, 0.0, 0.0 ),
			Arguments.of( -1, 0, 1, 0, 1, 1, 0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY),
			// FIXME This should not be bigger than 1
			Arguments.of( -1, 0, 1, 0, 1, 2, 0, 1.0986122886681098, 0.0 )
			// Y = -1
			//			Arguments.of( -1, 0, 1, 0, 1, -2, -1, -0.06366197723675814, -0.03183098861837907 ),
			//			Arguments.of( -1, 0, 1, 0, 1, -1, -1, -0.07957747154594767, -0.07957747154594767 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 0, -1, 0, -0.15915494309189535 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 1, -1, 0.07957747154594767, -0.07957747154594767 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 2, -1, 0.06366197723675814, -0.03183098861837907 ),
			// Y = -2
			//			Arguments.of( -1, 0, 1, 0, 1, -2, -2, -0.039788735772973836, -0.039788735772973836 ),
			//			Arguments.of( -1, 0, 1, 0, 1, -1, -2, -0.03183098861837907, -0.06366197723675814 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 0, -2, 0, -0.07957747154594767 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 1, -2, 0.03183098861837907, -0.06366197723675814 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 2, -2, 0.039788735772973836, -0.039788735772973836 )
		);
	}

}
