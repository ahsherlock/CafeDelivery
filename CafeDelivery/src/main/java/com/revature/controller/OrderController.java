package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.Orders;
import com.revature.service.Service;

public class OrderController {

	private static Service oService = new Service();
//	private static Logger log = Logger.getLogger(OrderController.class);

	public static boolean insertOrder(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (req.getMethod().equals("POST")) {

			ObjectMapper om = new ObjectMapper();

			Orders o = om.readValue(req.getReader(), com.revature.pojo.Orders.class);

			System.out.println("Reached Order Controller");

			// Need to set this to capture user information
//			o.setCustomerOrder((Integer) req.getSession().getAttribute("currentId"));
			o.setCustomerOrder(oService.getUserByUsername((String) req.getSession().getAttribute("Username")));

			System.out.println("This is O before it goes to service: " + o);
			oService.insertOrder(o);

			// This needs to change to the customer asset, not the index
			RequestDispatcher redis = req.getRequestDispatcher("/index.html");
			redis.forward(req, resp);

//			log.setLevel(Level.ALL);
//			log.info("User: " + req.getSession().getAttribute("FirstName") + " "
//					+ req.getSession().getAttribute("LastName") + ", " + req.getSession().getAttribute("Email")
//					+ " has submitted a new ticket.");

			resp.setStatus(201);
		} else {
			resp.setStatus(405);
		}
		return false;
	}

	public static boolean getAllOrdersByUsername(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if (req.getMethod().equals("GET")) {

			System.out.println("Reached Ticket Controller");
			List<Orders> o = null;

			String username = (String) req.getSession().getAttribute("Username");

			o = oService.getOrdersByUsername(username);

			ObjectMapper om = new ObjectMapper();
			resp.getWriter().write(om.writeValueAsString(o)); // This will parse our Java object into a JSON

			resp.setStatus(201);
		} else {
			resp.setStatus(405);
		}

		return false;
	}
}