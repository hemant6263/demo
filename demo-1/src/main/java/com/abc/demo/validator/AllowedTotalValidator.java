package com.abc.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AllowedTotalValidator implements ConstraintValidator<AllowedTotal, Double> {


	@Override
	public void initialize(AllowedTotal constraint) {

	}

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		if(value>=0)
			return true;
		
		return false;
	}
}