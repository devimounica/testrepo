#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: purchase the order from the Ecommerce Website
  I want to use this template for my feature file

    Background:
    Given i landed on Ecommerce Page

  @tag2
  Scenario Outline: positive test for submitting the order
    Given logged in with <username> and <password>
    When I add product <productname> to cart
    And  Checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." messege is displayed on Confirmationpage

    Examples: 
      | username                                  |             password    | product name |
      |devimounica99@gmail.com                    |             Mounikaa@99 | ZARA COAT 3  |
  
