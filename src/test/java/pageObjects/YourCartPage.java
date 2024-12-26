package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage {
    @FindBy(css = "#checkout")
    WebElement checkoutButton;
    @FindBy(css = "#remove-sauce-labs-backpack")
    WebElement removeButton;
    @FindBy(css = "#continue-shopping")
    WebElement continueShoppingButton;

    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    public void checkOut() throws InterruptedException {
        click(checkoutButton);
        sleep(1500);
    }

//    public void removeProduce() {
//        click(driver.findElement(By.cssSelector("")));
//    }

    public void continueShopping() {
        click(continueShoppingButton);
    }
}
