package example.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import example.app.businessobjs.User;
import example.app.service.LoginService;
import example.app.service.LoginServiceImpl;

/**
 * Login Servlet
 */
@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * user name parameter
	 */
	private static String USERNAME = "username";
	/**
	 * password parameter
	 */
	private static final String PASSWORD = "password";

	/**
	 * Service for logging in users to the system.
	 */
	private LoginService loginService;

	public Login() {
		loginService = new LoginServiceImpl();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		User u = loginService.login(request.getParameter(USERNAME),
				request.getParameter(PASSWORD));
		if (u != null) {
			request.getSession().setAttribute(ApplicationProperties.SESSION_USER, u);

			response.sendRedirect(ApplicationProperties.INDEX_SERVLET);
			return;

		} else {
			response.sendRedirect(ApplicationProperties.LOGIN_PAGE);
			return;
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User u = (User) request.getAttribute("user");

		if (u == null) {
			request.getRequestDispatcher(ApplicationProperties.LOGIN_PAGE).forward(request, response);
		} else {
			request.getRequestDispatcher(ApplicationProperties.INDEX_SERVLET).forward(request, response);
		}
	}

}
