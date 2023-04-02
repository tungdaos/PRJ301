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
import DAL.*;
import jakarta.servlet.http.HttpSession;
import java.util.*;
import model.*;

/**
 *
 * @author TM080522
 */
public class accountLog extends HttpServlet {

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
			out.println("<title>Servlet login</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
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
		if (ses.getAttribute("account") != null) {
			ses.removeAttribute("account");
			response.sendRedirect("home");
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
		HttpSession ses = request.getSession();
		boolean reload = false;
		if (ses.getAttribute("reload") != null) {
			reload = (boolean) ses.getAttribute("reload");
		}
		if (reload == true) {
			List<account> accountlist = dao.getallAccount();
			ses.setAttribute("accountlist", accountlist);
			ses.setAttribute("reload", false);
		}
		if (ses.getAttribute("accountlist") == null) {
			List<account> accountlist = dao.getallAccount();
			ses.setAttribute("accountlist", accountlist);
		}
		String inputemail = request.getParameter("email").trim();
		String inputpassword = request.getParameter("password").trim();
		List<account> allaccount = (ArrayList<account>) ses.getAttribute("accountlist");
		for (account acc : allaccount) {
			if (acc.getEmail().equals(inputemail) && acc.getPassword().equals(inputpassword)) {
				ses.setAttribute("account", acc);
			}
		}
		if (ses.getAttribute("account") != null) {
			response.sendRedirect("home");
		} else {
			request.setAttribute("alert", "*User not found, check your inputs again");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
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
