package org.desertskyrangers.caspian.element;

import org.desertskyrangers.caspian.Cfd;

public class SourceSheet extends Sheet {

	private final double sin;

	private final double cos;

	public SourceSheet( double[] position, double[] position1, double strength ) {
		this( position[ 0 ], position[ 1 ], position1[ 0 ], position1[ 1 ], strength );
	}

	public SourceSheet( double positionX, double positionY, double positionX1, double positionY1, double strength ) {
		super( positionX, positionY, positionX1, positionY1, strength );

		double dx = positionX1 - positionX;
		double dy = positionY1 - positionY;
		double length = Math.sqrt( dx * dx + dy * dy );

		sin = dx / length;
		cos = dy / length;
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

		// Get the angle from the point x,y to each endpoint
		double al = Math.atan2( xr, yr ) - Math.atan2( xr1, yr1);
		if( al > Math.PI ) al -= Cfd.TWO_PI;
		if( al < -Math.PI ) al += Cfd.TWO_PI;

		double t = strength * Math.log( r2 / r12 ) / 2.0;

		double u = t * cos - strength * al * sin;
		double v = t * sin + strength * al * cos;

		System.out.printf( "al=%f sin=%f cos=%f t=%f %n", Math.toDegrees( al ), sin, cos, t );

		return new double[]{ u, v };
	}

}
