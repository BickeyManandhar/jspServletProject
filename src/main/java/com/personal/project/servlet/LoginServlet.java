package com.personal.project.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Connection con=null;
		//RequestDispatcher rd=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jspServletProject","root","Bickey@123");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				PreparedStatement ps = con.prepareStatement("select * from registration where email=? and password=?");
				ps.setString(1, email);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("Hitting if statement");
					String uemail=rs.getString(1);
					String uname=rs.getString(2);
					String pass=rs.getString(3);
					String contactnum=rs.getString(4);
					
					/*
					 * System.out.println(rs.getInt("id") + "   " + rs.getString("name") + "   " +
					 * rs.getString("country") + "   " + rs.getString("email")); OR we can do
					 */
					request.setAttribute("username", uname);
					request.setAttribute("email", uemail);
					request.setAttribute("password", pass);
					request.setAttribute("contactnum", contactnum);
					request.getRequestDispatcher("congrats.jsp").forward(request, response);
					//rd = request.getRequestDispatcher("index.jsp");
					//rd.forward(request, response);
				}
				else {
					System.out.println("Hitting else statement");
					request.setAttribute("msg","Wrong email or password. Re-try...login again!!!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					//rd = request.getRequestDispatcher("login.jsp");
					//rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
