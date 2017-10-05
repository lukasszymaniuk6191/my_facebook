<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/register.css">   
    <link rel="stylesheet" type="text/css" href="bower_components/bootstrap/dist/css/bootstrap.min.css"> 
    <link rel="stylesheet" type="text/css" href="bower_components/bootstrap/dist/css/bootstrap.css"> 
    <title>Document</title>
</head>
<body>

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
    
    <div id="container">
      
		<center><h1>Login error. Password or login is not valid</h1></center><br>
		<center><h3><a href="/moj_facebook">Return to login pages</a></h3></center>

        
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