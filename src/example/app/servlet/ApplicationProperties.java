package example.app.servlet;

/**
 * A class to hold private static string variables for the various redirects etc that the web app uses.
 * @author Jonathon
 *
 */
public class ApplicationProperties 
{
	
	// SERVLETS
	public static final String LOGIN_SERVLET  = "login";
	public static final String INDEX_SERVLET = "index";
	public static final String CREATE_SERVLET = "createContact";
	public static final String DELETE_SERVLET = "deleteContact";
	
	// JSP PAGES
	public static final String LOGIN_PAGE = "/WEB-INF/login.jsp";
	public static final String INDEX_PAGE = "/WEB-INF/index.jsp";
			
	// SESSION PARAMS
	public static final String SESSION_USER = "user";
	
	
}
