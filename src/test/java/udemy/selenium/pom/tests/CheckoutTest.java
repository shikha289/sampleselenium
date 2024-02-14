package udemy.selenium.pom.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import udemy.selenium.pom.api.actions.CartApi;
import udemy.selenium.pom.api.actions.SignUpApi;
import udemy.selenium.pom.base.BaseTest;
import udemy.selenium.pom.objects.BillingAddress;
import udemy.selenium.pom.objects.Products;
import udemy.selenium.pom.objects.User;
import udemy.selenium.pom.pages.CheckoutPage;
import udemy.selenium.pom.utils.FakerUtils;
import udemy.selenium.pom.utils.JacksonUtils;

import java.io.IOException;

public class CheckoutTest extends BaseTest {
    @Test
    public void GuestCheckoutUsingDirectBankTransfer() throws IOException {
BillingAddress billingAddress= JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        CheckoutPage checkoutPage=new CheckoutPage(getDriver()).load();

        CartApi cartApi=new CartApi();
        cartApi.addToCart(1215,1);
        injectCookiesToBrowser(cartApi.getCookies());

        checkoutPage.load().
    setBillingAddress(billingAddress).selectDirectBankTransfer().placeOrder();

        Assert.assertEquals(checkoutPage.getNotice(),"Thank you. Your order has been received.");
    }
@Test
public void LoginAndCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {
    BillingAddress billingAddress= JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);

    String username="demouser"+new FakerUtils().generateRandomNumber();
    User user=new User().setUsername(username).setPassword("demopwd").setEmail(username+"@askomdch.com");
    SignUpApi signUpApi=new SignUpApi();
    signUpApi.register(user);
    CartApi cartApi=new CartApi(signUpApi.getCookies());
    Products products=new Products(1215);
    cartApi.addToCart(products.getId(), 1);

    CheckoutPage checkoutPage=new CheckoutPage(getDriver()).load();
    Thread.sleep(4000);
    injectCookiesToBrowser(signUpApi.getCookies());

    checkoutPage.load();
    Thread.sleep(3000);

            checkoutPage.setBillingAddress(billingAddress).selectDirectBankTransfer().placeOrder();

    Assert.assertEquals(checkoutPage.getNotice(),"Thank you. Your order has been received.");
}

}
