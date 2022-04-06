package org.desertskyrangers.caspian;

import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors( fluent = true )
public class Aircraft {

	/**
	 * Aircraft weight in grams.
	 */
	private final double weight;

	/**
	 * Aircraft wingspan in centimeters.
	 */
	private final double wingspan;

	/**
	 * Aircraft wing area in centimeters squared.
	 */
	private final double wingarea;

	/**
	 * The aircraft wing aspect ratio.
	 */
	private final double aspectRatio;

	/**
	 * The aircraft wing loading in g/cm^2
	 */
	private final double wingLoading;

	public Aircraft( double weight, double wingspan, double wingarea ) {
		this.weight = weight;
		this.wingspan = wingspan;
		this.wingarea = wingarea;

		this.aspectRatio = calcAspectRatio();
		this.wingLoading = calcWingLoading();
	}

	/**
	 * Calculate the wing aspect ratio.
	 *
	 * @return The wing aspect ratio
	 */
	public double calcAspectRatio() {
		return wingspan * wingspan / wingarea;
	}

	/**
	 * Calculate the wing loading.
	 *
	 * @return The wing loading in g/cm^2
	 */
	public double calcWingLoading() {
		return weight / wingarea;
	}

}
