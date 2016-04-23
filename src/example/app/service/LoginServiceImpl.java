package example.app.service;

import example.app.businessobjs.User;
import example.app.dao.UserDao;
import example.app.dao.UserDaoImpl;

public class LoginServiceImpl implements LoginService {
	
	
	private UserDao userDao;
	
	public LoginServiceImpl()
	{
		userDao = new UserDaoImpl();
	}

	@Override
	public User login(String username, String password) {
		return userDao.findUser(username,password);
	}
}
