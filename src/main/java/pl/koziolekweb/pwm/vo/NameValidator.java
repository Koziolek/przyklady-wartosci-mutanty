package pl.koziolekweb.pwm.vo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String> {

	@Override
	public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {

		return name !=null && name.matches("[A-ZŁŚŹŻ][a-ząćęłńóśżź]{2,}");
	}
}
