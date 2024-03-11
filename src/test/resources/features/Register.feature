Feature:  Check Register Form Functionality 
  User should able to register using unregistered user
  User should not able to register using existing user
  User should not able to register using null username or password
  
  as a user ,  I can sign up an account:
	required fields: 
 		- username
 		- email address
 		- password


Scenario Outline: User signup with unregistered username 
Given    User navigates the websites landing page
When     User navigates Sign up form
And      User enters "<username>" to username field and "<password>" to password field
And      User clicks the Sign up button

Then     "<message>" message should appear

Examples:
|username      |password      |message             |
|newuser       |p@ssw0rd      |Sign up successful. |



Scenario Outline: User signup with blank username and password
Given    User navigates the websites landing page
When     User navigates Sign up form
And      User enters "<username>" to username field and "<password>" to password field
And      User clicks the Sign up button

Then     "<message>" message should appear        

Examples:
|username      |password              |message                                |
|heralduser    |                      |Please fill out Username and Password. |
|              |p@ssword	            |Please fill out Username and Password. |
|              |                      |Please fill out Username and Password. |



Scenario Outline: User signup with registed username
Given    User navigates the websites landing page
When     User navigates Sign up form
And      User enters "<username>" to username field and "<password>" to password field
And      User clicks the Sign up button

Then     "<message>" message should appear      

Examples:
|username    |password      |message                   |
|heraldtest  |p@ssw0rd      |This user already exist.  |

