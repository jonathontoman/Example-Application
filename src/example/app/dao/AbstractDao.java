package example.app.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public abstract class AbstractDao<T extends Serializable> {
	/**
	 * The instance of the entity class.
	 */
	private Class<T> clazz;

	EntityManager em;
	

	/**
	 * Set the entity class
	 * 
	 * @param clazz
	 */
	public void setClass(Class<T> clazz) {
		this.clazz = clazz;
	}

	/**
	 * Find the entity by its id.
	 * 
	 * @param id
	 *            - id of the entity
	 * @return
	 */
	public T findById(Integer id) {
		em.getTransaction().begin();
		T item = em.find(clazz, id);
		em.getTransaction().commit();
		return item;
	}

	/**
	 * Find all instances of this type of entity.
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")	
	public List<T> findAll() {
		em.getTransaction().begin();		
		List<T> items = em.createQuery("from " + clazz.getName()).getResultList();
		em.getTransaction().commit();
		return 	items;
	}

	/**
	 * Persist this entity to the database.
	 * 
	 * @param entity
	 *            - the entity we wish to persist.
	 */
	public void save(T entity) {	
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	/**
	 * Delete this entity from the database.
	 * 
	 * @param entity
	 *            - the enity we want to delete.
	 */
	public void delete(T entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

	/**
	 * Delete this entity from the database
	 * 
	 * @param id
	 *            - the id of the database entity we want to delete.
	 */
	public void deleteById(Integer id) {
		T entity = findById(id);
		delete(entity);
	}

	/**
	 * Update this entity in the database.
	 * 
	 * @param entity
	 *            - the entity we wish to update
	 * @return T - the updated entity.
	 */
	public T update(T entity) {
		em.getTransaction().begin();
		T item = em.merge(entity);
		em.getTransaction().commit();
		return item;
	}
}
