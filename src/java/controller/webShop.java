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
public class webShop extends HttpServlet {

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
		response.setContentType("text/html;charset=UTF-8");

//load data using session start
		int startprice = 0;
		int endprice = -1;
		HttpSession ses = request.getSession();
		if (ses.getAttribute("startprice") != null && ses.getAttribute("endprice") != null) {
			startprice = (int) ses.getAttribute("startprice");
			endprice = (int) ses.getAttribute("endprice");
		}
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
		List<category> categorylist = (ArrayList<category>) ses.getAttribute("allcategories");
//load data using session end	

//load product by attributes start
		//load product by collection start
		List<product> Colproductlist = new ArrayList<>();
		String colid = request.getParameter("colid");
		if (colid != null) {
			for (product product : allproductlist) {
				if (product.getCollectionid().equalsIgnoreCase(colid)) {
					Colproductlist.add(product);
				}
			}
		} else {
			Colproductlist = allproductlist;
		}
		//load product by collection end
		//load product by category start	
		List<product> Catproductlist = new ArrayList<>();
		String catid = request.getParameter("catid");
		if (catid != null) {
			for (product product : Colproductlist) {
				if (product.getCatid().equalsIgnoreCase(catid)) {
					Catproductlist.add(product);
				}
			}
		} else {
			Catproductlist = Colproductlist;
		}
		//load product by category end
		//load product by searching start
		String searchString = request.getParameter("searchstring");
		List<product> searchlist = new ArrayList<>();
		if (searchString != null) {
			for (product product : Catproductlist) {
				if (product.getProductname().toLowerCase().trim().contains(searchString.toLowerCase().trim())) {
					searchlist.add(product);
				}
			}
			if (searchlist.isEmpty()) {
				request.setAttribute("alert", "no item was found!");
			}
		} else {
			searchlist = Catproductlist;
		}
		//load product by searching end
//load product by attributes end

//filter start	
		if (ses.getAttribute("colid") == null || !(((String) ses.getAttribute("colid")).equalsIgnoreCase(colid))) {
			ses.setAttribute("colid", colid);
		}
		if (ses.getAttribute("catid") == null || !(((String) ses.getAttribute("catid")).equals(catid))) {
			ses.setAttribute("catid", catid);
		}
		if (ses.getAttribute("searchstring") == null || !((String) ses.getAttribute("searchstring")).equals(searchString)) {
			ses.setAttribute("searchstring", searchString);
		}
		List<product> filteredproductlist = new ArrayList<>();
		if (startprice <= endprice) {
			for (product product : searchlist) {
				if (startprice <= product.getDiscountprice() && product.getDiscountprice() <= endprice) {
					filteredproductlist.add(product);
				}
			}
			if (searchlist.isEmpty()) {
				request.setAttribute("alert", "no item matches price range!");
			}
		} else {
			filteredproductlist = searchlist;
		}
//filter end

//sort product start
		sort(request, filteredproductlist);
//sort product end

//paging start
		int currentpage, begin, end, nrpp = 8, size = filteredproductlist.size();
		int numberofpage = (size % nrpp == 0) ? (size / nrpp) : (size / nrpp + 1);
		
		String clickedpage = request.getParameter("page");
		if (clickedpage == null) {
			currentpage = 1;
		} else {
			try {
				currentpage = Integer.parseInt(clickedpage);
				if(currentpage > numberofpage || currentpage < 0){
					currentpage = 1;
				}
			} catch (NumberFormatException e) {
				currentpage = 1;
			}			
		}
		begin = (currentpage - 1) * nrpp;
		end = (currentpage * nrpp) < size ? (currentpage * nrpp) : size;
		List<product> finalproductlist = getProductsInPage(filteredproductlist, begin, end);
//paging end

		ses.setAttribute("finalproductlist", finalproductlist);
		ses.setAttribute("categorylist", categorylist);
		ses.setAttribute("page", currentpage);
		ses.setAttribute("numberofpage", numberofpage);
		request.setAttribute("finalproductlist", finalproductlist);
		request.setAttribute("categorylist", categorylist);
		request.setAttribute("page", currentpage);
		request.setAttribute("numberofpage", numberofpage);
		request.getRequestDispatcher("shop.jsp").forward(request, response);
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
		String start = request.getParameter("startprice");
		String end = request.getParameter("endprice");
		int startprice;
		int endprice;
		try {
			startprice = Integer.parseInt(start);
			endprice = Integer.parseInt(end);
		} catch (NumberFormatException e) {
			startprice = 0;
			endprice = 2000000000;
		}

		HttpSession ses = request.getSession();
		ses.setAttribute("startprice", startprice);
		ses.setAttribute("endprice", endprice);
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

	public List<product> getProductsInPage(List<product> list, int begin, int end) {
		ArrayList<product> page = new ArrayList<>();
		for (int i = begin; i < end; i++) {
			page.add(list.get(i));
		}
		return page;
	}

	public void sort(HttpServletRequest request, List<product> filteredproductlist) {
		int order;
		HttpSession ses = request.getSession();
		try {
			if ( ses.getAttribute("order") == null || ((int)ses.getAttribute("order")) != Integer.parseInt(request.getParameter("order")) ) {
				order = Integer.parseInt(request.getParameter("order"));
				ses.setAttribute("order", order);
			} else{
				order = (int)ses.getAttribute("order");
			}
			switch (order) {
				case 1:
					Collections.sort(filteredproductlist, (product p1, product p2) -> p1.getCreateid() > p2.getCreateid() ? -1 : 1);
					break;
				case 2:
					Collections.sort(filteredproductlist, (product p1, product p2) -> p1.getCreateid() < p2.getCreateid() ? -1 : 1);
					break;
				case 3:
					Collections.sort(filteredproductlist, (product p1, product p2) -> p1.getDiscountprice() < p2.getDiscountprice() ? -1 : 1);
					break;
				case 4:
					Collections.sort(filteredproductlist, (product p1, product p2) -> p1.getDiscountprice() > p2.getDiscountprice() ? -1 : 1);
					break;
				default:
					break;
			}
		} catch (NumberFormatException e) {
		}
	}

	public void getses() {

	}
}
