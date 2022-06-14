package org.desertskyrangers.caspian.element;

import org.assertj.core.data.Offset;
import org.desertskyrangers.caspian.Cfd;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SourceTest {

	@Test
	void testVelocity() {
		assertThat( new Source( 0, 0, 1 ).velocity( 1, 0 ) ).isEqualTo( new double[]{ 1 / (Cfd.TWO_PI * 1) * 1, 0 } );
		assertThat( new Source( 0, 0, 1 ).velocity( 0, 1 ) ).isEqualTo( new double[]{ 0, 1 / (Cfd.TWO_PI * 1) * 1 } );
		assertThat( new Source( 0, 0, 1 ).velocity( -1, 0 ) ).isEqualTo( new double[]{ -1 / (Cfd.TWO_PI * 1) * 1, 0 } );
		assertThat( new Source( 0, 0, 1 ).velocity( 0, -1 ) ).isEqualTo( new double[]{ 0, -1 / (Cfd.TWO_PI * 1) * 1 } );

		assertThat( new Source( 0, 0, 5 ).velocity( 7, 0 ) ).isEqualTo( new double[]{ 5 / (Cfd.TWO_PI * 7) * 7, 0 } );
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

}
