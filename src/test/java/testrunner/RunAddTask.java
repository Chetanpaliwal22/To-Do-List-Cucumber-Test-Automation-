package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "C:\\Users\\cheta\\OneDrive\\Desktop\\Cucumber\\Cucumber-Test\\" }, plugin = {
		"html:target/site/cucumber-pretty",
		"json:target/cucumber.json" }, glue = { "helpers", "stepDefinitions", "steps" },
		// dryRun = true,
		monochrome = true)
public class RunAddTask {

}