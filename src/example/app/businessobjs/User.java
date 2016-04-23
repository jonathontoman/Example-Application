package example.app.businessobjs;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 */
@Entity
@Table(name="user")
public class User implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -4164175582898134540L;
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;

	public User() {
		super();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the passsword
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param passsword
	 *            the passsword to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
