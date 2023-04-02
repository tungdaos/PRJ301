/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.*;
import model.category;

/**
 *
 * @author TM080522
 */
public class categoryManaging extends HttpServlet {

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
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet managecategory</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet managecategory at " + request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
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
		HttpSession ses = request.getSession();
		boolean reload = false;
		String delete = request.getParameter("delete");
		if (delete == null) {
			request.getRequestDispatcher("managecategory.jsp").forward(request, response);
		} else {
			String catID = request.getParameter("id");
			dao.deleteCategory(catID);
			ses.setAttribute("reload", true);
		}
		if (ses.getAttribute("reload") != null) {
			reload = (boolean) ses.getAttribute("reload");
		}
		if (reload == true) {
			List<category> allcategories = dao.getallCategory();
			ses.setAttribute("allcategories", allcategories);
			ses.setAttribute("reload", false);
		}
		if (ses.getAttribute("allcategories") == null) {
			List<category> allcategories = dao.getallCategory();
			ses.setAttribute("allcategories", allcategories);
		}
		request.getRequestDispatcher("managecategory.jsp").forward(request, response);
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
		dao = new DAO();
		dao.insertCategory(id, name, description);
		List<category> allcategories = dao.getallCategory();
		HttpSession ses = request.getSession();
		ses.setAttribute("allcategories", allcategories);
		doGet(request, response);
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
