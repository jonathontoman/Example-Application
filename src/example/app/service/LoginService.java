package example.app.service;

import example.app.businessobjs.User;

/**
 * Login Service interface
 * @author Jonathon
 *
 */
public interface LoginService {

	/**
	 * Log the user in. Returns the logged in user if successful, else returns null;
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password);	

}