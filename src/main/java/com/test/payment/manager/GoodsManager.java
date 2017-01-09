package com.test.payment.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.test.payment.domain.Goods;
import com.test.payment.domain.GoodsType;

@Component
public class GoodsManager {

	List<Goods> list = new ArrayList<Goods>();

	public String createGoods(Goods goods) {
		list.add(goods);
		goods.setId(list.size() + " ");
		return Math.random() + " ";
	}

	public List<Goods> getAll() {
		return list;

	}

	public List<Goods> getAllByType(GoodsType goodsType) {
		List<Goods> listByType = new ArrayList<Goods>();
		for (Goods goods : list) {
			if (goods.getGoodsType().equals(goodsType)) {
				listByType.add(goods);
			}
		}
		return listByType;
	}

}
