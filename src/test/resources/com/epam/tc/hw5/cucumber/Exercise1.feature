Feature: Exercise One

  Scenario: Elements Page test
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    Then I logged as user on Index page
    When I click on "Service" button in Header
    And I click on 'Different Elements' button in Service dropdown
    Then The 'Elements Page' page should be opened
    And 4 'checkboxes' should contain following values in checkboxes section on Elements Page:
      | Checkboxes names |
      | Water            |
      | Earth            |
      | Wind             |
      | Fire             |
    And 4 'radio' should contain following values in radio section on Elements Page:
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
    When I click on 'Water' in checkboxes section on the Elements Page
    Then 'Water' should be displayed as selected in checkboxes section on the Elements Page
    When I click on 'Wind' in checkboxes section on the Elements Page
    Then 'Wind' should be displayed as selected in checkboxes section on the Elements Page
    When I click on 'Selen' in radio section on the Elements Page
    Then 'Selen' should be displayed as selected in radio section on the Elements Page
    When I click on value 'Yellow' in the droplist on the Elements page
    Then Log screen should contain '4' lines:
      | Log                              |
      | Colors: value changed to Yellow  |
      | metal: value changed to Selen    |
      | Wind: condition changed to true  |
      | Water: condition changed to true |




