package org.desertskyrangers.caspian;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@RequiredArgsConstructor
@Accessors( fluent = true )
public class Airfoil {

	private final double liftCoefficient;

}
