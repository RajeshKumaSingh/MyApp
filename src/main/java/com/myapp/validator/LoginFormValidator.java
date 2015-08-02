package com.myapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.myapp.form.LoginForm;

public class LoginFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginForm.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		LoginForm p = (LoginForm) obj;
        e.rejectValue("username", "negativevalue");
	}

}
