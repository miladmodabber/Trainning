package com.test.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.payment.domain.Goods;
import com.test.payment.domain.GoodsType;
import com.test.payment.domain.resource.GoodsResource;
import com.test.payment.exception.InvalidDataException;
import com.test.payment.manager.GoodsManager;
import com.test.payment.validator.GoodsValidator;

@RestController("/goods")
public class GoodsController {

	private GoodsManager manager;
	private GoodsValidator goodsValidator;

	@Autowired
	public GoodsController(GoodsManager manager, GoodsValidator goodsValidator) {
		this.manager = manager;
		this.goodsValidator = goodsValidator;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/goods")
	public ResponseEntity<List<Goods>> getAll() {
		return new ResponseEntity<List<Goods>>(manager.getAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/goods/types")
	public ResponseEntity<List<Goods>> getAllByType(@RequestParam GoodsType type) {

		return new ResponseEntity<List<Goods>>(manager.getAllByType(type) , HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/goods")
	public ResponseEntity<?> save(@RequestBody GoodsResource goodsResource) {
		try {

			goodsValidator.goodsValidator(goodsResource);

			String result = manager.createGoods(new Goods(null, goodsResource.getHeight(), goodsResource.getWide(),
					goodsResource.getLength(), goodsResource.getName(), GoodsType.ONE));
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (InvalidDataException exp) {
			return new ResponseEntity<>(exp.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
