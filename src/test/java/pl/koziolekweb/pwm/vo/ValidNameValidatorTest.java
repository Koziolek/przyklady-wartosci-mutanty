package pl.koziolekweb.pwm.vo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ClockProvider;
import javax.validation.ConstraintValidatorContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class ValidNameValidatorTest {

	private NameValidator sut;

	private ConstraintValidatorContext cvc = new ConstraintValidatorContext(){
		@Override
		public void disableDefaultConstraintViolation() {
			fail("DO NOT USE THIS");
		}

		@Override
		public String getDefaultConstraintMessageTemplate() {
			fail("DO NOT USE THIS");
			return null;
		}

		@Override
		public ClockProvider getClockProvider() {
			fail("DO NOT USE THIS");
			return null;
		}

		@Override
		public ConstraintViolationBuilder buildConstraintViolationWithTemplate(String s) {
			fail("DO NOT USE THIS");
			return null;
		}

		@Override
		public <T> T unwrap(Class<T> aClass) {
			fail("DO NOT USE THIS");
			return null;
		}
	};

	@BeforeEach
	void setUp() {
		this.sut = new NameValidator();
	}

	@Test
	void shouldSuccessOnProperName() {
		assertThat(sut.isValid("Bartek", cvc)).isTrue();
		assertThat(sut.isValid("Kuczyński", cvc)).isTrue();
		assertThat(sut.isValid("Łukasz", cvc)).isTrue();
		assertThat(sut.isValid("Świętosława", cvc)).isTrue();
		assertThat(sut.isValid("Żaneta", cvc)).isTrue();
		assertThat(sut.isValid("Zażółcićgęśląjaźć", cvc)).isTrue();
	}

	@Test
	void shouldFailOnNull() {
		assertThat(sut.isValid(null, cvc)).isFalse();
	}

	@Test
	void shouldFailOnNotCapitalFirstLetter() {
		assertThat(sut.isValid("null", cvc)).isFalse();
	}

	@Test
	void shouldFailOnSpaces() {
		assertThat(sut.isValid("Bartek Kuczyński", cvc)).isFalse();
	}

	@Test
	void shouldFailOnNumbers() {
		assertThat(sut.isValid("B4rt3k", cvc)).isFalse();
	}

	@Test
	void shouldFailOnNonLetters() {
		assertThat(sut.isValid("B$rt#k", cvc)).isFalse();
	}
	@Test
	void shouldFailOnTooShort() {
		assertThat(sut.isValid("Be", cvc)).isFalse();
	}
}