package org.desertskyrangers.caspian;

import java.util.Set;

public class FlowSet implements Flow {

	private final Set<Flow> elements;

	public FlowSet( Set<Flow> elements ) {
		this.elements = elements;
	}

	@Override
	public double[] velocity( double x, double y ) {
		double[] result = new double[ 2 ];
		elements.stream().map( flow -> flow.velocity( x, y ) ).forEach( vector -> {
			result[ 0 ] += vector[ 0 ];
			result[ 1 ] += vector[ 1 ];
		} );
		return result;
	}

	@Override
	public double[] velocityAtInfinity() {
		double[] result = new double[ 2 ];
		elements.stream().map( Flow::velocityAtInfinity ).forEach( vector -> {
			result[ 0 ] += vector[ 0 ];
			result[ 1 ] += vector[ 1 ];
		} );
		return result;
	}

}
