Feature: Check Login Functionality
  User should able to Login using valid user
  User should not able to login using invalid username and password
  User should not able to login using blank username or password
  
	as a user ,  I can log in after signing up:
	required fields: 
	 - username
	 - password

Background:
Given   User navigates the websites landing page
And     User navigates Login form

Scenario Outline: User log-in using registered username
When    User enters "<username>" and "<password>" 
And     User clicks the Log in button

Then    User should be logged-in
And     Log out button should appear in the header menu

Examples:
| username       | password  |     
| heraldtest1    | 123       |     
	
	
	
Scenario Outline: User log-in using invalid username or password
When    User enters "<username>" and "<password>" 
And     User clicks the Log in button

Then      "<message>" message should appear

Examples:
| username          | password     | message               |
| unreg_user        | 456          | User does not exist.  |
| unreg_user        | 123          | User does not exist.  |
| htest1            | 456          | Wrong password.       |
	


Scenario Outline: User log-in using blank username or password
When    User enters "<username>" and "<password>" 
And     User clicks the Log in button

Then      "<message>" message should appear
	
Examples:
| username          | password     | message                                  |
|                   |              | Please fill out Username and Password.   |
| htest1            |              | Please fill out Username and Password.   |
|                   | 123          | Please fill out Username and Password.   |
	
	
	
