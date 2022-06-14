package org.desertskyrangers.caspian.element;

import org.desertskyrangers.caspian.PotentialFlow;

public class SourceSheet implements PotentialFlow {

	@Override
	public double[] velocity( double x, double y ) {
		return new double[ 0 ];
	}

}
