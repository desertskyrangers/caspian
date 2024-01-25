package org.desertskyrangers.caspian;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionedVectorSetTest {

	@Test
	void testCenterScenario0() {
		PositionedVectorSet set = new PositionedVectorSet();
		set.add( new PositionedVector( Point.of( 1, 0 ), Vector.of( 0, 1 ) ) );

		assertThat( set.centroidPosition() ).isEqualTo( Point.of( 1, 0 ) );
		assertThat( set.centroidVector() ).isEqualTo( Vector.of( 0, 1 ) );
	}

	@Test
	void testCenterScenario1() {
		PositionedVectorSet set = new PositionedVectorSet();
		set.add( new PositionedVector( Point.of( 0, 0 ), Vector.of( 0, 0 ) ) );
		set.add( new PositionedVector( Point.of( 1, 0 ), Vector.of( 0, 1 ) ) );

		assertThat( set.centroidPosition() ).isEqualTo( Point.of( 1, 0 ) );
		assertThat( set.centroidVector() ).isEqualTo( Vector.of( 0, 1 ) );
	}

	@Test
	void testCenterScenario2() {
		PositionedVectorSet set = new PositionedVectorSet();
		set.add( new PositionedVector( Point.of( 0.5, 0 ), Vector.of( 0, 0 ) ) );
		set.add( new PositionedVector( Point.of( 1, 0.5 ), Vector.of( 0, 0.5 ) ) );
		set.add( new PositionedVector( Point.of( 0.5, 1 ), Vector.of( 0, 1 ) ) );
		set.add( new PositionedVector( Point.of( 0, 0.5 ), Vector.of( 0, 0.5 ) ) );

		assertThat( set.centroidPosition() ).isEqualTo( Point.of( 0.5, 0.75 ) );
		assertThat( set.centroidVector() ).isEqualTo( Vector.of( 0, 2 ) );
	}

	@Test
	void testCenterScenario3() {
		PositionedVectorSet set = new PositionedVectorSet();
		set.add( new PositionedVector( Point.of( 1, -0.1 ), Vector.of( -0.1, 0.1 ) ) );
		set.add( new PositionedVector( Point.of( 0, -0.1 ), Vector.of( 0.1, 0.1 ) ) );
		set.add( new PositionedVector( Point.of( 0, 0.1 ), Vector.of( 0.1, -0.1 ) ) );
		set.add( new PositionedVector( Point.of( 1, 0.1 ), Vector.of( -0.1, -0.1 ) ) );

		assertThat( set.centroidPosition() ).isEqualTo( Point.of( 0.5, 0 ) );
		assertThat( set.centroidVector() ).isEqualTo( Vector.of( 0, 0 ) );
	}

}
