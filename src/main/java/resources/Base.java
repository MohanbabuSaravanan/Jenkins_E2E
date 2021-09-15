package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
//import javax.imageio.ImageIO;

public class Base {

	//private static final String ShootingStrategies = null;
	public static WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Mohan.S\\eclipse-workspace\\E2Eproject\\src\\main\\java\\resources\\config.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	        driver=new ChromeDriver();
	        System.out.println(browserName);
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
	        driver=new FirefoxDriver();
		}
		else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver","C:\\edgedriver_win64\\msedgedriver.exe");
	        driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public void getScreenshot(String result) throws IOException {//WebDriver webdriver,String fileWithPath
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Pictures\\pic.png"));
		
		//Convert web driver object to TakeScreenshot
        //TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        //Call getScreenshotAs method to create image file
        //File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        //File DestFile=new File(fileWithPath);
        //Copy file at destination
        //FileUtils.copyFile(SrcFile,new File("C:\\Drivers\\screenshot.png"));
	    
	}
	/*public void getScreenshot() {
	Screenshot screenshot = new AShot().takeScreenshot(driver);
	//Object ShootingStrategies;
	screenshot = new AShot().shootingStrategy((ShootingStrategies).viewportPasting(1000)).takeScreenshot(driver);

	ImageIO.write(screenshot.getImage(), "png", new File("C:\\Drivers\\screenshot.png"));
	}*/

}
