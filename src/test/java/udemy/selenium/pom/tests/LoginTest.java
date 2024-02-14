package udemy.selenium.pom.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import udemy.selenium.pom.api.actions.CartApi;
import udemy.selenium.pom.api.actions.SignUpApi;
import udemy.selenium.pom.base.BaseTest;
import udemy.selenium.pom.objects.Products;
import udemy.selenium.pom.objects.User;
import udemy.selenium.pom.pages.CheckoutPage;
import udemy.selenium.pom.utils.FakerUtils;
import java.io.IOException;
public class LoginTest extends BaseTest {
    @Test
    public void loginDuringCheckout() throws IOException, InterruptedException {
        String username="demouser"+new FakerUtils().generateRandomNumber();
        User user=new User().setUsername(username).setPassword("demopwd").setEmail(username+"@askomdch.com");
        SignUpApi signUpApi=new SignUpApi();
        signUpApi.register(user);
        CartApi cartApi=new CartApi();
        Products products=new Products(1215);
        cartApi.addToCart(products.getId(), 1);
        CheckoutPage checkoutPage=new CheckoutPage(getDriver()).load();
        Thread.sleep(5000);
        injectCookiesToBrowser(cartApi.getCookies());
        checkoutPage.load();
        Thread.sleep(5000);
        checkoutPage.clickHereToLoginLink().login(user);
        Thread.sleep(5000);
        Assert.assertTrue(checkoutPage.getProductName().contains(products.getName()));
    }


}
