package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userdata.AccountHolder;
import service.impl.UserDataServiceImpl;

import exception.BusinessException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	AccountHolder accountholder = new AccountHolder();
    	
		//System.out.println("COntroller");
		accountholder.setUsername(request.getParameter("userName"));
		//System.out.println();
		accountholder.setPasswd(request.getParameter("password"));
		//session.setAttribute("accountHolder",accountholder);
		UserDataServiceImpl service=new UserDataServiceImpl();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=null;
		try {
			accountholder = service.find(accountholder.getUsername(), accountholder.getPasswd());
				
			  // https://www.youtube.com/watch?v=5J1LLfkkuvo
			  //success - forward
			   // Gson gson = new Gson();
			   // out.print(gson.toJson());
			if (accountholder != null) {///	System.out.println("If");
				HttpSession session=request.getSession();
				session.setAttribute("accountholder",accountholder);
				rd=request.getRequestDispatcher("success");
				rd.include(request,response);
				
				//rd.forward(request, response);
			}//out.print("<center><span style='color:red;'></span></center>");
			
		} catch (BusinessException e) {
			//failure - include
			//System.out.println("catch");
			rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);//
			out.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
			
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
