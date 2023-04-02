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
import Util.sendCode;
import jakarta.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import model.*;

/**
 *
 * @author TM080522
 */
public class accountSignup extends HttpServlet {

    DAO dao;
    public static String registerCode;

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
            out.println("<title>Servlet signup</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet signup at " + request.getContextPath() + "</h1>");
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
        }
        request.getRequestDispatcher("signup.jsp").forward(request, response);

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
        try {
            //processRequest(request, response);
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

            String username = request.getParameter("username");
            String email = request.getParameter("email").trim();
            String password = request.getParameter("password").trim();
            String confirmpassword = request.getParameter("confirmpassword").trim();
            String quiz = request.getParameter("quiz");
            String answer = request.getParameter("answer").trim();
            if (username.trim().length() < 1) {
                request.setAttribute("alert", "*Username must not be empty");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
            if (!email.matches("^[a-zA-Z]\\w*@(\\w+[.])+\\w+$")) {
                request.setAttribute("alert", "*Wrong email");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
            if (password.trim().length() < 1) {
                request.setAttribute("alert", "*Password must not be empty");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
            if (!confirmpassword.equals(password)) {
                request.setAttribute("alert", "*Password and Confirm field do not match");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }

            List<account> allaccount = (ArrayList<account>) ses.getAttribute("accountlist");
            for (account acc : allaccount) {
                if (email.trim().equals(acc.getEmail())) {
                    request.setAttribute("alert", "*This email has already registered");
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
                }
            }
            
            
            request.getSession().setAttribute("email", email);
            dao.insertAccount(username, email, password, quiz, answer);
            ses.setAttribute("reload", true);
            ses.setAttribute("account", new account(email, username, password, false, null, null, null, null, quiz, answer));
            sendCode c = new sendCode();
            registerCode = c.generateCode();
            c.sendMail(registerCode, email);

        } catch (MessagingException ex) {
            Logger.getLogger(accountSignup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(accountSignup.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getSession().setAttribute("codePass", registerCode);
        response.sendRedirect("registerCode.jsp");

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
