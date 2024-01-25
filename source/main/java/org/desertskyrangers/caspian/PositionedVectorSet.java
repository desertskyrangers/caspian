package org.desertskyrangers.caspian;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

public class PositionedVectorSet extends HashSet<PositionedVector> {

	private double[] centerPosition;

	private double[] centerVector;

	double[] centerPosition() {
		return centerPosition;
	}

	double[] centerVector() {
		return centerVector;
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

		double armX = 0;
		double armY = 0;
		double torqueX = 0;
		double torqueY = 0;
		for( PositionedVector v : this ) {
			Vector.add( sum, v.vector() );
			armX += v.position()[ 0 ];
			armY += v.position()[ 1 ];
			torqueX += v.position()[ 0 ] * v.vector()[ 1 ];
			torqueY += v.position()[ 1 ] * v.vector()[ 0 ];
		}

		double posX = torqueX == 0.0 ? 0.0 : torqueX / armX;
		double posY = torqueY == 0.0 ? 0.0 : torqueY / armY;

		this.centerPosition = Vector.of( posX, posY );
		this.centerVector = sum;
	}

}
