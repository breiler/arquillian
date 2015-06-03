Feature: Adding books to cart
  As a customer
  I want to add books to a cart
  So I can see the total price for the order

  Background: An empty custmer cart
    Given an empty cart

  Scenario: Adding two books
    Given a book with title "Spelaren", author "Harlan Coben" and price 120
    Given a book with title "Bluffen", author "Unni Drougge" and price 100
    When customer adds book with title 'Spelaren' to cart
    When customer adds book with title 'Bluffen' to cart
    Then the total cost for all items in cart is 220

  Scenario: Adding three books
    Given a book with title "Spelaren", author "Harlan Coben" and price 120
    Given a book with title "Bluffen", author "Unni Drougge" and price 100
    When customer adds book with title 'Spelaren' to cart
    When customer adds book with title 'Bluffen' to cart
    When customer adds book with title 'Bluffen' to cart
    Then the total cost for all items in cart is 320