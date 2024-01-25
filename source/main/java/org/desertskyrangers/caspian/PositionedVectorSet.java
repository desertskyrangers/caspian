package org.desertskyrangers.caspian;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

public class PositionedVectorSet extends HashSet<PositionedVector> {

	private double[] centroidPosition;

	private double[] centroidVector;

	double[] centroidPosition() {
		return centroidPosition;
	}

	double[] centroidVector() {
		return centroidVector;
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
		double[] sum = Vector.of( 0, 0 );
		double[] pos = Vector.of( 0, 0 );
		double magnitudeSum = 0;
		for( PositionedVector v : this ) {
			double magnitude = Vector.magnitude( v.vector() );
			Vector.add( pos, Vector.multiply( v.position(), magnitude ) );
			Vector.add( sum, v.vector() );
			magnitudeSum += magnitude;
		}

		double inverse = 1.0 / magnitudeSum;
		Vector.scale( pos, inverse );

		this.centroidPosition = Vector.of( pos[ 0 ], pos[ 1 ] );
		this.centroidVector = sum;
	}

}
