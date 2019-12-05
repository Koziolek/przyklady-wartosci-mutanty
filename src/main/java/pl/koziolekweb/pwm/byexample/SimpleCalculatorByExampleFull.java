package pl.koziolekweb.pwm.byexample;

import com.google.common.base.Preconditions;
import pl.koziolekweb.pwm.SimpleCalculator;

class SimpleCalculatorByExampleFull implements SimpleCalculator {
	@Override
	public int sum(int a, int b) {
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
