Feature: Subscription management

Scenario: An authorized user should be able to add new subscription
		Given with "nidhin@gmail.com" and "test"
		And login
		And Add subscribtion with plan name "monthly 30% discount" , car category "STU" , default plan : 0 ,Subciption period 30 , discount rate 30
		When user submit the subscription
		Then response should be 200 as status and "" as message 
Scenario: An authorized user should be able to subscription his card
		Given with "jithinraju95@gmail.com" and "qwerty"
		And login
		And Add plan id 20 for card "STU89567402" , payment ref no "PR104"
		When user add subscribtion to card
		Then response should be 200 as status and "" as message 