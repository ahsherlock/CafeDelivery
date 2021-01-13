package com.revature.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthController {
	// Needs Service
	public static void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		if (req.getMethod().equals("POST")) {

//			Employee e = null;

			String email = req.getParameter("email");

//			e = eService.getUserByEmail(email);
//			System.out.println("This is printing out e: " + e);

			if (req.getParameter("email").equals(e.getEmail())) {

				if (req.getParameter("password").equals(e.getPassword())) {
					// if username matches the masterUsere we will define a session
					if (e.getIsFM() == true) {
						System.out.println("Logging in as FM");
						HttpSession sesh = req.getSession();
						sesh.setAttribute("MasterAccess", true);
						sesh.setAttribute("Client", false);
						sesh.setAttribute("currentId", e.getEId());
						sesh.setAttribute("FirstName", e.getFirstName());
						sesh.setAttribute("LastName", e.getLastName());
						sesh.setAttribute("Email", e.getEmail());
						resp.sendRedirect("http://localhost:8080/P1/api/home");

//						log.setLevel(Level.ALL);
//						log.info("User: " + e.getFirstName() + " " + e.getLastName() + ", " + e.getEmail()
//								+ " has logged in.");

					} else {
						System.out.println("Logging in as Client");
						HttpSession sesh = req.getSession();
						sesh.setAttribute("Client", true);
						sesh.setAttribute("MasterAccess", false);
						sesh.setAttribute("currentId", e.getEId());
						sesh.setAttribute("FirstName", e.getFirstName());
						sesh.setAttribute("LastName", e.getLastName());
						sesh.setAttribute("Email", e.getEmail());
						resp.sendRedirect("http://localhost:8080/P1/api/home");

//						log.setLevel(Level.ALL);
//						log.info("User: " + e.getFirstName() + " " + e.getLastName() + ", " + e.getEmail()
//								+ " has logged in.");
					}
				} else {
					resp.setStatus(403);
//					resp.sendRedirect("http://localhost:8080/PlanetAPI/api/landing");
//					req.setAttribute("errorMessage", "Invalid Password");
//					req.getRequestDispatcher("/order.jsp").forward(req, resp);
				}

			} else {
				System.out.println("Invalid Email");
				// invalid credentials
				resp.setStatus(403);
//				resp.sendRedirect("http://localhost:8080/PlanetAPI/api/landing");
				req.setAttribute("errorMessage", "User Does Not Exist");
			}

		} else {

			// invalide method
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

		resp.sendRedirect("http://localhost:8080/P1/api/landing");
	}

	public static void getLandingPage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		RequestDispatcher redis = req.getRequestDispatcher("/index.html");

		redis.forward(req, resp);

	}
}
