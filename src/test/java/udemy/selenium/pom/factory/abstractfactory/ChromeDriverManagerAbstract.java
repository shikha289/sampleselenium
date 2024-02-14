package udemy.selenium.pom.factory.abstractfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManagerAbstract extends DriverManagerAbstract {

    @Override
    protected void startDriver() {
            WebDriverManager.chromedriver().cachePath("Drivers").setup();
            driver=new ChromeDriver();//using driver from abstract factory
            driver.manage().window().maximize();
        }
    }
