package org.desertskyrangers.caspian.element;

/**
 * The panel class represents straight flow panels (as compared to sheets that
 * can be curved). This is the superclass of all panel implementations.
 */
public abstract class Panel extends Singularity {

	protected double positionX1;

	protected double positionY1;

	protected Panel( double positionX, double positionY, double positionX1, double positionY1, double strength ) {
		super( positionX, positionY, strength );
		this.positionX1 = positionX1;
		this.positionY1 = positionY1;
	}

}
