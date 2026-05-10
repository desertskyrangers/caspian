package org.desertskyrangers.caspian.element;

import org.desertskyrangers.caspian.FlowElement;

import java.util.Set;

public class AggregateFlow implements FlowElement {

	private final Set<FlowElement> elements;

	public AggregateFlow( Set<FlowElement> elements ) {
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
		elements.stream().map( FlowElement::velocityAtInfinity ).forEach( vector -> {
			result[ 0 ] += vector[ 0 ];
			result[ 1 ] += vector[ 1 ];
		} );
		return result;
	}

}
