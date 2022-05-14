package org.desertskyrangers.caspian;

public interface PotentialFlow {

	double[] velocity( double x, double y );

	double stream( double x, double y );

	double potential( double x, double y );

}
