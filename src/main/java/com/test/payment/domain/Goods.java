package com.test.payment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(of="id")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

	String id ;
	String height ;
	String wide ;
	String length ;
	String name ;
	GoodsType goodsType ;
}
