package pl.koziolekweb.pwm.byexample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleCalculatorByExampleTestSample {

	private SimpleCalculatorByExample sut;

	@BeforeEach
	void setUp() {
		sut = new SimpleCalculatorByExample();
	}

	@Test
	void add2And2() {
		int sum = sut.sum(2, 2);
		org.junit.jupiter.api.Assertions.assertEquals(4, sum);
		org.assertj.core.api.Assertions.assertThat(sum).isEqualTo(4);
	}
}