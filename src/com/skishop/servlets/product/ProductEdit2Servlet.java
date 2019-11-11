package com.skishop.servlets.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skishop.dao.impl.ProductDaoImpl;
import com.skishop.entity.Cart;
import com.skishop.entity.Product;

/**
 * Servlet implementation class ProductEdit2Servlet
 */
@WebServlet("/ProductEdit2Servlet")
public class ProductEdit2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductEdit2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
//		String listimg = request.getParameter("listimg");//img标签无value值
		int price = Integer.valueOf(request.getParameter("price"));
		int discountprice = Integer.valueOf(request.getParameter("discountprice"));
		
		ProductDaoImpl pr = new ProductDaoImpl();
		
		Product product = new Product(id,name,description,pr.selectProduct(id).getListimg(),price,discountprice);
		
		boolean result = pr.updateProduct(product);
		
		
		//更新本地cart的折扣价
		HttpSession cartSession = request.getSession();
		Cart cart = (Cart)cartSession.getAttribute("cart");
		
		if (cart==null) {
			System.err.println("还未存在购物车！");
		}else {
			cart.getMap().get(product.getId()).getProduct().setDiscountprice(product.getDiscountprice());
			cart.getMap().get(product.getId()).setPrice(product.getDiscountprice());
			cartSession.setAttribute("cart", cart);
		}
		
		if (result) {
			request.setAttribute("product", product);
			request.getRequestDispatcher("editproduct.jsp").forward(request, response);
		}else {
			System.err.println("请求失败，请刷新重试！");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
