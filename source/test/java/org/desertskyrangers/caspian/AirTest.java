package org.desertskyrangers.caspian;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AirTest {

	@Test
	void thatAirIsaValuesAreCorrect() {
		assertThat( Air.ISA.pressure() ).isEqualTo( 101325.0 );
		assertThat( Air.ISA.temperature() ).isEqualTo( 15 );
		assertThat( Air.ISA.density() ).isEqualTo( 1.225 );
		assertThat( Air.ISA.viscosity() ).isEqualTo( 1.789e-5 );
	}

}
