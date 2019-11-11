package com.skishop.dao;

import java.util.ArrayList;

import com.skishop.entity.Product;

/**
 * 商品增删改查接口
 * @author anneli
 * @date 2019年10月14日 上午8:54:07 
 *
 */
public interface ProductDao {
	/**
	 * 查询所以的商品
	 * @return 返回商品列表
	 */
	public ArrayList<Product> findAll();
	
	/**
	 * 通过商品id查询商品对象
	 * @param id 商品id
	 * @return 商品对象
	 */
	public Product selectProduct(int id);
	
	/**
	 * 增加商品对象到数据库
	 * @param product 商品对象
	 * @return 增加成功返回1，失败返回-1
	 */
	public boolean addProduct(Product product);
	
	/**
	 * 删除指定商品id的商品对象
	 * @param id 商品id
	 * @return 删除成功返回1，失败返回-1
	 */
	public boolean delProduct(int id);
	
	/**
	 * 修改指定商品id的商品对象
	 * @param product 商品对象
	 * @return 修改成功返回1，失败返回-1
	 */
	public boolean updateProduct(Product product);
	
	/**
	 * 通过limit查询商品
	 * @param pageNum 第几页
	 * @param pageSize 查询个数
	 * @return 返回商品列表
	 */
	public ArrayList<Product> findProductByPage(int pageNum,int pageSize);
	
	/**
	 * 查询商品数量
	 * @return 商品数量
	 */
	public int findCountProduct();
}
