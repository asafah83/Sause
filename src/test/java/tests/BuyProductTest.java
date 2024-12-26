package tests;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pageObjects.*;

public class BuyProductTest extends BaseTest{
   // WebDriver driver;
    //   public static void main(String[] args) throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com/");

    @Test
    @Step("Login and verify its the Products page")
    public void tc1Negative() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectProduct("Sauce Labs Fleece Jacket");
        productsPage.verifyTitlePage("Products");
    }

    @Test
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
        checkoutOverviewPage.finish();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutCompletePage.printAllMessage();
        checkoutCompletePage.backToHome();

        productsPage.verifyTitlePage("Products");
    }


}

