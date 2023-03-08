package com.wapPractice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionDestroyServletForFactorial")
public class SessionDestroyServletForFactorial extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get session if any
		HttpSession existingSession = request.getSession(false);
		if (existingSession != null) {
			existingSession.invalidate();
		}
		request.setAttribute("firstpage", "You in now first page and previosu session has been destroyed.");
		request.getRequestDispatcher("factorial.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
