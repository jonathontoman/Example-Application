package example.app.service;

import java.util.List;

import example.app.businessobjs.Contact;
import example.app.dao.GenericDao;
import example.app.dao.GenericDaoImpl;

public class ContactServiceImpl implements ContactService
{

	
	private GenericDao<Contact> contactDao;
	
	public ContactServiceImpl()
	{
		contactDao = new GenericDaoImpl<Contact>(Contact.class);
	}
	
	
	public List<Contact> findAll()
	{
		return contactDao.findAll();
	}
	
	public void delete(Integer id)
	{
		contactDao.deleteById(id);
	}

	@Override
	public void save(String firstname, String lastname, String phonenumber, String street) {
		
		Contact c = new Contact();
		c.setFirstname(firstname);
		c.setLastname(lastname);
		c.setPhonenumber(phonenumber);
		c.setStreet(street);
		contactDao.save(c);
		
	}
	
}
  