Feature: Login Feature
  Verify if user is able to Login in to the site

   Scenario: Login as a authenticated user
   Given User Navigate to values Page
   Then User verify the right count values appear on the screen
   And values on the screen are greater than zero
   Then Need to verify the total balance is correct based on the values listed on the screen and Need to verify the total balance matches the sum of the values
   Then format as currencies
    
