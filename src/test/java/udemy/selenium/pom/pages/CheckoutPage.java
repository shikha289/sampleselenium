package udemy.selenium.pom.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import udemy.selenium.pom.base.BasePage;
import udemy.selenium.pom.objects.BillingAddress;
import udemy.selenium.pom.objects.User;
public class CheckoutPage extends BasePage {
     private final By firstNameFld=By.id("billing_first_name");
     private final By lastNameFld=By.id("billing_last_name");
    private final By addressLineOneFld=By.id("billing_address_1");
        private final By billingCityFld=By.id("billing_city");
        private final By billingPostcodeFld=By.id("billing_postcode");
        private final By billingEmailFld=By.id("billing_email");
        private final By placeOrderBTn=By.id("place_order");
        private final By successNotice=By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received");
        private  final By clickHereToLoginLink=By.className("showlogin");
        private final By usernameFld=By.id("username");
        private final By passwordFld=By.id("password");
        private final By loginFld=By.name("login");
        private final By overlay=By.cssSelector(".blockUI.blockOverlay");
        private final By countryDropDown=By.id("billing_country");
        private final By statDropDown=By.id("billing_state");
        private final By directBankTransferRadioBtn=By.id("payment_method_bacs");
        private final By alternateCountryDropdown=By.id("select2-billing_country-container");
        private  final By alternateStateDropdown=By.id("select2-billing_state-container");
        private final By productName=By.cssSelector("td[class='product-name']");
    public CheckoutPage(WebDriver driver){

            super(driver);
    }
    //functional method
    public CheckoutPage setBillingAddress(BillingAddress billingAddress){
        return enterFirstName(billingAddress.getFirstName()).selectCountry(billingAddress.getCountry())
        .enterLastName(billingAddress.getLastName()).enterAddressLineOne(billingAddress.getAddressLineOne())
                .enterCity(billingAddress.getCity()).selectState(billingAddress.getState()).
                enterPostCode(billingAddress.getPostalCode()).enterEmail(billingAddress.getEmail());
    }
    public CheckoutPage enterFirstName(String firstName){
       // driver.findElement(firstNameFld).clear();
        //driver.findElement(firstNameFld).sendKeys(firstName);
        WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameFld));
        e.clear();
        e.sendKeys(firstName);
        return this;
    }
    public CheckoutPage enterLastName(String lastName){
        driver.findElement(lastNameFld).clear();
        driver.findElement(lastNameFld).sendKeys(lastName);
        return this;
    }
    //to remove user dependencies
    public CheckoutPage selectCountry(String countryName){
      /*  Select select=new Select(driver.findElement(countryDropDown));
        select.selectByVisibleText(countryName);*/
        wait.until(ExpectedConditions.elementToBeClickable(alternateCountryDropdown)).click();
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+countryName+"']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();
        return this;
    }
    public CheckoutPage load(){
        load("/checkout/");
        return this;
    }
    public CheckoutPage selectState(String stateName){
        /*Select select=new Select(driver.findElement(statDropDown));
        select.selectByVisibleText(stateName);*/
        wait.until(ExpectedConditions.elementToBeClickable(alternateStateDropdown)).click();
        WebElement e1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+stateName+"']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",e1);
        e1.click();
        return this;
    }
    public CheckoutPage enterAddressLineOne(String addressLineOne){
        driver.findElement(addressLineOneFld).clear();
        driver.findElement(addressLineOneFld).sendKeys(addressLineOne);
        return this;
    }
    public CheckoutPage enterCity(String city){
        driver.findElement(billingCityFld).clear();
        driver.findElement(billingCityFld).sendKeys(city);
        return this;
    }
    public CheckoutPage enterPostCode(String postCode){
        driver.findElement(billingPostcodeFld).clear();
        driver.findElement(billingPostcodeFld).sendKeys(postCode);
        return this;
    }
    public CheckoutPage enterEmail(String email){
        driver.findElement(billingEmailFld).clear();
        driver.findElement(billingEmailFld).sendKeys(email);
        return this;
    }
    //remove application state dependency
    public CheckoutPage selectDirectBankTransfer(){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(directBankTransferRadioBtn));
        if (!e.isSelected()){
            e.click();
        }
        return this;
    }
    public CheckoutPage placeOrder(){
       waitForOverlaysToDisappear(overlay);//reusing method from base page
        driver.findElement(placeOrderBTn).click();
        return this;
    }
    public String getNotice(){
        return
                //driver.findElement(successNotice).getText();
                wait.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();
    }
    public CheckoutPage clickHereToLoginLink(){
        driver.findElement(clickHereToLoginLink).click();
        return this;
    }
    public CheckoutPage enterUsername(String username){
        //driver.findElement(usernameFld).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFld)).sendKeys(username);
        return this;
    }
    public CheckoutPage enterPassword(String password){
       // driver.findElement(passwordFld).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFld)).sendKeys(password);
        return this;
    }
    public CheckoutPage clickLoginBtn(){
       // driver.findElement(loginFld).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginFld)).click();
        return this;
    }
    /*public CheckoutPage login(String username,String password){
        return enterUsername(username).enterPassword(password).clickLoginBtn();
    }*/
    public CheckoutPage login(User user) {
        return enterUsername(user.getUsername()).enterPassword(user.getPassword()).clickLoginBtn();
    }
    public String getProductName(){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }
}
