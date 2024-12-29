package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ProductsPage extends BasePage {
    @FindBy(css = ".shopping_cart_link")
    WebElement shoppingCartButton;
    @FindBy(css = ".title")
    WebElement productsTitleLabel;
    @FindBy(css = "[class='product_sort_container']")
    WebElement sortDropDown;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    //addToCart function that based on clicking the "Add to cart" button, from the main page
    public void addToCart(String name) {
        List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item"));
        for (WebElement el : list) {
            WebElement titleEl = el.findElement(By.cssSelector(".inventory_item_name"));
            if (getText(titleEl).equalsIgnoreCase(name)) {
                WebElement addBtn = el.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
                click(addBtn);
                break;
            }
        }
        click(shoppingCartButton);
    }

    @Step("Select a product by providing the product name")
    public void selectProduct(String name) {
        List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item_name"));
        for (WebElement el : list) {
            if (getText(el).equalsIgnoreCase(name)) {
                click(el);
                break;
            }
        }
    }

    public void openCart() {
        click(shoppingCartButton);
    }

    @Step("Verify the page title")
    public void verifyPageTitle(String expected) {
        waitForElement(productsTitleLabel);
        String actual = getText(productsTitleLabel);
        Assert.assertEquals(expected, actual);
    }

    @Step("sort by one of the options")
    public void sortByOption(String optionText) {
        Select select = new Select(sortDropDown);
        select.selectByVisibleText(optionText);
        sleep(1500);// Sort using visible text of the option
    }
}



