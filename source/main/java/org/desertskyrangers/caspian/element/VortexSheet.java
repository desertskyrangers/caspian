package org.desertskyrangers.caspian.element;

import org.desertskyrangers.caspian.PotentialFlow;

public class VortexSheet implements PotentialFlow {

	@Override
	public double[] velocity( double x, double y ) {
//		xr1 = xf - x1;
//		yr1 = yf - y1;
//		r12 = xr1 * xr1 + yr1 * yr1;
//		if( r2 > 0.0 && r12 > 0.0 ) {
//			al = Math.atan2( xr, yr ) - Math.atan2( xr1, yr1 );
//			if( al > Math.PI ) al -= 2.0 * Math.PI;
//			if( al < -Math.PI ) al += 2.0 * Math.PI;
//			vel.v = -s * Math.log( r2 / r12 ) / 2.0 * cos + s * al * sin;
//			vel.u = s * al * cos + s * Math.log( r2 / r12 ) / 2.0 * sin;
//			vel.inf = false;
//		} else {
//			// Infinity
//		}

		return new double[ 0 ];
	}

}
