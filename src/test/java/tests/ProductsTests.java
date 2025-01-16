package tests;

import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

public class ProductsTests extends BaseTest {
    private LoginPage lp;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;

    @BeforeMethod
    public void setUpProductsPages() throws InterruptedException {
        // Initialize commonly used pages
        lp = new LoginPage(driver);
        lp.loginUsingValidUserDetails();
        productsPage = new ProductsPage(driver);
    }

    @Test
    @Description("Verify that the product was added properly to the shopping cart")
    public void tc1_verifyAddingProductToCart() {
        productsPage.addToCart("Sauce Labs Bike Light");
        yourCartPage = new YourCartPage(driver);
        yourCartPage.verifyPageTitle("Your Cart");
        yourCartPage.verifyTheProductExistOnCart("Sauce Labs Bike Light");
    }
}
