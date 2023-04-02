/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import model.*;
import DAL.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author TM080522
 */
public class webCheckout extends HttpServlet {

	DAO dao;

	@Override
	public void init() {
		dao = new DAO();
	}

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		  throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try ( PrintWriter out = response.getWriter()) {
			HttpSession ses = request.getSession();
			boolean reload = false;
			if (ses.getAttribute("reload") != null) {
				reload = (boolean) ses.getAttribute("reload");
			}
			if (reload == true) {
			List<product> allproductlist = dao.getallProduct();
			List<category> categorylist = dao.getallCategory();
			List<collection> collectionlist = dao.getallCollection();
			List<account> accountlist = dao.getallAccount();
			ses.setAttribute("allproducts", allproductlist);
			ses.setAttribute("allcategories", categorylist);
			ses.setAttribute("allcollections", collectionlist);
			ses.setAttribute("accountlist", accountlist);
			ses.setAttribute("reload", false);
		}
		if (ses.getAttribute("allproducts") == null || ses.getAttribute("allcategories") == null || ses.getAttribute("allcollections") == null || ses.getAttribute("accountlist") == null) {
			List<product> allproducts = dao.getallProduct();
			List<category> allcategories = dao.getallCategory();
			List<collection> collectionlist = dao.getallCollection();
			List<account> accountlist =  dao.getallAccount();
			ses.setAttribute("allproducts", allproducts);
			ses.setAttribute("allcategories", allcategories);
			ses.setAttribute("allcollections", collectionlist);
			ses.setAttribute("accountlist", accountlist);
		}
			List<product> allproductlist = (ArrayList<product>) ses.getAttribute("allproducts");

			Cookie[] allCookies = request.getCookies();
			String cartString = "";
			if (allCookies != null) {
				for (Cookie cookie : allCookies) {
					if (cookie.getName().equals("cart")) {
						cartString += cookie.getValue();
					}
				}
			}
			cart Cart = (cart) ses.getAttribute("cart");
//		cart Cart = new cart(cartString, allproductlist);
			account customer = (account) ses.getAttribute("account");

			request.setAttribute("account", customer);
			request.setAttribute("cart", Cart);
			request.setAttribute("dao", dao);
			dao.addOrder(customer, Cart);
//			request.getRequestDispatcher("test.jsp").forward(request, response);

			Cookie c = new Cookie("cart", "");
			c.setMaxAge(0);
			response.addCookie(c);
			ses.removeAttribute("cart");
			response.sendRedirect("shop");
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		  throws ServletException, IOException {
		HttpSession ses = request.getSession();
		if (ses.getAttribute("account") == null) {
			response.sendRedirect("login");
		} else if (ses.getAttribute("cart") == null) {
			response.sendRedirect("home");
		} else {
			request.getRequestDispatcher("checkout.jsp").forward(request, response);
		}
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		  throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
