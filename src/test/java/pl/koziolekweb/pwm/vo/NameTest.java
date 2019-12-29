package pl.koziolekweb.pwm.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

	@Test
	void shouldSuccessOnProperName() {
		assertThat(new Name("Bartek")).isNotNull();
		assertThat(new Name("Kuczyński")).isNotNull();
		assertThat(new Name("Łukasz")).isNotNull();
		assertThat(new Name("Świętosława")).isNotNull();
		assertThat(new Name("Żaneta")).isNotNull();
		assertThat(new Name("Zażółcićgęśląjaźć")).isNotNull();
	}

	@Test
	void shouldFailOnNull() {
		assertThrows(IllegalArgumentException.class, () -> new Name(null));
	}

	@Test
	void shouldFailOnNotCapitalFirstLetter() {
		assertThrows(IllegalArgumentException.class, () -> new Name("null"));
	}

	@Test
	void shouldFailOnSpaces() {
		assertThrows(IllegalArgumentException.class, () -> new Name("Bartek Kuczyński"));
	}

	@Test
	void shouldFailOnNumbers() {
		assertThrows(IllegalArgumentException.class, () -> new Name("B4rt3k"));
	}

	@Test
	void shouldFailOnNonLetters() {
		assertThrows(IllegalArgumentException.class, () -> new Name("B$rt#k"));
	}

	@Test
	void shouldFailOnTooShort() {
		assertThrows(IllegalArgumentException.class, () -> new Name("Be"));
	}
}