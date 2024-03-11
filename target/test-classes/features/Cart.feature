Feature: User should able to add to cart and place order
	1. As a User, I can Add item to cart
	 - Each item is clickable 
	   -- the ff should be shown:
	          --- image
	          --- model
	          --- Price
	          --- description
	          --- add to cart button
	          --- quantity
	 - A pop up is hsown upon clicking add to cart.
	 - item should be added to cart.
	
	
	2. As a User, I can remove Item to cart
	 - confirmation pop-up is shown when click delete button.
	 - total should be updated when deleting an item
	
	3. As a user ,  I can Place a order
	  - required fields:
	         -- Name
	         -- Credit card
	         -- Country
	         -- Month
	         -- City
	         -- Year
	 - A "Thank you" pop-up should be shown upon purchase



Scenario Outline: User should able to add to an item to cart using registered user

Given   User is logged-in to website using "<username>" and "<password>"
And     User navigate an "<item>" listed in home page
And     Item details should be displayed
When    User clicks the add to cart button

Then   "<message>" message should appear
And     "<item>" should be added to cart

Examples:
|username       |password      |item                  |message        |
|htest1         |123           |Samsung galaxy s6     |Product added. | 



Scenario Outline: User should able to add an item to cart using anonymous user
	
Given    User navigates the websites landing page
And      User navigate an "<item>" listed in home page
And      Item details should be displayed
When     User clicks the add to cart button

Then   "<message>" message should appear
And    "<item>" should be added to cart
 
Examples:
| item                |message        |
| Samsung galaxy s6   |Product added  |


	
Scenario Outline: User should able to remove an item from cart using registered user
Given   User is logged-in to website using "<username>" and "<password>"
And     User navigate an "<item>" listed in home page
When    User clicks the add to cart button
And     "<item>" should be added to cart
And     User clicks Delete Item

#Then    confirmation popup should appear
And    "<item>" should be remove in the cart
And     "<totalPrice>" should be updated

Examples:
|username       |password     |item                  |totalPrice |
|htest4        |123           |Samsung galaxy s6     |360        |


Scenario Outline: User should able to remove an item from cart using anonymous user
Given   User navigates the websites landing page
And     User navigate an "<item>" listed in home page
When    User clicks the add to cart button
And     "<item>" should be added to cart
And     User clicks Delete Item

#Then    confirmation popup should appear
And    "<item>" should be remove in the cart
And     Total Price should not display

Examples:
| item               | 
| Samsung galaxy s6  |

	
	
Scenario Outline: User should able to place an order using registered user
Given    User is logged-in to website using "<username>" and "<password>"
And      User navigate an "<item>" listed in home page
And      User clicks the add to cart button
And      "<message>" message should appear
And      User navigate Cart page
When     User clicks on Place order button
And      Place Order details should appear with "<totalPrice>" total price
And      User supply fields "<name>" , "<country>" , "<city>" , "<creditCard>" , "<month>" , "<year>"
And      User clicks Purchase button


Then     Thank you pop-up message should appear
And      Clicking OK should redirect the user in the home page


Examples:
|username   |password  |message        |totalPrice    |item                | name    | country      | city     | creditCard        | month | year |
|htest5     |123       |Product added. |360           |Samsung galaxy s6   | herald  | Philippines  | Navotas  | 4242424242424242  | 03    | 2025 |
	

Scenario Outline: User should able to place an order using anonymous user

Given    User navigates the websites landing page
And      User navigate an "<item>" listed in home page
And      User clicks the add to cart button
And      "<message>" message should appear
And      User navigate Cart page
When     User clicks on Place order button
And      Place Order details should appear with "<totalPrice>" total price
And      User supply fields "<name>" , "<country>" , "<city>" , "<creditCard>" , "<month>" , "<year>"
And      User clicks Purchase button

And     Thank you pop-up message should appear
And      Clicking OK should redirect the user in the home page


Examples:
|message        |totalPrice    |item                | name    | country      | city     | creditCard        | month | year |
|Product added  |360           |Samsung galaxy s6   | herald  | Philippines  | Navotas  | 4242424242424242  | 03    | 2025 |

	