package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.impl.CheckingServiceImpl;
import userdata.AccountHolder;

/**
 * Servlet implementation class Deposit
 */
@WebServlet("/deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
    	response.setContentType("text/html");
    	
		PrintWriter pw = response.getWriter();
		if(session == null) {  //check for the user name per https://www.journaldev.com/1907/java-session-management-servlet-httpsession-url-rewriting
    		pw.print("You must login to use this service");
    		response.sendRedirect("/BankApp/login.html");
    	}
    	RequestDispatcher rd = null;	
    	rd = request.getRequestDispatcher("acct.html");
    	rd.forward(request, response);
    	//AccountHolder accountholder = (AccountHolder) session.getAttribute("accountholder");
    	//long acctNo = accountholder.
		/*
		 * pw.
		 * print("<form action = 'makedeposit' method = 'post' onsubmit = 'return validate()'>"
		 * ); pw.print("<h4>Enter Deposit Amount </h4>");
		 * pw.print("<span id='msg' style='color: red;'></span><br/> ");
		 * pw.print("<input type = 'number' id='num' /> </br>");
		 * pw.print("<input type = 'submit' value = 'Make Deposit' />");
		 * pw.print("<script type='text/javascript' src='scripts/deposit.js'></script>"
		 * ); pw.print("</form>");
		 */
		//CheckingServiceImpl csi = new CheckingServiceImpl();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
