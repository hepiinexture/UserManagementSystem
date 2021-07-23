package com.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.training.service.UserService;
import com.training.util.DatabaseUtil;
import com.training.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(LoginServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = null;
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			HttpSession session = request.getSession();
			UserService userService = new UserService();

			if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
				User user = userService.loginUser(username, password);

				if (user == null)
					throw new Exception("Invalid username or password entered.");

				if (log.isDebugEnabled())
					log.debug(username + " logged in successfully.");
				
				session.setAttribute("username", user.getUsername());
				if (user.isType() == true)
					response.sendRedirect("usersList");
				else
					request.getRequestDispatcher("detailedView?userId=" + user.getUserId()).forward(request, response);
			} else {
				message = "Username or password must not be empty.";
				log.warn(message);
				request.setAttribute("message", message);
				request.getRequestDispatcher("login.jsp?message=" + message).forward(request, response);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("login.jsp?message=" + e.getMessage()).forward(request, response);
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
