package com.skishop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.skishop.entity.Product;
import com.sun.crypto.provider.RSACipher;

import sun.print.resources.serviceui;

import com.skishop.dao.ProductDao;

/**
 * 商品增删改查实现类
 * @author anneli
 * @date 2019年10月14日 上午9:12:46 
 *
 */
public class ProductDaoImpl implements ProductDao{

	@Override
	public ArrayList<Product> findAll(){
		try{
			ArrayList<Product> list=new ArrayList<Product>();
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from product");
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDescription(rs.getString(3));
				p.setListimg(rs.getString(4));
				p.setPrice(rs.getInt(5));
				p.setDiscountprice(rs.getInt(6));
				list.add(p);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Product selectProduct(int id) {
		try{
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from product where id = ?");
			pstm.setInt(1, id);
			ResultSet rs=pstm.executeQuery();
			Product p=new Product();
			while(rs.next()){
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDescription(rs.getString(3));
				p.setListimg(rs.getString(4));
				p.setPrice(rs.getInt(5));
				p.setDiscountprice(rs.getInt(6));
			}
			return p;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addProduct(Product product) {
		try{
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("insert into product values(?,?,?,?,?,?)");
			pstm.setInt(1, product.getId());
			pstm.setString(2, product.getName());
			pstm.setString(3, product.getDescription());
			pstm.setString(4, product.getListimg());
			pstm.setInt(5, product.getPrice());
			pstm.setInt(6, product.getDiscountprice());
			int result=pstm.executeUpdate();
			while(result>0){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean delProduct(int id) {
		try{
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("delete from product where id=?");
			pstm.setInt(1, id);
			int result=pstm.executeUpdate();
			while(result>0){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		try{
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("update product set name=?,description=?,listimg=?,price=?,discountprice=? where id=?");
			pstm.setString(1, product.getName());
			pstm.setString(2, product.getDescription());
			pstm.setString(3, product.getListimg());
			pstm.setInt(4, product.getPrice());
			pstm.setInt(5, product.getDiscountprice());
			pstm.setInt(6, product.getId());
			int result=pstm.executeUpdate();
			while(result>0){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public ArrayList<Product> findProductByPage(int pageNum, int pageSize) {
		try{
			ArrayList<Product> list=new ArrayList<Product>();
			Connection con=DBUtil.getCon();
			
			//limit有2个参数，第一个是启始数据，第二个参数是查询个数
			PreparedStatement pstm=con.prepareStatement("select * from product limit ?,?");
			pstm.setInt(1, (pageNum - 1) * pageSize);
			pstm.setInt(2, pageSize);
			
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDescription(rs.getString(3));
				p.setListimg(rs.getString(4));
				p.setPrice(rs.getInt(5));
				p.setDiscountprice(rs.getInt(6));
				list.add(p);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int findCountProduct() {
		try{
			int totals=0;
			
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("select count(*) as totals from product");
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				//totals=rs.getInt(1);
				totals=rs.getInt("totals");
				return totals;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
}
