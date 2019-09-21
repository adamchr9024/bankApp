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

import dao.checking.CheckingDao;
import dao.checking.CheckingDaoImpl;
import exception.BusinessException;
import oracle.sql.DATE;
import service.impl.CheckingServiceImpl;
import userdata.AccountHolder;

/**
 * Servlet implementation class SuccessLogin
 */
@WebServlet("/success")
public class SuccessLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuccessLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);///session should really start here
		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
		if (session == null) {
			pw.print("You must login to use this service");
			response.sendRedirect("/BankApp/login.html");
		}
		// RequestDispatcher rd=null;
		// rd = request.getRequestDispatcher("acct.html");
		// rd.include(request, response);
		AccountHolder accountholder = (AccountHolder) session.getAttribute("accountholder");
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<head>");
		pw.println("<title>");
		pw.println("Account Holder");
		pw.println("</title>");
		pw.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'>");
		pw.println("</head>");
		CheckingDaoImpl checking = new CheckingDaoImpl();
		double balance = 0.0;
		try {
			 balance = checking.getBalance(accountholder.getAcct().getAccountNo());
		} catch (BusinessException e) {
			request.getRequestDispatcher("login.html").include(request, response);
			pw.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
		
		}
		
		pw.print("<h2>Welcome " + accountholder.getFlname() + "</h2>"); //LocalDate.now()
		pw.print("<h4>You've logged in successfully at  " + new java.util.Date() + "</h4>");

		pw.print("<h4 id='bal'> Your Balance is " + String.format("$%.2f", balance) + "</h4>");
		
		  //double balance = csi.
		  
		//  pw.print("<form action = '/balance'>");
		//  pw.print("<br/> <input type = 'submit' value = 'Get Balance'>");
		  
		 // pw.print("</form>");
		
		pw.print("<script>");
		  pw.print("function preventBack(){window.history.forward();}");
		  pw.print(" setTimeout(preventBack(), 0);");
		  pw.print(" window.onunload=function(){null}");
		  pw.print("</script>");
		  
		  pw.print("<form action = 'deposit' method = 'post'> ");
		  pw.print("<br/> <input type = 'submit' value = 'Deposit'>");
		  pw.print("</form>");
		  
		  
		  //pw.print("</form>");
		  pw.print("<form action = 'withdrawal' method = 'post'>");
		  pw.print("<br/> <input type = 'submit' value = 'Withdrawal'>");
		  pw.print("</form>");
		  pw.print("<form action = 'transaction' method = 'post'>");
		  pw.print("<br/> <input type = 'submit' value = 'Show Transactions'>");
		 // pw.print("<br/><button onclick='update()' value='Update'>UpDate</button> ");
		  pw.print("</form>"); //pw.print("script scr = 'scripts/action.js'"); //add
		  //headers and fotters // + new
		  //SimpleDateFormat("dd.MMM.yyyy HH:mm:ss").format(new Date()) + "</h4>");
		  pw.print("<a href='/BankApp/logout'>LogOut</a>");
		//  pw.print("<script type='text/javascript' src = 'scripts/loginfetch.js'></script>");
		  pw.println("</body>");
          pw.println("</html>");
        
			
		 // pw.print();
		 

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
