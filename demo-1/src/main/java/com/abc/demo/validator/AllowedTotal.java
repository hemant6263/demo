package com.abc.demo.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AllowedTotalValidator.class)
public @interface AllowedTotal {

	String message() default "${validatedValue} invalid as total";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String fieldName();
}