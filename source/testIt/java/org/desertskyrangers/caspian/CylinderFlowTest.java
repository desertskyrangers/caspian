package org.desertskyrangers.caspian;

import org.desertskyrangers.caspian.element.Doublet;
import org.desertskyrangers.caspian.element.Uniform;
import org.junit.jupiter.api.Test;

import static org.desertskyrangers.caspian.assertion.DoubleArrayAssert.assertThat;

public class CylinderFlowTest {

	@Test
	void testCylinderFlow() {
		FlowField field = new FlowField( -0.5, -0.5, 1.5, 0.5 );

		Uniform onset = new Uniform( 1, 0 );
		field.add( onset );

		// The doublet orientation has to line up directly with the onset flow
		// The double strength is Vector.mag(onset)*2*Math.PI*R^2 where R is the cylinder radius
		double r = 0.5;
		double mu = Vector.magnitude( onset.getVelocity() ) * Cfd.TWO_PI * r * r;
		field.add( new Doublet( 0.5, 0, Vector.angle( onset.getVelocity() ), mu ) );

		assertThat( field.velocityAt( -1, 0 ) ).isEqualTo( new double[]{ 8.0 / 9.0, 0 } );
		assertThat( field.velocityAt( 0, 0 ) ).isCloseTo( new double[]{ 0, 0 } );
		assertThat( field.velocityAt( 0.5, 0 ) ).isEqualTo( new double[]{ Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY } );
		assertThat( field.velocityAt( 1, 0 ) ).isCloseTo( new double[]{ 0, 0 } );
		assertThat( field.velocityAt( 2, 0 ) ).isEqualTo( new double[]{ 8.0 / 9.0, 0 } );
	}

}
