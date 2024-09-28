package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SauceDemoCheckoutTests {

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
    public void validateCheckoutJourney() throws InterruptedException {
        Thread.sleep(2000);

        // Add multiple items to the cart
        List<WebElement> addToCartButtons = driver.findElements(By.className("btn_inventory"));
        for (int i = 0; i < 2; i++) {
            addToCartButtons.get(i).click();
        }

        // Navigate to the cart
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();
        Thread.sleep(2000);

        // Verify that the items are in the cart
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        Assert.assertEquals(cartItems.size(), 2, "The number of items in the cart is incorrect!");

        // Click on the checkout button
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        Thread.sleep(2000);

        // Fill in the checkout information
        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        lastNameInput.sendKeys("Doe");

        WebElement zipCodeInput = driver.findElement(By.id("postal-code"));
        zipCodeInput.sendKeys("12345");

        // Click on the continue button
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
        Thread.sleep(2000);

        // Click on the finish button
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
        Thread.sleep(2000);

        // Verify that the order confirmation page is displayed
        WebElement confirmationMessage = driver.findElement(By.className("complete-header"));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Order confirmation message is not displayed!");
    }

    @AfterMethod
    public void tearDown() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
