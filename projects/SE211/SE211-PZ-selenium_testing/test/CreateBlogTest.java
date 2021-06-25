import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.util.function.Supplier;

public class CreateBlogTest {
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
  public void newblog() {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver.get("http://localhost:3000/blog/");
    driver.manage().window().maximize();
    {
      WebElement element = driver.findElement(By.cssSelector(".material-icons"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    waitUntilElement(By.cssSelector(".material-icons"));
    driver.findElement(By.cssSelector(".material-icons")).click();

    JavascriptExecutor executor = (JavascriptExecutor)driver;
    WebElement title = driver.findElement(By.cssSelector(".col > .validate"));
    executor.executeScript("arguments[0].click();", title);
    driver.findElement(By.cssSelector(".col > .validate")).sendKeys("Naslov");

    WebElement slug = driver.findElement(By.cssSelector(".col > .input-field > .validate"));
    executor.executeScript("arguments[0].click();", slug);
    driver.findElement(By.cssSelector(".col > .input-field > .validate")).sendKeys("test");

    WebElement excerpt = driver.findElement(By.cssSelector(".materialize-textarea"));
    executor.executeScript("arguments[0].click();", excerpt);
    driver.findElement(By.cssSelector(".materialize-textarea")).sendKeys("test sazetak");

    driver.findElement(By.cssSelector(".dropdown-trigger")).click();
    driver.findElement(By.cssSelector("#select-options-a398213f-a9f0-ccb6-064a-1c810c98f2c63 > span")).click();
    {
      WebElement dropdown = driver.findElement(By.cssSelector(".ng-untouched:nth-child(4)"));
      dropdown.findElement(By.xpath("//option[. = 'fashion']")).click();
    }
    waitUntilElement(By.cssSelector(".CodeMirror-scroll"));
    driver.findElement(By.cssSelector(".CodeMirror-scroll")).click();
    driver.findElement(By.cssSelector(".CodeMirror textarea")).sendKeys("test opis 123 aaaaaaaaaaaaaaa");
    driver.findElement(By.name("action")).click();
  }

  public void waitUntil(Supplier<Boolean> cb) {
    do {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } while (!cb.get());
  }

  public void waitUntilElement(By selector) {
    waitUntil(() -> {
      try {
        return driver.findElement(selector) != null;
      } catch (Exception e) {
        return false;
      }
    });
  }
}
