package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
//import transact.Transaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enumerations.EnumClass;
import exception.BusinessException;
import service.impl.CheckingServiceImpl;
import userdata.AccountHolder;

/**
 * Servlet implementation class Transaction
 */
@WebServlet("/transaction")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transaction() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String trantype(EnumClass.TransType t_type) {
    
	if (t_type == EnumClass.TransType.DEPOSIT)
		  return "Deposit";
	else 
		return "Withdrawal";
      
   }
    public String addStar(long accountNo) {
		StringBuilder holdstr = new StringBuilder("");
		String strAcc = ""+accountNo;
		for(int i = 0; i < strAcc.length(); i++) {
			if (i>9) {
				holdstr.append(strAcc.charAt(i));
				continue;
			}
			holdstr.append("*");
		}
		return holdstr.toString();
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
		//System.out.println("insde transaction service");
		
		ArrayList< transact.Transaction> tran = new ArrayList< transact.Transaction>();
		AccountHolder accountholder = (AccountHolder)session.getAttribute("accountholder");
		CheckingServiceImpl checkingservice = new CheckingServiceImpl();
		RequestDispatcher rd = null;	
		try {
		tran = checkingservice.getTransactions(accountholder.getAcct().getAccountNo());
		//System.out.println(tran);
		rd = request.getRequestDispatcher("success");
		rd.include(request, response);
		pw.write("<table class='table table-bordered'>");
		pw.write("<thead><tr><th>Date</th> <th>Transaction Number</th><th>Account Number</th> <th>Transaction Type</th>");
		pw.write("<th>Transaction Amount</th> <th>Updated Balance</th></tr></thead>");
	    int count = 0;
	    String bootclass = "";
		for(transact.Transaction trans: tran) {
			bootclass = count%2==0?"table-success":"table-secondary";
			pw.write("<tr class ="+ bootclass+">");
			
		    pw.write("<td class = ''>"+trans.getDateOf()+"</td>");
		    pw.write("<td class = ''>"+trans.getTransactionNo()+"</td>");
		    
		    pw.write("<td class = ''>"+addStar(trans.getAccountNo())+"</td>");
		    
		    pw.write("<td class = ''>"+trantype(trans.getT_type())+"</td>");
		    pw.write("<td class = ''>"+String.format("$%.2f",trans.getAmount())+"</td>");
		    pw.write("<td class = ''>"+String.format("$%.2f",trans.getNewbalance())+"</td>");
			pw.write("</tr>");
			count++;
			
		}
		pw.write("</table>");
	//	pw.write("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\'>");
    	
		}
    	catch (BusinessException  e) {
						
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
