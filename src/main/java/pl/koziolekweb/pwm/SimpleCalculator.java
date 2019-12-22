package pl.koziolekweb.pwm;

public interface SimpleCalculator {

	default int sum(int a, int b) {return a + b;};

}
