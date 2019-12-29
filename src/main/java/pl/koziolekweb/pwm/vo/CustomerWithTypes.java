package pl.koziolekweb.pwm.vo;

import com.google.common.base.Preconditions;

class CustomerWithTypes {

	private final Name firstName;

	private final Name lastName;

	public CustomerWithTypes(Name firstName, Name lastName) {
		Preconditions.checkArgument(firstName!=null);
		Preconditions.checkArgument(lastName!=null);
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
