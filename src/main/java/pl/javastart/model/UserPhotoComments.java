package pl.javastart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user_photos_comments")
@NamedQueries({
	@NamedQuery(name = "UserPhotoComments.findUserPhotoComments", query = "SELECT upc FROM UserPhotoComments upc WHERE upc.username = :username AND upc.path = :path") 

})
public class UserPhotoComments {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id_user_comment")
	  private Long id;
	  
	  @Column(name = "username",nullable = false)
	  private String username;
	  @Column(name = "password",nullable = false)
	  private String password;
	  @Column(name = "photo_path",nullable = false)
	  private String path;
	  @Column(name = "comment",nullable = false)
	  private String comment;
	  @Column(name = "date",nullable = false)
	  private String date;
	  @ManyToOne
	  @JoinColumn(name = "user_photo_id")
	  private UserPhotos userPhotos;
	
	  
	public UserPhotoComments() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserPhotoComments(String username, String password, String path, String comment) {
		super();
		this.username = username;
		this.password = password;
		this.path = path;
		this.comment = comment;
	}

	  
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
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


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public UserPhotos getUserPhotos() {
		return userPhotos;
	}


	public void setUserPhotos(UserPhotos userPhotos) {
		this.userPhotos = userPhotos;
	}


	@Override
	public String toString() {
		return "UserPhotoComments [username=" + username + ", password=" + password + ", path=" + path + ", comment="
				+ comment + ", userPhotos=" + userPhotos + "]";
	}
	
	
	
	  
	  
	  
	  
	  
}
