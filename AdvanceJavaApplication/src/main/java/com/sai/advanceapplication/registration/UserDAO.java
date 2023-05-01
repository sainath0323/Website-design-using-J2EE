package com.sai.advanceapplication.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sai.advanceapplication.resetpassword.ResetPassword;

public class UserDAO {

	public static int saveData(UserData user) {

		int result = 0;
		try {
			Connection connection = TestConnection.createConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into user_details values(?,?,?,?,?,?,?,?,?)");

			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getCountry());
			preparedStatement.setString(5, user.getQualification());
			preparedStatement.setString(6, user.getGender());
			preparedStatement.setString(7, user.getTechnologies());
			preparedStatement.setString(8, user.getAddress());
			preparedStatement.setString(9, user.getComments());
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static int updateData(ResetPassword details) {
		int res = 0;
		try {
			Connection connection = TestConnection.createConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("update user_details set password=? where email=?");
			preparedStatement.setString(1, details.getPassword());
			preparedStatement.setString(2, details.getEmail());
			res = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static boolean checkLogin(String email, String password) {
		boolean result = false;
		try {
			Connection connection = TestConnection.createConnection();
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery("select password from user_details where email='" + email + "' and password='" + password + "'");
			if (set.next()) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static int deleteUser(String user, String email) {
		int res=0;
		try {
			Connection connection = TestConnection.createConnection();
			Statement statement = connection.createStatement();
			res=statement.executeUpdate("delete from user_details where username='"+user+"' and email='"+email+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	public static ResultSet listOfUser() {
		ResultSet set=null;
		Connection connection = TestConnection.createConnection();
		try {
			Statement statement = connection.createStatement();
		    set =	 statement.executeQuery("select username,email,country,qualification,gender,address from user_details");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return set;
	}

}