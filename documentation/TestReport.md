| Id | TestCase | Actual | Expected | Status |
|----------|--------|----------|--------|-----|
|1.|User can successfully login | User can successfully login | User can successfully login | **PASS**
|2.|User can successfully log out |	User can successfully log out |	User can successfully log out | **PASS**
|3.|User can’t login using wrong username |	User can’t login using wrong username | User can’t login using wrong username | **PASS**
|4.|User can’t login using wrong password |	User can’t login using wrong password | User can’t login using wrong password	| **PASS**
|5.|User can’t change password to whitespace | User can change password to whitespace | User can’t change password to whitespace |	**FAIL**
|6.|New user forced to change password | New user forced to change password | New user forced to change password | **PASS**
|7.|New user can’t change password same as old password | New user can change password same as old password | New user can’t change password same as old password | **FAIL**
|8.|Password has min length	| Password has not min length |	Password has min length | **FAIL**
|9.|Password has max length | Password has not max length | Password has max length | **FAIL**
|10.|Username has max length | Username has not max length |	Username has max length | **FAIL**
|11.|Username has min length | Username has not min length |	Username has min length | **FAIL**
|12.|User can view account balance |	User can view account balance | User can view account balance	| **PASS**
|13.|User get error message if changed password mismatch  |	User get error message if changed password mismatch  | User get error message if changed password mismatch 	| **PASS**
