package org.desertskyrangers.caspian;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FlowField {

	private final double xmin;

	private final double ymin;

	private final double xmax;

	private final double ymax;

	private final Air air;

	private Set<FlowElement> elements;

	public FlowField( double xmin, double ymin, double xmax, double ymax ) {
		this( xmin, ymin, xmax, ymax, Air.ISA );
	}

	public FlowField( double xmin, double ymin, double xmax, double ymax, Air air ) {
		this.xmin = xmin;
		this.ymin = ymin;
		this.xmax = xmax;
		this.ymax = ymax;
		this.air = air;

		this.elements = new HashSet<>();
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

	public void add( FlowElement element ) {
		this.elements.add( element );
	}

	public void addAll( Collection<? extends FlowElement> elements ) {
		this.elements.addAll( elements );
	}

	public double[] velocityAt( double x, double y ) {
		final double[] v = new double[] {0,0};

		elements.forEach( e -> {
			double[] ev = e.velocity( x,y );
			v[0] += ev[0];
			v[1] += ev[1];
		});

		return v;
	}

	public double pressureAt( double x, double y ) {
		return 0;
	}

}
