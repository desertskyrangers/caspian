package org.desertskyrangers.caspian;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@RequiredArgsConstructor
@Accessors( fluent = true )
public class Airfoil {

	// FIXME Airfoil should not have a lift coefficient attribute. Lift coefficient is defined by calculation.
	private final double liftCoefficient;

}
