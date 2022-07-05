package org.desertskyrangers.caspian;

public class FlowField {

	private final double xmin;

	private final double ymin;

	private final double xmax;

	private final double ymax;

	private FlowField( double xmin, double ymin, double xmax, double ymax ) {
		this.xmin = xmin;
		this.ymin = ymin;
		this.xmax = xmax;
		this.ymax = ymax;
	}

	public double getXmin() {
		return xmin;
	}

	public double getYmin() {
		return ymin;
	}

	public double getXmax() {
		return xmax;
	}

	public double getYmax() {
		return ymax;
	}

}
