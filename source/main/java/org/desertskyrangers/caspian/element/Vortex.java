package org.desertskyrangers.caspian.element;

import org.desertskyrangers.caspian.Cfd;

public class Vortex extends Singularity {

	public Vortex( double[] position, double strength ) {
		this( position[ 0 ], position[ 1 ], strength );
	}

	public Vortex( double x, double y, double strength ) {
		super( x, y, strength );
	}

	@Override
	public double[] velocity( double x, double y ) {
		// Get the vector from the vortex position to the point x,y
		double xr = x - positionX;
		double yr = y - positionY;

		// Get the distance from the vortex position to the point x,y
		double r2 =  xr * xr + yr * yr;

		// If the distance is zero return positive infinity
		if( r2 == 0.0 ) return new double[]{ Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

		// Calculate the velocity coefficient at the point x,y
		double c = this.strength / (Cfd.TWO_PI * r2);

		// Return the velocity vector at the point x,y
		return new double[]{ -c * yr, c * xr };
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
		double t = coordinates[ 1 ] + Math.PI * Math.signum( coordinates[ 1 ] );
		return new double[]{ strength / (Cfd.TWO_PI * coordinates[ 0 ]), t };
	}

	private double streamPolar( double[] coordinates ) {
		return strength * Math.log( coordinates[ 0 ] ) / Cfd.TWO_PI;
	}

	private double potentialPolar( double[] coordinates ) {
		return -strength * coordinates[ 1 ] / Cfd.TWO_PI;
	}

}
