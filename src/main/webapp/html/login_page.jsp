<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%	
	String login = request.getParameter("my_login");
	String password = request.getParameter("my_password");
	HttpSession httpSession = request.getSession();
	httpSession.setAttribute("login", login);
	httpSession.setAttribute("password", password);
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/login_page.css">   
    <link rel="stylesheet" type="text/css" href="bower_components/bootstrap/dist/css/bootstrap.min.css"> 
    <link rel="stylesheet" type="text/css" href="bower_components/bootstrap/dist/css/bootstrap.css"> 
    <title>Document</title>
</head>
<body >

	 <div id="header">
        <div class="span12">
                    <div class="span6">
                        <h1 class="muted">Company Name</h1>
                    </div>

                    <div class="span4 offset2" style="margin-top:15px;">
                        <button class="btn pull-right" type="button">Sign In</button>
                    </div>
                    
        </div>
    </div>
    
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
              <a class="navbar-brand" href="#">WebSiteName</a>
            </div>
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#viewStudents">View Students</a></li>
              <li><a href="#">Page 2</a></li>
              <li><a href="#">Page 3</a></li>
            </ul>

            <form class="navbar-form navbar-left">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="Search">
                <div class="input-group-btn">
                  <button class="btn btn-default" type="submit">
                    <i class="glyphicon glyphicon-search"></i>
                  </button>
                </div>
              </div>
            </form>

      </div>
    </nav>
    
    <div id="container" data-ng-app="loginModule" data-ng-controller="loginCtrl as loginControler">
 
     <%
     	//String login = request.getParameter("my_login");
     	//String password = request.getParameter("my_password");
     	
     	//request.setAttribute("login", login);
     	//request.setAttribute("password", password);
     %>

     
   	 <input type="hidden" name="login" data-ng-model='login' value="<%=login%>">
     <input type="hidden" name="password" data-ng-model='password' value=<%=password%>>
     
     	
     <div id="user_data_section" data-ng-init="loginControler.showUserData()">
	     <div class="user_data_section_font">
	     	<div data-ng-init="loginControler.showUserData()">
		      	   
			       <h5>Name: {{loginControler.user_login_data.name}}</h5> 
			       <h5>Month: {{loginControler.user_login_data.lastname}}</h5>
			       <h5>Year: {{loginControler.user_login_data.email}}</h5> 
			      
		    </div>
	     	
	     	<a href="" data-ng-hide="showme" data-ng-click="showme=true">Show user details</a>
		  	
		  
		  	<a data-ng-show="showme">User birthday</p>
		  	<a data-ng-show="showme">Day: {{loginControler.user_login_data.userBirthday.day}}</a><br>
		   	<a data-ng-show="showme">Month: {{loginControler.user_login_data.userBirthday.month}}</a><br>
		   	<a data-ng-show="showme">Year: {{loginControler.user_login_data.userBirthday.year}}</a><br><br>
		   	
		   	<a data-ng-show="showme">User Role</a><br>
		  	<a data-ng-show="showme">Year: {{loginControler.user_login_data.userRole.role}}</a><br><br>
		   
		    <a href="" ng-show="showme" ng-click="showme=false">Hide user details</a>
		    
		    
		    
	
		</div>	
     </div>
     <div class="user_photos_section">
     	<div  data-ng-init="loginControler.getUserPhotos()">
	 
	 
	 		
	 
	     	<div class="user_photos_section_single_photo" data-ng-repeat="userPhotos in loginControler.userPhotosNames">
	     		<img src="images/{{userPhotos}}"><br>
	     	
	     		<a href="" data-ng-hide="show_comments"  data-ng-click="comments = loginControler.getUserPhotoComments(userPhotos); show_comments=true">Show comments</a>       
	     		
				
	     	
	     	
				
				<div class="showPhotoCommentsScroll"> 		
		     		<div data-ng-show="show_comments" class="showPhotoComment" data-ng-repeat="single_comment in comments">
			     		<div class="commentDate">
			     			{{single_comment.date}}  <a>Usun</a><br>
			     		</div>		     		
		     		    {{single_comment.comment}}
		     		</div>
	     		</div>    
	     		
	     		<a href="" ng-show="  show_comments" ng-click="show_comments=false">Hide comments</a>
	     		
	     		
	     		<div>
	     		<textarea  class="textareaAddComment" name="current_comment" data-ng-model="loginControler.current_comment"
	     					placeholder="add comment">
                  
	            </textarea>		
	            </div>
	           
	                     
                <div class="addPhotoCommentButton"  class="btn-group btn-group-justified">
                     <a href="#" class="btn btn-primary" style="background-color: #000000; " data-name="addCommentButton"  
                     data-ng-click="loginControler.addCommentToPhoto(userPhotos); aaa = loginControler.getUserPhotoComments(userPhotos); show_comments=false">Add comment</a>
                </div>
          		<br>
	     		
	     		
	     	</div>
	
			<br>
			<br>
			<br>
	
	
	     	<h1>File Upload</h1>
		    <form method="post" action="UploadServlet"
		        enctype="multipart/form-data">
		        Select file to upload: <input type="file" name="file" size="60" /><br />
		        <br /> <input type="submit" value="Upload" />
	    	</form>
     	</div>
     </div>
     

     
   
     
  
      
      
      
      

     
        
    </div>
    
   <div id="footer">
        <h2>Ala ma kota</h2>
    </div>
    

   
   
    
 
    <script type="text/javascript" src="bower_components/angular/angular.js"></script>
    <script type="text/javascript" src="bower_components/angular-messages/angular-messages.min.js"></script>
    <script type="text/javascript" src="js/register.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
   </body>
</html>