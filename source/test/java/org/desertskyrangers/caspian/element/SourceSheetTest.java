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
			//Arguments.of( -1, 0, 1, 0, 1, 0, 2, 0, 0.9272952180016123 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 1, 2, 0.03183098861837907, 0.06366197723675814 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 2, 2, 0.039788735772973836, 0.039788735772973836 ),
			// Y = 1
			//			Arguments.of( -1, 0, 1, 0, 1, -2, 1, -0.8047189562170501, 0.46364760900080615 ),
			//			Arguments.of( -1, 0, 1, 0, 1, -1, 1, -0.8047189562170501, 1.1071487177940904 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 0, 1, 0, 1.5707963267948966 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 1, 1, 0.8047189562170501, 1.1071487177940904 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 2, 1, 0.8047189562170501, 0.46364760900080615 ),
			// Y = 0
			Arguments.of( -1, 0, 1, 0, 1, -2, 0, -0.1748495762830299, 0.0 ),
			Arguments.of( -1, 0, 1, 0, 1, -1, 0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( -1, 0, 1, 0, 1, 0, Double.MIN_NORMAL, 0.0, 0.5 ),
			Arguments.of( -1, 0, 1, 0, 1, 0, -Double.MIN_NORMAL, 0.0, -0.5 ),
			Arguments.of( -1, 0, 1, 0, 1, 1, 0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY ),
			Arguments.of( -1, 0, 1, 0, 1, 2, 0, 0.1748495762830299, 0.0 )
			// Y = -1
			//			Arguments.of( -1, 0, 1, 0, 1, -2, -1, -0.8047189562170501, -0.46364760900080615 ),
			//			Arguments.of( -1, 0, 1, 0, 1, -1, -1, -0.8047189562170501, -1.1071487177940904 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 0, -1, 0, -1.5707963267948966 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 1, -1, 0.8047189562170501, -1.1071487177940904 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 2, -1, 0.8047189562170501, -0.46364760900080615 ),
			// Y = -2
			//			Arguments.of( -1, 0, 1, 0, 1, -2, -2, -0.039788735772973836, -0.039788735772973836 ),
			//			Arguments.of( -1, 0, 1, 0, 1, -1, -2, -0.03183098861837907, -0.06366197723675814 ),
			//						Arguments.of( -1, 0, 1, 0, 1, 0, -2, 0, -0.9272952180016123 )
			//			Arguments.of( -1, 0, 1, 0, 1, 1, -2, 0.03183098861837907, -0.06366197723675814 ),
			//			Arguments.of( -1, 0, 1, 0, 1, 2, -2, 0.039788735772973836, -0.039788735772973836 )
		);
	}

}
