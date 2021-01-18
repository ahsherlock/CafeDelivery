package com.revature.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.dao.OrderDao;
import com.revature.dao.OrderDaoImpl;
import com.revature.pojo.Customer;
import com.revature.pojo.Menu;
import com.revature.pojo.Orders;
import com.revature.service.Service;

public class OrderController {

	private static Service oService = new Service();
	private static OrderDao oDao = new OrderDaoImpl();
	private static Logger log = Logger.getLogger(OrderController.class);

	public static boolean insertOrder(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (req.getMethod().equals("POST")) {

			ObjectMapper om = new ObjectMapper();

			Orders o = om.readValue(req.getReader(), com.revature.pojo.Orders.class);

			System.out.println("Reached Order Controller");
			System.out.println("This is the order info from the front-end" + o);

			// Need to set this to capture user information

			Customer newCustomer = new Customer((int) req.getSession().getAttribute("Id"),
					(String) req.getSession().getAttribute("Username"),
					(String) req.getSession().getAttribute("Password"),
					(String) req.getSession().getAttribute("FirstName"),
					(String) req.getSession().getAttribute("LastName"));

			o.setCustomerOrder(newCustomer);
			System.out.println("This is O before it goes to service: " + o);

			oDao.insertOrder(o);

			// This needs to change to the customer asset, not the index
			RequestDispatcher redis = req.getRequestDispatcher("/index.html");
			redis.forward(req, resp);

			log.setLevel(Level.ALL);
			log.info("User: " + req.getSession().getAttribute("FirstName") + " "
					+ req.getSession().getAttribute("LastName") + ", " + req.getSession().getAttribute("Username")
					+ " has submitted a new Order.");

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
			List<Object> o = null;

//			int cId = (int) req.getSession().getAttribute("Id");
			int cId = 1;

			o = oService.getOrdersByCustomerId(cId);

			System.out.println(o);
			ObjectMapper om = new ObjectMapper();
			om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			resp.getWriter().write(om.writeValueAsString(o)); // This will parse our Java object into a JSON
			resp.setStatus(201);
		} else {
			resp.setStatus(405);
		}

		return false;
	}

	public static boolean getOrderByOrderId(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if (req.getMethod().equals("GET")) {

			resp.setContentType("application/json");

			System.out.println("Reached Ticket Controller");
			List<Menu> o = null;

//			int cId = (int) req.getSession().getAttribute("currentId");
			int oId = 4;

			o = oService.getOrderByOrderId(oId);

			ObjectMapper om = new ObjectMapper();
			resp.getWriter().write(om.writeValueAsString(o)); // This will parse our Java object into a JSON

			resp.setStatus(201);
		} else {
			resp.setStatus(405);
		}

		return false;
	}

	public static void getMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Menu> menu = new ArrayList<>();
		menu = oService.getMenu();
		ObjectMapper om = new ObjectMapper();
		resp.getWriter().write(om.writeValueAsString(menu));
		resp.setStatus(201);

	}

}
