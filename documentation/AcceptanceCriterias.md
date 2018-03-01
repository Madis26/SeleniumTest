Acceptance Criteria
===================
**Scenario 1:** User sign in with valid credentials  
*Given* the user is an authorized user  
*When* he go to bankWebApp login page  
*And* insert valid credentials  
*Then* he is challenged by a home page  
*And* welcome page for successful login  

**Scenario 2:** Signed in user logging out  
*Given* the user is an authorized user  
*And* has been logged in  
*When* he clicks logout button  
*Then* he is challenged by a login screen  
*And*  he sees correct signing out message  

**Scenario 3:** User is new user with valid credentials  
*Given* the user is an authorized user  
*When* she login  
*Then* she sees a password changing page  

**Scenario 4:** User can see account balance  
*Given* the user is an authorized user  
*When* he logging in the bank  
*Then* he sees his account balance  