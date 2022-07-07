package org.desertskyrangers.caspian;

import org.desertskyrangers.caspian.element.Uniform;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FlowField {

	private final Air air;

	private final Uniform onsetFlow;

	private final double vInf;

	private final double pInf;

	private Set<FlowElement> elements;

	public FlowField( Uniform onsetFlow ) {
		this( Air.ISA, onsetFlow );
	}

	public FlowField( Air air, Uniform onsetFlow ) {
		this.air = air;
		this.onsetFlow = onsetFlow;
		this.vInf = Vector.magnitude( onsetFlow.getVelocity() );
		this.pInf = air.pressure() - (0.5 * air.density() * vInf * vInf);
		this.elements = new HashSet<>();
	}

	public Air getAir() {
		return air;
	}

	public Uniform getOnsetFlow() {
		return onsetFlow;
	}

	public void add( FlowElement element ) {
		this.elements.add( element );
	}

	public void addAll( Collection<? extends FlowElement> elements ) {
		this.elements.addAll( elements );
	}

	public double[] velocityAt( double x, double y ) {
		final double[] v = new double[]{ 0, 0 };

		// Add the onset flow velocity
		Vector.add( v, onsetFlow.getVelocity() );

		// Add all the local velocity
		Vector.add( v, relativeVelocityAt( x, y ) );

		return v;
	}

	public double[] relativeVelocityAt( double x, double y ) {
		final double[] v = new double[]{ 0, 0 };

		// Add all the element velocities
		elements.forEach( e -> Vector.add( v, e.velocity( x, y ) ) );

		return v;
	}

	public double pressureAt( double x, double y ) {
		double v = Vector.magnitude( velocityAt( x, y ) );
		return air.pressure() - (0.5 * air.density() * v * v);
	}

	public double relativePressureAt( double x, double y ) {
		return pressureAt(x,y) - pInf;
	}

}
