package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductPage extends BasePage {
    @FindBy(css = "#add-to-cart")
    WebElement addToCartButton;
    @FindBy(css = ".shopping_cart_link")
    WebElement shoppingCartButton;
    @FindBy(css = "#back-to-products")
    WebElement backToProductButton;
    @FindBy(css = "[class='inventory_details_name large_size']")
    WebElement productTitle;
    @FindBy(css = "[class='inventory_details_desc large_size']")
    WebElement productDescription;
    @FindBy(css = "[class='inventory_details_price']")
    WebElement productPrice;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Add the product to the shopping cart")
    public void addProductToCart() throws InterruptedException {
        click(addToCartButton);
        sleep(1000);
    }

    @Step("Move to the shopping cart page")
    public void movingToShoppingCartPage() {
        click(shoppingCartButton);
    }

    public void backToProductsPage() {
        click(backToProductButton);
    }

    public void verifyPrice(String expectedPrice) {
        String actualPrice = getText(productPrice);
        Assert.assertEquals(actualPrice, expectedPrice);
    }

    public void verifyProductTitle(String expectedProductTitle) {
        String actualProductTitle = getText(productTitle);
        Assert.assertEquals(actualProductTitle, expectedProductTitle);
    }

    public void verifyProductDescription(String expectedProductDescription) {
        String actualProductDescription = getText(productDescription);
        Assert.assertEquals(actualProductDescription, expectedProductDescription);
    }

}
