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
import DAL.DAO;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.product;

/**
 *
 * @author TM080522
 */
public class productUpdate extends HttpServlet {

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
			/* TODO output your page here. You may use following sample code. */

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
		//processRequest(request, response);
		String productID = request.getParameter("id");
		HttpSession ses = request.getSession();
		List<product> allproductlist = (ArrayList<product>) ses.getAttribute("allproducts");
		for (product p : allproductlist) {
			if (productID.equals(p.getProductid())) {
				request.setAttribute("id", p.getProductid());
				request.setAttribute("name", p.getProductname());
				request.setAttribute("description", p.getDescription());
				request.setAttribute("size", p.getSize());
				request.setAttribute("price", p.getPrice());
				request.setAttribute("stock", p.getStock());
				request.setAttribute("image", p.getImage());
				request.setAttribute("category", p.getCatid());
				request.setAttribute("collection", p.getCollectionid());
				break;
			}
		}
		request.getRequestDispatcher("manageupdateproduct.jsp").forward(request, response);
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
		//processRequest(request, response);
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String size = request.getParameter("size");
		int price = Integer.parseInt(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		String image = request.getParameter("image");
		String category = request.getParameter("category");
		String collection = request.getParameter("collection");
		dao = new DAO();
		dao.updateProduct(id, name, description, size, price, stock, image, category, collection);
		HttpSession ses = request.getSession();
		ses.setAttribute("reload", true);
		response.sendRedirect("manageproduct");
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
