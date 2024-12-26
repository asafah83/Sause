package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(css = "#add-to-cart")
    WebElement addToCartButton;
    @FindBy(css = ".shopping_cart_link")
    WebElement shoppingCartButton;
    @FindBy(css = "#back-to-products")
    WebElement backToProductButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() throws InterruptedException {
        sleep(1500);
        click(addToCartButton);
        click(shoppingCartButton);
        sleep(1500);
    }

    public void backToProductsPage() {
        click(backToProductButton);
    }
}
