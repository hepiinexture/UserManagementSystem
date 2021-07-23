package com.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.training.dto.UserDetailsDTO;
import com.training.service.UserService;

/**
 * Servlet implementation class DetailedUserView
 */
public class DetailedUserView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(DetailedUserView.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailedUserView() {
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
			UserDetailsDTO userDetailsDTO = userService.getUserDetailFromUserId(Integer.parseInt(request.getParameter("userId")));
			request.setAttribute("user", userDetailsDTO.getUser());
			request.setAttribute("addresses", userDetailsDTO.getAddress());
			request.getRequestDispatcher("detailedView.jsp").forward(request, response);
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
