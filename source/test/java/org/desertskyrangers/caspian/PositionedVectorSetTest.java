package org.desertskyrangers.caspian;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionedVectorSetTest {

	@Test
	void testMean() {
		PositionedVectorSet set = new PositionedVectorSet();
		set.add( new PositionedVector( Point.of( 0, 0 ), Vector.of( 0, 0 ) ) );
		set.add( new PositionedVector( Point.of( 1, 0 ), Vector.of( 0, 1 ) ) );

		// FIXME Position needs to be weighted by vector magnitude
		assertThat( set.meanPosition() ).isEqualTo( Point.of( 0.5, 0 ) );
		assertThat( set.meanVector() ).isEqualTo( Vector.of( 0, 0.5 ) );

	}

}
