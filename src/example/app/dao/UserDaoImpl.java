package example.app.dao;

import example.app.businessobjs.User;

public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	public User findUser(String username, String password) {

		User u =  (User) em
				.createQuery(
						"SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
				.setParameter("username", username)
				.setParameter("password", password)
				.getSingleResult();
		return u;
	}

}
