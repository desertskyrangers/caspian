package org.desertskyrangers.caspian.element;

import org.desertskyrangers.caspian.FlowElement;

public abstract class Singularity implements FlowElement {

	protected double positionX;

	protected double positionY;

	protected double strength;

	protected Singularity( double positionX, double positionY, double strength ) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.strength = strength;
	}

}
