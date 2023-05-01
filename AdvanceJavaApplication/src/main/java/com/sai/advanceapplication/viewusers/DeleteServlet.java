package com.sai.advanceapplication.viewusers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sai.advanceapplication.registration.UserDAO;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		        //getting client data
		        String user = request.getParameter("user");
				String email = request.getParameter("email");
				int  res=UserDAO.deleteUser(user, email);
				System.out.println(res);
				if(res>0) {
					RequestDispatcher dispatcher=request.getRequestDispatcher("ViewServlet");
					dispatcher.forward(request, response);
				}
		
	}
}