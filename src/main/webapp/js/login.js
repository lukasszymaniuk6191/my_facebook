var app = angular.module('loginModule', ['ngMessages']);

app.controller('loginCtrl',['$scope','$http','$filter', function($scope, $http,$filter)
	{
		console.log('loginCtrl działa!')
		
		//$scope.message = "";
		

		
		var vm = this;
		vm.showUserData = function() 
		{
			var login = document.getElementsByName('login')[0].value
			var password = document.getElementsByName('password')[0].value
			
			var myUrl = 'api/users/' + login+'/'+password;
			//var myUrl = 'api/users';
			$http({
			     	method : 'GET',
			     	url : myUrl
			     }).then(function success(response) 
			     {
			    	 console.log('success');
			    	 vm.user_login_data = response.data;
			    	 console.log(vm.user_login_data);
			     }, function error(response) 
			     {
			        console.log('API error ' + response.status);
			     });
    
		}

		
		vm.getUserPhotoComments = function(path) 
		{
			var login = document.getElementsByName('login')[0].value
			var myUrl = 'api/users/photos/comments/'+login+'/'+path;
			var userPhotoCommentsArray = new Array();
			
			var userPhotoObjects = new Array();
			
			//var myUrl = 'api/users';
			console.log(myUrl);
			console.log('getUserPhotos() działa');
			$http({
			     	method : 'GET',
			     	url : myUrl
			     }).then(function success(response) 
			     {
			    	 console.log('success');
			    	
			    	 var userPhotoComments = response.data;
			    
			    	 for(i=0; i<userPhotoComments.length;i++)
			    	 {
		
			    	 userPhotoObjects.push(userPhotoComments[i]);
			    	 }
			    	 /*
			    	 for(i=0; i<userPhotoComments.length;i++)
		    		 {
			    		 console.log(userPhotoComments[i].comment)
			    		 userPhotoCommentsArray.push(userPhotoComments[i].comment);
		    		 }
			    	*/
			    	 
			     }, function error(response) 
			     {
			        console.log('API error ' + response.status);
			     });
			
			
			
			//return  userPhotoCommentsArray;
			return userPhotoObjects;
			
			
		}
		
	
		
		vm.getUserPhotos = function() 
		{
			var login = document.getElementsByName('login')[0].value
			var password = document.getElementsByName('password')[0].value
			var myUrl = 'api/users/photos/' + login+'/'+password;
			var photosNamesArray = new Array();
			//var myUrl = 'api/users';
			//console.log(myUrl);
			//console.log('getUserPhotos() działa');
			$http({
			     	method : 'GET',
			     	url : myUrl
			     }).then(function success(response) 
			     {
			    	 console.log('success');
			    	 vm.user_photos = response.data;
			    	 
			    	 var userPhotos = response.data;
			    
			    	 
			    	 for(i=0; i<userPhotos.length;i++)
			    	 {
			    		 //console.log(userPhotos[i].path);
			    		 photosNamesArray.push(userPhotos[i].path);
			    	 }

			    	 vm.userPhotosNames = photosNamesArray;
		
			    	 
			     }, function error(response) 
			     {
			        console.log('API error ' + response.status);
			     });
			
		
		}
		
	
		
		vm.addCommentToPhoto = function(filePath) 
		{
			var login = document.getElementsByName('login')[0].value;
			var password = document.getElementsByName('password')[0].value;
			var comment = vm.current_comment;
			vm.current_comment = "";

			var date = new Date();
		    var currentDate = $filter('date')(new Date(), 'dd/MM/yyyy');
		    var currentTime = $filter('date')(new Date(), 'HH:mm:ss');
		    var photoDate = currentTime + ' ' + currentDate;
			
		    console.log('photoDate: '+photoDate)
		    
			var path = filePath;
			var userPhotoComments = new UserPhotoComments(login, password,path, comment,photoDate);

			
			var myUrl = 'api/users/photos/comments';
			var photosNamesArray = new Array();
			
			$http({
			     	method : 'POST',
			     	url : myUrl,
			     	data: userPhotoComments
			     }).then(function success(response) 
			     {
			    	 console.log('success');
			   
		
			    	 
			     }, function error(response) 
			     {
			        console.log('API error ' + response.status);
			     });
			
		
		}
		
		
		
		 $scope.userLoginFunction = function()
		 {

			 /*
			 
				 $http({
			            url : 'UserLoginServlet',
			            method : "POST",
			            contentType: 'application/json',
			            data : {
			                'login' : $scope.my_login,
			                'password' : $scope.my_password
			            }
			            
			            
			        }).then(function(response) {
			        	console.log('http sucess!');
			            console.log(response.data);
			            //$scope.message = response.data;
			        }, function(response) {
			            //fail case
			        	console.log('http fail!');
			            console.log(response);
			            //$scope.message = response;
			        });
			*/	
			
		 }

	}]);

function UserPhotoComments(username, password, path, comment,date)
{
	this.username = username;
	this.password = password;
	this.path = path;
	this.comment = comment;
	this.date = date;


}


angular.bootstrap(document.getElementById("loginMod"), ['loginModule']);