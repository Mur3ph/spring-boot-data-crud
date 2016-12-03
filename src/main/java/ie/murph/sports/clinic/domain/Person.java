package ie.murph.sports.clinic.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person 
{
	//private static final long serialVersionUID = -1801714432822866390L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long person_id;

	@Column(name = "first_name", nullable = false)
	private String personFirstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;
	
	public Person() {
	}

	public Person(String personFirstName, String lastName, String password, String username) {
		this.personFirstName = personFirstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public long getId() {
		return person_id;
	}

	public void setId(long id) {
		this.person_id = id;
	}

	public String getPersonFirstName() {
		return personFirstName;
	}

	public void setPersonFirstName(String personFirstName) {
		this.personFirstName = personFirstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getId()).append(", ").append(this.getPersonFirstName()).append(", ").append(this.getLastName());
		return builder.toString();
	}
}
