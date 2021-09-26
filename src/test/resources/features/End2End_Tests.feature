Feature: Automated End2End Tests
  Description: The purpose of this feature is to test End 2 End flow of todo mvc application

  @AddNewToDo
  Scenario: As a ToDo MVC user, I should be able to add new todo
    Given I am on ToDo MVC home page
    And I see title "Vue.js • TodoMVC"
    When I enter new ToDo "todo one"
    Then verify "todo one" gets displayed
    And todo count show "1" item left
    And clicking link "All" show added item as "todo one"
    And clicking link "Active" show added item as "todo one"
    And clicking link "Completed" show no completed items

  @MarkTodoAsComplete
  Scenario:  As a ToDo MVC user, I should be able to mark todo as completed
    Given I am on ToDo MVC home page
    And I see title "Vue.js • TodoMVC"
    When I enter new ToDo "todo one"
    When I mark "todo one" as complete by clicking on checkbox next to it
    Then clicking link "Completed" show "todo one" as completed




