package org.desertskyrangers.caspian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(fluent = true)
public class Air {

	public static final Air ISA = new Air( 101325, 15, 1.225, 1.789e-5 );

	/**
	 * Air pressure in pascals.
	 */
	private final double pressure;

	/**
	 * Air temperature in degrees Celsius.
	 */
	private final double temperature;

	/**
	 * Air density in kg/m^3
	 */
	private final double density;

	/**
	 * Air viscosity in kg/m/s.
	 */
	private final double viscosity;

}
