package org.desertskyrangers.caspian.element;

public abstract class Sheet extends Singularity {

	protected double positionX1;

	protected double positionY1;

	protected Sheet( double positionX, double positionY, double positionX1, double positionY1, double strength ) {
		super( positionX, positionY, strength );
		this.positionX1 = positionX1;
		this.positionY1 = positionY1;
	}

}
