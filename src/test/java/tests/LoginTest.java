package tests;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    @Description("Test of success login - valid userName + valid password + verify the user in the correct page")
    public void tc2loginSuccess() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.verifyPageTitle("Product");
    }

    @Test(priority = 2)
    @Description("Test of fail login - invalid userName + valid password, and print the error message")
    public void tc1loginFailed1() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user1", "secret_sauce");
        loginPage.verifyTheErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 3)
    @Description("Test of Locked out user login - verification of message when the user locked out")
    public void tc3LockedOutLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");
        loginPage.verifyTheErrorMessage("Epic sadface: Sorry, this user has been locked out");
    }
    @Test(dataProvider = "getData")
    public void tc4_loginFailedUsingDDT(String user, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user, password);
        loginPage.verifyTheErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] myData = {
                {"user1", "123"},
                {"Asaf", "123"},
                {"Shimon", "12@#@#3"},
                {"Niv", "1sgdsdsgsd23"},
        };
        return myData;
    }
}
