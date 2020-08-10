Feature: Bus Management

Scenario: Test case 12 - An authorized admin user should be able to create bus type
	Given  with "nidhin@gmail.com" and "test"
	And login
	And bus type name "Tata mototrs" , seating capacity: 40 , standing capacity: 40
	When Create new bus type
	Then response should be 200 as status and "Bus Type Created successfully" as message 
	
Scenario: Test case 13 -  An authorized admin user should be able to create bus service provider
	Given  with "nidhin@gmail.com" and "test"
	And login
	And bus service name "Bus eiran 10"
	When Create new bus service
	Then response should be 200 as status and "" as message 

Scenario: Test case 1 - A user uses a valid card with balance less than -1
	Given  with "nidhin@gmail.com" and "test"
	And login
	And user boards in bus with service id 1 from stop id 1 with card "GEN45628001"
	When user tap the card to board
	Then response should be 500 as status and "Insufficient Balance" as message 
	
Scenario: Test case 2 - A user uses a valid card with balance equal to -1
	Given  with "nidhin@gmail.com" and "test"
	And login
	And user boards in bus with service id 1 from stop id 1 with card "GEN45628903"
	When user tap the card to board
	Then response should be 500 as status and "Insufficient Balance" as message

Scenario: Test case 3 - A user uses a valid card with balance greater than -1
	Given  with "nidhin@gmail.com" and "test"
	And login
	And user boards in bus with service id 1 from stop id 1 with card "GEN13123123"
	When user tap the card to board
	Then response should be 200 as status and "Not Peak Time - Checked in" as message 

Scenario: Test case 4 - A user uses a valid card with balance greater than -1 taps to alight
	Given  with "nidhin@gmail.com" and "test"
	And login
	And user boards in bus with service id 1 from stop id 1 with card "GEN13123123"
	When user tap the card to alight
	Then response should be 200 as status and "Checked out" as message 


Scenario: Test case 5 - A user uses a valid card with balance less than -1 , but has a subscription
	Given  with "nidhin@gmail.com" and "test"
	And login
	And user boards in bus with service id 1 from stop id 3 with card "GEN12345678"
	When user tap the card to board
	Then response should be 200 as status and "Not Peak Time - Checked in" as message  

Scenario: Test case 5 - A user uses a valid card with balance less than -1 , but has a subscription tap to alight
	Given  with "nidhin@gmail.com" and "test"
	And login
	And user boards in bus with service id 1 from stop id 3 with card "GEN12345678"
	When user tap the card to alight
	Then response should be 200 as status and "Checked out" as message  
	