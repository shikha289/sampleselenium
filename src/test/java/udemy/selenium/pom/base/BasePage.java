package udemy.selenium.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import udemy.selenium.pom.utils.ConfigLoader;

import java.time.Duration;
import java.util.List;

public class BasePage{
    protected WebDriver driver;
    protected  WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
      //  waitShort=new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    //common method to load url
    public void load(String endPoint){
        //driver.get("https://askomdch.com/"+ endPoint); //endpoint is relative path after the basepage url
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }
    public void waitForOverlaysToDisappear(By overlay){
        List<WebElement> overlays=driver.findElements(overlay);
        System.out.println("OVERLAY SIZE"+ overlays.size());
        if (overlays.size()>0){
           wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("overlays are invisible");
        }else {
            System.out.println("overlay not found");
        }

    }
}
