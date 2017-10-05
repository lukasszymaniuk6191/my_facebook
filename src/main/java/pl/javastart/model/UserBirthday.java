package pl.javastart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_birthday")
public class UserBirthday {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id_user_birthday")
	  private Long id;

	  @Column(name = "username",nullable = false)
	  private String username;
	  @Column(name = "password",nullable = false)
	  private String password;
	  
	  @Column(name = "day",nullable = false)
	  private int day;
	  @Column(name = "month",nullable = false)
	  private int month;
	  @Column(name = "year",nullable = false)
	  private int year;
	
	  public UserBirthday() {
		super();
	  }
	
		public UserBirthday(String username, String password, int day, int month, int year) {
			super();
			this.username = username;
			this.password = password;
			this.day = day;
			this.month = month;
			this.year = year;
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
	
		public int getDay() {
			return day;
		}
	
		public void setDay(int day) {
			this.day = day;
		}
	
		public int getMonth() {
			return month;
		}
	
		public void setMonth(int month) {
			this.month = month;
		}
	
		public int getYear() {
			return year;
		}
	
		public void setYear(int year) {
			this.year = year;
		}
	
		@Override
		public String toString() {
			return "UserBirthday [username=" + username + ", password=" + password + ", day=" + day + ", month=" + month
					+ ", year=" + year + "]";
		}
		  
		
	  
	  
	  
}
