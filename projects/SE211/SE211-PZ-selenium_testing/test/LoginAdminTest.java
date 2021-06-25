import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class LoginAdminTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
//    driver.quit();
  }
  @Test
  public void login() {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver.get("http://localhost:3000/login/");
    driver.manage().window().maximize();
    driver.findElement(By.cssSelector("body > app-root > login-login-form > div > div > form > div:nth-child(1) > div > input")).click();
    driver.findElement(By.cssSelector(".row:nth-child(1) > .input-field > .ng-untouched")).click();
    driver.findElement(By.cssSelector(".row:nth-child(1) > .input-field > .ng-untouched")).sendKeys("admin");
    driver.findElement(By.cssSelector(".ng-untouched")).click();
    driver.findElement(By.cssSelector(".ng-untouched")).sendKeys("admin");
    driver.findElement(By.name("action")).click();
  }
}
