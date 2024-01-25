package org.desertskyrangers.caspian;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

public class PositionedVectorSet extends HashSet<PositionedVector> {

	private double[] position;

	private double[] vector;

	double[] meanPosition() {
		return position;
	}

	double[] meanVector() {
		return vector;
	}

	@Override
	public boolean add( PositionedVector positionedVector ) {
		boolean result = super.add( positionedVector );
		update();
		return result;
	}

	@Override
	public boolean remove( Object o ) {
		boolean result = super.remove( o );
		update();
		return result;
	}

	@Override
	public void clear() {
		super.clear();
		update();
	}

	@Override
	public boolean removeAll( Collection<?> c ) {
		boolean result = super.removeAll( c );
		update();
		return result;
	}

	@Override
	public boolean addAll( Collection<? extends PositionedVector> c ) {
		boolean result = super.addAll( c );
		update();
		return result;
	}

	@Override
	public boolean retainAll( Collection<?> c ) {
		boolean result = super.retainAll( c );
		update();
		return result;
	}

	@Override
	public boolean removeIf( Predicate<? super PositionedVector> filter ) {
		boolean result = super.removeIf( filter );
		update();
		return result;
	}

	private void update() {
		int index = 0;
		double[] pos = Vector.of( 0, 0 );
		double[] mean = Vector.of( 0, 0 );
		// Update the position and vector
		for( PositionedVector pv : this ) {
			double scaleUp = index;
			double scaleDown = 1.0 / ++index;
			// FIXME Position needs to be weighted by vector magnitude
			Vector.scale( Vector.add( Vector.scale( pos, scaleUp ), pv.position() ), scaleDown );
			Vector.scale( Vector.add( Vector.scale( mean, scaleUp ), pv.vector() ), scaleDown );
		}
		this.position = pos;
		this.vector = mean;
	}

}
