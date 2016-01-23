package freelance.poc.hibernate.ex2.entity;

//Using the * to make the import list smaller
import javax.persistence.*;

@Entity
@Table(name = "TEST_USER")
//@SequenceGenerator(name = "USER_SEQUENCE", sequenceName = "USER_SEQUENCE", allocationSize = 1, initialValue = 0)
public class User {

	@Id
	@Column
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQUENCE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String login;

	@Column
	private String password;
	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}