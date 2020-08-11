Narrative:
  As a business owner
  I want to sell coffee
  So that I earn money

Feature: F1

  @smoke
  Scenario: Buy coffee declarative

    Given coffee machine is ready for an order
    When Customer order a cup of 'Latte'
    Then Customer get a cap of 'Latte'


  Scenario: Buy coffee imperative
    Given Coffee machine has enough 'Coffee' in the machine
    And Coffee machine has enough 'Milk' in the machine
    And Coffee machine has enough 'Water' in the machine
    And Coffee machine in 'Ready' status
    When Customer have deposited '6' dollar
    And Customer choose coffee type 'Latte'
    And Customer choose coffee size 'Huge'
    And Customer press the Start button
    Then Customer get a cap of coffee with params:
      | type  | size |
      | Latte | Huge |

