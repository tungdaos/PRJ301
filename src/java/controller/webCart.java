/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.*;
import model.*;

/**
 *
 * @author TM080522
 */
public class webCart extends HttpServlet {

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
		cart Cart = new cart(cartString, allproductlist);
		request.setAttribute("cart", Cart);
		ses.setAttribute("cart", Cart);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
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
		HttpSession ses = request.getSession();
		boolean reload = false;
		if (ses.getAttribute("reload") != null) {
			reload = (boolean) ses.getAttribute("reload");
		}
		if (reload == true) {
			List<product> allproductlist = dao.getallProduct();
			List<account> accountlist = dao.getallAccount();
			ses.setAttribute("allproducts", allproductlist);
			ses.setAttribute("accountlist", accountlist);
			ses.setAttribute("reload", false);
		}
		if (ses.getAttribute("allproducts") == null || ses.getAttribute("accountlist") == null) {
			List<product> allproducts = dao.getallProduct();
			List<account> accountlist = dao.getallAccount();
			ses.setAttribute("allproducts", allproducts);
			ses.setAttribute("accountlist", accountlist);
		}
		List<product> allproductlist = (ArrayList<product>) ses.getAttribute("allproducts");
		Cookie[] allCookies = request.getCookies();
		String cartString = "";
		if (allCookies != null) {
			for (Cookie cookie : allCookies) {
				if (cookie.getName().equals("cart")) {
					cartString += cookie.getValue();
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		String id = request.getParameter("productid");
		String quantity = request.getParameter("quantity");
		if (cartString.isEmpty()) {
			cartString = id + ":" + quantity;
		} else {
			cartString = cartString + "/" + id + ":" + quantity;
		}
		Cookie c = new Cookie("cart", cartString);
		c.setMaxAge(3600 * 24 * 30);
		response.addCookie(c);
		response.sendRedirect("shop");
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
