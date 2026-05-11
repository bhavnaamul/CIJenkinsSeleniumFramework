Feature: Store Functionality

@smoke1
Scenario: Store page
Given when I am on the store page
Then I should see the store page title	

@regression
Scenario: Add products in Store page
Given when I am on the store page
When user adds products in the cart
Then I should see the products in add to cart link	

