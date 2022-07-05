package org.desertskyrangers.caspian;

public class Vector {

	public static double[] sum( double[] a, double[] b ) {
		return new double[]{ a[ 0 ] + b[ 0 ], a[ 1 ] + b[ 1 ] };
	}

	public static double magnitude( double x, double y ) {
		return Math.sqrt( x * x + y * y );
	}

	public static double magnitude( double[] vector ) {
		return magnitude( vector[ 0 ], vector[ 1 ] );
	}

	public static double angle( double x, double y ) {
		return Math.atan2( y, x );
	}

	public static double angle( double[] vector ) {
		return angle( vector[ 0 ], vector[ 1 ] );
	}

	public static double[] cartesianToPolar( double[] coordinates ) {
		return cartesianToPolar( coordinates[ 0 ], coordinates[ 1 ] );
	}

	public static double[] cartesianToPolar( double x, double y ) {
		return new double[]{ magnitude( x, y ), angle( x, y ) };
	}

	public static double[] polarToCartesian( double[] coordinates ) {
		return polarToCartesian( coordinates[ 0 ], coordinates[ 1 ] );
	}

	public static double[] polarToCartesian( double r, double t ) {
		return new double[]{ Math.cos( t ) * r, Math.sin( t ) * r };
	}

}
