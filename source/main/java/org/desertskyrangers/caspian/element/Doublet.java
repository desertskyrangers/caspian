package org.desertskyrangers.caspian.element;

import org.desertskyrangers.caspian.Cfd;
import org.desertskyrangers.caspian.Vector;

import java.util.Arrays;

public class Doublet extends Singularity {

	private final double angle;

	private final double sinOrientation;

	private final double cosOrientation;

	public Doublet( double x, double y, double angle, double strength ) {
		super( x, y, strength );
		this.angle = angle;
		this.sinOrientation = Math.sin( angle );
		this.cosOrientation = Math.cos( angle );
	}

	public Doublet( double[] position, double angle, double strength ) {
		this( position[ 0 ], position[ 1 ], angle, strength );
	}

	@Override
	public double[] velocity( double ax, double ay ) {
		double x = ax - positionX;
		double y = ay - positionY;

		// Rotate the point according to the doublet orientation
		double dx = cosOrientation * x - sinOrientation * y;
		double dy = sinOrientation * x + cosOrientation * y;

		double x2 = dx * dx;
		double y2 = dy * dy;
		double r2 = x2 + y2;

		double twoPiR4 = Cfd.TWO_PI * r2 * r2;

		double vx = -strength * x2 / twoPiR4 + strength * y2 / twoPiR4;
		double vy = -strength * dx * dy / twoPiR4 - strength * dx * dy / twoPiR4;

		return new double[]{ vx, vy };
	}

	@Override
	public double stream( double x, double y ) {
		return streamPolar( Vector.cartesianToPolar( x - positionX, y - positionY ) );
	}

	@Override
	public double potential( double x, double y ) {
		return potentialPolar( Vector.cartesianToPolar( x - positionX, y - positionY ) );
	}

	private double[] velocityPolar( double[] coordinates ) {
		System.out.println( "pcoords=" + Arrays.toString( coordinates ) );
		double denom = Cfd.TWO_PI * coordinates[ 0 ] * coordinates[ 0 ];
		double vr = strength * Math.cos( coordinates[ 1 ] - angle ) / denom;
		double vt = strength * Math.sin( coordinates[ 1 ] - angle ) / denom;
		System.out.println( "pcoords=[" + vr + "," + vt + "]" );
		return new double[]{ vr, vt };
	}

	private double streamPolar( double[] coordinates ) {
		return -strength * Math.sin( coordinates[ 1 ] - angle ) / Cfd.TWO_PI * coordinates[ 0 ];
	}

	private double potentialPolar( double[] coordinates ) {
		return strength * Math.cos( coordinates[ 1 ] - angle ) / Cfd.TWO_PI * coordinates[ 0 ];
	}

}
