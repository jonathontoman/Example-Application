package example.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import example.app.service.ContactService;
import example.app.service.ContactServiceImpl;

@WebServlet("/createContact")
public class CreateContact extends HttpServlet
{	

	/**
	 * parameter string for the first name
	 */
	private static final String FIRSTNAME="firstname";
	/**
	 * parameter string for the last name
	 */
	private static final String LASTNAME="lastname";
	/**
	 * parameter string for the address
	 */
	private static final String ADDRESS="streetaddress";
	/**
	 * parameter string for the phone number
	 */
	private static final String PHONENUMBER="phonenumber";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7190535297054884957L;
	/**
	 * Data access for user data.
	 */
	private ContactService contactService;

	@Override
	public void init()
	{
		contactService = new ContactServiceImpl();
	}
		
	/**
	 * Create a new contact in the contact system.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{								
		
		// Create contact and persist to database.
		contactService.save(req.getParameter(FIRSTNAME), req.getParameter(LASTNAME), req.getParameter(PHONENUMBER), req.getParameter(ADDRESS));				
		resp.sendRedirect(ApplicationProperties.INDEX_SERVLET);
		return;
	}
	
}
