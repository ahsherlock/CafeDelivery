package com.revature.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.Customers;
import com.revature.service.Service;

public class CustomerController {

	private static Service cService = new Service();

	public static boolean insertCustomer(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if (req.getMethod().equals("POST")) {

			int id = 0;
			String username = req.getParameter("username");
			String fname = req.getParameter("firstName");
			String lname = req.getParameter("lastName");
			String password = req.getParameter("password");

			System.out.println("Reached Employee Controller");

			Customers c = new Customers(id, username, password, fname, lname);

			cService.insertCustomer(c);

			RequestDispatcher redis = req.getRequestDispatcher("/CafeDelivery/api/main");
			redis.forward(req, resp);

			resp.setStatus(201);
		} else {
			resp.setStatus(405);
		}

		return false;
	}

//	public static List<Customer> getAllUsers(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//
//		if (req.getMethod().equals("GET")) {
//
//			List<Customer> c = null;
//
//			resp.setContentType("application/json");
//
//			c = cService.getAllUsers();
//
//			ObjectMapper om = new ObjectMapper();
//			resp.getWriter().write(om.writeValueAsString(c));
//			resp.setStatus(200);
//			return c; // This will return a list of customers from service
//		} else {
//			resp.setStatus(400);
//			return null;
//		}
//
//	}

}
