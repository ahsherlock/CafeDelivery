package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.Customer;

public class CustomerController {

//	private static Service cService = new Service();

	public static boolean insertCustomer(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if (req.getMethod().equals("POST")) {

			int id = 0;
			String username = req.getParameter("username");
			String fname = req.getParameter("firstName");
			String lname = req.getParameter("lastName");
			String password = req.getParameter("password");

			System.out.println("Reached Employee Controller");

			Customer c = new Customer(id, username, password, fname, lname);

//			cService.insertCustomer(c);

			RequestDispatcher redis = req.getRequestDispatcher("/CafeDelivery/api/main");
			redis.forward(req, resp);

			resp.setStatus(201);
		} else {
			resp.setStatus(405);
		}

		return false;
	}

	public static List<Customer> getAllCustomers(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if (req.getMethod().equals("GET")) {

			Customer c = null;

			resp.setContentType("application/json");

//			c = cService.getAllCustomers();

			ObjectMapper om = new ObjectMapper();
			resp.getWriter().write(om.writeValueAsString(c));
			resp.setStatus(200);
			return c; // This will return a list of customers from service
		} else {
			resp.setStatus(400);
			return null;
		}

	}

//	public static Customer getCustomerByUsername(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//
//		if (req.getMethod().equals("GET")) {
//
//			Customer c = null;
//
//			resp.setContentType("application/json");
//
//			String username = req.getParameter("Username");
//
////			c = cService.getCustomerByUsername(username);
//
//			ObjectMapper om = new ObjectMapper();
//			resp.getWriter().write(om.writeValueAsString(c));
//			resp.setStatus(200);
//			return c;
//		} else {
//			resp.setStatus(400);
//			return null;
//		}
//
//	}

}
