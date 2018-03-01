Test Report
=================
Summary
------------------
The overall goal is to test a simple bank web application. Created basic automated tests.

References to automatic tests  
------------------
| Id | TestCase | Actual | Expected | Status |Automated|
|----------|--------|----------|--------|-----|-------|
|1.|User can successfully login | User can successfully login | User can successfully login | **PASS**| YES
|2.|User can successfully log out |	User can successfully log out |	User can successfully log out | **PASS** | YES
|3.|User can’t login using wrong username |	User can’t login using wrong username | User can’t login using wrong username | **PASS** | YES
|4.|User can’t login using wrong password |	User can’t login using wrong password | User can’t login using wrong password	| **PASS** | YES
|5.|User can’t change password to whitespace | User can change password to whitespace | User can’t change password to whitespace |	**FAIL** | YES
|6.|New user forced to change password | New user forced to change password | New user forced to change password | **PASS** | YES
|7.|New user can’t change password same as old password | New user can change password same as old password | New user can’t change password same as old password | **FAIL** | YES
|8.|Password has min length	| Password has not min length |	Password has min length | **FAIL** | NO
|9.|Password has max length | Password has not max length | Password has max length | **FAIL** | YES
|10.|Username has max length | Username has not max length |	Username has max length | **FAIL** | YES
|11.|Username has min length | Username has not min length |	Username has min length | **FAIL** | NO
|12.|User can view account balance |	User can view account balance | User can view account balance	| **PASS** | NO
|13.|User get error message if changed password mismatch  |	User get error message if changed password mismatch  | User get error message if changed password mismatch 	| **PASS** | YES
