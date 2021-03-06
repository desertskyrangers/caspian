package org.desertskyrangers.caspian;

import org.assertj.core.api.Assertions;
import org.desertskyrangers.caspian.element.Doublet;
import org.desertskyrangers.caspian.element.Uniform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.desertskyrangers.caspian.assertion.DoubleArrayAssert.assertThat;

public class CylinderFlowTest {

	private FlowField field;

	@BeforeEach
	void setup() {
		field = new FlowField( new Uniform( 1, 0 ) );

		double r = 0.5;
		// The double strength is Vector.mag(onset)*2*Math.PI*R^2 where R is the cylinder radius
		double mu = Vector.magnitude( field.getOnsetFlow().getVelocity() ) * Cfd.TWO_PI * r * r;
		// The doublet orientation has to line up directly with the onset flow
		field.add( new Doublet( 0.5, 0, Vector.angle( field.getOnsetFlow().getVelocity() ), mu ) );
	}

	@Test
	void testCylinderFlowVelocity() {
		assertThat( field.velocityAt( -1, 0 ) ).isCloseTo( new double[]{ 8.0 / 9.0, 0 } );
		assertThat( field.velocityAt( 0, 0 ) ).isCloseTo( new double[]{ 0, 0 } );
		assertThat( field.velocityAt( 0.5, 0 ) ).isCloseTo( new double[]{ Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY } );
		assertThat( field.velocityAt( 1, 0 ) ).isCloseTo( new double[]{ 0, 0 } );
		assertThat( field.velocityAt( 2, 0 ) ).isCloseTo( new double[]{ 8.0 / 9.0, 0 } );

		assertThat( field.velocityAt( 0.5, -1 ) ).isCloseTo( new double[]{ 1.25, 0 } );
		assertThat( field.velocityAt( 0.5, 1 ) ).isCloseTo( new double[]{ 1.25, 0 } );
	}

	@Test
	void testCylinderFlowPressure() {
		Assertions.assertThat( field.pressureAt( -1, 0 ) ).isEqualTo( 101324.51604938271 );
		Assertions.assertThat( field.pressureAt( 0, 0 ) ).isEqualTo( 101325.0 );
		Assertions.assertThat( field.pressureAt( 0.5, 0 ) ).isEqualTo( Double.NEGATIVE_INFINITY );
		Assertions.assertThat( field.pressureAt( 1, 0 ) ).isEqualTo( 101325.0 );
		Assertions.assertThat( field.pressureAt( 2, 0 ) ).isEqualTo( 101324.51604938271 );

		Assertions.assertThat( field.pressureAt( 0.5, -1 ) ).isEqualTo( 101324.04296875 );
		Assertions.assertThat( field.pressureAt( 0.5, 1 ) ).isEqualTo( 101324.04296875 );
	}

	@Test
	void testCylinderFlowRelativePressure() {
		Assertions.assertThat( field.relativePressureAt( -1, 0 ) ).isEqualTo( 0.1285493827163009 );
		Assertions.assertThat( field.relativePressureAt( 0, 0 ) ).isEqualTo( 0.6125000000029104 );
		Assertions.assertThat( field.relativePressureAt( 0.5, 0 ) ).isEqualTo( Double.NEGATIVE_INFINITY );
		Assertions.assertThat( field.relativePressureAt( 1, 0 ) ).isEqualTo( 0.6125000000029104 );
		Assertions.assertThat( field.relativePressureAt( 2, 0 ) ).isEqualTo( 0.1285493827163009 );

		Assertions.assertThat( field.relativePressureAt( 0.5, -1 ) ).isEqualTo( -0.3445312499970896 );
		Assertions.assertThat( field.relativePressureAt( 0.5, 1 ) ).isEqualTo( -0.3445312499970896 );
	}

}
