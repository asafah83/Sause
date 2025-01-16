package pages;

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
    private WebElement shoppingCartButton;
    @FindBy(css = ".title")
    private WebElement productsTitleLabel;
    @FindBy(css = "[class='product_sort_container']")
    private WebElement sortDropDown;
    @FindBy(css = "#react-burger-cross-btn")
    private WebElement burgerMenu;
    @FindBy(css = ".MuiTypography-root.MuiTypography-body1.css-1mz1i0z")
    private WebElement validationTextOfAboutPage;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void selectFromMenu(String optionToSelect) {
        click(burgerMenu);
        //selectSpecificValueFromList("[class='bm-menu'] a", menuOption);

        List<WebElement> menuOptions = driver.findElements(By.cssSelector("[class='bm-menu'] a")); // Adjust selector as needed

        boolean optionFound = false;

        for (WebElement option : menuOptions) {
            String menuText = option.getText().trim();

            // Use switch-case to determine which option to select
            switch (menuText) {
                case "All Items":
                    if (menuText.equals(optionToSelect)) {
                        option.click();
                        System.out.println("Navigated to Home page.");
                        optionFound = true;
                    }
                    break;

                case "About":
                    if (menuText.equals(optionToSelect)) {
                        option.click();
                        System.out.println("Navigated to About page.");
                        optionFound = true;
                    }
                    break;

                case "Logout":
                    if (menuText.equals(optionToSelect)) {
                        option.click();
                        System.out.println("Navigated to Services page.");
                        optionFound = true;
                    }
                    break;

                case "Reset Aoo State":
                    if (menuText.equals(optionToSelect)) {
                        option.click();
                        System.out.println("Navigated to Contact page.");
                        optionFound = true;
                    }
                    break;

                default:
                    // Handle unexpected or unmatched options
                    System.out.println("Unknown menu option: " + menuText);
            }

            if (optionFound) {
                break; // Exit the loop once the desired option is found
            }
        }

        if (!optionFound) {
            System.out.println("Menu option \"" + optionToSelect + "\" not found.");
        }
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



