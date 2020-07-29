@Testing
Feature: Automating goibibo site 2
  Scenario Outline: Performing Round trip flow
    Given I launch goibibo site
    Then I enter round trip
    When Enter "<From>" and "<To>" places
    And I enter departure date and passesnger details
    And I verify for price up arrow and get the flight details return
    And I enter book button
    And I veriy the filght details in review page and search results page are same return.

    Examples: 
      | From  	  | To 		  |
      | Hyderabad | Bengaluru |