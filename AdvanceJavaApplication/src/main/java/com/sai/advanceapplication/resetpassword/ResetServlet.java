package com.sai.advanceapplication.resetpassword;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sai.advanceapplication.registration.UserDAO;

@WebServlet("/ResetServlet")
public class ResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//getting client data
	String email=	request.getParameter("email");
	String newPassword=	request.getParameter("newpassword");
	String confPassword=	request.getParameter("confpassword");
	
   //
	if(newPassword.equals(confPassword)) {
		ResetPassword details=new ResetPassword(email, confPassword);
		int res= UserDAO.updateData(details);
		if(res==1) {
		RequestDispatcher dispatcher=request.getRequestDispatcher("ResetSuccess.jsp");
		dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher=request.getRequestDispatcher("ResetFail.jsp");
			dispatcher.forward(request, response);
		}
	}
	else {
		RequestDispatcher dispatcher=request.getRequestDispatcher("PassFail.jsp");
		dispatcher.forward(request, response);
	}
	
	}
}