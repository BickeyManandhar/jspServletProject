package com.personal.project.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
		String password = request.getParameter("pass");
		String email= request.getParameter("email");
		String contact= request.getParameter("contact");
		
		Connection conn = null;

		try {
			// Step 1: Loading the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Creating connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspServletProject", "root", "Bickey@123");
			if(conn!=null) {
				System.out.println("Connection establised successfully with database.");
			}
			
			// Step 3: Creating statement where we pass our queries
			PreparedStatement ps = conn.prepareStatement("insert into registration values (?,?,?,?)");
			ps.setString(1, email); // (pointing 1st ? , value)
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, contact);


			// Step 4: Executing queries
			int modifiedRows = ps.executeUpdate();
			//System.out.println(modifiedRows);

			if (modifiedRows == 1) {
				System.out.println("Modification successful.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Step 5: Closing connection
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("regsuccess", "Successfully registered. Now you can login.");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
