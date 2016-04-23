package example.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import example.app.service.ContactService;
import example.app.service.ContactServiceImpl;

@WebServlet("/deleteContact")
public class DeleteContact extends HttpServlet
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7684545936646803152L;

	/**
	 * request parameter of ids that we are going to delete.
	 */
	private static final String DELETE="deleteSelection";
	
	/**
	 * Data access for user data.
	 */
	private ContactService contactService;

	
	@Override
	public void init()
	{
		contactService = new ContactServiceImpl();
	}
			
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		// Delete Contacts in the system
		String [] ids = req.getParameterValues(DELETE);
		
		for (String s : ids)
		{
			contactService.delete(new Integer(s));
		}
		
		// Post - Get  redirect
		resp.sendRedirect(ApplicationProperties.INDEX_SERVLET);
	}
	
 }
