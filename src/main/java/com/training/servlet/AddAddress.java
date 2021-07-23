package com.training.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.training.service.UserService;
import com.training.vo.Address;
import com.training.vo.User;

/**
 * Servlet implementation class AddAddress
 */
public class AddAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(getClass().getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAddress() {
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
			userService = new UserService();
			request.setAttribute("userId", Integer.parseInt(request.getParameter("userId")));
			request.getRequestDispatcher("addAddress.jsp").forward(request, response);
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
		Address address = null;
		List<Address> addresses = null;
		User user = null;
		try {
			userService = new UserService();
			address = new Address();
			addresses = new ArrayList<Address>();
			int count = Integer.parseInt(request.getParameter("czContainer_czMore_txtCount"));
			for(int i=0;i<=count; i++) {
				address = new Address();
				address.setAddressId(Integer.parseInt(request.getParameter("addressId_"+i+"_")));
				address.setUserId(Integer.parseInt(request.getParameter("userId_"+i+"_")));
				address.setStreet(request.getParameter("street_"+i+"_"));
				address.setCity(request.getParameter("city_"+i+"_"));
				address.setCountry(request.getParameter("country_"+i+"_"));
				addresses.add(address);
			}
			userService.addAddress(addresses);
			
			user = userService.getUserDetailFromUsername(request.getSession().getAttribute("username").toString());
			if(user.isType())
				response.sendRedirect("usersList");
			else
				response.sendRedirect("detailedView?userId="+user.getUserId());
		}catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

}
