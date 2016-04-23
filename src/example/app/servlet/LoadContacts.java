package example.app.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import example.app.businessobjs.Contact;
import example.app.businessobjs.User;
import example.app.service.ContactService;
import example.app.service.ContactServiceImpl;

@WebServlet("/index")
/**
 * Prepares the data for the main page and forwards onto the correct jsp to display it.
 */
public class LoadContacts extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8819660183960898341L;
	/**
	 * Data access for user data.
	 */
	private ContactService contactService;

	@Override
	public void init() {
		contactService = new ContactServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		// check if we are logged in, if not redirect to login.
		User u = (User) req.getSession().getAttribute(ApplicationProperties.SESSION_USER);
		if (u == null) {
			resp.sendRedirect(ApplicationProperties.LOGIN_SERVLET);
			return;
		} else {
			List<Contact> c = contactService.findAll();
			req.setAttribute("contacts", c);
			req.getRequestDispatcher(ApplicationProperties.INDEX_PAGE).forward(req, resp);
			return;
		}
	}

}
