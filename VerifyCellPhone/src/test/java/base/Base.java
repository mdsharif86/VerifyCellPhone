package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
	
	
public class Base {
	public static WebDriver driver;
	static FileInputStream fis;
	public static Properties locatorProp;
	public static Properties configProp;
	@BeforeSuite
	public void setWebDriver() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\JAVA\\Driver\\chromedriver.exe");
		WebDriver driver;
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		
		fis = new FileInputStream(projectPath + "src\\test\\resources\\properties\\locators.properties");
		locatorProp = new Properties();
		locatorProp.load(fis);
		
		configProp = new Properties();
		
		fis = new FileInputStream(projectPath + "src\\test\\resources\\properties\\locators.properties");
		configProp.load(fis);
		
		if(configProp.getProperty("browser").contains("chrome")){
			System.setProperty("webdriver.chrome.driver",
			projectPath + "src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (configProp.getProperty("browser").contains("firefox")){
			System.setProperty("webdriver.gecko.driver",
					projectPath + "src\\test\\resources\\executables\\geckodriver.exe");
			driver = new ChromeDriver();
			
					
		}
		public void navigateUrl(String url) {
			Driver.get(url);
		}
		public void click(By by) {
			driver.findElement(by).click();
		}
		public void sendkeys(By xpath, String value) {
			driver.findElement(by)
		}
		
		
		
	}
	
}
