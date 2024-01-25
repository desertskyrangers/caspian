package org.desertskyrangers.caspian;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VectorTest {

	@Test
	void scale() {
		double[] a = Vector.of( 1, 2 );
		double[] result = Vector.scale( a, 3 );
		assertThat( a ).isEqualTo( Vector.of( 3, 6 ) );
		assertThat( result ).isEqualTo( Vector.of( 3, 6 ) );
	}

	@Test
	void multiply() {
		double[] a = Vector.of( 1, 2 );
		double[] result = Vector.multiply( a, 3 );
		assertThat( a ).isEqualTo( Vector.of( 1, 2 ) );
		assertThat( result ).isEqualTo( Vector.of( 3, 6 ) );
	}

}
