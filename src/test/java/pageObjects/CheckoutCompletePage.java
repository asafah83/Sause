package pageObjects;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {
    @FindBy(css = "#back-to-products")
    WebElement backToProductButton;
//    @FindBy(css = "")
//    WebElement el;
//    @FindBy(css = "")
//    WebElement el;
//    @FindBy(css = "")
//    WebElement el;
//    @FindBy(css = "")
//    WebElement el;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
@Description("")
    public void printAllMessage() {
        String thanksMessage = getText(driver.findElement(By.cssSelector(".complete-header")));
        String orderMessage = getText(driver.findElement(By.cssSelector(".complete-text")));
        String completedMessage = getText(driver.findElement(By.cssSelector("title")));
        System.out.println(thanksMessage);
        System.out.println(orderMessage);
        System.out.println(completedMessage);
    }

    public void backToHome() throws InterruptedException {
        click(backToProductButton);
        sleep(1500);
    }
}
