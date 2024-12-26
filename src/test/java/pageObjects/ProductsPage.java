package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProductsPage extends BasePage {
    @FindBy(css = ".shopping_cart_link")
    WebElement shoppingCartButton;
    @FindBy(css = ".title")
    WebElement productsTitleLabel;
//    @FindBy(css = "")
//    WebElement el1;
//    @FindBy(css = "")
//    WebElement el1;
//    @FindBy(css = "")
//    WebElement el1;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    //addToCart function that based on clicking the "Add to cart" button, from the main page
    public void addToCart(String name) {
        List<WebElement> list = driver.findElements(By.cssSelector(""));
        for (WebElement el : list) {
            WebElement titleEl = el.findElement(By.cssSelector(""));
            if (getText(titleEl).equalsIgnoreCase(name)) {
                WebElement addBtn = el.findElement(By.cssSelector(""));
                click(addBtn);
                break;
            }
        }
    }

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

    public void verifyTitlePage(String expected) {
        String actual = getText(productsTitleLabel);
        Assert.assertEquals(expected, actual);
    }

//    public void verify1YouInProductsPage(String title) {
//        String pageTitle = driver.findElement(By.cssSelector(".title")).getText();
//        if (pageTitle.equals(title)) {
//            System.out.println("You are on the correct page");
//        } else {
//            System.out.println("Probably, you are not on the correct page");
//        }
//    }
//    public boolean isProductsPage() {
//        if (getText(productsTitleLabel).equals("Product")) {
//            return true;
//        }
//        return false;
//    }

}
