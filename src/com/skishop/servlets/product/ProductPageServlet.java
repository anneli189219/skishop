package com.skishop.servlets.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skishop.dao.impl.ProductDaoImpl;
import com.skishop.entity.Page;
import com.skishop.entity.Product;

/**
 * Servlet implementation class ProductPageServlet
 */
@WebServlet("/ProductPageServlet")
public class ProductPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductPageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String number = request.getParameter("pageNum");
		int pageNum;

		if (number == null || number.equals(" ")) {
			pageNum = 1;
		} else {
			pageNum = Integer.valueOf(number);
		}
		

		ProductDaoImpl pd = new ProductDaoImpl();
		ArrayList<Product> products = pd.findProductByPage(pageNum, 4);
		int totalCount = pd.findCountProduct();

		Page<Product> page = new Page<Product>(pageNum, 4);
		page.setList(products);
		page.setTotalCount(totalCount);

		request.setAttribute("page", page);

		request.getRequestDispatcher("shoppage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
