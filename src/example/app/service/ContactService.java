package example.app.service;

import java.util.List;

import example.app.businessobjs.Contact;

/**
 * Interface to deal with contacts in the system
 * @author Jonathon
 *
 */
public interface ContactService {
	
	/**
	 * Get all contacts in the system
	 * @return - a list of contacts in the system.
	 */
	public List<Contact> findAll();
	/**
	 * Delete a contact in the system
	 * @param id - the id of the contact we want to delete.
	 */
	public void delete(Integer id);
	
	/**
	 * Create a contact in the system
	 * @param c, the contact we are creating.
	 */
	public void save(String firstname, String lastname, String phonenumber, String street);

}