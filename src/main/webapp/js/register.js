var app = angular.module('myApp', ['ngMessages']);

app.service('UsersService', function(){
	
	var days = new Array();
	var months = [];
	var year = [];
	
	
});





app.controller('registerCtrl',['$scope','$http', function($scope, $http) 
{
	 var day = new Array();
	 var month = new Array();
	 var year = new Array();
	
	 function comparePasswords(password,confirmPassword)
	 {
		 if(password==confirmPassword)
		 {
			 return true;
		 }
		 
		 if(password!=confirmPassword)
		 {
			 return false;
		 }
	 }
	 
	 function changeHeadings(addToDataBase, arePasswordsEqual) 
	 {
		 	if(addToDataBase==true && arePasswordsEqual==true)
		 	{
		 		 var document_result = document.getElementById("registration_info");
		 		 var registration_display_info = "Registration was successful. You can log in now.";
		 		 var result = registration_display_info.fontcolor("green");
		 		 registration_info.innerHTML = result;
		 		 
		 		 var document_result_two = document.getElementById("arePasswordsEquals");
		 		 var registration_display_info_two = "";
		 		 var result_two = registration_display_info_two.fontcolor("red");
		 		 arePasswordsEquals.innerHTML = result_two;
		 	}
		 	else if(addToDataBase==false)
		 	{
		 		 var document_result = document.getElementById("registration_info");
		 		 var registration_display_info = "Registration failed. Try again.";
		 		 var result = registration_display_info.fontcolor("red");
		 		 registration_info.innerHTML = result;
		 		 
		 		 if(arePasswordsEqual==false)
		 		 {
		 			 var document_result_two = document.getElementById("arePasswordsEquals");
			 		 var registration_display_info_two = "The entered passwords are different.";
			 		 var result_two = registration_display_info_two.fontcolor("red");
			 		 arePasswordsEquals.innerHTML = result_two;
		 		 }
		 		 
		 		 if(arePasswordsEqual==true)
		 		 {
		 			 var document_result_two = document.getElementById("arePasswordsEquals");
			 		 var registration_display_info_two = "";
			 		 var result_two = registration_display_info_two.fontcolor("red");
			 		 arePasswordsEquals.innerHTML = result_two;
		 		 }

		 	}
		 	else if(addToDataBase==true && arePasswordsEqual==false)
		 	{
		 		 var document_result = document.getElementById("registration_info");
		 		 var registration_display_info = "Registration failed. Try again.";
		 		 var result = registration_display_info.fontcolor("red");
		 		 registration_info.innerHTML = result;
		 		 
		 		 if(arePasswordsEqual==false)
		 		 {
		 			 var document_result_two = document.getElementById("arePasswordsEquals");
			 		 var registration_display_info_two = "The entered passwords are different.";
			 		 var result_two = registration_display_info_two.fontcolor("red");
			 		 arePasswordsEquals.innerHTML = result_two;
		 		 }
		 	}
		 	
		 	arePasswordsEquals
		   
	 }
	 
	 function clearInputFields()
	 {
		
		 document.getElementsByName("name")[0].value = "";
		 document.getElementsByName("lastname")[0].value = "";
		 document.getElementsByName("username")[0].value = "";
		 document.getElementsByName("password")[0].value = "";
		 document.getElementsByName("confirmPassword")[0].value = "";
		 document.getElementsByName("email")[0].value = "";
		 document.getElementsByName("selectedDay")[0].value = "";
		 document.getElementsByName("selectedMonth")[0].value = "";
		 document.getElementsByName("selectedYear")[0].value = "";
		 document.getElementsByName("role")[0].value = "";
	 }
	 
	 
	 $scope.loadCalendar = function()
	 {
		 console.log("Load Calendar");
		
		 for(i=0; i<30; i++)
		 {
			 day[i]=i+1;
		 }
		 for(i=0; i<12; i++)
		 {
			 month[i]=i+1;
		 }
		 for(i=0; i<67; i++)
		 {
			 year[i]=i+1950;
		 }
		 
	 }
	 
	 $scope.days = day;
	 $scope.months = month;
	 $scope.years = year;
	 
	
	 
	 $scope.registerUserFunction = function()
	 {
		 console.log("Register user function działa");
		 
		 var userData = new UserData($scope.name, $scope.lastname, $scope.username, $scope.password, $scope.confirmPassword, $scope.email, $scope.role);
		 userData.userBirthDay.setUserBirthDay($scope.selectedDay,$scope.selectedMonth,$scope.selectedYear);
		 
		  if($scope.selectedFemale == true)
	      {
	          userData.setUserSex("Woman");
	      }
	      else
	      {
	          userData.setUserSex("Man");
	      }

		
		 
		 
		 
		 var userDataJSON = JSON.stringify(userData);
		 
		
		 var arePasswordEquals  =  comparePasswords($scope.password,$scope.confirmPassword)
		
		 var addToDataBase = false;
		 
		 if(userData.name!=undefined && userData.lastname!=undefined && userData.password!=undefined &&
				 userData.confirmPassword!=undefined && userData.email!=undefined && userData.role!=undefined)
			 {
			 	if(userData.userBirthDay.day!=undefined && userData.userBirthDay.month!=undefined
			 			&& userData.userBirthDay.year!=undefined)
			 		{
			 			addToDataBase = true;
			 			
			 		}
			 }
		 
		
		 
		 if(addToDataBase==true && arePasswordEquals==true)
		 {
			 $http({
		            url : 'UserRegisterServlet',
		            method : "POST",
		            contentType: 'application/json',
		            data : userDataJSON 
		            
		        }).then(function(response) {
		        	console.log('http sucess!');
		            //console.log(response.data);
		            //$scope.message = response.data;
		        }, function(response) {
		            //fail case
		        	console.log('http fail!');
		            //console.log(response);
		            //$scope.message = response;
		        });
			 
			 changeHeadings(addToDataBase,arePasswordEquals);
			 clearInputFields();
		 }
		 else
		 {
			//console.log('Niestety nie udało się wprowadzić poprwnie wartości sprawdź formularz');
			changeHeadings(addToDataBase,arePasswordEquals);
			//console.log('Hasła się różnią');
			 
			
		 }
	 
	 }
}]);




function UserData(name, lastname, username ,password,confirmPassword, email, role)
     {
      	 this.name = name;
      	 this.lastname = lastname;
	 	 this.username = username; 
	 	 this.password = password;
	 	 this.confirmPassword = confirmPassword;
         this.email = email;
         this.sex = null;
         this.role = role;
         this.userBirthDay = new UserBirthDay(0,0,0);
        

         this.showUserData = function()
         {
             return 'Name: '+this.name+ ' Lastname: '+this.lastname+' Username: '+this.username + ' Hasło: '+this.password + ' e-mail: '+this.email + 
                '  Role: ' + this.role;
                
         }
         
         this.setUserSex = function(sex)
         {
        	 this.sex = sex;
         }
         
        

     }


function UserBirthDay(day, month, year)
	{
	    this.day = day;
	    this.month = month;
	    this.year = year;
	    //this.setUserBirthDay = setUserBirthDay; 
	    
	this.setUserBirthDay = function(day, month, year)
	{
	    this.day = day;
	    this.month = month;
	    this.year = year;
	}
	    
	    
	}


