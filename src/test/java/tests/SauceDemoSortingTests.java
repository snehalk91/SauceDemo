
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

public class SauceDemoSortingTests {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Setup GeckoDriver for Firefox
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Navigate to the SauceDemo login page
        driver.get("https://www.saucedemo.com/");

        // Login to the website
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void verifySortingZA() {
        // Click the sorting dropdown and choose Z to A
        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        sortDropdown.click();
        sortDropdown.findElement(By.xpath("//option[. = 'Name (Z to A)']")).click();

        // Get all the product names into a list
        List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
        List<String> actualProductNames = new ArrayList<>();

        for (WebElement product : productNames) {
            actualProductNames.add(product.getText());
        }

        // Create a copy of the list and sort it manually from Z to A
        List<String> sortedProductNames = new ArrayList<>(actualProductNames);
        Collections.sort(sortedProductNames, Collections.reverseOrder());

        // Verify that the actual order matches the sorted (Z to A) order
        Assert.assertEquals(actualProductNames, sortedProductNames, "Products are not sorted from Z to A");
    }

    @AfterMethod
    public void teardown() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

