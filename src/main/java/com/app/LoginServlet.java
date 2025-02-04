package com.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String url = "jdbc:mysql://localhost:3306/TicketApp";
	String db_username = "root";
	String db_password = "";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection con = DriverManager.getConnection(url, db_username, db_password);
					PreparedStatement ps = con.prepareStatement("select * from Users where userPhone = ? and userPassword = ?")) {

				ps.setString(1, phone);
				ps.setString(2, password);

				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					Cookie loginCookie = new Cookie("user", phone);
					loginCookie.setMaxAge(90);
					response.addCookie(loginCookie);
					
					response.sendRedirect("homepage");
				} else {
					response.sendRedirect("index.jsp");
				}
			}

		} catch (Exception e) {
			response.sendRedirect("index.jsp");
		}
		
	}
}
