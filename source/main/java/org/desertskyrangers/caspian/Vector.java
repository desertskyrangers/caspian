package org.desertskyrangers.caspian;

public class Vector {

	public static double[] of( double x, double y ) {
		return new double[]{ x, y };
	}

	/**
	 * Adds vector b to vector a and returns vector a. Unlike the {@link #sum}
	 * method, this method does not allocate a new array, but uses the array
	 * from parameter a.
	 *
	 * @param a The vector to add to
	 * @param b The vector to add to parameter a
	 * @return The sum of the vectors
	 */
	public static double[] add( double[] a, final double[] b ) {
		a[ 0 ] += b[ 0 ];
		a[ 1 ] += b[ 1 ];
		return a;
	}

	/**
	 * Sums vector a and vector b. Unlike the {@link #add} method, this method
	 * does not modify either of the parameters, but creates a new array for
	 * the result.
	 *
	 * @param a Vector A
	 * @param b Vector B
	 * @return The sum of the vectors in a new array
	 */
	public static double[] sum( final double[] a, final double[] b ) {
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

	/**
	 * Scale a vector by a constant. Unlike the {@link #multiply} method,
	 * this method modifies parameter a and does not create a new array.
	 *
	 * @param a The vector to scale
	 * @param s The scaling constant
	 * @return The scaled vector
	 */
	public static double[] scale( double[] a, final double s ) {
		a[0] *= s;
		a[1] *= s;
		return a;
	}

	public static double[] multiply( final double[] a, final double s ) {
		return Vector.of(a[0]*s, a[1]*s);
	}

}
