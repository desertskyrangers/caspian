package org.desertskyrangers.caspian.element;

import lombok.Getter;
import org.desertskyrangers.caspian.FlowElement;

@Getter
public class Uniform implements FlowElement {

	private final double[] velocity;

	public Uniform( double[] velocity ) {
		this( velocity[ 0 ], velocity[ 1 ] );
	}

	public Uniform( double x, double y ) {
		this.velocity = new double[]{ x, y };
	}

	public static Uniform ofPolar( double v, double theta ) {
		return new Uniform( v * Math.cos( theta ), v * Math.sin( theta ) );
	}

	public double[] velocity( double x, double y ) {
		return new double[]{ velocity[ 0 ], velocity[ 1 ] };
	}

	@Override
	public double[] velocityAtInfinity() {
		return velocity;
	}

	//	public double stream( double x, double y ) {
	//		return velocity[ 0 ] * y - velocity[ 1 ] * x;
	//	}
	//
	//	public double potential( double x, double y ) {
	//		return velocity[ 0 ] * x + velocity[ 1 ] * y;
	//	}

}
