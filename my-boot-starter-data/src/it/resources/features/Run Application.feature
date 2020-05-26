#language: en
@SystemTest
Feature: Run Application

  Scenario: Send and receive message
    Given I send the message "Hello World"
    Then the returned message equals "Hello World"