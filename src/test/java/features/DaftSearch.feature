Feature: Daft Website Keyword Filtering

  Background:
    Given user navigates to Daft homepage url

  @smoke
  Scenario Outline: Validate the search results after applying the "garage" keyword filter
    When user searches for county "<county>" in the input field
    And user clicks on the desired location from the dropdown suggestions
    Then search results should be displayed for this location
    When user clicks on the filter option and applies the "<filter>" filter
    Then search results should be displayed for the filter
    Examples:
      | county | filter |
      | Dublin | garage |

  @regression
  Scenario Outline: Validate the applied filter on a search result
    When user searches for county "<county>" in the input field
    And user clicks on the desired location from the dropdown suggestions
    Then search results should be displayed for this location
    When user clicks on the filter option and applies the "<filter>" filter
    Then search results should be displayed for the filter
    When user opens a search result
    Then advert description should contain the "<filter>" keyword
    Examples:
      | county | filter |
      | Dublin | garage |