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
public class accountProfile extends HttpServlet {

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
			out.println("<title>Servlet profile</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Profile</h1>");
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
		HttpSession ses = request.getSession();
		if (ses.getAttribute("account") == null) {
			response.sendRedirect("login");
		} else {
			request.getRequestDispatcher("profile.jsp").forward(request, response);
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
		//processRequest(request, response);
		HttpSession ses = request.getSession();
		boolean reload = true;
		String email = ((account) ses.getAttribute("account")).getEmail();
		String name = request.getParameter("username");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String district = request.getParameter("district");
		String address = request.getParameter("address");
		if (!phone.trim().matches("^0\\d{9}$")) {
			request.setAttribute("alert", "phone number invalid");
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		}
		dao.updateAccount(email, name, phone, city, district, address);
		List<account> accountlist = dao.getallAccount();
		for (account acc : accountlist) {
			if (acc.getEmail().equals(email)) {
				ses.setAttribute("account", acc);
				break;
			}
		}
		ses.setAttribute("reload", true);
		request.getRequestDispatcher("profile.jsp").forward(request, response);
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
