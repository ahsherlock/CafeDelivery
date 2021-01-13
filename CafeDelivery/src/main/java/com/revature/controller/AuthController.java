package com.revature.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pojo.Customer;

public class AuthController {
	// Needs Service
	public static void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		if (req.getMethod().equals("POST")) {

			Customer c = null;

			String username = req.getParameter("username");

			// To be implemented in the Service layer
//			c = cService.getUserById(username);

			if (req.getParameter("username").equals(c.getUsername())) {
				if (req.getParameter("password").equals(c.getPassword())) {

					HttpSession sesh = req.getSession();
					sesh.setAttribute("Customer", true);
					sesh.setAttribute("FirstName", c.getFirstName());
					sesh.setAttribute("LastName", c.getLastName());
					sesh.setAttribute("Username", c.getUsername());

					//
					resp.sendRedirect("http://localhost:8080/P1/api/home");
				} else {
					resp.setStatus(403);
					// Send to Error page?
//					resp.sendRedirect("http://localhost:8080/PlanetAPI/api/landing");

				}

			} else {
				System.out.println("Invalid Email");
				// invalid credentials
				resp.setStatus(403);
//				resp.sendRedirect("http://localhost:8080/PlanetAPI/api/landing");
				req.setAttribute("errorMessage", "User Does Not Exist");
			}

		} else {

			// invalidate method
			resp.setStatus(405);
			resp.sendRedirect("http://localhost:8080/PlanetAPI/api/landing");
		}

	}

	public static void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// Our logout method invalidates the session and redirects back to the home
		// controller

//		log.setLevel(Level.ALL);
//		log.info("User: " + req.getSession().getAttribute("FirstName") + " " + req.getSession().getAttribute("LastName")
//				+ ", " + req.getSession().getAttribute("Email") + " has logged out.");

		req.getSession().invalidate();

		resp.sendRedirect("http://localhost:8080/CafeDelivery/api/main");
	}

	public static void getMainPage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		RequestDispatcher redis = req.getRequestDispatcher("/index.html");

		redis.forward(req, resp);

	}
}
