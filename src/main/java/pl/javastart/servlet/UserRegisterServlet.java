package pl.javastart.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import pl.javastart.model.User;
import pl.javastart.model.UserBirthday;
import pl.javastart.model.UserRole;
import pl.javastart.repository.UserRepository;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	UserRepository userRepository ;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        
        String name = jObj.getString("name");
        String lastname = jObj.getString("lastname");
        String username = jObj.getString("username");
        String password = jObj.getString("password");
        String confirmPassword = jObj.getString("confirmPassword");
		String email = jObj.getString("email");
		String role = jObj.getString("role");
		String sex = jObj.getString("sex");
		
		JSONObject birthday = jObj.getJSONObject("userBirthDay");
		
		int day = birthday.getInt("day");
		int month = birthday.getInt("month");
		int year = birthday.getInt("year");
		
		boolean isDoubleValue = userRepository.checkDoubleValuesInUser(username,email);
		
		System.out.println("isDoubleValue: "+isDoubleValue);
		
		if(isDoubleValue==false)
		{
			UserRole userRole = new UserRole(username, password, role);
			UserBirthday userBirthday = new UserBirthday(username,password,day,month,year);
			User user = new User(name,lastname, username,password,confirmPassword,email,sex);
			user.setUserBirthday(userBirthday);
			user.setUserRole(userRole);
			userRepository.addUser(user, userRole, userBirthday);
		}
		else
		{
			
			System.out.println("Wartość nie może być dodana, wartości się powtarzają");
			
		
			
		
		}
		
		
		
		
		
	}

}
