package com.training.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.training.service.UserService;
import com.training.vo.Address;
import com.training.vo.User;

/**
 * Servlet implementation class UserRegistration
 */
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(getClass().getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = null;
		User user = null;
		Address address = null;
		List<Address> addresses = null;
		try {
			userService = new UserService();
			user = new User();
			address = new Address();
			addresses = new ArrayList<Address>();
			user.setUsername(request.getParameter("username"));
			user.setEmail(request.getParameter("email"));
			user.setPhoneNumber(request.getParameter("phoneNumber"));
			user.setPassword(request.getParameter("password"));
			address.setStreet(request.getParameter("street"));
			address.setCity(request.getParameter("city"));
			address.setCountry(request.getParameter("country"));
			addresses.add(address);
			user.setAddresses(addresses);
			userService.registerUser(user);

			if (log.isDebugEnabled())
				log.debug("New user is registered. User=" + user);

			String username = request.getSession().getAttribute("username").toString();
			if (username == null || username.isEmpty())
				response.sendRedirect("login.jsp");
			else
				response.sendRedirect("usersList");
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
