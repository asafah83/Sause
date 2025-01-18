package tests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class BuyProductTest extends BaseTest {
    private LoginPage lp;
    private ProductsPage productsPage;

    // WebDriver driver;
    //   public static void main(String[] args) throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com/");

    @BeforeMethod
    public void setUpProductsPages() {
        // Initialize commonly used pages
        lp = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    private void loginAsStandardUser() throws InterruptedException {
        lp.login("standard_user", "secret_sauce");
        productsPage.verifyPageTitle("Products"); // Verify login success
    }
//////////////////////////******* Tests list *********/////////////////////////////////////////////////////////
    @Test
    @Description("Test 1 - Login with a valid user, to the website and verify that the user is in correct page")
    public void tc1_Negative() throws InterruptedException {
        loginAsStandardUser();
    }

    @Test
    @Description("Test 2 - an E2E test: login > select product > add to cart > buy the product")
    public void tc2_PositiveTestE2E() throws InterruptedException {
        loginAsStandardUser();

        productsPage.selectProduct("Sauce Labs Fleece Jacket");

        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart();
        productPage.movingToShoppingCartPage();

        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.verifyPageTitle("Your Cart");
        yourCartPage.clickCheckOut();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);

        checkoutInformationPage.verifyPageTitle("Checkout: Your Information");
        checkoutInformationPage.fillInformation("Asaf", "Aharoni", "12345");
        checkoutInformationPage.clickContinue();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.verifyPageTitle("Checkout: Overview");
        checkoutOverviewPage.clickFinish();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutOverviewPage.verifyPageTitle("Checkout: Complete!");
        checkoutCompletePage.backToHome();

        productsPage.verifyPageTitle("Products");
    }

    @Test
    @Description("Test 3 {E2E Test} - Add a product to the cart, directly, from the Products page > complete the flow")
    public void tc3_addProductToCartFromProductsPage() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        loginAsStandardUser();
        productsPage.addToCart("Sauce Labs Onesie");
    }

//    @Test
//    @Description("This test check the Sort functionality")
//    public void tc4_Sorting() throws InterruptedException {
//        LoginPage lp = new LoginPage(driver);
//        loginAsStandardUser();
//        productsPage.sortByOption("Price (low to high)");
//    }
}

