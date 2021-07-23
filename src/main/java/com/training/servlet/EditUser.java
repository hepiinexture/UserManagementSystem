package com.training.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.training.vo.Address;
import com.training.vo.User;
import com.training.service.UserService;

/**
 * Servlet implementation class EditUser
 */
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(getClass().getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUser() {
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
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			userService = new UserService();
			User user = userService.getUserFromUserId(Integer.parseInt(request.getParameter("userId")));			
			ArrayList<Address> addresses = userService.getAddressFromUserId(user.getUserId());
			request.setAttribute("user", user);
			request.setAttribute("addresses", addresses);
			request.getRequestDispatcher("editUser.jsp").forward(request, response);
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
		UserService userService = null;
		User user = null;
		Address address = null;
		List<Address> addresses = null;
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());

			userService = new UserService();
			user = new User();
			addresses = new ArrayList<Address>();
			user.setUserId(Integer.parseInt(request.getParameter("userId").toString()));
			user.setUsername(request.getParameter("username"));
			user.setEmail(request.getParameter("email"));
			user.setPhoneNumber(request.getParameter("phoneNumber"));
			
			int addressSize = Integer.parseInt(request.getParameter("addressSize"));
			List<String> deletedIndex = Arrays.asList(request.getParameter("deletedIndex").split(","));
			List<String> deletedAddressId = Arrays.asList(request.getParameter("deletedAddressId").split(","));
			
			for(int i = 1; i<=addressSize; i++) {
				if(deletedIndex.contains(String.valueOf(i)))
					continue;
				address = new Address();
				address.setAddressId(Integer.parseInt(request.getParameter("addressId"+i)));
				address.setUserId(Integer.parseInt(request.getParameter("userId"+i)));
				address.setStreet(request.getParameter("street"+i));
				address.setCity(request.getParameter("city"+i));
				address.setCountry(request.getParameter("country"+i));
				addresses.add(address);
			}
			user.setAddresses(addresses);
			userService.editAddress(user);
			
			userService.deleteAddresses(deletedAddressId);
			
			int count = Integer.parseInt(request.getParameter("czContainer_czMore_txtCount"));
			addresses = new ArrayList<Address>();
			for(int i=1;i<=count; i++) {
				address = new Address();
				address.setAddressId(Integer.parseInt(request.getParameter("addressId_"+i+"_")));
				address.setUserId(Integer.parseInt(request.getParameter("userId_"+i+"_")));
				address.setStreet(request.getParameter("street_"+i+"_"));
				address.setCity(request.getParameter("city_"+i+"_"));
				address.setCountry(request.getParameter("country_"+i+"_"));
				addresses.add(address);
			}
			userService.addAddress(addresses);
			
			if(user.isType())
				response.sendRedirect("usersList");
			else
				response.sendRedirect("detailedView?userId="+user.getUserId());
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

}
