package org.desertskyrangers.caspian;

public class Cfd {

	public static final double SQRT_2 = Math.sqrt( 2 );

	public static final double TWO_PI = 2 * Math.PI;

	public static final double ONE_OVER_TWO_PI = 1 / TWO_PI;

	public static double calcLift( Air air, Aircraft aircraft, Airfoil airfoil, double speed ) {
		// 0.5 * kg/m^3 * m/s * m/s * cm^2 * %
		// kg/m*m*m * m/s * cm*cm
		// kg*m / s^2
		// N
		return 0.5 * air.density() * speed * speed * aircraft.wingarea() * airfoil.liftCoefficient();
	}

}
