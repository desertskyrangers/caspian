package org.desertskyrangers.caspian.assertion;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;

import static org.assertj.core.error.ShouldBeEqualWithinOffset.shouldBeEqual;

public class DoubleArrayAssert extends AbstractAssert<DoubleArrayAssert, double[]> {

	public static final double DEFAULT_CLOSENESS = 1e-16;

	protected DoubleArrayAssert( double[] actual ) {
		super( actual, DoubleArrayAssert.class );
	}

	public static DoubleArrayAssert assertThat( double[] actual ) {
		return new DoubleArrayAssert( actual );
	}

	public DoubleArrayAssert isEqualTo( double[] expected ) {
		return isCloseTo( expected, Offset.offset( 0.0 ) );
	}

	public DoubleArrayAssert isCloseTo( double[] expected ) {
		return isCloseTo( expected, Offset.offset( DEFAULT_CLOSENESS ) );
	}

	public DoubleArrayAssert isCloseTo( double[] expected, Offset<Double> offset ) {
		for( int index = 0; index < actual.length; index++ ) {
			Assertions.assertThat( actual[ index ] ).isCloseTo( expected[ index ], offset );
		}
		return this;
	}

}
