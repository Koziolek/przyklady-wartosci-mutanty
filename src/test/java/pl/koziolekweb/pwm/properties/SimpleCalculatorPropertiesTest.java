package pl.koziolekweb.pwm.properties;

import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Negative;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleCalculatorPropertiesTest implements AutoCloseable {
	private SimpleCalculatorProperties sut;

	SimpleCalculatorPropertiesTest() {
		sut = new SimpleCalculatorProperties();
	}

	@Example
	void simpleAddExample() {
		assertThat(sut.sum(2, 2)).isEqualTo(4);
	}

	@Property
	void simplePositiveProperties(@ForAll @IntRange(min = 0, max = Integer.MAX_VALUE / 2) int a, @ForAll @IntRange(min = 0, max = Integer.MAX_VALUE / 2) int b) {
		assertThat(sut.sum(a, b)).isGreaterThanOrEqualTo(a).isGreaterThanOrEqualTo(b);
	}

	@Property
	void simpleNegativeProperties(@ForAll @IntRange(min = Integer.MIN_VALUE/2, max = 0) int a, @ForAll @IntRange(min = Integer.MIN_VALUE/2, max = 0) int b) {
		assertThat(sut.sum(a, b)).isLessThanOrEqualTo(a).isLessThanOrEqualTo(b);
	}


	@Override
	public void close() throws Exception {
		sut = null;
	}
}