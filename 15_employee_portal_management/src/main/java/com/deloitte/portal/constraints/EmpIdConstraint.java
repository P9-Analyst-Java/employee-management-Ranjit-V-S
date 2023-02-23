package com.deloitte.portal.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = EmpIdValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmpIdConstraint {

	String message() default "Emp Id should is already taken!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
