package com.demo.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.Account;
import com.demo.service.AccountServiceLocal;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    AccountServiceLocal accountService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id = 0; 
			if(request.getParameter("id").isEmpty()) {
				response.sendRedirect(request.getContextPath() + "/ListAccount");
			}
			id = Integer.parseInt(request.getParameter("id"));
			Account acc = accountService.getAccount(id);
			if(acc==null) {
				response.sendRedirect(request.getContextPath() + "/ListAccount");
			}
			request.setAttribute("account", acc );
			 RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Update.jsp");
		      dispatcher.forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect(request.getContextPath() + "/ListAccount");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String username = (String) request.getParameter("username");
			String password =(String) request.getParameter("password");
			String email =(String) request.getParameter("email");
			String phone = (String)request.getParameter("phone");
			String address =(String) request.getParameter("address");
			Account acc = new Account(id,username,password,email,phone,address);
			accountService.updateAccount(acc);
			response.sendRedirect(request.getContextPath() + "/ListAccount");
		}catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect(request.getContextPath() + "/ListAccount");
		}
		
	}

}
