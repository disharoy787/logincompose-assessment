package cucumberpackage1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefinition {

	WebDriver driver;

	
	@Given("url should be open")
	public void url_should_be_open() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DishaRoy\\chromedriver.exe");

	   driver = new ChromeDriver();

		driver.get("http://elearningm1.upskills.in/");

	}

	@When("Enter valid name {string}")
	public void enter_valid_name(String string) throws InterruptedException {
		System.out.println("Enter valid name");
		driver.findElement(By.xpath("//input[@id='login']")).sendKeys(string);
		Thread.sleep(3000);

	}
	@When("Enter valid password {string}")
	public void enter_valid_password(String string) throws InterruptedException {
		System.out.println("Enter valid password");
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys(string);
		 Thread.sleep(3000); 
	    
	}
	@When("click on login button")
	public void click_on_login_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[@name='submitAuth']")).click();
		 Thread.sleep(2000); 
		 
		
	}
	@Then("login success {string}")
	public void login_success(String string) throws InterruptedException {
		Thread.sleep(3000);
        System.out.println("insdie login success method");
        String expected =driver.findElement(By.xpath("(//*[text()='disha roy'])[3]")).getText();
        String actual=string;
        Assert.assertEquals(expected, actual);
        Thread.sleep(3000);
        }
	@When("Click on the compose button")
	public void click_on_the_compose_button() throws InterruptedException {
		System.out.println("inside compose link method");
        driver.findElement(By.xpath("//*[@id='profileCollapse']/div/ul/li[2]/a")).click();
        Thread.sleep(2000);
	}
	@When("Enter mail id")
	public void enter_mail_id() throws InterruptedException {
		WebElement dd = driver.findElement(By.xpath("//*[@id='compose_message']/fieldset/div[1]/div[1]/span/span[1]/span/ul/li/input"));
        dd.sendKeys("naveen");
        Thread.sleep(2000);
        dd.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
	}
	@When("Enter subject")
	public void enter_subject() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='compose_message_title']")).sendKeys("Test Mail");
        Thread.sleep(2000);    	
	}
	@When("Enter the message")
	public void enter_the_message() throws InterruptedException {
		System.out.println("inside message content method");
        WebElement frm = driver.findElement(By.xpath("//*[@id='cke_1_contents']/iframe"));
        Thread.sleep(2000);
        driver.switchTo().frame(frm);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//html//body[@contenteditable='true']")).sendKeys("Test Message from disha");
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
	}
	@When("Click on the send button")
	public void click_on_the_send_button() throws InterruptedException {
		Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='compose_message_compose']")).click();
        Thread.sleep(2000); 
	}
	@Then("Message sent successfully")
	public void message_sent_successfully() throws InterruptedException {
		Thread.sleep(2000);    
        String expected =driver.findElement(By.xpath("//*[@id=\"cm-content\"]/div/div[2]/div/div[contains(text(),'The message has been sent')]")).getText();
        System.out.println(expected);
        String actual="The message has been sent";
        Assert.assertTrue(expected.contains(actual));
        driver.close();
	}
	}

