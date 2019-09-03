#Author: Nimantha
#Keywords Summary :
#Scenario 01 - Login to app and logout sucessfully
#Scenario 02 - Verify using incorrect username and password
#Scenario 03 - Verify when try to login without username
#Scenario 04 - Verify when try to login without password

Feature: Test Login


  @tag1
  Scenario: Correct login
    Given Opend browser and start application
    When Enter username "hostportuser" and password "$*$*Grace_&_lighT*$*$"
    Then Verify the home page
    Then Click on user name
    Then Click Logout
    Then Close the application
 

  @tag2
  Scenario: Incorrect user name and password
  Given Opend browser and start application
  When Enter username "ABC" and password "abc"
  Then Verify the Error message when both username and password is wrong
  Then Close the application
 
 @tag2
  Scenario: Without username
  Given Opend browser and start application
  When Enter username "" and password "abc"
  Then Verify the error message when "username" is empty
  Then Close the application
  
  @tag2
  Scenario: Without password
  Given Opend browser and start application
  When Enter username "ads" and password ""
  Then Verify the error message when "password" is empty
  Then Close the application
