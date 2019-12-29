package pl.koziolekweb.pwm.vo;

import com.google.common.base.Preconditions;

class Customer {

	private final String firstName;

	private final String lastName;

	public Customer(String firstName, String lastName) {
		Preconditions.checkArgument(firstName !=null && firstName.matches("[A-ZŁŚŹŻ][a-ząćęłńóśżź]{2,}"));
		Preconditions.checkArgument(lastName !=null && lastName.matches("[A-ZŁŚŹŻ][a-ząćęłńóśżź]{2,}"));
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
