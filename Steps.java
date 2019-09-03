package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

WebDriver driver;
By username = By.id("Email");
By password = By.id("Password");
By loginbutton = By.id("btSignIn");
By ClickMenuLogoutElement = By.id("menu-user-log-out");

//Open chrome browser and navigating to the system
@Given("^Opend browser and start application$")
public void opend_browser_and_start_application() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "F:\\Space Genius tutorial\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://dev-sg.smartreservationservices.com/Admin");
   
}


//Entering the username and Password to login to system
@When("^Enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
public void enter_username_and_password(String UserName, String Password) throws Throwable {
	
	Thread.sleep(5000);
	driver.findElement(username).sendKeys(UserName);
	driver.findElement(password).sendKeys(Password);
	driver.findElement(loginbutton).click();
	Thread.sleep(5000);
}


//Verifying the Home page is displayed successful
@Then("^Verify the home page$")
public void verify_the_home_page() throws Throwable {
	String title = "Welcome to Space Genius";
    Assert.assertTrue("Home Page is not loaded", title.equals(driver.findElement(By.xpath("//div[contains(@class, 'ribbon-top')]/h4")).getText()));
    
}

//Clicking on the user name panel
@Then("^Click on user name$")
public void click_on_user_name() throws Throwable {
	Thread.sleep(5000);
	driver.findElement(By.id("navbar-user-caret-down")).click();
    Thread.sleep(5000);
}

//Clicking on the logout page
@Then("^Click Logout$")
public void click_Logout() throws Throwable {
	driver.findElement(ClickMenuLogoutElement).click();
	String title = "Please sign into your account";
	Assert.assertTrue("Looged out was not successfull", title.equals(driver.findElement(By.xpath("//div[contains(@class, 'col-sm-12')]/p")).getText()));
}


//Verify the error message when username and password is wrong
@Then("^Verify the Error message when both username and password is wrong$")
public void verify_the_Error_message() throws Throwable {
	Thread.sleep(5000);
	String title = "Email Address or Password is incorrect.";
	System.out.print(driver.findElement(By.cssSelector("div.container.body-content.reservation-body > form > div:nth-child(2) > div > div > ul > li")).getText());
	Assert.assertTrue("Error message missing", title.equals(driver.findElement(By.cssSelector("div.container.body-content.reservation-body > form > div:nth-child(2) > div > div > ul > li")).getText()));
}

@Then("^Verify the error message when \"([^\"]*)\" is empty$")
public void verify_the_message(String fieldName) throws Throwable {
	Thread.sleep(5000);
	if(fieldName.equals("username")){
		System.out.print(driver.findElement(By.id("Email-error")).getText());
		Assert.assertTrue("Error message is not displayed when no username", driver.findElement(By.id("Email-error")).getText().contains("Please provide your email address"));
	}
	else if(fieldName.equals("password")){
	Assert.assertTrue("Error message is not displayed when no password", driver.findElement(By.id("Password-error")).getText().contains("Please provide your password"));
	}
}



@Then("^Close the application$")
public void close_the_application() throws Throwable {
    driver.quit();
}


}
