package udemy.selenium.pom.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import udemy.selenium.pom.base.BaseTest;
import udemy.selenium.pom.pages.StorePage;

public class SearchTest extends BaseTest {
    @Test
    public void searchWithPartialMatch(){
        String searchFor="Blue";
        StorePage storePage=new StorePage(getDriver()).load().search(searchFor);
        Assert.assertEquals(storePage.getTitle(),"Search results: “"+searchFor+"”");
    }

}
