Feature: Checkoutpage checkout functionality

  Scenario: Checkout product
    Given when I am on the store page
    When user adds products in the cart
    Then I should see the proceed to checkout button cart page
    Then User proceed to checkoutpage
    Then User fills the checkout details and place the order
    Then User verify the order confirmation message
