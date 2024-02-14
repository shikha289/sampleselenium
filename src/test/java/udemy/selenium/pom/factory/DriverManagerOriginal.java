package udemy.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import udemy.selenium.pom.constants.DriverType;

public class DriverManagerOriginal {
    public WebDriver initializeDriver(String browser){
        WebDriver driver;
        //String browser=System.getProperty("browser");
         browser=System.getProperty("browser",browser);//default value taking from testng.xml
        //switch (browser) {
        //switch (browser.toLowerCase()){
        switch (DriverType.valueOf(browser)){
            case CHROME:
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalThreadStateException("invalid browser name" + browser);
        }
        /*WebDriverManager.chromedriver().cachePath("Drivers").setup();
        WebDriver driver=new ChromeDriver();*/
        /*WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
        WebDriver driver=new FirefoxDriver();*/
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//implicit wait
        return driver;
    }
}
