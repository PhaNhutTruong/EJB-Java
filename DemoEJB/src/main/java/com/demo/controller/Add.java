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
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    AccountServiceLocal accountService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Add.jsp");
	     dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = (String) request.getParameter("username");
		String password =(String) request.getParameter("password");
		String email =(String) request.getParameter("email");
		String phone = (String)request.getParameter("phone");
		String address =(String) request.getParameter("address");
		Account acc = new Account(accountService.getListAccount().size()+2,username,password,email,phone,address);
		accountService.addAccount(acc);
		response.sendRedirect(request.getContextPath() + "/ListAccount");
	}

}
