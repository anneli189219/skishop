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
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		
		ProductDaoImpl pr = new ProductDaoImpl();
		Product product = pr.selectProduct(id);
		
		HttpSession cartSession = request.getSession();
		
		//cartSession.setMaxInactiveInterval(5);
		
		Cart cart = (Cart)cartSession.getAttribute("cart");
		
		if (cart==null) {
			cart = new Cart();
			
		}
		
		cart.addItem(product);
		
		cartSession.setAttribute("cart", cart);
		
		request.getRequestDispatcher("ProductListServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
