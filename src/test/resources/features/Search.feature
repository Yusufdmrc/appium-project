@Search
Feature: Search and Selection Test Cases

  Background:
    Given User at home page

  @SearchProduct @LoginRequired
  Scenario Outline: Search for a "<product>"
    When User clicks on the search bar
    And User searches for "<product>"
    Then User verifies that products are listed
    Examples:
      | product |
      | laptop  |
