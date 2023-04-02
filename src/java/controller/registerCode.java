/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.DAO;
import Util.sendCode;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author FPTShop
 */
public class registerCode extends HttpServlet {
    
    public static String registerCode;

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
            out.println("<title>Servlet registerCode</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registerCode at " + request.getContextPath() + "</h1>");
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
//       try {
//           String email = request.getParameter("email");
//           sendCode c = new sendCode();
//           registerCode = c.generateCode();
//           c.sendMail(registerCode, email);
//       } catch (MessagingException ex) {
//           Logger.getLogger(registerCode.class.getName()).log(Level.SEVERE, null, ex);
//       } catch (UnsupportedEncodingException ex) {
//           Logger.getLogger(registerCode.class.getName()).log(Level.SEVERE, null, ex);
//       }
//        String email = (String) request.getParameter("email");
//        sendCode c = new sendCode();
//        registerCode = c.generateCode();
//        request.setAttribute("email", email);
//        request.getRequestDispatcher("registerCode.jsp").forward(request, response);
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
//        processRequest(request, response);
        DAO d = new DAO();
        String code = request.getParameter("code");
        String codePass = (String) request.getSession().getAttribute("codePass");
        String email = (String) request.getSession().getAttribute("email");
        if (code.equalsIgnoreCase(codePass)) {
            d.updateStatus(email);
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
