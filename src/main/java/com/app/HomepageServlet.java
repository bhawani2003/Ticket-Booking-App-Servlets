package com.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/homepage")
public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String url = "jdbc:mysql://localhost:3306/";
	String db_username = "root";
	String db_password = "";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isAuthenticated = false;
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("user".equals(cookie.getName())) {
					isAuthenticated = true;
					break;
				}
			}
		}

		if (!isAuthenticated) {
			response.getWriter().println("Not authenticated");
			response.sendRedirect("index.jsp");
			return;
		}

		ArrayList<Movie> movieList = new ArrayList<Movie>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, db_username, db_password);
			PreparedStatement ps = con.prepareStatement("select * from Movies");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String movieUrl = rs.getString("movieUrl");
				String movieName = rs.getString("movieName");
				String movieRating = rs.getString("movieRating");
				String releaseYear = rs.getString("releaseYear");
				double duration = rs.getDouble("duration");

				movieList.add(new Movie(movieUrl, movieName, movieRating, releaseYear, duration));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("movieList", movieList);
		request.getRequestDispatcher("homepage.jsp").forward(request, response);
	}
}
