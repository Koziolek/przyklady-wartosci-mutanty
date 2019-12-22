package pl.koziolekweb.pwm;

import com.google.common.base.Preconditions;

public interface SimpleCalculatorFull extends SimpleCalculator {

	default int sum(int a, int b) {
		int sum = a + b;
		if (a > 0 && b > 0)
			Preconditions.checkState(sum >= a && sum >= b,
					"Result overflow MAX_INT");
		if (a < 0 && b < 0)
			Preconditions.checkState(sum <= a && sum <= b,
					"Result overflow MIN_INT");
		return sum;
	}

}
