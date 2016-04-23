package example.app.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Interface for the common functions the generic dao must implement.
 * @author Jonathon
 *
 * @param <T>
 */
public interface GenericDao  <T extends Serializable>{
	 
	   T findById(final Integer id);
	 
	   List<T> findAll();
	 
	   void save(final T entity);
	 
	   T update(final T entity);
	 
	   void delete(final T entity);
	 
	   void deleteById(final Integer entityId);
}

