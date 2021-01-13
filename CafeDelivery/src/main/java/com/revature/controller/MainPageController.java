package com.revature.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainPageController {
	public static void getHomePage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// checking that session exists and session attributes match (access - true)
		if (req.getSession(false) != null && (Boolean) req.getSession().getAttribute("Client")) {
			RequestDispatcher redis = req.getRequestDispatcher("/client.html");
			System.out.println("Logging in!");
			redis.forward(req, resp);
		} else {
			resp.sendRedirect("http://localhost:8080/CafeDelivery/api/landing");
//		resp.setStatus(403);
		}

	}
}
