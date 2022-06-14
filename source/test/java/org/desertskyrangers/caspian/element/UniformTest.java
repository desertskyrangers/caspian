package org.desertskyrangers.caspian.element;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UniformTest {

	@Test
	void testVelocity() {
		assertThat( new Uniform( new double[]{ 2, 1 } ).velocity( 3, -2 ) ).isEqualTo( new double[]{ 2, 1 } );
	}

//	@Test
//	void testStream() {
//		assertThat( new Uniform( new double[]{ 2, 0 } ).stream( 0, 1 ) ).isEqualTo( 2 );
//		assertThat( new Uniform( new double[]{ 2, 0 } ).stream( 1, 0 ) ).isEqualTo( 0 );
//		assertThat( new Uniform( new double[]{ 2, 0 } ).stream( 0, -1 ) ).isEqualTo( -2 );
//		assertThat( new Uniform( new double[]{ 2, 0 } ).stream( -1, 0 ) ).isEqualTo( 0 );
//
//		assertThat( new Uniform( new double[]{ 2, 2 } ).stream( 2, 2 ) ).isEqualTo( 0 );
//		assertThat( new Uniform( new double[]{ 2, 2 } ).stream( -2, -2 ) ).isEqualTo( 0 );
//		assertThat( new Uniform( new double[]{ 2, 2 } ).stream( 2, -2 ) ).isEqualTo( -8 );
//		assertThat( new Uniform( new double[]{ 2, 2 } ).stream( -2, 2 ) ).isEqualTo( 8 );
//	}

//	@Test
//	void testPotential() {
//		assertThat( new Uniform( new double[]{ 1, -1 } ).potential( 2, -2 ) ).isEqualTo( 4 );
//		assertThat( new Uniform( new double[]{ 1, -1 } ).potential( -2, 2 ) ).isEqualTo( -4 );
//		assertThat( new Uniform( new double[]{ 1, -1 } ).potential( -2, -2 ) ).isEqualTo( 0 );
//		assertThat( new Uniform( new double[]{ 1, -1 } ).potential( 2, 2 ) ).isEqualTo( 0 );
//	}

}
