package example.app.dao;

import java.io.Serializable;

import example.app.servlet.EM;

public class GenericDaoImpl<T extends Serializable> extends AbstractDao<T>
		implements GenericDao<T> {


	public GenericDaoImpl(Class<T> clazz) {
						
		setClass(clazz);
		this.em = EM.createEntityManager();
	}

}
