Feature: Customers

  Background: Below are the comon steps for each scenarion
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User  enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard

  @sanity
  Scenario: Add a new Customer
    When User click on customers Menu
    And Click on customers Menu item
    And click on Add new
    Then User can view Add new custumer
    When user enter customer info
    And click on Save button
    Then user can view confirmation message "The new customer has been added successfully."
    And close browser

  @regression
  Scenario: Search Customer by EMAILID
    When User click on customers Menu
    And Click on customers Menu item
    And Enter customer EMail
    When Click on search button
    Then User should found Email in the Search table
    And close browser

  @regression
  Scenario: Search Customer by Name
    When User click on customers Menu
    And Click on customers Menu item
    And Enter customer FirstName
    And Enter customer LastName
    When Click on search button
    Then User should found Name in the Search table
    And close browser
