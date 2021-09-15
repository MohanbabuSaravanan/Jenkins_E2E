package pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	By s=By.cssSelector(".sumome-react-wysiwyg-move-handle");
	By signin= By.cssSelector("a[href*='sign_in']");
	By email= By.cssSelector("input[id='user_email']");
	By password=By.cssSelector("input[type='password']");
	By login=By.cssSelector("[value='Log In']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public WebElement Popup() {
		return driver.findElement(s);
	}
	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement clickLogin() {
		return driver.findElement(login);
	}
	
}

