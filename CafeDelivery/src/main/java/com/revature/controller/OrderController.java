package com.revature.controller;

import java.awt.Menu;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.CafeMenu;
import com.revature.models.Orders;
import com.revature.service.Service;

public class OrderController {

	private static Service oService = new Service();
	private static Logger log = Logger.getLogger(OrderController.class);

	public static boolean insertOrder(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (req.getMethod().equals("POST")) {

			ObjectMapper om = new ObjectMapper();

			Orders o = om.readValue(req.getReader(), com.revature.models.Orders.class);

			System.out.println("Reached Order Controller");
			System.out.println(o);

			// Need to set this to capture user information
//			o.setCustomerOrder((Integer) req.getSession().getAttribute("currentId"));
//			o.setCustomerOrder(oService.getUserByUsername((String) req.getSession().getAttribute("Username")));

			System.out.println("This is O before it goes to service: " + o);

			o.setOrderDate(LocalDate.now());
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

	public static boolean getOrdersByCustomerId(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if (req.getMethod().equals("GET")) {

			System.out.println("Reached Ticket Controller");
			List<Orders> oList = null;

//			int cId = (int) req.getSession().getAttribute("Id");
			int cId = 1;

			oList = oService.getOrdersByCustomerId(cId);

//			int x = -1;
//			System.out.println("cId   cName       oId   oDate        iName     iPrice");
//			for (Orders o : oList) {
//				if (x != o.getId()) {
//					for (CafeMenu c : o.getCafeMenu()) {
//					}
//					x = o.getId();
//				}
//			}

			ObjectMapper om = new ObjectMapper();
			resp.getWriter().write(om.writeValueAsString(oList)); // This will parse our Java object into a JSON

			resp.setStatus(201);
		} else {
			resp.setStatus(405);
		}

		return false;
	}

	public static boolean getOrderByOrderId(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if (req.getMethod().equals("GET")) {

			System.out.println("Reached Ticket Controller");
			List<Menu> o = null;

//			int cId = (int) req.getSession().getAttribute("currentId");
			int oId = 4;

//			o = oService.getOrderByOrderId(oId);

			ObjectMapper om = new ObjectMapper();
			resp.getWriter().write(om.writeValueAsString(o)); // This will parse our Java object into a JSON

			resp.setStatus(201);
		} else {
			resp.setStatus(405);
		}

		return false;
	}

	public static List<CafeMenu> getMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<CafeMenu> m = null;

		ObjectMapper om = new ObjectMapper();
		m = oService.getMenu();
		System.out.println("This is the menu: " + m);
		resp.getWriter().write(om.writeValueAsString(m));
		return m;
	}

}
