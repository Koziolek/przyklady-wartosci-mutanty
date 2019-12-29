package pl.koziolekweb.pwm.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerWithTypesTest {

	private final Name validName = new Name("Adam");

	@Test
	void shouldSuccessOnNotNullNames() {
		assertThat(new CustomerWithTypes(validName, validName)).isNotNull();
	}

	@Test
	void shouldFailOnNullFN() {
		assertThrows(IllegalArgumentException.class, () -> new CustomerWithTypes(null, validName));
	}
	
	@Test
	void shouldFailOnNullLN() {
		assertThrows(IllegalArgumentException.class, () -> new CustomerWithTypes(null, validName));
	}
}