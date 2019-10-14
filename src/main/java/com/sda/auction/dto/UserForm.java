package com.sda.auction.dto;

import com.sda.auction.validator.ConfirmPasswordConstraint;
import javax.validation.constraints.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Data
@ToString
@ConfirmPasswordConstraint(message = "Confirm password doesn't match!")
public class UserForm {

	@NotEmpty(message = "{error.user.first.name.empty}")
	private String firstName;

	@NotEmpty(message = "{error.user.last.name.empty}")
	private String lastName;

	@Email(message = "{error.user.email.mail}")
	@NotEmpty(message = "{error.user.email.empty}")
	private String email;

	@Length(min = 4, message = "{error.user.password.length}")
	private String password;
	private String confirmPassword;
}
