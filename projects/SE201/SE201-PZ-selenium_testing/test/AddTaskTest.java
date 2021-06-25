import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.*;
import java.util.function.Supplier;

public class AddTaskTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    public static String addTaskButtonSelector = "#cdk-drop-list-0 > div:nth-child(1) > div:nth-child(3) > button";
    public static String saveColorButtonSelector = "#mat-dialog-1 > app-color-picker-dialog > button.mat-focus-indicator.mat-raised-button.mat-button-base.mat-primary";
    public static String addbuttonSelector = "#mat-dialog-0 > app-edit-task > form > mat-dialog-actions > button:nth-child(2)";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
//        driver.quit();
    }

    @Test
    public void addTask() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.get("http://localhost:4200/");
        {
            WebElement element = driver.findElement(By.cssSelector(addTaskButtonSelector));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        waitUntilElement(By.cssSelector(addTaskButtonSelector));
        driver.findElement(By.cssSelector(addTaskButtonSelector)).click();
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.id("mat-input-0")).sendKeys("Testiranje dodavanja novog taska");
        driver.findElement(By.cssSelector(".mat-select-placeholder")).click();
        driver.findElement(By.cssSelector("#mat-option-1 > .mat-option-text")).click();
        driver.findElement(By.id("mat-input-1")).click();
        driver.findElement(By.id("mat-input-1")).sendKeys("Dusan Stankovic, Marko Markovic, Petar Petrovic");
        driver.findElement(By.id("mat-input-2")).click();
        driver.findElement(By.id("mat-input-2")).sendKeys("http://blog.inf.ed.ac.uk/atate/files/2016/07/video-test-pattern-16x10-2560x1600.jpg");
        driver.findElement(By.id("mat-input-3")).click();
        driver.findElement(By.id("mat-input-3")).sendKeys("Testiranje dodavanja novog taska na ToDo listu");
        driver.findElement(By.id("mat-chip-list-input-0")).click();
        driver.findElement(By.id("mat-chip-list-input-0")).sendKeys("test red tag");
        driver.findElement(By.id("mat-chip-list-input-0")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector(".mat-icon:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".wrap > input")).click();
        driver.findElement(By.cssSelector(".wrap > input")).sendKeys("#FF0000");
        driver.findElement(By.cssSelector(".wrap > input")).sendKeys(Keys.ENTER);
        {
            WebElement element = driver.findElement(By.cssSelector(saveColorButtonSelector));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(saveColorButtonSelector)).click();
        driver.findElement(By.cssSelector(addbuttonSelector)).click();
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
