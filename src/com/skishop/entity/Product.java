package com.skishop.entity;

public class Product {
	private int id;
	private String name;
	private String description;
	private String listimg;
	private int price;
	private int discountprice;

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", listimg=" + listimg
				+ ", price=" + price + ", discountprice=" + discountprice + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getListimg() {
		return listimg;
	}

	public void setListimg(String listimg) {
		this.listimg = listimg;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountprice() {
		return discountprice;
	}

	public void setDiscountprice(int discountprice) {
		this.discountprice = discountprice;
	}

	public Product(int id, String name, String description, String listimg, int price, int discountprice) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.listimg = listimg;
		this.price = price;
		this.discountprice = discountprice;
	}

	public Product() {
		super();
	}

}
