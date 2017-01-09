package com.test.payment.validator;


import org.springframework.stereotype.Component;

import com.test.payment.domain.resource.GoodsResource;
@Component
public class GoodsValidator {

	public void goodsValidator(GoodsResource goodsResource){
		new UserValidator().notNull(goodsResource.getHeight(), "the hight is inValid"); 
		new UserValidator().notNull(goodsResource.getLength(), "the Lenght is inValid");
		new UserValidator().notNull(goodsResource.getWide(), "the Wide is inValid");
		new UserValidator().notNull(goodsResource.getName(), "the name is inValid");
	} 


}
