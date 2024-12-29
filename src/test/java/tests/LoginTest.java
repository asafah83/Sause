package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;


public class LoginTest extends BaseTest {
    @Test(priority = 1)
    public void tc1loginFailed1() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user1", "secret_sauce");
        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = loginPage.getErrorMessage();
        Assert.assertEquals(actual, expected);
        //  Assert.assertTrue();
    }

    @Test(priority = 2)
    public void tc2loginSuccess() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
productsPage.verifyPageTitle("Product");
    }

}
