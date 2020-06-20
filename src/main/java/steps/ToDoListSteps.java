package steps;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ToDoListSteps {

	WebDriver driver = null;
	String taskName = "Task  Added from Cucumber Script " + currentDateTime();

	@Given("^I am on the To-Do-List Application Page$")
	public void i_am_on_the_To_Do_List_Application_Page() throws Throwable {
		String url = "https://chetanpaliwal22.github.io/To-Do-List-App/";
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Given("^I click on the Add Task button$")
	public void i_click_on_the_Add_Task_button() throws Throwable {
		pause(2000);
		WebElement addTaskButton = driver.findElement(By.xpath(".//button[@class='btn btn-outline-success']"));
		addTaskButton.click();
	}

	@Given("^I enter the task name$")
	public void i_enter_the_task_name() throws Throwable {
		pause(2000);
		WebElement nameField = driver.findElement(By.xpath(".//input[@id='formTask']"));
		nameField.sendKeys(taskName);
	}

	@Given("^I select the Check Box$")
	public void i_select_the_Check_Box() throws Throwable {
		pause(2000);
		WebElement checkBox = driver.findElement(By.xpath("//*[@id='formBasicCheckbox']"));
		checkBox.click();
	}

	@Given("^I click on Add button$")
	public void i_click_on_Add_button() throws Throwable {
		pause(2000);
		WebElement addTaskButton = driver.findElement(By.xpath(".//button[@class='btn btn-primary']"));
		addTaskButton.click();
	}

	@Then("^New task is added to my To-Do List$")
	public void new_task_is_added_to_my_To_Do_List() throws Throwable {
		pause(3000);
		boolean taskFlag = driver.getPageSource().contains(taskName);
		assertEquals(true, taskFlag);
	}

	@Then("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
		driver.close();
	}

	public void pause(Integer milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String currentDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return formatter.format(date);
	}
}
