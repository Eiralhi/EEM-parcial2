Feature: Test user login 

Scenario: User succesfully logins with credentials
  Given Browser is open
  And user is in login page
  When user enters <username> and <password>
  And user clicks loggin button
  Then website shows main page
  
  Examples: 
  |username|password|
  |Eiralhi|12345|
  |Ivan|12345|