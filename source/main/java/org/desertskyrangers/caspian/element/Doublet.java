package org.desertskyrangers.caspian.element;

import org.desertskyrangers.caspian.Cfd;
import org.desertskyrangers.caspian.Vector;

public class Doublet extends Singularity {

	private final double rotate;

	private final double sinOrientation;

	private final double cosOrientation;

	public Doublet( double x, double y, double rotate, double strength ) {
		super( x, y, strength );
		this.rotate = rotate;
		this.sinOrientation = Math.sin( rotate );
		this.cosOrientation = Math.cos( rotate );
	}

	public Doublet( double[] position, double rotate, double strength ) {
		this( position[ 0 ], position[ 1 ], rotate, strength );
	}

	@Override
	public double[] velocity( double x, double y ) {
		// Move the point relative to doublet origin
		double dx = x - positionX;
		double dy = y - positionY;

		// Rotate the point to doublet rotation
		dx = cosOrientation * dx - sinOrientation * dy;
		dy = sinOrientation * dx + cosOrientation * dy;

		double[] dv = velocityRelativeToDoublet( dx, dy );

		// Rotate the vector back to world orientation
		return new double[]{ cosOrientation * dv[ 0 ] + sinOrientation * dv[ 1 ], -sinOrientation * dv[ 0 ] + cosOrientation * dv[ 1 ] };
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

	private double[] velocityRelativeToDoublet( double dx, double dy ) {
		double x2 = dx * dx;
		double y2 = dy * dy;
		double r2 = x2 + y2;

		double twoPiR4 = Cfd.TWO_PI * r2 * r2;

		double vx = -strength * x2 / twoPiR4 + strength * y2 / twoPiR4;
		double vy = -strength * dx * dy / twoPiR4 - strength * dx * dy / twoPiR4;

		return new double[]{ vx, vy };
	}

	private double streamPolar( double[] coordinates ) {
		return -strength * Math.sin( coordinates[ 1 ] - rotate ) / Cfd.TWO_PI * coordinates[ 0 ];
	}

	private double potentialPolar( double[] coordinates ) {
		return strength * Math.cos( coordinates[ 1 ] - rotate ) / Cfd.TWO_PI * coordinates[ 0 ];
	}

}
