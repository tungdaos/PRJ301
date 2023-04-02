/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.*;
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
public class webHome extends HttpServlet {

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

        HttpSession ses = request.getSession();
        boolean reload = true;
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
            List<account> accountlist = dao.getallAccount();
            ses.setAttribute("allproducts", allproducts);
            ses.setAttribute("allcategories", allcategories);
            ses.setAttribute("allcollections", collectionlist);
            ses.setAttribute("accountlist", accountlist);
        }
        //Exess attributes from category and Search
        ses.removeAttribute("catid");
        ses.removeAttribute("searchstring");
        ses.removeAttribute("colid");
        ses.removeAttribute("startprice");
        ses.removeAttribute("endprice");
        ses.removeAttribute("order");
        //

        //product table
        List<product> allproductlist = (ArrayList<product>) ses.getAttribute("allproducts");
        Collections.shuffle(allproductlist);
        List<product> productlist = new ArrayList<>();
        for (int i = 0; i < productlist.size(); i++) {
            productlist.add(allproductlist.get(i));
        }
        for (product object : productlist) {
            System.out.println(object);
        }
        //category bar
        List<category> categorylist = (ArrayList<category>) ses.getAttribute("allcategories");

        //product vendor
        List<product> latestlist = new ArrayList<>();
        Collections.sort(allproductlist, new Comparator<product>() {
            @Override
            public int compare(product p1, product p2) {
                return p1.getCreateid() > p2.getCreateid() ? -1 : 1;
            }
        });
        for (int i = 0; i < latestlist.size(); i++) {
            latestlist.add(allproductlist.get(i));
        }

        request.setAttribute("categorylist", categorylist);
        request.setAttribute("productlist", productlist);
        request.setAttribute("latestlist", latestlist);

        ses.setAttribute("categorylist", categorylist);
        ses.setAttribute("latestlist", latestlist);
        ses.setAttribute("homeproductlist", productlist);
        ses.setMaxInactiveInterval(9999);
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
        processRequest(request, response);
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
