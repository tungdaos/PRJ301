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
import jakarta.servlet.http.HttpSession;
import DAL.*;
import java.util.*;
import model.*;

/**
 *
 * @author TM080522
 */
public class accountForgetpass extends HttpServlet {

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
			out.println("<title>Servlet forgetpass</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet forgetpass at " + request.getContextPath() + "</h1>");
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
			request.getRequestDispatcher("forgetpass.jsp").forward(request, response);
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
		List<account> accountlist = (List<account>) ses.getAttribute("accountlist");
		String email = request.getParameter("email");
		account accounttocheck = new account();
		for (account account : accountlist) {
			if (email != null && email.equals(account.getEmail())) {
				ses.setAttribute("filledemail", account.getEmail());
				request.setAttribute("filledemail", account.getEmail());
				request.setAttribute("ask", account.getSecurityquiz());
				request.setAttribute("ans", account.getSecurityanswer());
				accounttocheck = account;
				ses.setAttribute("accounttocheck", accounttocheck);
				request.getRequestDispatcher("forgetpass.jsp").forward(request, response);
			}
		}
		account acc = (account)ses.getAttribute("accounttocheck");
		if ((acc == null) || (email != null && !email.equals(acc.getEmail()))) {
			request.setAttribute("alert", "no such email found, contact admin for info");
			request.getRequestDispatcher("forgetpass.jsp").forward(request, response);
		}
		if (email == null && request.getParameter("answer") != null && acc.getSecurityanswer().equalsIgnoreCase(request.getParameter("answer").trim())) {
			request.setAttribute("pass", "pass");
			request.getRequestDispatcher("forgetpass.jsp").forward(request, response);
		} else if (email == null && request.getParameter("answer") != null && !acc.getSecurityanswer().equalsIgnoreCase(request.getParameter("answer").trim())) {
			request.setAttribute("alert", "wrong answer, contact admin for info");
			request.getRequestDispatcher("forgetpass.jsp").forward(request, response);
		}

		if (email == null && request.getParameter("answer") == null) {
			String password = request.getParameter("password").trim();
			String confirmpassword = request.getParameter("confirmpassword").trim();
			if (password.trim().length() < 1) {
				request.setAttribute("alert", "*Password must not be empty");
				request.getRequestDispatcher("forgetpass.jsp").forward(request, response);
			}
			if (!confirmpassword.equals(password)) {
				request.setAttribute("alert", "*Password and Confirm field do not match");
				request.getRequestDispatcher("forgetpass.jsp").forward(request, response);
			} else {
				dao.updatepassword((String) ses.getAttribute("filledemail"), password);
				ses.setAttribute("accountlist", dao.getallAccount());
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		//processRequest(request, response);
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
