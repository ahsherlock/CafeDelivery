package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String endpoint = req.getRequestURI();
//		System.out.println(endpoint);

		/**
		 * When the user hits one of the following routes (with the matching VERB)
		 * 
		 */

		switch (endpoint) {
		case "/CafeDelivery/api/landing":
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
		case "/CafeDelivery/api/customer":
			switch (req.getMethod()) {
//			case "GET":
//				System.out.println("Hit the CLIENT GET route");
//				CustomerController.getAllUsers(req, resp);
//				break;
			case "POST":
				System.out.println("Hit the CLIENT POST route");
				CustomerController.insertCustomer(req, resp);
				break;
			}
			break;
		case "/CafeDelivery/api/order":
			switch (req.getMethod()) {
			case "GET":
				System.out.println("Hit the ORDER GET route");
				OrderController.getAllOrdersByUsername(req, resp);
				break;
			case "POST":
				System.out.println("Hit the ORDER POST route");
				OrderController.insertOrder(req, resp);
				break;
			}
			break;
		default:
//			System.out.println("Didn't hit any RH routes");
			break;
		}
	}

}
