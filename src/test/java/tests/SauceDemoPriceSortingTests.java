package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SauceDemoPriceSortingTests {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\PT-Snehal\\IdeaProjects\\Guru99EcomProject\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");

        // Log in
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Test
    public void verifyPriceOrderHighToLow() throws InterruptedException {
        // Wait for the page to load
        Thread.sleep(2000);

        // Extract prices
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        List<Double> prices = new ArrayList<>();

        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "");
            prices.add(Double.parseDouble(priceText));
        }

        // Sort prices in descending order
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices, Collections.reverseOrder());

        // Verify that the displayed prices are in high to low order
        Assert.assertEquals(prices, sortedPrices, "The prices are not sorted from high to low!");
    }

    @AfterMethod
    public void tearDown() {
        // Wait before closing the driver
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
