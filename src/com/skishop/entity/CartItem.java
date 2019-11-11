package com.skishop.entity;

/**
 * 购物项类：商品、商品数量、小计价格
 * 
 * @author anneli
 * @date 2019年10月14日 下午3:13:12
 *
 */
public class CartItem {
	private Product product;// 商品
	private int count;// 商品数量
	private int price;// 小计价格
	
	public CartItem() {
	}

	public CartItem(Product product, int count) {
		super();
		this.product = product;
		this.count = count;
		this.price = this.product.getDiscountprice() * count;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.price = this.product.getDiscountprice() * count;
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price * count;
	}

}
