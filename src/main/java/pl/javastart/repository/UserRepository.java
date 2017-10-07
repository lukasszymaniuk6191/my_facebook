package pl.javastart.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import pl.javastart.model.User;
import pl.javastart.model.UserBirthday;
import pl.javastart.model.UserPhotoComments;
import pl.javastart.model.UserPhotos;
import pl.javastart.model.UserRole;

@Stateless
public class UserRepository {
 
    @PersistenceContext
    private EntityManager em;
    
    public List<UserPhotoComments> getUserPhotoComments(String username, String path)
    {
     	TypedQuery<UserPhotoComments> userPhotoCommentsList = em.createNamedQuery("UserPhotoComments.findUserPhotoComments", UserPhotoComments.class);
     	userPhotoCommentsList.setParameter("username", username);
     	userPhotoCommentsList.setParameter("path", path);
        List<UserPhotoComments> photoCommentsList = userPhotoCommentsList.getResultList();
    	return photoCommentsList;
    }
    
    public void addComment(UserPhotoComments userPhotoComments)
    {
    	
    	String username = userPhotoComments.getUsername();
    	String password = userPhotoComments.getPassword();
    	String path = userPhotoComments.getPath();
    	String date = userPhotoComments.getDate();
    	
    	System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
    	System.out.println(date);
    	System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
    	
    	UserPhotos userPhoto = getUserSinglePhotos(username, password, path);
    	Long photoId = userPhoto.getId();
    	
    	UserPhotos userPhotos = em.find(UserPhotos.class, photoId);
    	userPhotoComments.setUserPhotos(userPhotos);;
    	
    	em.persist(userPhotoComments);
    }
    
    public List<UserPhotos> getUserPhotos(String username, String password)
    {
    	TypedQuery<UserPhotos> userPhotosList = em.createNamedQuery("UserPhotos.findUserPhotosByLoginData", UserPhotos.class);
        userPhotosList.setParameter("username", username);
        userPhotosList.setParameter("password", password);
        List<UserPhotos> photosList = userPhotosList.getResultList();
    	
    	return photosList;
    }
    
    public UserPhotos getUserSinglePhotos(String username, String password, String path)
    {
    	TypedQuery<UserPhotos> userPhotosList = em.createNamedQuery("UserPhotos.findUserSinglePhotoByLoginData", UserPhotos.class);
        userPhotosList.setParameter("username", username);
        userPhotosList.setParameter("password", password);
        userPhotosList.setParameter("path", path);
        List<UserPhotos> photosList = userPhotosList.getResultList();

        UserPhotos userPhotos = photosList.get(0);
      
    	return userPhotos;
    }
    
    public void addPhoto(UserPhotos userPhoto)
    {
    	em.persist(userPhoto);
    }
    
    public void addUser(User user, UserRole userRole, UserBirthday userBirthday){
    
    	em.persist(user);
        em.persist(userRole);
        em.persist(userBirthday);

    }
    
    public User getUserByEmail(String username, String password)
    {
        TypedQuery<User> userDataList = em.createNamedQuery("User.findUserByLoginData", User.class);
        userDataList.setParameter("username", username);
        userDataList.setParameter("password", password);
        List<User> userList = userDataList.getResultList();
        User user = userList.get(0);
        
        return user;
    }
    
    public List<User> getAll() {
        TypedQuery<User> getAllQuery = em.createNamedQuery("User.findAllUsers", User.class);
        List<User> users = getAllQuery.getResultList();
        return users;
    }
    
    
    public boolean passwordAndLoginAreValid(String username, String password)
    {
    	 boolean passwordAndLoginAreValid = false;
   	  
         TypedQuery<User> query = em.createNamedQuery("User.findAllUsers", User.class);
         List<User> resultList = query.getResultList();
         
         for(int i=0; i<resultList.size(); i++)
         {
     
	          if((resultList.get(i).getUsername().equals(username)) || (resultList.get(i).getEmail().equals(password)))
	          {	  
	        	  passwordAndLoginAreValid = true;
	        
	          }
         }
    	
    	return passwordAndLoginAreValid;
    }
    
    public boolean checkDoubleValuesInUser(String username, String email)
    {
    	  boolean oneValueIsDouble = false;
    	  
          TypedQuery<User> query = em.createNamedQuery("User.findAllUsers", User.class);
          List<User> resultList = query.getResultList();
          
          for(int i=0; i<resultList.size(); i++)
          {
      
	          if((resultList.get(i).getUsername().equals(username)) || (resultList.get(i).getEmail().equals(email)))
	          {	  
	        	  oneValueIsDouble = true;
	        
	          }
          }

          return oneValueIsDouble;
          
    }
    
    
}

