package com.skishop.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 购物车类
 * @author anneli
 * @date 2019年10月14日 下午3:02:09 
 *
 */
public class Cart {
	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
	private int price;
	
	public Map<Integer, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<Integer, CartItem> map) {
		this.map = map;
	}

	public int getPrice() {
		int totalPrice=0;//总价
		for (Entry<Integer, CartItem> entry:map.entrySet()) {
			totalPrice+=map.get(entry.getKey()).getPrice();
		}
		this.price=totalPrice;
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void addItem(Product product) {
		//判断product是否存在map里
		if (map.containsKey(product.getId())) {
			int count=map.get(product.getId()).getCount();//得到购物项数量
			map.get(product.getId()).setCount(count+1);//数量+1
		}
		else {
			CartItem cartItem = new CartItem(product,1);//初始化购物项
			map.put(product.getId(), cartItem);
		}
	}


	
}
