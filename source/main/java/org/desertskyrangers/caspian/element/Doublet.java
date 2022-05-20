package org.desertskyrangers.caspian.element;

import org.desertskyrangers.caspian.Cfd;
import org.desertskyrangers.caspian.PotentialFlow;
import org.desertskyrangers.caspian.Vector;

public class Doublet implements PotentialFlow {

	private final double[] position;

	private final double strength;

	/**
	 * The clockwise angle from the negative X axis. Similar to the angle of attack.
	 */
	private final double angle;

	public Doublet( double x, double y, double angle, double strength ) {
		this( new double[]{ x, y }, angle, strength );
	}

	public Doublet( double[] position, double angle, double strength ) {
		this.position = position;
		this.angle = angle;
		this.strength = strength;
	}

	@Override
	public double[] velocity( double x, double y ) {
		return Vector.polarToCartesian( velocityPolar( Vector.cartesianToPolar( x - position[ 0 ], y - position[ 1 ] ) ) );
	}

	@Override
	public double stream( double x, double y ) {
		return streamPolar( Vector.cartesianToPolar( x - position[ 0 ], y - position[ 1 ] ) );
	}

	@Override
	public double potential( double x, double y ) {
		return potentialPolar( Vector.cartesianToPolar( x - position[ 0 ], y - position[ 1 ] ) );
	}

	private double[] velocityPolar( double[] coordinates ) {
		double denom = Cfd.TWO_PI * coordinates[ 0 ] * coordinates[ 0 ];
		double vr = strength * Math.cos( coordinates[ 1 ]-angle ) / denom;
		double vt = strength * Math.sin( coordinates[ 1 ]-angle ) / denom;
		return new double[]{ vr, vt };
	}

	private double streamPolar( double[] coordinates ) {
		return -strength * Math.sin( coordinates[ 1 ]-angle ) / Cfd.TWO_PI * coordinates[ 0 ];
	}

	private double potentialPolar( double[] coordinates ) {
		return strength * Math.cos( coordinates[ 1 ]-angle ) / Cfd.TWO_PI * coordinates[ 0 ];
	}

}
