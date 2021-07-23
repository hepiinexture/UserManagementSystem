package com.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.training.service.UserService;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(getClass().getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = null;
		try {
			userService = new UserService();
			String password = request.getParameter("password");
			String confirmPassword = request.getParameter("confirmPassword");
			String username = request.getParameter("username");
			String message = userService.changePassword(password, confirmPassword, username);
			if(!message.equals("changed")) {
				request.setAttribute("message", message);
				request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
			}
			else
				response.sendRedirect("login.jsp");
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
