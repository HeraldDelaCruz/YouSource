Feature: Check Home Page Functionality
  Carousel should work display image per category
  Categories should be displayed in Home Page
  Item details should be display in Home Page
  
as a user ,  I view all the available items
 - Carousel slider
    -- Display each category
 - Category selection
    -- Phone 
    -- Laptaps
    -- Monitors
 - Display for each item
    -- Image
    -- Model
    -- Price ($)
    -- Description / Specs

Background: 
Given   User navigates the websites landing page

Scenario Outline: Verify Carousel Image if display an item per category
When    User checks the "<category Image slide>" in Carousel 

Then    "<image>" should be displayed

Examples:
|category Image slide          |image    | 
|First slide                   |Phone    |
|Second slide                  |Laptop   |
|Third slide                   |Monitor  |



Scenario Outline: Verify Category Selection section is displayed in the Home Page
When    User checks the category selection section

Then    Categories should be displayed

	

    