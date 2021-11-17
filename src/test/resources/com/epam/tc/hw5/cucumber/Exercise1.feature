Feature: Exercise One

  Scenario: Elements Page test
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    Then I logged as user on Index page
    When I click on "Service" button in Header
    And I click on 'Different Elements' button in Service dropdown
    Then The 'Elements Page' page should be opened
    And 4 'checkboxes' should contain following values in 'checkboxes' section on Elements Page:
      | Checkboxes names |
      | Water            |
      | Earth            |
      | Wind             |
      | Fire             |
    And 4 'radio' should contain following values in 'radio' section on Elements Page:
      | Radio names |
      | Gold        |
      | Silver      |
      | Bronze      |
      | Selen       |
    And 1 dropdown should contain values in dropdown section on Elements Page:
      | Options |
      | Red     |
      | Green   |
      | Blue    |
      | Yellow  |
    When I click on 'Water' in 'checkboxes' section on the Elements Page
    Then 'Water' should be displayed as selected in 'checkboxes' section on the Elements Page
    When I click on 'Wind' in 'checkboxes' section on the Elements Page
    Then 'Wind' should be displayed as selected in 'checkboxes' section on the Elements Page
    When I click on 'Selen' in 'radio' section on the Elements Page
    Then 'Selen' should be displayed as selected in 'radio' section on the Elements Page
    When I click on value 'Yellow' in the droplist on the Elements page
    Then 1 log row has 'Colors: value changed to Yellow' text in log section
    When I click on 'Water' in 'checkboxes' section on the Elements Page
    And I click on 'Water' in 'checkboxes' section on the Elements Page
    And I click on 'Wind' in 'checkboxes' section on the Elements Page
    And I click on 'Wind' in 'checkboxes' section on the Elements Page
    And I click on 'Earth' in 'checkboxes' section on the Elements Page
    And I click on 'Earth' in 'checkboxes' section on the Elements Page
    And I click on 'Fire' in 'checkboxes' section on the Elements Page
    And I click on 'Fire' in 'checkboxes' section on the Elements Page
    Then Log screen should contain '8' lines:
      | Log                               |
      | Fire: condition changed to false  |
      | Fire: condition changed to true   |
      | Earth: condition changed to false |
      | Earth: condition changed to true  |
      | Wind: condition changed to true   |
      | Wind: condition changed to false  |
      | Water: condition changed to true  |
      | Water: condition changed to false |
    When I click on 'Silver' in 'radio' section on the Elements Page
    And I click on 'Gold' in 'radio' section on the Elements Page
    And I click on 'Bronze' in 'radio' section on the Elements Page
    And I click on 'Selen' in 'radio' section on the Elements Page
    Then Log screen should contain '4' lines:
      | Log                            |
      | metal: value changed to Selen  |
      | metal: value changed to Bronze |
      | metal: value changed to Gold   |
      | metal: value changed to Silver |
    When I click on value 'Green' in the droplist on the Elements page
    And I click on value 'Yellow' in the droplist on the Elements page
    And I click on value 'Red' in the droplist on the Elements page
    And I click on value 'Blue' in the droplist on the Elements page
    Then Log screen should contain '4' lines:
      | Log                             |
      | Colors: value changed to Blue   |
      | Colors: value changed to Red    |
      | Colors: value changed to Yellow |
      | Colors: value changed to Green  |

