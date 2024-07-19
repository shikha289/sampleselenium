package udemy.selenium.pom.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import udemy.selenium.pom.base.BaseTest;
import udemy.selenium.pom.dataproviders.MyDataProvider;
import udemy.selenium.pom.objects.Products;
import udemy.selenium.pom.pages.CartPage;
import udemy.selenium.pom.pages.HomePage;
import udemy.selenium.pom.pages.StorePage;

import java.io.IOException;

public class AddToCartTest extends BaseTest {
    @Link("https://example.org")
    @Link(name = "allure",type = "mylink")
    @TmsLink("12345")
    @Issue("111111")
    @Description("trying to add product to cart")
    @Test(description = "should be able to add product to cart")
    public void addToCartFromStorePage() throws IOException {
        Products products=new Products(1215);
        CartPage cartPage=new StorePage(getDriver()).load().
                getProductThumbnail().clickAddToCartBtn(products.getName()).
                clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), products.getName());
    }
    @Test(dataProvider = "getFeaturedProducts",dataProviderClass = MyDataProvider.class)
    public void addToCartFeaturedProducts(Products products){
        CartPage cartPage=new HomePage(getDriver()).load().
                getProductThumbnail().clickAddToCartBtn(products.getName()).clickViewCart();
        Assert.assertEquals(cartPage.getProductName(),products.getName());
    }
    /*@DataProvider(name = "getFeaturedProducts",parallel = true)
    public Object[] getFeaturedProducts() throws IOException {
        return JacksonUtils.deserializeJson("products.json",Products[].class);
    }*/
}
