@Search
Feature: Search and Selection Test Cases

  Background:
    Given User at home page

  @SearchProduct @LoginRequired
  Scenario Outline: Search for a "<product>" and open random result
    When User clicks on the search bar
    And User searches for "<product>"
    And User selects a random product from the list
    Then User checks that the product detail page opens
    Examples:
      | product   |
      | laptop    |
      | air fryer |
