package org.desertskyrangers.caspian.element;

import org.desertskyrangers.caspian.Cfd;
import org.desertskyrangers.caspian.PotentialFlow;

public class Source implements PotentialFlow {

	private final double[] position;

	private final double strength;

	public Source( double x, double y, double strength ) {
		this( new double[]{ x, y }, strength );
	}

	public Source( double[] position, double strength ) {
		this.position = position;
		this.strength = strength;
	}

	@Override
	public double[] velocity( double x, double y ) {
		// Get the vector from the source position to the point x,y
		double xr = x - this.position[ 0 ];
		double yr = y - this.position[ 1 ];

		// Get the distance from the source position to the point x,y
		double r = Math.sqrt( xr * xr + yr * yr );

		// If the distance is zero return positive infinity
		if( r == 0.0 ) return new double[]{ Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

		// Calculate the velocity coefficient at the point x,y
		double c = this.strength / (Cfd.TWO_PI * r);

		// Return the velocity vector at the point x,y
		return new double[]{ c * xr, c * yr };
	}

	//	@Override
	//	public double stream( double x, double y ) {
	//		return streamPolar( Vector.cartesianToPolar( x - position[ 0 ], y - position[ 1 ] ) );
	//	}
	//
	//	@Override
	//	public double potential( double x, double y ) {
	//		return potentialPolar( Vector.cartesianToPolar( x - position[ 0 ], y - position[ 1 ] ) );
	//	}

	private double[] velocityPolar( double[] coordinates ) {
		return new double[]{ strength / (Cfd.TWO_PI * coordinates[ 0 ]), coordinates[ 1 ] };
	}

	private double streamPolar( double[] coordinates ) {
		return -strength * coordinates[ 1 ] / Cfd.TWO_PI;
	}

	private double potentialPolar( double[] coordinates ) {
		return -strength * Math.log( coordinates[ 0 ] ) / Cfd.TWO_PI;
	}

}
