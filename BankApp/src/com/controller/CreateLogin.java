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

import exception.BusinessException;
import service.impl.CheckingServiceImpl;
import service.impl.UserDataServiceImpl;

/**
 * Servlet implementation class CreateLogin
 */
@WebServlet(name = "createlogin", urlPatterns = { "/createlogin" })
public class CreateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session=request.getSession();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username= request.getParameter("userName");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String flname = firstname + " "+lastname;
		//CheckingServiceImpl csi = new CheckingServiceImpl();
		UserDataServiceImpl udsi = new UserDataServiceImpl();
		RequestDispatcher rd = null;
		try {
		 //long acctNO =	csi.create("checking" , 0.0);
		  if (udsi.createUser(username, password, flname)) {
			  rd=request.getRequestDispatcher("createsuccess");
			  rd.forward(request, response);
		  }
		      
		  
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			rd=request.getRequestDispatcher("createLogin.html");
			rd.include(request, response);//
			out.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
		}
		 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
