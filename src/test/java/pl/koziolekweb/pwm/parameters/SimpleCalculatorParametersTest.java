package pl.koziolekweb.pwm.parameters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleCalculatorParametersTest {

	private SimpleCalculatorParameters sut;

	@BeforeEach
	void setUp() {
		sut = new SimpleCalculatorParameters();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/positive-data.csv")
	void simpleAddPositiveNumbers(int a, int b, int expectedSum) {
		int sum = sut.sum(a, b);
		assertThat(sum).isEqualTo(expectedSum);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/negative-data.csv")
	void simpleAddNegativeNumbers(int a, int b, int expectedSum) {
		int sum = sut.sum(a, b);
		assertThat(sum).isEqualTo(expectedSum);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/exceptional-data.csv")
	void simpleAddOverflow(int a, int b, String expectedMessage) {
		assertThrows(IllegalStateException.class, () -> sut.sum(a, b), expectedMessage);
	}

}