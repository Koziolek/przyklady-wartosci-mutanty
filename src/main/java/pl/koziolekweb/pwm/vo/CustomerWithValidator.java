package pl.koziolekweb.pwm.vo;

class CustomerWithValidator {

	@ValidName
	private final String firstName;
	@ValidName
	private final String lastName;

	public CustomerWithValidator(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
