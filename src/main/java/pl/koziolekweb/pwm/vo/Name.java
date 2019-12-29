package pl.koziolekweb.pwm.vo;

import com.google.common.base.Preconditions;

class Name {

	private final String value;

	Name(String value) {
		Preconditions.checkArgument(value !=null && value.matches("[A-ZŁŚŹŻ][a-ząćęłńóśżź]{2,}"));
		this.value = value;
	}

}
