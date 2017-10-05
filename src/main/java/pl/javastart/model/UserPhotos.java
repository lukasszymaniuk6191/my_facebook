package pl.javastart.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_photos")
@NamedQueries({
	@NamedQuery(name = "UserPhotos.findUserPhotosByLoginData", query = "SELECT up FROM UserPhotos up WHERE up.username = :username AND up.password = :password"), 
	@NamedQuery(name = "UserPhotos.findUserSinglePhotoByLoginData", query = "SELECT up FROM UserPhotos up WHERE up.username = :username AND up.password = :password AND up.path = :path")
})
public class UserPhotos {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id_user_photo")
	  private Long id;
	  
	  @Column(name = "username",nullable = false)
	  private String username;
	  @Column(name = "password",nullable = false)
	  private String password;
	  @Column(name = "path",nullable = false, unique=true)
	  private String path;
	  
	  @OneToMany(mappedBy="userPhotos")
	  private List<UserPhotoComments> userPhotoComments;
	   
	
	public UserPhotos() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserPhotos(String username, String password, String path) {
		super();
		this.username = username;
		this.password = password;
		this.path = path;
		//this.user = null;
	}

	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}

	/*
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	*/

	@Override
	public String toString() {
		return "UserPhotos [username=" + username + ", password=" + password + ", path=" + path + ", user=" /*+ user*/
				+ "]";
	}

	
	  
	
}
