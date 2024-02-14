package udemy.selenium.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import udemy.selenium.pom.base.BasePage;
public class CartPage extends BasePage {
   /* private final By productName=By.cssSelector("td[class='product-name'] a");
    private final  By checkoutBtn=By.cssSelector(".checkout-button.button.alt.wc-forward");*/
    // using page factory
    @FindBy(css = "td[class='product-name'] a") private WebElement productName;
    @FindBy(how = How.CSS,using = ".checkout-button.button.alt.wc-forward") @CacheLookup
    private WebElement checkoutBtn;
    public CartPage(WebDriver driver) {
        super(driver);
        //initialize the elements
        PageFactory.initElements(driver,this);
    }
    public String getProductName(){
        //return driver.findElement(productName).getText();
       return wait.until(ExpectedConditions.visibilityOf(productName)).getText(); //cannot use beacuse used for assertion
    }
    public  CheckoutPage clickCheckoutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
        //driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }
}
