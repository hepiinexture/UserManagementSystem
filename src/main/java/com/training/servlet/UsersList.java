package com.training.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.training.vo.User;
import com.training.service.UserService;

/**
 * Servlet implementation class UsersList
 */
public class UsersList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(UsersList.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersList() {
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
			List<User> users = userService.usersList();
			if(log.isDebugEnabled())
				log.debug("User records are fatched users="+users);
			request.setAttribute("users", users);
			request.getRequestDispatcher("usersList.jsp").forward(request, response);
		} catch (Exception e) {
			log.error(e);
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
