package pl.koziolekweb.pwm.byexample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleCalculatorByExampleFullTest {
	private SimpleCalculatorByExampleFull sut;

	@BeforeEach
	void setUp() {
		sut = new SimpleCalculatorByExampleFull();
	}

	@Test
	void add2And2() {
		int sum = sut.sum(2, 2);
		assertThat(sum).isEqualTo(4);
	}

	@Test
	void add2And0() {
		int sum = sut.sum(2, 0);
		assertThat(sum).isEqualTo(2);
	}

	@Test
	void addm2Andm2() {
		int sum = sut.sum(-2, -2);
		assertThat(sum).isEqualTo(-4);
	}

	@Test
	void add2Andm2() {
		int sum = sut.sum(2, -2);
		assertThat(sum).isEqualTo(0);
	}

	@Test
	void addm2And2() {
		int sum = sut.sum(-2, 2);
		assertThat(sum).isEqualTo(0);
	}

	@Test
	void addMaxOverflow() {
		assertThrows(IllegalStateException.class, () -> sut.sum(Integer.MAX_VALUE, 1), "Result overflow MAX_INT");
	}

	@Test
	void addMinOverflow() {
		assertThrows(IllegalStateException.class, () -> sut.sum(Integer.MIN_VALUE, -1), "Result overflow MIN_INT");
	}

}