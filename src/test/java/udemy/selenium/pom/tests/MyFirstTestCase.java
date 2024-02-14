package udemy.selenium.pom.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import udemy.selenium.pom.base.BaseTest;
import udemy.selenium.pom.objects.BillingAddress;
import udemy.selenium.pom.objects.Products;
import udemy.selenium.pom.objects.User;
import udemy.selenium.pom.pages.CartPage;
import udemy.selenium.pom.pages.CheckoutPage;
import udemy.selenium.pom.pages.HomePage;
import udemy.selenium.pom.pages.StorePage;
import udemy.selenium.pom.utils.ConfigLoader;
import udemy.selenium.pom.utils.JacksonUtils;
import java.io.IOException;
public class MyFirstTestCase extends BaseTest {
        @Test
public  void guestCheckoutUsingDirectBankTRansfer() throws InterruptedException, IOException {
            String searchFor="Blue";//replace"Blue with searchFor
       // WebDriver driver;
       // driver = new ChromeDriver();
       // System.setProperty("driver", "C:/Users/lenovo/Downloads/chromedriver_win32");
        //driver.get("https://askomdch.com/");
            BillingAddress billingAddress=JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
            Products products=new Products(1215);
            /*BillingAddress billingAddress=new BillingAddress("demo","user" ,"san fransisco","san fransisco","94188","askomdch@gmail.com");*/

          /*  BillingAddress billingAddress=new BillingAddress();
            InputStream is=getClass().getClassLoader().getResourceAsStream("myBillingAddress.json");
            billingAddress= JacksonUtils.deserializeJson(is,billingAddress);*/

           /* BillingAddress billingAddress=new BillingAddress().setFirstName("demo").setLastName("user").
                    setAddressLineOne("san fransisco").setCity("san fransisco").setPostalCode("94188").
                    setEmail("askomdch@gmail.com");*/

           /* billingAddress.setFirstName("demo");
            billingAddress.setLastName("user");
            billingAddress.setAddressLineOne("san fransisco");
            billingAddress.setCity("san fransisco");
            billingAddress.setPostalCode("94188");
            billingAddress.setEmail("askomdch@gmail.com");*/

             /*   HomePage homePage=new HomePage(driver);//using basetest driver as parameter we are setting the basepage driver and we can use it for other pages
             StorePage storepage= homePage.clickStoreMenuLink();//fluent interface*/
            StorePage storepage=new HomePage(getDriver()).load().getMyHeader().navigateToStoreUsingMenu().search(searchFor);
              /* storepage.enterTxtInSearchField("Blue");
               storepage.clickSearchBtn();*/
           // storepage.enterTxtInSearchField("Blue").clickSearchBtn();//builderpattern
            //storepage.search("Blue");//structural page object
             Assert.assertEquals(storepage.getTitle(),"Search results: “"+searchFor+"”");//sometimes maven is not able to identify the encoding

               //storepage.clickAddToCartBtn("Blue Shoes");//dynamic ui element//
            //reeplace "Blue Shoes" with product.getName
            storepage.getProductThumbnail().clickAddToCartBtn(products.getName());
        //driver.manage().window().maximize();
        //driver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
        //driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
        //driver.findElement(By.cssSelector("button[value='Search']")).click();
        //Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),"Search results: “Blue”");
        //driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        //Thread.sleep(5000);
       // driver.findElement(By.cssSelector("a[title='View cart']")).click();
      //  Assert.assertEquals(driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),"Blue Shoes");
            CartPage cartpage=storepage.getProductThumbnail().clickViewCart();
          //  Assert.assertEquals(cartpage.getProductName(),"Blue Shoes");
            Assert.assertEquals(cartpage.getProductName(),products.getName());
        //driver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();
            /*CheckoutPage checkoutpage=cartpage.clickCheckoutBtn();
        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_address_1")).sendKeys("san fransisco");
        driver.findElement(By.id("billing_city")).sendKeys("san fransisco");
        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
        driver.findElement(By.id("billing_email")).sendKeys("askomdch@gmail.com");
        driver.findElement(By.id("place_order")).click();*/
            CheckoutPage checkoutPage=cartpage.clickCheckoutBtn().setBillingAddress(billingAddress).selectDirectBankTransfer()
                    .placeOrder();
        //Thread.sleep(5000);
        Assert.assertEquals(checkoutPage.getNotice(),"Thank you. Your order has been received.");
    }
    @Test
    public  void loginAndCheckoutUsingDirectBankTRansfer() throws InterruptedException, IOException {
        String searchFor="Blue";
        BillingAddress billingAddress=JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Products products=new Products(1215);
        //User user=new User("demouser2","demopwd");
        User user=new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
       /* driver.get("https://askomdch.com/");
        HomePage homePage=new HomePage(driver);
        StorePage storepage= homePage.clickStoreMenuLink();
        storepage.search("Blue");//structural page object*/
        StorePage storepage=new HomePage(getDriver()).load().
                getMyHeader().navigateToStoreUsingMenu().search(searchFor);
       // Assert.assertEquals(storepage.getTitle(),"Search results: “Blue”");
        Assert.assertEquals(storepage.getTitle(),"Search results: “"+searchFor+"”");
        storepage.getProductThumbnail().clickAddToCartBtn("Blue Shoes");
       // Thread.sleep(5000);
        CartPage cartpage=storepage.getProductThumbnail().clickViewCart();
        Assert.assertEquals(cartpage.getProductName(),products.getName());
        CheckoutPage checkoutpage=cartpage.clickCheckoutBtn();
        checkoutpage.clickHereToLoginLink().
                login(user).
                setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                placeOrder();
      // Thread.sleep(3000);
       /* checkoutpage.login("demouser2","demopwd")
                .enterFirstName("demo").enterLastName("user")
                .enterAddressLineOne("san fransisco").enterCity("san fransisco").enterPostCode("941880")
                .enterEmail("askomdch@gmail.com").placeOrder();*/
        //Thread.sleep(5000);
        Assert.assertEquals(checkoutpage.getNotice(),"Thank you. Your order has been received.");

    }
}
