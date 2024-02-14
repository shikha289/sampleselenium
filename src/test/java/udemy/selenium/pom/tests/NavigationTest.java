package udemy.selenium.pom.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import udemy.selenium.pom.base.BaseTest;
import udemy.selenium.pom.pages.HomePage;
import udemy.selenium.pom.pages.StorePage;

public class NavigationTest extends BaseTest {
    @Test
    public void navigateFromHomeToStoreUsingMainMenu(){
        StorePage storePage=new HomePage(getDriver()).load().getMyHeader().navigateToStoreUsingMenu();
        Assert.assertEquals(storePage.getTitle(),"Store");
    }
}
