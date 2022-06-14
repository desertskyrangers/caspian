package org.desertskyrangers.caspian.element;

import org.desertskyrangers.caspian.Cfd;

public class Doublet extends Singularity {

	private final double angle;

	private final double sinAngle;

	private final double cosAngle;

	public Doublet( double[] position, double angle, double strength ) {
		this( position[ 0 ], position[ 1 ], angle, strength );
	}

	public Doublet( double x, double y, double angle, double strength ) {
		super( x, y, strength );
		this.angle = angle;
		this.sinAngle = Math.sin( angle );
		this.cosAngle = Math.cos( angle );
	}

	@Override
	public double[] velocity( double x, double y ) {
		// Get the vector from the source position to the point x,y
		double xr = x - positionX;
		double yr = y - positionY;

		// Get the distance from the source position to the point x,y
		double r2 = xr * xr + yr * yr;

		// If the distance is zero return positive infinity
		if( r2 == 0.0 ) return new double[]{ Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

		// Rotate the point to doublet rotation
		xr = cosAngle * xr - sinAngle * yr;
		yr = sinAngle * xr + cosAngle * yr;

		//		double[] v = velocityRelativeToDoublet( xr, yr );
		//
		//		// Rotate the vector back to world orientation
		//		return new double[]{ cosOrientation * v[ 0 ] + sinOrientation * v[ 1 ], -sinOrientation * v[ 0 ] + cosOrientation * v[ 1 ] };

		double u = strength / r2 / r2 * ((xr * xr - yr * yr) * cosAngle + 2.0 * xr * yr * sinAngle);
		double v = strength / r2 / r2 * (-(xr * xr - yr * yr) * sinAngle + 2.0 * xr * yr * cosAngle);

		return new double[]{ cosAngle *u + sinAngle *v, -sinAngle * u + cosAngle *v };
	}

	//	@Override
	//	public double stream( double x, double y ) {
	//		return streamPolar( Vector.cartesianToPolar( x - positionX, y - positionY ) );
	//	}
	//
	//	@Override
	//	public double potential( double x, double y ) {
	//		return potentialPolar( Vector.cartesianToPolar( x - positionX, y - positionY ) );
	//	}

	private double[] velocityRelativeToDoublet( double xr, double yr ) {
		double r2 = xr * xr + yr * yr;

		double twoPiR4 = Cfd.TWO_PI * r2 * r2;

		double vx = -strength * xr * xr / twoPiR4 + strength * yr * yr / twoPiR4;
		double vy = -strength * xr * yr / twoPiR4 - strength * xr * yr / twoPiR4;

		return new double[]{ vx, vy };
	}

	private double streamPolar( double[] coordinates ) {
		return -strength * Math.sin( coordinates[ 1 ] - angle ) / Cfd.TWO_PI * coordinates[ 0 ];
	}

	private double potentialPolar( double[] coordinates ) {
		return strength * Math.cos( coordinates[ 1 ] - angle ) / Cfd.TWO_PI * coordinates[ 0 ];
	}

}
