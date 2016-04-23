package example.app.dao;

import example.app.businessobjs.User;

public interface UserDao {

		/**
		 * Find the user with the matching username and password, return null if none is found.
		 * @param username - 
		 * @param password
		 * @return
		 */
		public User findUser(String username , String password);
}