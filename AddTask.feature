Feature: Registration 

Scenario: Test Add To-Do 
	Given I am on the To-Do-List Applicaiton Page  
	 And I click on the Add Task button 
	 And I enter the task name
	 And I select the Check Box
	 And I click on Add button
	Then New task is added to my To-Do List
	 And I close the browser 
