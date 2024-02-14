package udemy.selenium.pom.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import udemy.selenium.pom.base.BasePage;
import udemy.selenium.pom.pages.CartPage;

public class ProductThumbnail extends BasePage {
    private  final By viewCartLink=By.cssSelector("a[title='View cart']");

    public ProductThumbnail(WebDriver driver) {
        super(driver);
    }

    private final By getAddToCartBtnElement(String productName){
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }
    public ProductThumbnail clickAddToCartBtn(String productName){
        By addToCartBtn= getAddToCartBtnElement(productName);
        // driver.findElement(addToCartBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        return this;
    }
    public CartPage clickViewCart(){
        // driver.findElement(viewCartLink).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
        return new CartPage(driver);
    }
}
