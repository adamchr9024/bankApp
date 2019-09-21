package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.BusinessException;
import service.impl.CheckingServiceImpl;
import userdata.AccountHolder;

/**
 * Servlet implementation class MakeDeposit
 */
@WebServlet("/makedeposit")
public class MakeDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeDeposit() {
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
		double amount = Double.parseDouble((request.getParameter("amount")));
		//System.out.println("amount = "+amount);
		
		AccountHolder accountholder = (AccountHolder)session.getAttribute("accountholder");
		//System.out.println("account number = "+accountholder.getAcct().getAccountNo());
		
		//push to database
		RequestDispatcher rd = null;
		CheckingServiceImpl checkingservice = new CheckingServiceImpl();
		try {
			long updated = checkingservice.deposit(accountholder.getAcct().getAccountNo(), amount);
			rd=request.getRequestDispatcher("success");
			rd.include(request, response);
			if (updated > 0) {
				pw.print("<center><span style='color:green;'>Deposit Successful</span></center>");
			}
			else
				pw.print("<center><span style='color:red;'>Service is not available..Check database and internet service</span></center>");
		} catch (ClassNotFoundException | BusinessException | SQLException e) {
			// TODO Auto-generated catch block
			rd=request.getRequestDispatcher("success");
			rd.include(request, response);//
			pw.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
