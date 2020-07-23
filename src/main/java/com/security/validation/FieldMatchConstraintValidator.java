package com.security.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class FieldMatchConstraintValidator 
implements ConstraintValidator<FieldMatch, Object> {
	

	private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize( FieldMatch fieldMatch) {
	    	firstFieldName = fieldMatch.first();
	    	secondFieldName = fieldMatch.second();
	    	message = fieldMatch.message();
    }
	@Override
	//thecode is actullay entered by user in html fom
	public boolean isValid(Object thecode, ConstraintValidatorContext context) {
		boolean valid = true;
        try
        {
             Object firstObj = new BeanWrapperImpl(thecode).getPropertyValue(firstFieldName);
             Object secondObj = new BeanWrapperImpl(thecode).getPropertyValue(secondFieldName);

            valid =  firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch ( Exception ignore)
        {
            
        }

        if (!valid){
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(firstFieldName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return valid;
    }
	}

	

	

	
	
	
	

