Feature: Card management

Scenario: Test Case 5 - An authorized used should be able to link his card to the account.
		Given with "jithinraju95@gmail.com" and "qwerty"
		And login
		And card "STU89567402"
		When user adds card to the his account
		Then response should be 200 as status and "" as message 

Scenario: Test Case 6 - An authorized used should not be able to link his card to the account.
		Given with "jithinraju95@gmail.com" and "qwerty"
		And login
		And card "STU89567402"
		When user adds card to the his account
		Then response should be 200 as status and "Card already mapped to a user" as message 

Scenario: Test Case 7 - An authorized used should be able to see all card link to his account.
		Given with "jithinraju95@gmail.com" and "qwerty"
		And login
		When user want to see his linked cards
		Then response should be 200 as status and "STU89567402" as message 

Scenario: Test case - A user should be able to delink the card that is linked to his account
		Given with "jithinraju95@gmail.com" and "qwerty"
		And login
		And card "STU89567402"
		When user delink card from his account
		Then response should be 200 as status and "" as message 
	
			