package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pageObjects.*;

public class BuyProductTest extends BaseTest {
    // WebDriver driver;
    //   public static void main(String[] args) throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com/");

    @Test
    @Description("Test 1 - Login to the website and verify its the correct page")
    public void tc1Negative() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.verifyPageTitle("Products");
    }

    @Test
    @Description("An E2E test: login > select product > add to cart > buy the product")
    public void tc2PositiveTestE2E() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectProduct("Sauce Labs Fleece Jacket");

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();

        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.checkOut();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillInfoAndContinue("Asaf", "Aharoni", "12345");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.verifyPageTitle("Checkout: Overview");
        checkoutOverviewPage.clickFinish();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
checkoutOverviewPage.verifyPageTitle("Checkout: Complete!");
        checkoutCompletePage.backToHome();

        productsPage.verifyPageTitle("Products");

      //  productsPage.verifyTitlePage("Products");
    }

    @Test
    @Description("This test check the functionality of the sort")
    public void tc3Sorting() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.sortByOption("Price (low to high)");
    }
}

