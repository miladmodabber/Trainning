package com.test.payment.validator;

import org.springframework.stereotype.Component;
import com.test.payment.domain.User;
import com.test.payment.domain.resource.UserResource;
import com.test.payment.exception.InvalidDataException;

@Component
public class UserValidator {
	

	public void validateUser(UserResource userResource){
		notNull(userResource.getName(),"name is invalid ");
		notNull(userResource.getFamily(),"family is invalid ");
		notNull(userResource.getBirthDay() , "birthDay is invalid");
		notNull(userResource.getSex() , "sex is invalid ") ;
		
	}
	
	public void notNull(Object obj ,String message){
		if(obj == null){
			throw new InvalidDataException(message);
		}
	}

}
