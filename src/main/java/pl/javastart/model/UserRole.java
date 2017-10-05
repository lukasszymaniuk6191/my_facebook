package pl.javastart.model;
 
import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_role")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    private String role;
    
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(String username, String password, String role) {
		super();
		
		this.username = username;
		this.password = password;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [username=" + username + ", password=" + password + ", role=" + role + "]";
	}

	
	
	
	
	
}