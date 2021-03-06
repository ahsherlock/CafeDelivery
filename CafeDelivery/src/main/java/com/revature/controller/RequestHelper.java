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
		case "/CafeDelivery/api/landing":
			System.out.println("Hit the LANDING route");
			AuthController.getLandingPage(req, resp);
			break;
		case "/CafeDelivery/api/loginpage":
			System.out.println("Hit the LOGINPAGE route");
			AuthController.getLoginPage(req, resp);
			break;
		case "/CafeDelivery/api/registrationpage":
			System.out.println("Hit the REGISTRATIONPAGE route");
			AuthController.getRegistrationPage(req, resp);
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
			case "GET":
				System.out.println("Hit the CLIENT GET route");
//				CustomerController.getAllUsers(req, resp);
				break;
			case "POST":
				System.out.println("Hit the CLIENT POST route");
				CustomerController.insertCustomer(req, resp);
				break;
			}
			break;
		case "/CafeDelivery/api/menu":
			System.out.println("Hit API MENU Endpoint");
			OrderController.getMenu(req, resp);
			break;
		case "/CafeDelivery/api/order":
			switch (req.getMethod()) {
			case "GET":
				System.out.println("Hit the ORDER GET route");
				OrderController.getOrderByOrderId(req, resp);
				break;
			case "POST":
				System.out.println("Hit the ORDER POST route");
				OrderController.insertOrder(req, resp);
				break;
			}
			break;
		case "/CafeDelivery/api/orderbycustomer":
			switch (req.getMethod()) {
			case "GET":
				OrderController.getOrdersByCustomerId(req, resp);
				break;
			}
			break;
		default:
//			System.out.println("Didn't hit any RH routes");
			break;
		}
	}

}
