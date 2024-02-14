package udemy.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import udemy.selenium.pom.base.BasePage;
import udemy.selenium.pom.pages.components.ProductThumbnail;

public class StorePage extends BasePage {
   // private  final By viewCartLink=By.cssSelector("a[title='View cart']");
    private  final  By searchFld= By.id("woocommerce-product-search-field-0");
    private final By searchBtn=By.cssSelector("button[value='Search']");
    private  final By title=By.cssSelector(".woocommerce-products-header__title.page-title");

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    // private final By addToCartBtn=By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
    private ProductThumbnail productThumbnail;
    public StorePage(WebDriver driver) {

        super(driver);
        productThumbnail=new ProductThumbnail(driver);}
  /*  public void enterTxtInSearchField(String txt){
        driver.findElement(searchFld).sendKeys(txt);
    }
    public void clickSearchBtn(){
        driver.findElement(searchBtn).click();
    }
    public String getTitle(){
        return driver.findElement(title).getText();
    }
    public void clickAddToCartBtn(){
        driver.findElement(addToCartBtn).click();
    }*/
    //builder pattern
  /*public StorePage enterTxtInSearchField(String txt){
      driver.findElement(searchFld).sendKeys(txt);
      return new StorePage(driver);
  }
    public StorePage clickSearchBtn(){
        driver.findElement(searchBtn).click();
        return this;
    }*/

    //structural page object
    public  StorePage search(String txt){
        //driver.findElement(searchFld).sendKeys(txt);
       // driver.findElement(searchBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFld)).sendKeys(txt);
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        return this;
    }
    public String getTitle(){

        //return driver.findElement(title).getText();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }
   /* public void clickAddToCartBtn(){
        driver.findElement(addToCartBtn).click();
    }*/
    //dynamic UI element

    public StorePage load(){
        load("/store");
        return this;
    }
}
