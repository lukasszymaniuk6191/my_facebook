<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
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
        <div id="section_one" data-ng-app="myApp"  data-ng-controller='registerCtrl'>
            <div class="section_one_form">
                
                <div>
                    <h2>Register form</h2>
                </div>
                <div>
                	<h3 id="registration_info">
					</h3>
					<h4 id="arePasswordsEquals"></h4>
					<h4>
					
					</h4>
					
                </div>
                
                <form name="exampleForm">
                
                  <div class="row">
                    <div class="col-sm-8">                
                        <input type="text" class="form-control" name="name" data-ng-model='name' placeholder="Name" required>
                        <div data-ng-messages="exampleForm.name.$error">
                            <div data-ng-message="required">This field is required</div>
                        </div>
                    </div>
                </div><br>
      
               
                
                <div class="row">
                    <div class="col-sm-8">                
                        <input type="text" class="form-control" name="lastname" data-ng-model='lastname' placeholder="Lastname" required>
                         <div data-ng-messages="exampleForm.lastname.$error">
                            <div data-ng-message="required">This field is required</div>
                        </div>
                        
                    </div>
                </div><br>
                
                
                <div class="row">
                    <div class="col-sm-8">                
                        <input type="text" class="form-control" name="username" data-ng-model='username' placeholder="Login" required>
                        <div data-ng-messages="exampleForm.username.$error">
                            <div data-ng-message="required">This field is required</div>
                        </div>
                    </div>
                </div><br>
                
                <div class="row">
                    <div class="col-sm-8">                
                        <input type="text" class="form-control" name="password" data-ng-model='password' placeholder="Password" data-ng-minlength="5" data-ng-maxlength="15" required>
                         <div data-ng-messages="exampleForm.password.$error">
                            <div data-ng-message="required">This field is required</div>
                            <div data-ng-message="minlength">Message must be over 5 characters</div>
                          	<div data-ng-message="maxlength">Message must not exceed 15 characters</div>
                        </div>
                        
                    </div>
                </div><br>
                
                <div class="row">   
                    <div class="col-sm-8">                
                        <input type="text" class="form-control" name='confirmPassword' data-ng-model='confirmPassword' placeholder="Confirm password" data-ng-minlength="5" data-ng-maxlength="15" required>
                          <div data-ng-messages="exampleForm.confirmPassword.$error">
                          <div data-ng-message="required">This field is required</div>
                          <div data-ng-message="minlength">Message must be over 5 characters</div>
                          <div data-ng-message="maxlength">Message must not exceed 15 characters</div>
                        </div>
                    </div>
                </div><br>
                
                <div class="row">   
                    <div class="col-sm-8">                
                        <input type="email" class="form-control" name="email" data-ng-model='email' placeholder="e-mail">
                        <div data-ng-messages="exampleForm.email.$error">
                          <div data-ng-message="required">This field is required</div>
                          <div data-ng-message="email">Your email address is invalid</div>
                        </div>
                    </div>
                </div><br>
                
                <h4>Birthday</h4>
                
                <div class="row" data-ng-init="loadCalendar()">
                    
                    <div class="col-xs-2">
                            <div class="form-group">
                                <select class="selectpicker form-control" name="selectedDay" data-ng-model="selectedDay" data-ng-options="item for item in days" ></select>
                            </div>
                    </div>
					<div class="col-xs-3">
                            <div class="form-group">
                                <select class="selectpicker form-control" name="selectedMonth" data-ng-model="selectedMonth" data-ng-options="item for item in months"></select>
                            </div>
                    </div>

                    <div class="col-xs-3">
                            <div class="form-group">
                                <select class="selectpicker form-control" name="selectedYear" data-ng-model="selectedYear" data-ng-options="item for item in years"></select>
                            </div>
                    </div>
                
                </div>
                
                <div class="row"  style="padding-left:100px;">
                       <h4>
                            <label class="checkbox-inline"><input type="checkbox" data-ng-model="selectedFemale" value="">Women</label>
                            <label class="checkbox-inline"><input type="checkbox" data-ng-model="selectedMale" value="">Men</label>
                       </h4> 
                </div>
                
                
                
                
                
                
                
                
                <div class="row">
                    <div class="col-sm-8">                
                        <input type="text" class="form-control" name="role" data-ng-model='role' placeholder="Role" required>
                         <div data-ng-messages="exampleForm.role.$error">
                            <div data-ng-message="required">This field is required</div>
                        </div>
                        
                    </div>
                </div><br>
        
        		<div class="row">   
                    <div class="col-sm-8">                
                           <div class="btn-group btn-group-justified">
                                <a href="#" class="btn btn-primary" style="background-color: #000000; " data-name="registerButton"  data-ng-click="registerUserFunction()">Register</a>
                           </div>
                    </div>
                </div><br>
              
           
              
               
              
                </form>
             
              

                
                
            </div>
        </div>
            
         
             
       <div id="loginMod" class="aside" data-ng-app="loginModule"  data-ng-controller='loginCtrl'>
       		<div>
                    <h2>Log in</h2>
                </div>
                
                <form name="exampleForm_two" action="UserLoginServlet" method="post">   
                
                <div class="row">
                    <div class="col-sm-8">                
                        <input type="text" class="form-control" name='my_login' data-ng-model='my_login' placeholder="Login">
                    </div>
                </div><br>
                
                <div class="row">
                    <div class="col-sm-8">                
                        <input type="text" class="form-control" name='my_password' data-ng-model='my_password' placeholder="Password">
                    </div>
                </div><br>
                
                
             
              
              	<div class="row">   
                    <div class="col-sm-12">   
                      	 	<input  class="btn btn-primary" style="background-color: #000000;"    type="submit" value="Submit">
                      </div>
                </div><br>  
                
              </form>    
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