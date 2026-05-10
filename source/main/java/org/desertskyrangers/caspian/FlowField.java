package org.desertskyrangers.caspian;

import lombok.Getter;
import org.desertskyrangers.caspian.element.AggregateFlow;
import org.desertskyrangers.caspian.element.Uniform;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FlowField implements FlowElement{

	@Getter
	private final Air air;

	private final double velocityAtInfinity;

	private final double pressureAtInfinity;

	// TODO The onset flow should also be a set of flow elements.
	private final AggregateFlow onsetFlow;

	private final Set<FlowElement> elements;

	public FlowField( Uniform onsetFlow ) {
		this( Air.ISA, onsetFlow );
	}

	public FlowField( Air air, Uniform onsetFlow ) {
		this( air, Set.of( onsetFlow ) );
	}

	public FlowField( Air air, Set<FlowElement> onsetFlow ) {
		this.air = air;
		this.onsetFlow = new AggregateFlow(  onsetFlow  );
		this.velocityAtInfinity = Vector.magnitude( this.onsetFlow.velocityAtInfinity() );
		this.pressureAtInfinity = air.pressure() - (0.5 * air.density() * velocityAtInfinity * velocityAtInfinity);
		this.elements = new HashSet<>();
	}

	public FlowElement getOnsetFlow() {
		return onsetFlow;
	}

	public void add( FlowElement element ) {
		this.elements.add( element );
	}

	public void addAll( Collection<? extends FlowElement> elements ) {
		this.elements.addAll( elements );
	}

	public double[] velocity( double x, double y ) {
		final double[] v = new double[]{ 0, 0 };

		// Add the onset flow velocity
		Vector.add( v, getOnsetFlow().velocity(x,y) );

		// Add all the local velocity
		Vector.add( v, relativeVelocity( x, y ) );

		return v;
	}

	public double[] relativeVelocity( double x, double y ) {
		final double[] v = new double[]{ 0, 0 };

		// Add all the element velocities
		elements.forEach( e -> Vector.add( v, e.velocity( x, y ) ) );

		return v;
	}

	/**
	 * Returns the absolute pressure at the given point.
	 *
	 * @param x The x-coordinate of the point
	 * @param y The y-coordinate of the point
	 * @return The absolute pressure at the given point
	 */
	public double pressureAt( double x, double y ) {
		double v = Vector.magnitude( velocity( x, y ) );
		return air.pressure() - (0.5 * air.density() * v * v);
	}

	/**
	 * Returns the relative pressure at the given point.
	 *
	 * @param x The x-coordinate of the point
	 * @param y The y-coordinate of the point
	 * @return The relative pressure at the given point
	 */
	public double relativePressureAt( double x, double y ) {
		return pressureAt(x,y) - pressureAtInfinity;
	}

}
