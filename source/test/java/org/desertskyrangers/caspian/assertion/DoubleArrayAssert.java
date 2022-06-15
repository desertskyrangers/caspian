package org.desertskyrangers.caspian.assertion;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.assertj.core.error.BasicErrorMessageFactory;
import org.assertj.core.error.ErrorMessageFactory;
import org.assertj.core.error.ShouldBeEqualWithinOffset;
import org.assertj.core.internal.Failures;

import static org.assertj.core.error.ShouldBeEqualWithinOffset.shouldBeEqual;

public class DoubleArrayAssert extends AbstractAssert<DoubleArrayAssert, double[]> {

	public static final double DEFAULT_CLOSENESS = 1e-16;

	private Failures failures = Failures.instance();

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
			try {
				Assertions.assertThat( actual[ index ] ).isCloseTo( expected[ index ], offset );
			} catch( AssertionError error ) {
				double difference = expected[ index ] - actual[ index ];
				throw failures.failure( ShouldBeEqualWithinOffset.shouldBeEqual( actual, expected, index, offset, difference ).create() );
			}
		}
		return this;
	}

	private static class ShouldBeEqualWithinOffset extends BasicErrorMessageFactory {

		public static ErrorMessageFactory shouldBeEqual( double[] actual, double[] expected, int index, Offset<Double> offset, double difference ) {
			return new ShouldBeEqualWithinOffset( actual, expected,index, offset, difference );
		}

		private <T extends Number> ShouldBeEqualWithinOffset( double[] actual, double[] expected, int index, Offset<Double> offset, double difference ) {
			super(
				"%n" + "Expecting actual at index %s:%n" + "  %s%n" + "to be close to:%n" + "  %s%n" + "by less than %s but difference was %s.%n" + "(a difference of exactly %s being considered " + validOrNot( offset ) + ")",
				index,
				actual,
				expected,
				offset.value,
				difference,
				offset.value
			);
		}

		private static <T extends Number> String validOrNot( Offset<T> offset ) {
			return offset.strict ? "invalid" : "valid";
		}

	}

}

