package udemy.selenium.pom.base;

import io.restassured.http.Cookies;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import udemy.selenium.pom.constants.DriverType;
import udemy.selenium.pom.factory.abstractfactory.DriverManagerAbstract;
import udemy.selenium.pom.factory.abstractfactory.DriverManagerFactoryAbstract;
import udemy.selenium.pom.utils.CookieUtils;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseTest {
    protected ThreadLocal<DriverManagerAbstract> driverManager=new ThreadLocal<>();
    private ThreadLocal<WebDriver> driver=new ThreadLocal<>();
    private void setDriverManager(DriverManagerAbstract driverManager) {
        this.driverManager.set(driverManager);
    }
    protected DriverManagerAbstract getDriverManager() {
        return this.driverManager.get();
    }
    private synchronized void setDriver(WebDriver driver){
        this.driver.set(driver);
    }
    protected WebDriver getDriver(){
        return this.driver.get();
    }
    @Parameters("browser")//taking browser value from testng
    @BeforeMethod
    public void StartDriver(@Optional String browser){
        browser=System.getProperty("browser",browser);//default value taking from testng.xml
        //if (browser==null) browser="CHROME";//hard coded bcoz not using testng
        //setDriver(new DriverManagerOriginal().initializeDriver(browser));
        // setDriver(DriverManagerFactory.getManager(DriverType.valueOf(browser)).createDriver());//usingfactorypattern
       setDriverManager( DriverManagerFactoryAbstract.getManager(DriverType.valueOf(browser)));
       setDriver(getDriverManager().getDriver());

        System.out.println("CURRENT THREAD"+Thread.currentThread().getId()+","+"DRIVER"+getDriver());
    }
    @Parameters("browser")
    @AfterMethod
  public synchronized void quitDriver(@Optional String browser, ITestResult result) throws InterruptedException, IOException {
        Thread.sleep(300);
            System.out.println("CURRENT THREAD"+Thread.currentThread().getId()+","+"DRIVER"+getDriver());
        //getDriver().quit();
        if (result.getStatus()==ITestResult.FAILURE){
            File destfile=new File("scr" + File.separator+ browser+ File.separator+
                    result.getTestClass().getRealClass().getSimpleName()+"_"
                    + result.getMethod().getMethodName()+".png");
           // takeScreenshot(destfile);
            takeScreenshotUsingAshot(destfile);
        }
        getDriverManager().getDriver().quit();
    }
    private void takeScreenshot(File destfile) throws IOException {
        TakesScreenshot takesScreenshot= (TakesScreenshot) getDriver();
        File srcFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,destfile);
    }
    private void takeScreenshotUsingAshot(File destFile){
        Screenshot screenshot=new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(getDriver());
        try {
            ImageIO.write(screenshot.getImage(),"PNG",destFile);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //to inject cookies to browser
    public void injectCookiesToBrowser(Cookies cookies){
        List<Cookie> seleniumCookies=new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        for (Cookie cookie:seleniumCookies){
            getDriver().manage().addCookie(cookie);
        }
    }
}
