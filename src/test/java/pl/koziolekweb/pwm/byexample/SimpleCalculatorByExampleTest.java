package pl.koziolekweb.pwm.byexample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleCalculatorByExampleTest {
	private SimpleCalculatorByExample sut;

	@BeforeEach
	void setUp() {
		sut = new SimpleCalculatorByExample();
	}

	@Test
	void add2And2() {
		int sum = sut.sum(2, 2);
		assertThat(sum).isEqualTo(4);
	}
}