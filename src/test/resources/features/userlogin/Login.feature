Feature: User registration.

Scenario: Test case 9 - A new user should be able to sign in to the system with a valid email id and password.
	Given : Valid emailid: "nidhin.paul@live.com" , password: "testpass" ,name: "Nidhin" ,phonenumber: "89338933" , Date "13 10 2010"
	When : User click register button
	Then response should be 200 as status and "Invalid Email/User already exist" as message
	
Scenario: Test case 10 - A valid user should be able to login to the system
	Given with "jithinraju95@gmail.com" and "qwerty"
	When : I click enter
	Then : user should be able to login successfully.
	
Scenario: Test case 11 - A invalid user should not be able to login to the system
	Given with "jithinraju95@gmail.com" and "qwerty1"
	When : I click enter
	Then : Response 500 , "message" , "Incorrect username and password"