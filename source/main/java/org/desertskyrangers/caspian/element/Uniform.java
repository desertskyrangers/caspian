package org.desertskyrangers.caspian.element;

import org.desertskyrangers.caspian.PotentialFlow;

public class Uniform implements PotentialFlow {

	private final double[] velocity;

	public Uniform( double v, double theta ) {
		this.velocity = new double[] {v * Math.cos(theta), v * Math.sin(theta)};
	}

	public Uniform( double[] velocity ) {
		this.velocity = velocity;
	}

	public double[] velocity( double x, double y ) {
		return new double[]{ velocity[ 0 ], velocity[ 1 ] };
	}

	public double stream( double x, double y ) {
		return velocity[0] * y - velocity[1] * x;
	}

	public double potential( double x, double y ) {
		return velocity[0] * x + velocity[1] * y;
	}

}
