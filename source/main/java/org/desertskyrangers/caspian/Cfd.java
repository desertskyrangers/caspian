package org.desertskyrangers.caspian;

public class Cfd {

	public static double calcLift( Air air, Aircraft aircraft, Airfoil airfoil, double speed ) {
		// 0.5 * kg/m^3 * m/s * m/s * cm^2 * %
		return 0.5 * air.density() * speed * speed * aircraft.wingarea() * airfoil.liftCoefficient();
	}

}
