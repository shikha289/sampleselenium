package udemy.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import udemy.selenium.pom.base.BasePage;
import udemy.selenium.pom.pages.components.MyHeader;
import udemy.selenium.pom.pages.components.ProductThumbnail;

public class HomePage extends BasePage {
    private MyHeader myHeader;
    private ProductThumbnail productThumbnail;
    private final By storeMenuLink=By.cssSelector("#menu-item-1227 > a");
    private  final By viewCartLink=By.cssSelector("a[title='View cart']");

    public MyHeader getMyHeader() {
        return myHeader;
    }

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    public HomePage(WebDriver driver) {
        super(driver);
        myHeader=new MyHeader(driver);
        productThumbnail=new ProductThumbnail(driver);
    }

    public HomePage load(){
        load("/");  //calling method from basepage
        return this;
    }
}
