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
import model.*;

/**
 *
 * @author TM080522
 */
public class collectionManaging extends HttpServlet {

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
			out.println("<title>Servlet managecollection</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet managecollection at " + request.getContextPath() + "</h1>");
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
			request.getRequestDispatcher("managecollection.jsp").forward(request, response);
		} else {
			String colID = request.getParameter("id");
			dao.removeCollection(colID);
			dao.deleteCollection(colID);
			ses.setAttribute("reload", true);
		}
		if (ses.getAttribute("reload") != null) {
			reload = (boolean) ses.getAttribute("reload");
		}
		if (reload == true) {
			List<collection> allcollections = dao.getallCollection();
			ses.setAttribute("allcollections", allcollections);
		}
		if (ses.getAttribute("allcollections") == null) {
			List<collection> allcollections = dao.getallCollection();
			ses.setAttribute("allcollections", allcollections);
		}
		request.getRequestDispatcher("managecollection.jsp").forward(request, response);
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
		int discount = Integer.parseInt(request.getParameter("discount"));
		String image = request.getParameter("image");

		dao = new DAO();
		dao.insertCollection(id, name, discount, image);
		List<collection> allcollections = dao.getallCollection();
		HttpSession ses = request.getSession();
		ses.setAttribute("allcollections", allcollections);
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
