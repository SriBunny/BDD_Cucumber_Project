@Testing
Feature: Automating goibibo site 1
  Scenario Outline: Performing One way trip flow
    Given I launch goibibo site
    When I enter "<From>" and "<To>" places
    And I enter departure date and passesnger details
    And I verify for price up arrow and get the flight details
    And I enter book button
    And I veriy the filght details in review page and search results page are same.

    Examples: 
      | From  	  | To  	  |
      | Hyderabad | Bengaluru |