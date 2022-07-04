package org.desertskyrangers.caspian.element;

import org.desertskyrangers.caspian.Cfd;

public class UniformVortexPanel extends Panel {

	private final double sin;

	private final double cos;

	public UniformVortexPanel( double[] position, double[] position1, double strength ) {
		this( position[ 0 ], position[ 1 ], position1[ 0 ], position1[ 1 ], strength );
	}

	public UniformVortexPanel( double positionX, double positionY, double positionX1, double positionY1, double strength ) {
		super( positionX, positionY, positionX1, positionY1, strength );

		double dx = positionX1 - positionX;
		double dy = positionY1 - positionY;
		double length = Math.sqrt( dx * dx + dy * dy );

		sin = dy / length;
		cos = dx / length;
	}

	@Override
	public double[] velocity( double x, double y ) {
		// Get the vector from the sheet position to the point x,y
		double xr = x - positionX;
		double yr = y - positionY;

		// Get the distance from the sheet position to the point x,y
		double r2 = xr * xr + yr * yr;

		// Get the vector from the sheet position1 to the point x,y
		double xr1 = x - positionX1;
		double yr1 = y - positionY1;

		// Get the distance from the sheet position1 to the point x,y
		double r12 = xr1 * xr1 + yr1 * yr1;

		if( r2 == 0.0 || r12 == 0.0 ) return new double[]{ Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

		// Get the sweep angle from endpoint 1 to endpoint 2 using the point x,y as the center
		double al = Math.atan2( yr, xr ) - Math.atan2( yr1, xr1 );
		if( al > Math.PI ) al -= Cfd.TWO_PI;
		if( al < -Math.PI ) al += Cfd.TWO_PI;

		double t = 0.5 * strength * Math.log( r2 / r12 );
		double u = Cfd.ONE_OVER_TWO_PI * (strength * al * cos - t * sin);
		double v = Cfd.ONE_OVER_TWO_PI * (strength * al * sin + t * cos);

		return new double[]{ u, v };
	}

}

// source
//vel.u=s*Math.log(r2/r12)/2.0*cos-s*al*sin;
//vel.v=s*al*cos+s*Math.log(r2/r12)/2.0*sin;
// vortex
//vel.u=s*al*cos+s*Math.log(r2/r12)/2.0*sin;
//vel.v=-s*Math.log(r2/r12)/2.0*cos+s*al*sin;
