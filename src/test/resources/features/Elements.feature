Feature: Interaction with Elements
  Background:
    Given Navigate to "https://demoqa.com" Site and click on "Elements" tab

  Scenario: Interaction with TextBox Element
    Given Then Click on "Text Box"
    When Enter Full Name, Email, Current and Permanent Address and Submit
      | fullName              | emailId          | currentAddress  | permanentAddress           |
      | TestName TestFullName | Selenium@bdd.com | 12 test address | 123 test permanent Address |
    Then Display Text Box Output

  Scenario: Interaction with CheckBox Element
    Given Then Click on "Check Box"
    When Expand on "Home"  node
    And Expand on "Documents"  node
    And Expand on "WorkSpace"  node
    And Check on "Angular" Check Boxes
    Then Display Check Box Output

  Scenario: Interaction with Radio Button Element
    Given Then Click on "Radio Button"
    When Click on "Yes" Radio button
    Then Display Radio Button Output

  Scenario: Interaction With WebTables - Add a record
    Given Then Click on "Web Tables"
    When Click on Add Button
    And Add Data as given below
      | firstName     | lastName | age | userEmail        | salary | department  |
      | TestFirstName | LastName | 67  | Selenium@bdd.com | 120000 | Engineering |
    Then Check If data in table

  Scenario: Interaction With Buttons
    Given Then Click on "Buttons"
    When click on "Double" Click
    Then Check Output

#  Scenario: Interaction With Buttons
#    Given Then Click on "Buttons"
#    When click on "Right" Click
#    Then Check Output
#
#  Scenario: Interaction With Buttons
#    Given Then Click on "Buttons"
#    When click on "Dynamic" Click
#    Then Check Output
#
#  Scenario: Interaction With Links
#    Given Then Click on "Links"
#    When click on "Home" Link
#    And click on "PartialLink" Link
#
#  Scenario: Interaction With Links
#    Given Then Click on "Links"
#    When click on "Created" API Link
#    And click on "NoContent" API Link
#    And click on "Moved" API Link
#    And click on "BadRequest" API Link
