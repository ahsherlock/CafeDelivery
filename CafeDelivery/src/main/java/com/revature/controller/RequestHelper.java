package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String endpoint = req.getRequestURI();
		System.out.println(endpoint);

		switch (endpoint) {
		case "/CafeDeliver/api/landing":
			System.out.println("Hit the LANDING route");
			AuthController.getLandingPage(req, resp);
			break;
		case "/CafeDelivery/api/main":
			System.out.println("Hit the MAIN route");
			MainPageController.getHomePage(req, resp);
			break;
		case "/CafeDelivery/api/login":
			System.out.println("Hit the LOGIN route");
			AuthController.login(req, resp);
			break;
		case "/CafeDelivery/api/logout":
			System.out.println("Hit the LOGOUT route");
			AuthController.logout(req, resp);
			break;
		case "/CafeDelivery/api/client":
			switch (req.getMethod()) {
			case "GET":
				System.out.println("Hit the CLIENT GET route");
				break;
			case "POST":
				System.out.println("Hit the CLIENT POST route");
				break;
			}
			break;
		case "/CafeDelivery/api/order":
			switch (req.getMethod()) {
			case "GET":
				System.out.println("Hit the ORDER GET route");
				break;
			case "POST":
				System.out.println("Hit the ORDER POST route");
				break;
			case "PUT":
				System.out.println("Hit the ORDER PUT route");
				break;
			case "DELETE":
				System.out.println("Hit the ORDER DELETE route");
				break;
			}
			break;
		default:
			System.out.println("Didn't hit any RH routes");
			break;
		}
	}

}
