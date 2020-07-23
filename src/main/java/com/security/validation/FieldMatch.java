package com.security.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=FieldMatchConstraintValidator.class)
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface FieldMatch {
	//define default msgs
	String message() default "";
	//define default group
	public Class<?>[] groups() default{};
	//define payload
	Class<? extends Payload>[] payload() default {};
	String first();
    String second();
    @Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List
    {
    	FieldMatch[] value();
    }

}
