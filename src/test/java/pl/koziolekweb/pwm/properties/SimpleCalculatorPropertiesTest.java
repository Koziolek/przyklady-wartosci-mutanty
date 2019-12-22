package pl.koziolekweb.pwm.properties;

import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Negative;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleCalculatorPropertiesTest implements AutoCloseable{
	private SimpleCalculatorProperties sut;

	SimpleCalculatorPropertiesTest() {
		sut = new SimpleCalculatorProperties();
	}

	@Example
	void simpleAddExample() {
		assertThat(sut.sum(2, 2)).isEqualTo(4);
	}

	@Property
	void simplePositiveProperties(@ForAll @Positive int a, @ForAll @Positive int b) {
		assertThat(sut.sum(a, b)).isGreaterThanOrEqualTo(a).isGreaterThanOrEqualTo(b);
	}

	@Property
	void simpleNegativeProperties(@ForAll @Negative int a, @ForAll @Negative int b) {
		assertThat(sut.sum(a, b)).isLessThanOrEqualTo(a).isLessThanOrEqualTo(b);
	}


	@Override
	public void close() throws Exception {
		sut = null;
	}
}