package pl.javastart.model;
 
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "users")
@NamedQueries({
	@NamedQuery(name = "User.findAllUsers", query = "SELECT u FROM User u"),
	@NamedQuery(name = "User.findUserByLoginData", query = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
})

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false, unique=true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String confirmPassword;
    @Column(nullable = false, unique=true)
    private String email;
    @OneToOne
    private UserRole userRole;
    @OneToOne
    private UserBirthday userBirthday;
    @Column(nullable = false)
    private String sex;
   
  
    
    
    public User() {
		super();
	}

	public User(String name, String lastname, String username, String password, String confirmPassword, String email, String sex) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.userRole = null;
		this.userBirthday = null;
		this.sex = sex;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
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



	public String getConfirmPassword() {
		return confirmPassword;
	}



	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public UserRole getUserRole() {
		return userRole;
	}



	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}



	public UserBirthday getUserBirthday() {
		return userBirthday;
	}



	public void setUserBirthday(UserBirthday userBirthday) {
		this.userBirthday = userBirthday;
	}

	

	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", lastname=" + lastname + ", username=" + username + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", email=" + email + ", userRole=" + userRole
				+ ", userBirthday=" + userBirthday + ", sex=" + sex + ", userPhotos="/*+ userPhotos + */+"]";
	}



	

	

	
     
   
}