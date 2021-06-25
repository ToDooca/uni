import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;
import java.util.function.Supplier;

public class DeleteTaskTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    public static String firstXButtonSelector = "#to-do > .cdk-drag:nth-child(2) .mat-icon";
    public static String firstDelTaskButtonSelector = ".cdk-focused > .mat-button-wrapper";
    public static String secondXButtonSelector = ".cdk-drag:nth-child(1) .mat-card-content:nth-child(1) > .mat-icon";
    public static String secondDelTaskButtonSelector = ".cdk-focused > .mat-button-wrapper";

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
    public void deleteTask() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.get("http://localhost:4200/");

        waitUntilElement(By.cssSelector(firstXButtonSelector));
        driver.findElement(By.cssSelector(firstXButtonSelector)).click();

        waitUntilElement(By.cssSelector(firstDelTaskButtonSelector));
        driver.findElement(By.cssSelector(firstDelTaskButtonSelector)).click();

        waitUntilElement(By.cssSelector(secondXButtonSelector));
        driver.findElement(By.cssSelector(secondXButtonSelector)).click();

        waitUntilElement(By.cssSelector(secondDelTaskButtonSelector));
        driver.findElement(By.cssSelector(secondDelTaskButtonSelector)).click();

//        driver.findElement(By.cssSelector("#to-do > .cdk-drag:nth-child(2) .mat-icon")).click();
//        driver.findElement(By.cssSelector(".cdk-focused > .mat-button-wrapper")).click();
//        driver.findElement(By.cssSelector(".cdk-drag:nth-child(1) .mat-card-content:nth-child(1) > .mat-icon")).click();
//        driver.findElement(By.cssSelector(".cdk-focused > .mat-button-wrapper")).click();
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
