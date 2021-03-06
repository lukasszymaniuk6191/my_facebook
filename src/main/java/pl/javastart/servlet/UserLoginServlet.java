package pl.javastart.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import pl.javastart.repository.UserRepository;


@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	UserRepository userRepository;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	      
		  String login = request.getParameter("my_login");
		  String password = request.getParameter("my_password");

	      
	      boolean canILogIn = userRepository.passwordAndLoginAreValid(login, password);
	      
	      if(canILogIn)
	      {
	    	  request.getRequestDispatcher("html/login_page.jsp").include(request,response);
	      }
	      else
	      {
	    	  request.getRequestDispatcher("html/login_error_page.jsp").include(request,response);
	      }

	      
	      
	      
	    
	}
	

	

}
