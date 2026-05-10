package org.desertskyrangers.caspian;

public interface FlowElement {

	default double[] velocity( double x, double y ) {
		return Vector.ZERO;
	}

	default double[] velocityAtInfinity() {
		return Vector.ZERO;
	}

	default double stream( double x, double y ) {
		return 0;
	}

	default double potential( double x, double y ) {
		return 0;
	}

}
