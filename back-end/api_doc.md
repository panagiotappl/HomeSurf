# HomeSurf API
**Base url**: https://localhost:8443/home-surf
___

**User Controller**

 - **Find a user by id**
	 Method: GET
	 Endpoint: /users/{userId}
	``` json 
	Request body: none
	```
 - **Register a new user**
	Method: POST
	 Endpoint: /users
	``` json 
	Request body: {
	    "email": "someone@gmail.com",
	    "password": "password",
	    "name": "dimitris",
	    "surname": "anastasopoulos",
	    "mobile": "+30 6938067279",
	    "username": "dimitris21gr",
	    "roles": [
	        {
	            "roleId": 1
	        }
	    ]
	}
	```
 - **Check if user with input username exists**
	 Method: GET
	 Endpoint: /users/username-exists/{username}
	``` json 
	Request body: none
	```
 - **Check if user with input email exists**
	 Method: GET
	 Endpoint: /users/email-exists/{email}
	``` json 
	Request body: none
	```
___