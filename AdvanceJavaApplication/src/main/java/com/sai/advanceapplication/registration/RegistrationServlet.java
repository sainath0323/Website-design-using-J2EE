package com.sai.advanceapplication.registration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// getting the client data
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String email = request.getParameter("email");
		String country = request.getParameter("country");

		String qualification[] = request.getParameterValues("qualification");
		String gender = request.getParameter("gender");

		String technologies [] = request.getParameterValues("technologies");
		String address[] = request.getParameterValues("address");

		String comments = request.getParameter("comments");

		String finalQualification = String.join(",", qualification);
		String finalTechnologies = String.join(",", technologies);
		String finalAddress = String.join(",", address);

		//adding data into user object
		UserData user = new UserData(username, password, email, country, finalQualification, gender, finalTechnologies,finalAddress, comments);

		//getting response from DAO layer
		int result= UserDAO.saveData(user);
	
		//sending request to JSP file
		if(result==1) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("RegistrationSuccess.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher=request.getRequestDispatcher("RegistrationFailure.jsp");
			dispatcher.forward(request, response);
		}
	}
}