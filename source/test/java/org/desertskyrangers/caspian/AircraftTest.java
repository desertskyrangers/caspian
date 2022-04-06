package org.desertskyrangers.caspian;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AircraftTest {

	@Test
	void thatAspectRatioIsComputedCorrectly() {
		Aircraft demo = new Aircraft( 1000, 150, 2500 );
		assertThat( demo.aspectRatio() ).isEqualTo( 9.0 );
	}

	@Test
	void thatWingLoadingIsComputedCorrectly() {
		Aircraft demo = new Aircraft( 1000, 150, 2500 );
		assertThat( demo.wingLoading() ).isEqualTo( 0.4 );
	}

}
