import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;
import java.util.function.Supplier;

public class EditTaskTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    public static String editTaskButtonSelector = "#in-progress > app-card > mat-card > mat-card-actions > button";
    public static String updateTaskButtonSelector = "#mat-dialog-0 > app-edit-task > form > mat-dialog-actions > button:nth-child(2)";

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
    public void editTask() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.get("http://localhost:4200/");

        waitUntilElement(By.cssSelector(editTaskButtonSelector));
        driver.findElement(By.cssSelector(editTaskButtonSelector)).click();
        driver.findElement(By.id("mat-input-0")).click();
        driver.findElement(By.id("mat-input-0")).sendKeys("Promena naziva taska");
        driver.findElement(By.id("mat-select-value-1")).click();
        driver.findElement(By.cssSelector("#mat-option-0 > .mat-option-text")).click();
        driver.findElement(By.id("mat-input-1")).click();
        driver.findElement(By.id("mat-input-1")).clear();
        driver.findElement(By.id("mat-input-1")).sendKeys("Jon Doe 1, Jon Doe 2");
        driver.findElement(By.cssSelector(".mat-chip-remove:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".mat-dialog-actions")).click();
        waitUntilElement(By.cssSelector(updateTaskButtonSelector));
        driver.findElement(By.cssSelector(updateTaskButtonSelector)).click();
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
