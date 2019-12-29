package pl.koziolekweb.pwm.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerTest {

	private final String cvc = "Adam";

	@Test
	void shouldSuccessOnProperNameFN() {
		assertThat(new Customer("Bartek", cvc)).isNotNull();
		assertThat(new Customer("Kuczyński", cvc)).isNotNull();
		assertThat(new Customer("Łukasz", cvc)).isNotNull();
		assertThat(new Customer("Świętosława", cvc)).isNotNull();
		assertThat(new Customer("Żaneta", cvc)).isNotNull();
		assertThat(new Customer("Zażółcićgęśląjaźć", cvc)).isNotNull();
	}

	@Test
	void shouldFailOnNullFN() {
		assertThrows(IllegalArgumentException.class, () -> new Customer(null, cvc));
	}

	@Test
	void shouldFailOnNotCapitalFirstLetterFN() {
		assertThrows(IllegalArgumentException.class, () -> new Customer("null", cvc));
	}

	@Test
	void shouldFailOnSpacesFN() {
		assertThrows(IllegalArgumentException.class, () -> new Customer("Bartek Kuczyński", cvc));
	}

	@Test
	void shouldFailOnNumbersFN() {
		assertThrows(IllegalArgumentException.class, () -> new Customer("B4rt3k", cvc));
	}

	@Test
	void shouldFailOnNonLettersFN() {
		assertThrows(IllegalArgumentException.class, () -> new Customer("B$rt#k", cvc));
	}

	@Test
	void shouldFailOnTooShortFN() {
		assertThrows(IllegalArgumentException.class, () -> new Customer("Be", cvc));
	}

	@Test
	void shouldSuccessOnProperNameLN() {
		assertThat(new Customer(cvc, "Bartek")).isNotNull();
		assertThat(new Customer(cvc, "Kuczyński")).isNotNull();
		assertThat(new Customer(cvc, "Łukasz")).isNotNull();
		assertThat(new Customer(cvc, "Świętosława")).isNotNull();
		assertThat(new Customer(cvc, "Żaneta")).isNotNull();
		assertThat(new Customer(cvc, "Zażółcićgęśląjaźć")).isNotNull();
	}

	@Test
	void shouldFailOnNullLN() {
		assertThrows(IllegalArgumentException.class, () -> new Customer(cvc, null));
	}

	@Test
	void shouldFailOnNotCapitalFirstLetterLN() {
		assertThrows(IllegalArgumentException.class, () -> new Customer(cvc, "null"));
	}

	@Test
	void shouldFailOnSpacesLN() {
		assertThrows(IllegalArgumentException.class, () -> new Customer(cvc, "Bartek Kuczyński"));
	}

	@Test
	void shouldFailOnNumbersLN() {
		assertThrows(IllegalArgumentException.class, () -> new Customer(cvc, "B4rt3k"));
	}

	@Test
	void shouldFailOnNonLettersLN() {
		assertThrows(IllegalArgumentException.class, () -> new Customer(cvc, "B$rt#k"));
	}

	@Test
	void shouldFailOnTooShortLN() {
		assertThrows(IllegalArgumentException.class, () -> new Customer(cvc, "Be"));
	}
}