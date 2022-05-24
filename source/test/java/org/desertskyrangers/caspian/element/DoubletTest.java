package org.desertskyrangers.caspian.element;

import org.assertj.core.data.Offset;
import org.desertskyrangers.caspian.Cfd;
import org.junit.jupiter.api.Test;

import static org.desertskyrangers.caspian.assertion.DoubleArrayAssert.assertThat;

public class DoubletTest {

	@Test
	void testVelocity() {
		//double sqrtHalf = 0.5 * Cfd.SQRT_2;

		// Y = 2
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( -2, 2 ) ).isCloseTo( new double[]{ 0.0, 1 / (Cfd.TWO_PI * 4* Cfd.SQRT_2 * Cfd.SQRT_2) }, Offset.offset( 1e-16 ) );
		//assertThat( new Doublet( 0, 0, 0, 1 ).velocity( -1, 2 ) ).isCloseTo( new double[]{ -1 / (Cfd.TWO_PI * 1 * 1), 0.0 }, Offset.offset( 0.0 ) );
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( 0, 2 ) ).isCloseTo( new double[]{ 1 / (Cfd.TWO_PI * 2 * 2), 0.0 }, Offset.offset( 0.0 ) );
		//assertThat( new Doublet( 0, 0, 0, 1 ).velocity( 1, 2 ) ).isCloseTo( new double[]{ -1 / (Cfd.TWO_PI * 1 * 1), 0.0 }, Offset.offset( 0.0 ) );
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( 2, 2 ) ).isCloseTo( new double[]{ 0.0, -1 / (Cfd.TWO_PI * 4* Cfd.SQRT_2 * Cfd.SQRT_2) }, Offset.offset( 1e-16 ) );

		// Y = 1
		//assertThat( new Doublet( 0, 0, 0, 1 ).velocity( -2, 1 ) ).isCloseTo( new double[]{ -1 / (Cfd.TWO_PI * 1 * 1), 0.0 }, Offset.offset( 0.0 ) );
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( -1, 1 ) ).isCloseTo( new double[]{ 0.0, 1 / (Cfd.TWO_PI * Cfd.SQRT_2 * Cfd.SQRT_2) }, Offset.offset( 1e-16 ) );
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( 0, 1 ) ).isCloseTo( new double[]{ 1 / (Cfd.TWO_PI * 1 * 1), -0.0 }, Offset.offset( 0.0 ) );
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( 1, 1 ) ).isCloseTo( new double[]{ 0.0, -1 / (Cfd.TWO_PI * Cfd.SQRT_2 * Cfd.SQRT_2) }, Offset.offset( 1e-16 ) );
		//assertThat( new Doublet( 0, 0, 0, 1 ).velocity( 2, 1 ) ).isCloseTo( new double[]{ -1 / (Cfd.TWO_PI * 1 * 1), 0.0 }, Offset.offset( 0.0 ) );

		// Y = 0
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( -2, 0 ) ).isCloseTo( new double[]{ -1 / (Cfd.TWO_PI * 2 * 2), 0.0 }, Offset.offset( 0.0 ) );
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( -1, 0 ) ).isCloseTo( new double[]{ -1 / (Cfd.TWO_PI * 1 * 1), 0.0 }, Offset.offset( 0.0 ) );
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( 0, 0 ) ).isCloseTo( new double[]{ Double.NaN, Double.NaN }, Offset.offset( 0.0 ) );
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( 1, 0 ) ).isCloseTo( new double[]{ -1 / (Cfd.TWO_PI * 1 * 1), 0.0 }, Offset.offset( 0.0 ) );
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( 2, 0 ) ).isCloseTo( new double[]{ -1 / (Cfd.TWO_PI * 2 * 2), 0.0 }, Offset.offset( 0.0 ) );

		// Y = -1
		//assertThat( new Doublet( 0, 0, 0, 1 ).velocity( -2, -1 ) ).isCloseTo( new double[]{ -1 / (Cfd.TWO_PI * 1 * 1), 0.0 }, Offset.offset( 0.0 ) );
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( -1, -1 ) ).isCloseTo( new double[]{ 0.0, -1 / (Cfd.TWO_PI * Cfd.SQRT_2 * Cfd.SQRT_2) }, Offset.offset( 1e-16 ) );
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( 0, -1 ) ).isCloseTo( new double[]{ 1 / (Cfd.TWO_PI * 1 * 1), 0.0 }, Offset.offset( 0.0 ) );
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( 1, -1 ) ).isCloseTo( new double[]{ 0.0, 1 / (Cfd.TWO_PI * Cfd.SQRT_2 * Cfd.SQRT_2) }, Offset.offset( 1e-16 ) );
		//assertThat( new Doublet( 0, 0, 0, 1 ).velocity( 2, -1 ) ).isCloseTo( new double[]{ -1 / (Cfd.TWO_PI * 1 * 1), 0.0 }, Offset.offset( 0.0 ) );

		// Y = -2
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( -2, -2 ) ).isCloseTo( new double[]{ 0.0, -1 / (Cfd.TWO_PI * 4* Cfd.SQRT_2 * Cfd.SQRT_2) }, Offset.offset( 1e-16 ) );
		//assertThat( new Doublet( 0, 0, 0, 1 ).velocity( -1, -2 ) ).isCloseTo( new double[]{ -1 / (Cfd.TWO_PI * 1 * 1), 0.0 }, Offset.offset( 0.0 ) );
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( 0, -2 ) ).isCloseTo( new double[]{ 1 / (Cfd.TWO_PI * 2 * 2), -0.0 }, Offset.offset( 0.0 ) );
		//assertThat( new Doublet( 0, 0, 0, 1 ).velocity( 1, -2 ) ).isCloseTo( new double[]{ -1 / (Cfd.TWO_PI * 1 * 1), 0.0 }, Offset.offset( 0.0 ) );
		assertThat( new Doublet( 0, 0, 0, 1 ).velocity( 2, -2 ) ).isCloseTo( new double[]{ 0.0, 1 / (Cfd.TWO_PI * 4* Cfd.SQRT_2 * Cfd.SQRT_2) }, Offset.offset( 1e-16 ) );

		// Different strength, far location
		assertThat( new Doublet( 0, 0, 0, 5 ).velocity( 7, 0 ) ).isCloseTo( new double[]{ -5 / (Cfd.TWO_PI * 7 * 7), 0.0 }, Offset.offset( 0.0 ) );

		//		// Angled doublets
		//		//assertThat( new Doublet( 0, 0, 0.25 * Math.PI, 1 ).velocity( -sqrtHalf, sqrtHalf )[ 0 ] ).isCloseTo( sqrtHalf * 1 / (Cfd.TWO_PI * 1 * 1), Offset.offset( 1e-16 ) );
		//		assertThat( new Doublet( 0, 0, 0.25 * Math.PI, 1 ).velocity( -sqrtHalf, sqrtHalf )[ 1 ] ).isCloseTo( sqrtHalf * 1 / (Cfd.TWO_PI * 1 * 1), Offset.offset( 1e-16 ) );
	}

	@Test
	void testStream() {
		//		assertThat( new Doublet( 0, 0, 1 ).stream( 0, 0 ) ).isEqualTo( 0 );
		//
		//		assertThat( new Doublet( 0, 0, 1 ).stream( 1, 0 ) ).isEqualTo( 0 );
		//		assertThat( new Doublet( 0, 0, 1 ).stream( 0, 1 ) ).isEqualTo( -0.25 );
		//		assertThat( new Doublet( 0, 0, 1 ).stream( -1, 0 ) ).isEqualTo( -0.5 );
		//		assertThat( new Doublet( 0, 0, 1 ).stream( 0, -1 ) ).isEqualTo( 0.25 );
	}

	@Test
	void testPotential() {
		//		assertThat( new Doublet( 0, 0, 1 ).potential( 0, 0 ) ).isEqualTo( Double.POSITIVE_INFINITY );
		//		assertThat( new Doublet( 0, 0, 1 ).potential( 0.5, 0 ) ).isEqualTo( -Math.log( 0.5 ) / Cfd.TWO_PI );
		//		assertThat( new Doublet( 0, 0, 1 ).potential( 1, 0 ) ).isEqualTo( 0 );
		//		assertThat( new Doublet( 0, 0, 1 ).potential( 2, 0 ) ).isEqualTo( -Math.log( 2 ) / Cfd.TWO_PI );
	}

}
