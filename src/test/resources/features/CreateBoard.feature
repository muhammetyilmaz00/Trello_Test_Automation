@trello @createBoard
Feature: Trello Board Creation

  @createBoardViaAPI @UI
  Scenario: Create a new Trello board with a valid name through the API and check it out on the UI
    Given I create a Trello board named "Cross-Test Board via API" via the API
    When I log into Trello via the UI
    Then I check the board "Cross-Test Board via API" is on the Trello homepage
    And I check the board is retrievable by its ID using the API
    And I delete the board

  @createBoardViaUI @UI
  Scenario: Create a new Trello board with a valid name through the UI and check it out on the API
    Given I log into Trello via the UI
    And I create a Trello board named "Cross-Test Board via UI" via the UI
    Then I check the board "Cross-Test Board via UI" is visible on the Trello homepage
    And I check the board is retrievable by its ID using the API
    And I delete the board
