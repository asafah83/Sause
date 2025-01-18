package tests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ExcelUtils;

import java.io.IOException;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpLogin() {
        loginPage = new LoginPage(driver);
    }

    //////////////////////****** Test list ******///////////////////////////////////////////

    @Test(priority = 1)
    @Description("Test of success login - valid userName + valid password + verify the user in the correct page")
    public void tc1_loginSuccess() throws InterruptedException {
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.verifyPageTitle("Product");
    }

    @Test(priority = 2)
    @Description("Test of fail login - invalid userName + valid password, and print the error message")
    public void tc2_loginFailed1() throws InterruptedException {
        loginPage.login("standard_user1", "secret_sauce");
        loginPage.verifyTheErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 3)
    @Description("Test of Locked out user login - verification of message when the user locked out")
    public void tc3_LockedOutLogin() throws InterruptedException {
        loginPage.login("locked_out_user", "secret_sauce");
        loginPage.verifyTheErrorMessage("Epic sadface: Sorry, this user has been locked out");
    }

    @Test(dataProvider = "getData")
    public void tc4_loginFailedUsingDDT(String user, String password) throws InterruptedException {
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

    @Test
    public void tc5_testLoginWithExcelData() throws IOException, InterruptedException {
        // Load the Excel file
        String filePath = "src/test/resources/data/LoginData.xlsx";
        ExcelUtils excel = new ExcelUtils(filePath);

        // Read login data from the Excel sheet
        String username = excel.getCellData("Login", 1, 0); // Row 1, Column 0
        String password = excel.getCellData("Login", 1, 1); // Row 1, Column 1

        // Perform login
        LoginPage lp = new LoginPage(driver);
        lp.login(username, password);

        // Clean up
        excel.close();
    }
}

